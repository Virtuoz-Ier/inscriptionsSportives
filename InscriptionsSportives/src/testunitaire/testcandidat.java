package testunitaire;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class testcandidat {
	
	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Personne personne = inscriptions.createPersonne("Dolores", "Dupont", "jetrythis@test.com");
	Personne gens = inscriptions.createPersonne("Dolores", "Dupont", "jetrythis@test.com");
	

	@Test
	public void testGetNom() {
		assertEquals("Dolores", personne.getNom());
	}

	@Test
	public void testSetNom() {
		personne.setNom("Th�odor");
		assertEquals("Th�odor", personne.getNom());
	}



	@Test
	public void testAdd() {
		Set<Competition> Competitions = personne.getCompetitions();
		Competition testCompetition = inscriptions.createCompetition("Comp�tition de beach soccer", null, false);
		testCompetition.add(personne);
		
		assertTrue(Competitions.contains(testCompetition));
	}
	

	@Test
	public void testRemove() {
		Set<Competition> Competitions = personne.getCompetitions();
		Competition testCompetition = inscriptions.createCompetition("Comp�tition de beach soccer", null, false);
		testCompetition.add(personne);
		testCompetition.remove(personne);
		
		assertFalse(Competitions.contains(testCompetition));
	}



	@Test
	public void testDelete() {
		Set<Competition> Competitions = personne.getCompetitions();
		Competition testCompetition = inscriptions.createCompetition("Comp�tition de beach soccer", null, false);
		testCompetition.add(personne);
		personne.delete();
	
		assertTrue(Competitions.isEmpty());
	}
	
	
	@Test
	public void testCompareTo() {
		assertTrue(personne.compareTo(gens) == 0);
	}

	
	@Test
	public void testToString() {
		
	}

}