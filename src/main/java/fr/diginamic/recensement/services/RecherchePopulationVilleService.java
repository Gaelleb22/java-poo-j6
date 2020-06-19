package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.ClasseException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ClasseException{

		System.out.println("Quel est le nom de la ville recherchÃ©e ? ");
		String choix = scanner.nextLine();

		List<Ville> villes = rec.getVilles();
		Ville villeChoisie = null;
		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				villeChoisie = ville;
				System.out.println(villeChoisie);
			}
		}
		if (villeChoisie == null) {
			throw new ClasseException("Cette ville n'est pas dans la base de donnée");
		}
	}

}
