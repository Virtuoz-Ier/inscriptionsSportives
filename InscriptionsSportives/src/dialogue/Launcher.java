package dialogue;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class Launcher
{
	public static void main(String[] args)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Competition flechettes = inscriptions.createCompetition("Mondial de fléchettes", null, false);
		Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty"), 
				boris = inscriptions.createPersonne("Boris", "le Hachoir", "ytreza");
		flechettes.add(tony);
		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
		lesManouches.add(boris);
		lesManouches.add(tony);
		
		MenuInscriptions menu = new MenuInscriptions("Menu Inscription", inscriptions);
		menu.launch();
	}
}