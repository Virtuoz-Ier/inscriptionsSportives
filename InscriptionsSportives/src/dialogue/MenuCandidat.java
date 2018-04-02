package dialogue;

import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Candidat;
import inscriptions.Inscriptions;

public class MenuCandidat extends Menu
{
	private Candidat candidat;

	public MenuCandidat(String longTitle, String shortTitle, String shortcut, Candidat candidat)
	{
		super(longTitle, shortTitle, shortcut);
		this.candidat = candidat;
		this.setOptions();
	}
	
	public Candidat getCandidat()
	{
		return this.candidat;
	}

	public void setOptions()
	{
		this.add(getOptionGetNom());
		this.add(getOptionSetNom());
		this.add(getOptionGetCompetitions());
		this.add(getOptionAfficher());
		this.add(getOptionSupprimer());
		this.addBack("Retour", "r");
	}

	private Option getOptionGetNom()
	{
		return new Option("Voir nom", "1", () -> System.out.println(this.getCandidat().getNom()));
	}
	
	private Option getOptionSetNom()
	{
		Option option = new Option("Changer nom", "2");
		
		option.setAction( () -> 
		{
			String nom = InOut.getString("Nom: ");
			this.getCandidat().setNom(nom);
		});
		
		return option;
	}
	
	private Option getOptionGetCompetitions()
	{
		return new Option("Voir compétitions", "3", () -> System.out.println(this.getCandidat().getCompetitions()));
	}
	
	private Option getOptionAfficher()
	{
		return new Option("Afficher candidat", "4", () -> System.out.println(this.getCandidat()));
	}
	
	private Option getOptionSupprimer()
	{
		return new Option("Supprimer candidat", "5", () -> { this.getCandidat().delete(); goBack(); });
	}

	public Option getMenuCandidat(Inscriptions inscriptions) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
