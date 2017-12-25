package dialogue;


	import commandLineMenus.Action;
	import commandLineMenus.List;
	import commandLineMenus.ListData;
	import commandLineMenus.ListOption;
	import commandLineMenus.Menu;
	import commandLineMenus.Option;

	public class CandList {
		
	private java.util.List<String> Candidat;
		
		CandList(java.util.List<String> people)
		{
			this.Candidat = people;
			List<String> list = getCompeteList();
			list.start();
		}
		
		private List<String> getCompeteList()
		{
			List<String> liste = new List<>("Selectionner une competition",
					getListCompetition(),
					getOptionListeCompetition());
			liste.setAutoBack(false);
			liste.addQuit("q");
			return liste;
		}
		
		private ListData<String> getListCompetition()
		{
			return new ListData<String>()
			{
				@Override
				public java.util.List<String> getList()
				{
					return Candidat;
				}
			};
		}
		
		private ListData<String> getListCompetition()
		{
			return new ListData<String>()
			{
				@Override
				public java.util.List<String> getList()
				{
					return Candidat;
				}
			};
		}
		
		private ListData<String> getListCompetition()
		{
			return new ListData<String>()
			{
				@Override
				public java.util.List<String> getList()
				{
					return Candidat;
				}
			};
		}
		
		private ListOption<String> getOptionListeCompetition()
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
			somebodyMenu.add(SupprimerCand(somebody));
			return somebodyMenu;
		}
		
		private Option SupprimerCand(String somebody)
		{
			return new Option("SuppCand", "s", new Action()
			{
				@Override
				public void optionSelected()
				{
					System.out.println("Entrer nom: " + somebody + ".");
				}
			});
		}	

	}
}
