package testunitaire;

import static org.junit.Assert.*;
import java.util.SortedSet;
import inscriptions.*;
import org.junit.Test;

public class TestEquipe {
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Equipe fire = inscriptions.createEquipe("Bonjour everyone");
	
	Personne personnes = inscriptions.createPersonne("Patrick", "Lemoustique", "test@test.com");
	Personne gens = inscriptions.createPersonne("Marin", "Patetedouce", "testdouce@test.com");
	
	@Test
	public void testGetMembres() {
		SortedSet<Personne> lesMembres = fire.getMembres();
		fire.add(personnes);
		fire.add(gens);

		
		assertEquals(lesMembres, fire.getMembres());
	}

	
	@Test
	public void testAddpersonne() {
		SortedSet<Personne> lesMembres = fire.getMembres();
		fire.add(personnes);
		fire.add(gens);
		
		
		assertTrue(lesMembres.contains(personnes) && lesMembres.contains(gens));
	}


	@Test
	public void testRemovePersonnesonne() {
		SortedSet<Personne> membres = fire.getMembres();
		fire.add(personnes);
		fire.add(gens);

		
		fire.remove(personnes);
		fire.remove(gens);
	
		
		assertTrue(!membres.contains(personnes));
	}
}
