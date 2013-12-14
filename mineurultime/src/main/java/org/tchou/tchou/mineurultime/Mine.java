package org.tchou.tchou.mineurultime;

public class Mine {

	private int largeur;
	private int hauteur;
	private int nbDiamants;

	public Mine(int largeur, int hauteur, int nbDiamants) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.nbDiamants = nbDiamants;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getNbDiamants() {
		return nbDiamants;
	}

	@Override
	public String toString() {
		return "Mine [largeur=" + largeur + ", hauteur=" + hauteur + ", nbDiamants=" + nbDiamants + "]";
	}

}
