package org.tchou.tchou.mineurultime.mineur;

public class Position {

	private int positionX;
	private int positionY;

	public Position(String position, String delimiter) {
		parsePosition(position, delimiter);
	}

	private void parsePosition(String initPosition, String delimiter) {
		String[] posValues = initPosition.split(delimiter);
		positionX = Integer.parseInt(posValues[0]);
		positionY = Integer.parseInt(posValues[1]);
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
