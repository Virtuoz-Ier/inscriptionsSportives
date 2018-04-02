package dialogue;

import java.util.ArrayList;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Inscriptions;




@SuppressWarnings("unused")
public class MenuGeneral {
	
	private static Menu MenuG;
	private static  MenuPersonne Mpe;
	private static MenuCompetition Mco;
	private static MenuEquipe Me;
	private static Inscriptions inscriptions;

	public MenuGeneral(){
		inscriptions = Inscriptions.getInscriptions();
		MenuG = getMenuG();
		Mpe = new MenuPersonne() ;
		Mco = new MenuCompetition(null, null, null, null, null, null);
		Me = new MenuEquipe(null, null, null, null, null);
		new PremierExemple();
	}

	public static void main(String[] args)
	{
		MenuGeneral menu = new MenuGeneral();
		menu.start();
	}
	
	public void start()
	{
		MenuG.start();
	}
	
	public Inscriptions getInscriptions()
	{
		return inscriptions;
	}
	
	static Menu getMenuG()
	{
		Menu MenuG = new Menu("Menu Complet");
		MenuG.add(MenuPersonne.getMenuPersonne(inscriptions));
		MenuG.add(Me.getMenuEquipe());
		MenuG.add(Mco.getMenuCompetition());
		MenuG.addQuit("q");
		return MenuG;
	}
	
	static Option PersonneMenu()
	{
		Option Personne = new Option("Inserer Personne", "ip", 
				insererPersonneAction());
		Option Modifpersonne = new Option("Modifier Personne", "mp", 
				ModifierpersonneOption());
		return Personne;
	}
	
	static Option EquipeMenu()
	{
		Option Creeequipe = new Option("Cre�r Equipe", "ce", 
				creerequipeAction());
		Option Modifequipe = new Option("Modifier Equipe", "me", 
				ModifierequipeOption());
		return Creeequipe;
	}
	
	static Option CompeteMenu()
	{
		Option Creecompete = new Option("Cre�r Competition", "cc", 
				creercompetionAction());
		Option Modifcompetition = new Option("Modifier Competition", "mc", 
				ModifiercompetionOption());
		return Creecompete;
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
	
	static Action ModifiercompetionOption()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				//ListCompete(compete);
				 ListCompete();
					
		}
			private void ListCompete() {
				
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
