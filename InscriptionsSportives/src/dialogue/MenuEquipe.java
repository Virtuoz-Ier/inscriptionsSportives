package dialogue;

import java.util.SortedSet;
import java.util.TreeSet;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Equipe;
import inscriptions.Personne;

public class MenuEquipe extends Menu
{
	private Equipe equipe;
	private SortedSet<Personne> personnes = new TreeSet<>();

	public MenuEquipe(String longTitle, String shortTitle, String shortcut, Equipe equipe, SortedSet<Personne> personnes)
	{
		super(longTitle, shortTitle, shortcut);
		this.equipe = equipe;
		this.personnes = personnes;
		this.setOptions();
	}
	
	public Equipe getEquipe()
	{
		return this.equipe;
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
	
	private Personne getPersonneEquipe(String name)
	{
		for (Personne p : this.getEquipe().getMembres())
		{
			if (p.getNom().equals(name));
				return p;
		}
		return null;
	}
	
	public void setOptions()
	{
		this.add(getOptionVoirMembres());
		this.add(getOptionAjouterPersonne());
		this.add(getOptionRetirerPersonne());
		this.add(getOptionAfficher());
		this.add(getOptionSupprimer());
		this.addBack("Retour", "r");
	}
	
	private Option getOptionVoirMembres()
	{
		return new Option("Voir membres", "1", () -> System.out.println(this.getEquipe().getMembres()));
	}
	
	private Option getOptionAjouterPersonne()
	{
		Option option = new Option("Ajouter personne", "2");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getEquipe().add(this.getPersonne(nom));
		});
		
		return option;
	}
	
	private Option getOptionRetirerPersonne()
	{
		Option option = new Option("Retirer personne", "3");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getEquipe().remove(this.getPersonneEquipe(nom));
		});
		
		return option;
	}
	
	private Option getOptionAfficher()
	{
		return new Option("Afficher équipe", "4", () -> System.out.println(this.getEquipe()));
	}
	
	private Option getOptionSupprimer()
	{
		return new Option("Supprimer équipe", "5", () -> { this.getEquipe().delete(); goBack(); });
	}
	
}