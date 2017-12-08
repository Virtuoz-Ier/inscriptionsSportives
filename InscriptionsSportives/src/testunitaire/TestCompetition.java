package testunitaire;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Test;

import inscriptions.*;


public class TestCompetition {

	Inscriptions inscriptions = Inscriptions.getInscriptions();
	Competition competition = inscriptions.createCompetition("Seikooooo", LocalDate.now(), false);
	Competition competitions = inscriptions.createCompetition("Foot de rue", LocalDate.now(), true);
	Personne personne = inscriptions.createPersonne("Pila", "fee", "pife@test.com");
	
	
	@Test
	public void testGetNom() {

	}

	
	@Test
	public void testGetDateCloture() {
	   
		
	}
	
	public void testEstEnEquipe() {
		
	}

	@Test
	public void ouvert() {
	
	}
	
	
	@Test
	public void testGetCandidats() {
		Set<Candidat> candidats = competition.getCandidats();
		competition.add(personne);
		assertEquals(candidats, competition.getCandidats());
	}


	@Test
	public void testAddPersonne() {
		Set<Candidat> candidats = competition.getCandidats();
		competition.add(personne);
		assertTrue(candidats.contains(personne));
	}


	@Test
	public void testAddEquipe() {
		Set<Candidat> candidats = competition.getCandidats();
		Equipe jdbc = inscriptions.createEquipe("JDBC - Java DataBase Connectivity");
		competitions.add(jdbc);
		
	}

	
	@Test
	public void testRemove() {
		Set<Candidat> candidats = competition.getCandidats();
		competition.add(personne);
		competition.remove(personne);
		
		assertTrue(!candidats.contains(personne));
	}

	
	@Test
	public void testDelete() {
		SortedSet<Competition> competitionDel = inscriptions.getCompetitions();
		competition.delete();
		
		assertTrue(!competitionDel.contains(competition));
	}

	
	@Test
	public void testCompareTo() {
	
		Competition competitionQuis = inscriptions.createCompetition("Foot de rue", null, true);

		assertTrue(competitions.compareTo(competitionQuis) == 0);
	}
	
	public void testToString() {

		
	}
}