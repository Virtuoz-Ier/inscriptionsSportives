package dialogue;

import commandLineMenus.*;

public class ListComp {

    private java.util.List<String> competition;

    ListComp(java.util.List<String> competition)
    {
        this.competition = competition;
        List<String> list = getCompetitionList();
        list.start();
    }

    private List<String> getCompetitionList()
    {
        List<String> liste = new List<>("Select compétition",
                getListDataCompetition(),
                getOptionListeCompetition());
        liste.setAutoBack(false);
        liste.addQuit("q");
        return liste;
    }

    private ListData<String> getListDataCompetition()
    {
        return new ListData<String>()
        {
            @Override
            public java.util.List<String> getList()
            {
                return competition;
            }
        };
    }

    private ListOption<String> getOptionListeCompetition()
    {
        return new ListOption<String>()
        {

            public Option getOption(String UneCompetition)
            {
                return getUneCompetitionMenu(UneCompetition);
            }
        };
    }

   
    private Option getUneCompetitionMenu(final String UneCompetition)
    {
        Menu UneCompetitionMenu = new Menu(UneCompetition);
        UneCompetitionMenu.add(getDisplayUneCompetitionOption(UneCompetition));
        UneCompetitionMenu.add(getDeleteUneCompetitionOption(UneCompetition));
        UneCompetitionMenu.addBack("w");
        UneCompetitionMenu.setAutoBack(true);
        return UneCompetitionMenu;
    }

    
    private Option getDisplayUneCompetitionOption(String UneCompetition)
    {
        return new Option("afficher", "f", new Action()
        {
            @Override
            public void optionSelected()
            {
                System.out.println("Nom personne : " + UneCompetition + ".");
            }
        });
    }


    private Option getDeleteUneCompetitionOption(String UneCompetition)
    {
        return new Option("supprimer", "s", new Action()
        {
            @Override
            public void optionSelected()
            {
                competition.remove(UneCompetition);
                System.out.println(UneCompetition + " a été supprimée");
                System.out.println(competition);
            }
        });
    }
}
