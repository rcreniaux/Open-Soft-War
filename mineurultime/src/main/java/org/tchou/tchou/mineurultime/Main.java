package org.tchou.tchou.mineurultime;

import java.io.IOException;

import org.tchou.tchou.mineurultime.communication.ComServeur;
import org.tchou.tchou.mineurultime.mine.Mine;
import org.tchou.tchou.mineurultime.mineur.Mineur;
import org.tchou.tchou.mineurultime.mineur.Position;
import org.tchou.tchou.mineurultime.mineur.archetypes.RandomMineur;

public class Main {

	private static final String DELIMITER_ESPACE = "\\s";

	public static void main(String[] args) {
		ComServeur comServeur = new ComServeur();

		// initialisation du mineur avec un archetype particulier
		Mineur mineur = new RandomMineur();

		// on transmet notre nom au simu
		System.out.println("Mineur ultime Proto");

		// on reçoit les informations d'initialisation de la mine (largeur, hauteur et nombre total de diamants). ex: 40 25 170

		try {
			Mine mine = new Mine(comServeur.getNextLine(), DELIMITER_ESPACE);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		// System.out.println(mine.toString());

		try {
			while (true) {
				// - position du mineur sur la carte (0≤x<largeur et 0≤y<hauteur ex: x=12 y=18) et nombre de joueur en vue (0)
				// 1ere ligne: 12 18 0
				// 2eme ligne: S 7 7 S M
				// 3eme ligne: S M S S M
				// 4eme ligne: S M X M M
				// 5eme ligne: S S M M M
				// 6eme ligne: S M M S M
				// 7eme, 8eme et 9eme lignes sont présentes seulement si les mineurs adverses sont en vue

				// Position du mineur et nombre d'ennemis aux alentours
				String positionAndNbEnnemis = comServeur.getNextLine();
				Position positionMineur = new Position(positionAndNbEnnemis, DELIMITER_ESPACE);
				// System.out.println(positionMineur.toString());

				String[] posValues = positionAndNbEnnemis.split(DELIMITER_ESPACE);
				int nbEnnemis = Integer.parseInt(posValues[2]);

				// System.out.println("nbEnnemis: " + nbEnnemis);

				// environnement proche du mineur (5x5 cases avec le mineur au milieu)
				String[][] env = new String[5][5];
				for (int numLigne = 0; numLigne < 5; numLigne++) {
					String[] ligne = comServeur.getNextLine().split(DELIMITER_ESPACE);
					for (int numColonne = 0; numColonne < 5; numColonne++) {
						env[numLigne][numColonne] = ligne[numColonne];
					}
				}

				// recuperation des position des adversaires (optionnel)
				StringBuilder positionAdversaires = new StringBuilder();
				for (int i = 1; i <= nbEnnemis; i++) {
					positionAdversaires.append(comServeur.getNextLine());
				}

				// send command to goldrush-simu
				comServeur.sendCommand(mineur.doAction().toString());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
