package dialogue;

import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.rendering.examples.util.InOut;
import inscriptions.Inscriptions;

public class MenuInscription {
	
	private static Menu MenuM;
	private static  MenuPers MenuP;
	private static MenuComp MenuC;
	private static MenuEquipe MenuE;
	private static Inscriptions inscriptions;

	public MenuInscription(){
		inscriptions = Inscriptions.getInscriptions();
		MenuM = getMenuM();
		MenuP = new MenuPers() ;
		MenuC = new MenuComp();
		MenuE = new MenuEquipe();
	}

	
	public static void main(String[] args)
	{
		MenuInscription menu = new MenuInscription();
		menu.start();
	}
	
	public void start()
	{
		MenuM.start();
	}
	
	public Inscriptions getInscriptions()
	{
		return inscriptions;
	}
	

	static Menu getMenuM()
	{
		Menu MenuM = new Menu("Menu Complet");
		MenuM.add(MenuPers.getMenuPers(inscriptions));
		MenuM.addQuit("q");
		return MenuM;
	}
	
	static Option CompeteMenu()
	{
		Option Creecompete = new Option("Creér Competition", "cc", creercompetionAction());
		Option Modifcompete = new Option("Modifier Competition", "mc", ModifiercompetionOption());
		return Creecompete;
	}
	
	static Option PersonneMenu()
	{
		Option Personne = new Option("Inserer Personne", "ip", insererPersonneAction());
		Option Modifpersonne = new Option("Modifier Personne", "mp", ModifierpersonneOption());
		return Personne;
	}
	
	static Option EquipeMenu()
	{
		Option Creeequipe = new Option("Creér Equipe", "ce", creerequipeAction());
		Option Modifequipe = new Option("Modifier Equipe", "me", ModifierequipeOption());
		return Creeequipe;
	}
	
	static Action creercompetionAction()
	{
		return new Action()
		{
			public void optionSelected()
			{
				String a = InOut.getString("Le nom de la competition : "),
					b = InOut.getString("Date de debut de la compete : "),
					c = InOut.getString("Date de fin d'inscription : "),
					d = InOut.getString("Type de compete : ");
				System.out.println("Le nom de la competition :" + a );
				System.out.println("Date de debut de la compete :" +b );
				System.out.println("Date de fin d'inscription :" + c );
				System.out.println("Type de compete :" + d );
			}

			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
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

			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
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

			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
			}
	};
	}
	
	static Action ModifiercompetionOption()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				
				 ListCompete();
					
		}
			private void ListCompete() {
				
			}
			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
			}
	};
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

			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	static Action ModifierpersonneOption()
	{
		return new Action()
		{
			@Override
			public void optionSelected() {
				ListPerss();
					
		}
			private void ListPerss() {
				
				
			}
			@Override
			public void optionSelectionnee() {
				// TODO Auto-generated method stub
				
			}
	};
	}
}