package org.tchou.tchou.mineurultime.mineur.archetypes;

import java.util.Random;

import org.tchou.tchou.mineurultime.mineur.Mineur;
import org.tchou.tchou.mineurultime.mineur.MineurAction;
import org.tchou.tchou.mineurultime.mineur.Position;

public class RandomMineur extends Mineur {

	Random random;

	public RandomMineur(Position position) {
		this(position, new Random());
	}

	public RandomMineur(Position position, Random random) {
		super(position);
		this.random = random;
	}

	@Override
	public MineurAction doAction() {
		MineurAction action = null;
		switch (random.nextInt(MineurAction.values().length)) {
		case 0:
			action = MineurAction.DROP;
			break;
		case 1:
			action = MineurAction.EAST;
			break;
		case 2:
			action = MineurAction.NORTH;
			break;
		case 3:
			action = MineurAction.PICK;
			break;
		case 4:
			action = MineurAction.SHOOT;
			break;
		case 5:
			action = MineurAction.SOUTH;
			break;
		case 6:
			action = MineurAction.WEST;
			break;
		}
		return action;
	}

}
