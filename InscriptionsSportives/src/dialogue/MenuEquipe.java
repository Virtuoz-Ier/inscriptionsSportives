package dialogue;

import java.util.ArrayList;

import commandLineMenus.Action;
import commandLineMenus.List;
import commandLineMenus.ListData;
import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;

public class OptionList
{
	private java.util.List<String> people ;
	
	OptionList(java.util.List<String> people)
	{
		this.people = people;
		List<String> list = getPeopleList();
		list.start();
	}
	
	private List<String> getPeopleList()
	{
		List<String> liste = new List<>("Select somebody",getListDataPeople(),getOptionListePeople());
		liste.setAutoBack(false);
		liste.addQuit("q");
		return liste;
	}
	private ListOption<String> getOptionListePeople()
	{
		return new ListOption<String>()
		{
		
			public Option getOption(String somebody)
			{
				return getsomebodyMenu(somebody);
			}
		};
	}
	
	private ListData<String> getListDataPeople()
	{
		return new ListData<String>()
		{
			@Override
			public java.util.List<String> getList()
			{
				return people;
			}
		};
	}
	
	private ListOption<String> getOptionListePeople()
	{
		return new ListOption<String>()
		{
		
			public Option getOption(String somebody)
			{
				return getsomebodyMenu(somebody);
			}
		};
	}
	

	private Option getsomebodyMenu(final String somebody)
	{
		Menu somebodyMenu = new Menu(somebody);
		somebodyMenu.add(getDisplaysomebodyOption(somebody));
		somebodyMenu.add(getDeletesomebodyOption(somebody));
		somebodyMenu.setAutoBack(true);
		return somebodyMenu;
	}
	

	private Option getDisplaysomebodyOption(String somebody)
	{
		return new Option("show", "s", new Action()
		{
			@Override
			public void optionSelected()
			{
				System.out.println("You must give the man a name : " + somebody + ".");
			}
		});
	}
	

	private Option getDeletesomebodyOption(String somebody)
	{
		return new Option("delete", "d", new Action()
		{
			@Override
			public void optionSelected()
			{
				people.remove(somebody);
				System.out.println(somebody + " has been deleted.");
				System.out.println(people);
			}
		});
	}


	public static void main(String[] args)
	{
		java.util.List<String> people = new ArrayList<>();
		people.add("Ginette");
		people.add("Marcel");
		people.add("Gisèle");
		new OptionList(people);
	} 
}