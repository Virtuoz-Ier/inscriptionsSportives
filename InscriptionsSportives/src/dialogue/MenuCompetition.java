package dialogue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.*;

public class MenuCompetition extends Menu
{
	private Competition competition;
	private SortedSet<Personne> personnes = new TreeSet<>();
	private SortedSet<Equipe> equipes = new TreeSet<>();

	public MenuCompetition(String longTitle, String shortTitle, String shortcut, Competition competition, SortedSet<Personne> personnes, SortedSet<Equipe> equipes)
	{
		super(longTitle, shortTitle, shortcut);
		this.competition = competition;
		this.personnes = personnes;
		this.equipes = equipes;
		this.setOptions();
	}
	
	public Competition getComp()
	{
		return this.competition;
	}
	
	private Candidat getCandidat(String name)
	{
		for (Candidat c : this.getComp().getCandidats())
		{
			if (c.getNom().equals(name));
				return c;
		}
		return null;
	}
	
	private Personne getPersonne(String name)
	{
		for (Personne p : this.personnes)
		{
			if (p.getNom().equals(name));
				return p;
		}
		return null;
	}
	
	private Equipe getEquipe(String name)
	{
		for (Equipe e : this.equipes)
		{
			if (e.getNom().equals(name));
				return e;
		}
		return null;
	}
	
	public void setOptions()
	{
		this.add(getOptionVoirNom());
		this.add(getOptionSetNom());
		this.add(getOptionInscriptionsOuvertes());
		this.add(getOptionEnEquipe());
		this.add(getOptionViewDateCloture());
		this.add(getOptionSetDateCloture());
		this.add(getOptionAjouterPersonne());
		this.add(getOptionAjouterEquipe());
		this.add(getOptionRetirerCandidat());
		this.add(getOptionAfficher());
		this.add(getOptionSupprimer());
		this.addBack("Retour", "r");
	}
	
	private Option getOptionVoirNom()
	{
		return new Option("Voir nom", "1", () -> System.out.println(this.getComp().getNom()));
	}
	
	private Option getOptionSetNom()
	{
		Option option = new Option("Changer nom", "2");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getComp().setNom(nom);
		});
		
		return option;
	}
	
	private Option getOptionInscriptionsOuvertes()
	{
		return new Option("Inscription ouvertes?", "3", () -> System.out.println(this.getComp().inscriptionsOuvertes()));
	}
	
	private Option getOptionEnEquipe()
	{
		return new Option("En équipe?", "4", () -> System.out.println(this.getComp().estEnEquipe()));
	}
	
	private Option getOptionViewDateCloture()
	{
		return new Option("Voir dâte de cloture", "5", () -> System.out.println(this.getComp().getDateCloture()));
	}

	private Option getOptionSetDateCloture()
	{
		Option option = new Option("Changer dâte de cloture", "6");
		
		option.setAction( () -> 
		{
			String date = InOut.getString("Date (jj/mm/yyyy): ");
			String dateRegex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([2][0])?[1-9][0-9]$";
			
			while(!Pattern.matches(dateRegex, date))
			{
				System.out.println("Mauvaise date.");
				date = InOut.getString("Date (jj/mm/yyyy): ");
			}
			
			LocalDate dateCloture = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			this.getComp().setDateCloture(dateCloture);
		});
		
		return option;
	}
	
	private Option getOptionAjouterPersonne()
	{
		Option option = new Option("Ajouter personne", "7");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getComp().add(this.getPersonne(nom));
		});
		
		return option;
	}
	
	private Option getOptionAjouterEquipe()
	{
		Option option = new Option("Ajouter équipe", "8");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getComp().add(this.getEquipe(nom));
		});
		
		return option;
	}
	
	private Option getOptionRetirerCandidat()
	{
		Option option = new Option("Retirer candidat", "9");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getComp().remove(this.getCandidat(nom));
		});
		
		return option;
	}
	
	private Option getOptionAfficher()
	{
		return new Option("Afficher compétition", "10", () -> System.out.println(this.getComp()));
	}
	
	private Option getOptionSupprimer()
	{
		return new Option("Supprimer compétition", "11", () -> { this.getComp().delete(); goBack(); });
	}

	public Option getMenuCompetition() {
		// TODO Auto-generated method stub
		return null;
	}
}
