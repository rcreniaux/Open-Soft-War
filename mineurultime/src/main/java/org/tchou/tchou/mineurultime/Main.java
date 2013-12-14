package org.tchou.tchou.mineurultime;

import java.util.Scanner;

public class Main {

	private static final String CARACTERE_ESPACE = "\\s";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// on transmet notre nom au simu
		System.out.println("Mineur ultime");

		// on reçoit les informations d'initialisation de la mine (largeur, hauteur et nombre total de diamants). ex: 40 25 170
		String initEnv = scanner.nextLine();

		Mine mine = initMine(initEnv);
		System.out.println(mine.toString());

		while (true) {
			try {
				// - position du mineur sur la carte (0≤x<largeur et 0≤y<hauteur ex: x=12 y=18) et nombre de joueur en vue (0)
				// 1ere ligne: 12 18 0
				// 2eme ligne: S 7 7 S M
				// 3eme ligne: S M S S M
				// 4eme ligne: S M X M M
				// 5eme ligne: S S M M M
				// 6eme ligne: S M M S M
				// 7eme, 8eme et 9eme lignes sont présentes seulement si les mineurs adverses sont en vue

				// Position du mineur et nombre d'ennemis aux alentours
				String positionAndNbEnnemis = scanner.nextLine();
				Position positionMineur = parsePosition(positionAndNbEnnemis);

				System.out.println(positionMineur.toString());

				String[] posValues = positionAndNbEnnemis.split(CARACTERE_ESPACE);
				int nbEnnemis = Integer.parseInt(posValues[2]);

				System.out.println("nbEnnemis: " + nbEnnemis);

				// environnement proche du mineur (5x5 cases avec le mineur au milieu)
				String[][] env = new String[5][5];
				for (int numLigne = 0; numLigne < 5; numLigne++) {
					String[] ligne = scanner.nextLine().split(CARACTERE_ESPACE);
					for (int numColonne = 0; numColonne < 5; numColonne++) {
						env[numLigne][numColonne] = ligne[numColonne];
					}
				}

				// recuperation des position des adversaires (optionnel)
				StringBuilder positionAdversaires = new StringBuilder();
				for (int i = 1; i <= nbEnnemis; i++) {
					positionAdversaires.append(scanner.nextLine());
				}

				// send command to goldrush-simu
				System.out.println(MineurAction.WEST);

			} catch (Exception e) {
				break;
			}
		}

	}

	private static Position parsePosition(String initPosition) {
		String[] posValues = initPosition.split(CARACTERE_ESPACE);
		int positionX = Integer.parseInt(posValues[0]);
		int positionY = Integer.parseInt(posValues[1]);
		return new Position(positionX, positionY);
	}

	private static Mine initMine(String initEnv) {
		String[] envValues = initEnv.split(CARACTERE_ESPACE);
		int largeur = Integer.parseInt(envValues[0]);
		int hauteur = Integer.parseInt(envValues[1]);
		int nbDiamants = Integer.parseInt(envValues[2]);
		return new Mine(largeur, hauteur, nbDiamants);
	}

}
