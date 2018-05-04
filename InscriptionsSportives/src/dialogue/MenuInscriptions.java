package dialogue;

import java.util.ArrayList;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Inscriptions;

@SuppressWarnings("unused")

public class MenuInscriptions {
	
	private static Menu MenuI;
	private static MenuPersonne Mpe;
	private static MenuCompetition Mco;
	private static MenuEquipe Me;
	private static Inscriptions inscriptions;

	public MenuInscriptions(){
		inscriptions = Inscriptions.getInscriptions();
		MenuI = getMenuI();
		Mpe = new MenuPersonne() ;
		Mco = new MenuCompetition();
		Me = new MenuEquipe();
		new Hibernate();
	}

	public static void main(String[] args)
	{
		MenuInscriptions menu = new MenuInscriptions();
		menu.start();
	}
	
	public void start()
	{
		MenuI.start();
	}
	
	public Inscriptions getInscriptions()
	{
		return inscriptions;
	}
	
	static Menu getMenuI()
	{
		Menu MenuI = new Menu("Menu Complet");
		MenuI.add(MenuPersonne.getMenuPersonne(inscriptions));
		MenuI.add(Me.getMenuEquipe());
		MenuI.add(Mco.getMenuComp());
		MenuI.addQuit("q");
		return MenuI;
	}
	
	static Option PersonneMenu()
	{
		Option Personne = new Option("Insérer Personne", "ip", 
				insererPersonneAction());
		Option Modifpersonne = new Option("Modifier Personne", "mp", 
				ModifierpersonneOption());
		return Personne;
	}
	
	static Option EquipeMenu()
	{
		Option Creeequipe = new Option("Créer Equipe", "ce", 
				creerequipeAction());
		Option Modifequipe = new Option("Modifier Equipe", "me", 
				ModifierequipeOption());
		return Creeequipe;
	}
	
	static Option CompeteMenu()
	{
		Option Creecompetition = new Option("Créer Compétition", "cc", 
				creercompetionAction());
		Option Modifcompetition = new Option("Modifier Compétition", "mc", 
				ModifierequipeOption());
		return Creecompetition;
	}
	
	static Action insererPersonneAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				String a = InOut.getString("Le nom de la personne : "),
						b = InOut.getString("Le prenom : ");
				System.out.println("Le nom de la competition :" + a );
				System.out.println("Date de debut de la compete :" +b );
				
				//a completer
			}
		};
	}
	
	static Action creercompetionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				String v = InOut.getString("Le nom de la competition : "),
						w = InOut.getString("Date de debut de la compete : "),
						q = InOut.getString("Date de fin d'inscription : "),
						k = InOut.getString("Type de compete : ");
				System.out.println("Le nom de la competition :" + v );
				System.out.println("Date de debut de la compete :" +w );
				System.out.println("Date de fin d'inscription :" + q );
				System.out.println("Type de compete :" + k );
			}
		};
	}
	
	static Action creerequipeAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				String a = InOut.getString("Le nom de l'equipe : ");
				System.out.println("Le nom de l'equipe :" + a );
			}
		};
	}
	
	static Action ModifierequipeOption()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				listeequipe();
					
		}

			private void listeequipe() {
				
				
			}
	};
	}
	
	static Option getDisplayCompOption()
	{
		Option displayComp = new Option("Afficher les compétitions", "2",
				getDisplayCompetition());
		return displayComp;
	}
	
	static Action getDisplayCompetition() {
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println(Inscriptions.getInscriptions().getCompetitions());
			}
		};
}
	
	static Action ModifierpersonneOption()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				Listpersonne();
					
		}
			private void Listpersonne() {
				
				
			}
	};
	}
}
