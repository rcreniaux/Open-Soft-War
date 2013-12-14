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

		// on transmet notre nom au simu pour initier la communication
		System.out.println("Mineur ultime");

		// on reçoit les informations d'initialisation de la mine (largeur, hauteur et nombre total de diamants). ex: 40 25 170
		try {
			Mine mine = new Mine(comServeur.getNextLine(), DELIMITER_ESPACE);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			while (true) {
				// - La 1ere ligne indique la position du mineur sur la carte sous la forme 'x y nbAdversaires' (0≤x<largeur et 0≤y<hauteur) et nombre de joueur en vue
				// 1ere ligne: 12 18 0
				// - De la 2nd ligne a la 6ème on a une représentation de la carte autour du mineur sous la forme de 5 caractères (entre chaque un espace fait office de delimiter 
				// X: notre mineur, M: Mud (terre), S: Stone (pierre), entier: nombre de diamants présent, E: Empty (vide)
				// 2eme ligne: S 7 7 S M
				// 3eme ligne: S M S S M
				// 4eme ligne: S M X M M
				// 5eme ligne: S S M M M
				// 6eme ligne: S M M S M
				// - 7eme, 8eme et 9eme lignes sont présentes seulement si des mineurs adverses sont en vue, position du mineur sur la carte (0≤x1<largeur et 0≤y1<hauteur)
				// x1 y1
				// x2 y2
				// x3 y3
				
				// Position du mineur et nombre d'ennemis aux alentours
				String positionAndNbEnnemis = comServeur.getNextLine();
				Position positionMineur = new Position(positionAndNbEnnemis, DELIMITER_ESPACE);

				String[] posValues = positionAndNbEnnemis.split(DELIMITER_ESPACE);
				int nbEnnemis = Integer.parseInt(posValues[2]);

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

				// initialisation du mineur
				Mineur mineur = new RandomMineur(positionMineur);
				
				// send command to goldrush-simu
				comServeur.sendCommand(mineur.doAction().toString());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
