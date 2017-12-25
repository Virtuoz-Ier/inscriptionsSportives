package dialogue;

import java.util.SortedSet;
import java.util.TreeSet;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class MenuPers {
	
	private java.util.List<Personne> Lpers ;
	private static ListPerss Lpers2;

	private static Inscriptions inscriptions;
	
	public MenuPers()
	{
		Lpers2 = new Listpersonne(Lpers);
		inscriptions = Inscriptions.getInscriptions();
	}

	public Inscriptions getInscriptions()
	{
		return inscriptions;
	}
	
	static Menu getMenuPers(Inscriptions inscriptions)
	{
		Menu MenuPers = new Menu ("Gestion de Personnes","3");
		MenuPers.add(AjouterPersonneMenu());
		MenuPers.add(Lpers2.getListPers());
		MenuPers.addQuit("q");
		MenuPers.setAutoBack(false);
		return MenuPers;
	}

	static Option AjouterPersonneMenu()
	{
		Option Personne = new Option("Inserer Personne", "i", 
				insererPersonneAction());
		return Personne;
	}
	
	static Action insererPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				String nom = InOut.getString("Le nom de la personne : "),
						prenom = InOut.getString("Le prenom : "),
						email = InOut.getString("Le mail : ");
					inscriptions.createPersonne(nom, prenom, email);
			}

			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}