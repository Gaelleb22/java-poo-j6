package fr.diginamic.recensement.services;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fr.diginamic.exemple.exceptions.ClasseException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un d√©partement dont la population est comprise
 * entre une valeur min et une valeur max renseign√©es par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ClasseException{

		System.out.println("Quel est le code du d√©partement recherch√© ? ");
		String choix = scanner.nextLine();
		
		List<Ville> dep = rec.getVilles();
		Set<String> departement = new HashSet<>();
		for(Ville ville : dep) {
			departement.add(ville.getCodeDepartement());
		}
		if(!departement.contains(choix)) {
			throw new ClasseException("Code de dÈpartement inconnu");
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		
		if (!Character.isDigit(saisieMin.charAt(0))) {
			throw new ClasseException("Entrer un nombre suppÈrieur ou Ègal ‡ 0");
		}
		

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		if (!Character.isDigit(saisieMax.charAt(0))) {
			throw new ClasseException("Entrer un nombre suppÈrieur ou Ègal ‡ 0");
		}
	
		if (Integer.parseInt(saisieMax)<Integer.parseInt(saisieMin)) {
			throw new ClasseException("Le nombre max ne peut pas Ítre infÈrieur au min");
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
