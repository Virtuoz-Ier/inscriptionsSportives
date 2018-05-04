package dialogue;

import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;

public class ListEquipe {
private java.util.List<String> equipe;
	
	ListEquipe(java.util.List<String> equipe)
	{
		this.equipe = equipe;
		List<String> list = getCompeteList();
		list.start();
	}
	private List<String> getCompeteList()
	{
		List<String> liste = new List<>("Selectionner une equipe",
				getListEquipe(),
				getOptionListEquipe());
		liste.setAutoBack(false);
		liste.addQuit("q");
		return liste;
	}
	
	private ListData<String> getListEquipe()
	{
		return new ListData<String>()
		{
			@Override
			public java.util.List<String> getList()
			{
				return equipe;
			}
		};
	}
	
	private ListOption<String> getOptionListEquipe()
	{
		return new ListOption<String>()
		{ 
			public Option getOption(String someone)
			{
				return getSomeoneMenu(someone);
			}
		};
	}
	
	private Option getSomeoneMenu(final String someone)
	{
		Menu someoneMenu = new Menu(someone);
		someoneMenu.add(ModNomcompeteAction(someone));
		someoneMenu.add(AjoutUnMembre(someone));
		someoneMenu.setAutoBack(true);
		return someoneMenu;
	}
	
	private Option ModNomcompeteAction(String someone)
	{
		return new Option("modifier le nom", "n", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Insérer un nouveau nom: " + someone + ".");
			}
		});
	}
	
	private Option AjoutUnMembre(String someone)
	{
		return new Option("AddMembre", "a", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("Ajouter un candidat " + someone + ".");
			}
		});
	}
}
