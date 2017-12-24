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
	

		
		static Inscriptions inscriptions;

			//Menu personne
			static Menu getMenuPersonne(Inscriptions inscriptions)
			{
				Menu menuPersonne = new Menu ("Gestion de Personnes","3");
				menuPersonne.add(getListePersonne());
				menuPersonne.add(getAjouterPersonne());
				menuPersonne.addBack("r");
				menuPersonne.setAutoBack(false);
				return menuPersonne;
			}
			
			//Liste de personnes
			private static Option getListePersonne()
			{
				return new Option("Liste de personne", "l", 
						() -> 
						{
							for (Personne insc : inscriptions.getPersonnes())
								System.out.println(insc);
						}
						
					);
			}
			//Action ajouter une personne
			private static Option getAjouterPersonne()
			{
				return new Option("Ajouter une personne", "a", 
						() -> 
						{
							inscriptions.createPersonne(InOut.getString("Prénom : "), 
							InOut.getString("Nom : "), InOut.getString("Email :"));

						}
					);
			}
			
			static Option getOptionSupprimerPersonne(Personne personne)
			{
				return new Option("Supprimer "+personne.getPrenom(),"2",getActionSupprimerPersonne(personne));
			}

			
			static Action getActionSupprimerPersonne(final Personne personne)
			{
				return new Action ()
				{
					@Override
					public void optionSelected()
					{
						personne.delete();
					}
				};
			}
			
			//voir les personne
			private static Option getOptionEditerUnePersonne(Personne inscriptions)
			{
				return new Option("Modifier "+inscriptions.getPrenom(),"6",getActionModifierPersonne(inscriptions));
			}
			
			//Action Modifier une personne
			static Action getActionModifierPersonne (final Personne personne){
				return new Action ()
				{
					@Override
					public void optionSelected()
					{
						personne.setNom(InOut.getString("Nom: "));
						personne.setPrenom(InOut.getString("Prenom: "));
						personne.setMail(InOut.getString("Mail: "));
					}
				};
	}
}