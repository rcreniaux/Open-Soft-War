package org.tchou.tchou.mineurultime;

public class Position {

	private int positionX;
	private int positionY;

	public Position(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	@Override
	public String toString() {
		return "Position [positionX=" + positionX + ", positionY=" + positionY + "]";
	}

}
