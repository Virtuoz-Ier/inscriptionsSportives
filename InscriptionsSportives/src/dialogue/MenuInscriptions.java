package dialogue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.List;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.*;

public class MenuInscriptions extends Menu
{
	private Inscriptions inscriptions;
	
	public MenuInscriptions(String title, Inscriptions inscriptions)
	{
		super(title);
		this.inscriptions = inscriptions;
	}
	
	public Inscriptions getInsc()
	{
		return this.inscriptions;
	}
	
	public void launch()
	{
		this.setOptions();
		this.start();
	}
	
	public void setOptions()
	{
		this.add(this.getMenuGererCandidat());
		this.add(this.getMenuGererCompetition());
		this.add(this.getMenuGererEquipe());
		this.add(this.getOptionGetPersonnes());
		this.add(this.getOptionGetCandidats());
		this.add(this.getOptionGetEquipes());
		this.add(this.getOptionGetCompetitions());
		this.add(this.getOptionCreatePersonne());
		this.add(this.getOptionCreateEquipe());
		this.add(this.getOptionCreateCompetition());
		this.add(this.getOptionReinitialiser());
		this.add(this.getOptionRecharger());
		this.add(this.getOptionSauvegarder());
		this.add(this.getOptionAfficher());
		this.addQuit("Quitter", "q");
	}
	
	private Candidat getCandidat(String name)
	{
		for (Candidat c : this.getInsc().getCandidats())
		{
			if (c.getNom().equals(name));
				return c;
		}
		return null;
	}
	
	private Competition getCompetition(String name)
	{
		for (Competition c : this.getInsc().getCompetitions())
		{
			if (c.getNom().equals(name));
				return c;
		}
		return null;
	}
	
	private Equipe getEquipe(String name)
	{
		for (Equipe e : this.getInsc().getEquipes())
		{
			if (e.getNom().equals(name));
				return e;
		}
		return null;
	}
	
	private Menu getMenuGererCandidat()
	{
		java.util.List<String> options = new ArrayList<>();
		
		for (Candidat c : this.getInsc().getCandidats())
		{
			options.add(c.getNom());
		}
		
		List<String> menu = new List<String>("Gerer Candidat", "1", 
				new ListData<String>()		
				{
					// Returns the data needed to refresh the list 
					// each time it is displayed. 
					public java.util.List<String> getList()
					{
						return options;
					}	
				},
				new ListOption<String>()
				{	
					public Option getOption(String someone)
					{
						return new MenuCandidat("Gérer " + someone, someone, null, getCandidat(someone));
					}
				});
		
		menu.addBack("Retour", "r");
		return menu;
	}
	
	private Menu getMenuGererCompetition()
	{
		java.util.List<String> options = new ArrayList<>();
		
		for (Competition c : this.getInsc().getCompetitions())
		{
			options.add(c.getNom());
		}
		
		List<String> menu = new List<String>("Gerer Compétition", "2", 
				new ListData<String>()		
				{
					// Returns the data needed to refresh the list 
					// each time it is displayed. 
					public java.util.List<String> getList()
					{
						return options;
					}	
				},
				new ListOption<String>()
				{	
					public Option getOption(String someone)
					{
						return new MenuCompetition("Gérer " + someone, someone, null, getCompetition(someone), getInsc().getPersonnes(), getInsc().getEquipes());
					}
				});
		
		menu.addBack("Retour", "r");
		return menu;
	}
	
	private Menu getMenuGererEquipe()
	{
		java.util.List<String> options = new ArrayList<>();
		
		for (Equipe e : this.getInsc().getEquipes())
		{
			options.add(e.getNom());
		}
		
		List<String> menu = new List<String>("Gerer Equipe", "3", 
				new ListData<String>()		
				{
					// Returns the data needed to refresh the list 
					// each time it is displayed. 
					public java.util.List<String> getList()
					{
						return options;
					}	
				},
				new ListOption<String>()
				{	
					public Option getOption(String someone)
					{
						return new MenuEquipe("Gérer " + someone, someone, null, getEquipe(someone), getInsc().getPersonnes());
					}
				});
		
		menu.addBack("Retour", "r");
		return menu;
	}
	
	private Option getOptionGetPersonnes()
	{
		return new Option("Voir personnes", "4", () -> System.out.println(this.getInsc().getPersonnes()));
	}
	
	private Option getOptionGetCandidats()
	{
		return new Option("Voir candidats", "5", () -> System.out.println(this.getInsc().getCandidats()));
	}
	private Option getOptionGetEquipes()
	{
		return new Option("Voir équipes", "6", () -> System.out.println(this.getInsc().getEquipes()));
	}
	
	private Option getOptionGetCompetitions()
	{
		return new Option("Voir compétitions", "7", () -> System.out.println(this.getInsc().getCompetitions()));
	}

	private Option getOptionCreatePersonne()
	{
		Option option = new Option("Créer personne", "8");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			String prenom = InOut.getString("Prenom: ");
			String mail = InOut.getString("Mail: ");
			this.getInsc().createPersonne(nom, prenom, mail);
		});
		
		return option;
	}
	
	private Option getOptionCreateEquipe()
	{
		Option option = new Option("Créer équipe", "9");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getInsc().createEquipe(nom);
		});
		
		return option;
	}
	
	private Option getOptionCreateCompetition()
	{
		Option option = new Option("Créer compétition", "10");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			
			String date = InOut.getString("Date (jj/mm/yyyy): ");
			String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([2][0])?[1-9][0-9]$";
			
			while(!Pattern.matches(dateRegex, date))
			{
				System.out.println("Mauvaise date.");
				date = InOut.getString("Date (jj/mm/yyyy): ");
			}
			
			LocalDate dateCloture = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			String team = InOut.getString("En équipe? (oui ou non): ");
			boolean enEquipe = true;
			
			while(!(team.equals("oui") || team.equals("non")))
			{
				team = InOut.getString("En équipe? (oui ou non): ");
			}
			
			if (team.equals("non"))
				enEquipe = false;

			this.getInsc().createCompetition(nom, dateCloture, enEquipe);
		});
		
		return option;
	}
	
	private Option getOptionReinitialiser()
	{
		return new Option("Réinitialiser", "11", () -> this.getInsc().reinitialiser());
	}
	
	private Option getOptionRecharger()
	{
		return new Option("Recharger", "12", () -> this.getInsc().recharger());
	}
	
	private Option getOptionSauvegarder()
	{
		Option option = new Option("Sauvegarder", "13");
		
		option.setAction( () -> 
		{
			try
			{
				this.getInsc().sauvegarder();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});

		return option;
	}
	
	private Option getOptionAfficher()
	{
		return new Option("Afficher", "14", () -> System.out.println(this.getInsc()));
	}
}