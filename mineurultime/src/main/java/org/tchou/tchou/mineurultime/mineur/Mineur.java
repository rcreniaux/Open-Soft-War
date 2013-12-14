package org.tchou.tchou.mineurultime.mineur;


public abstract class Mineur{

	protected Position positionCourante;
	
	public Mineur(Position position) {
		this.positionCourante = position;
	}
	
	public abstract MineurAction doAction();

}
