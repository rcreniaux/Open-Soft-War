package org.tchou.tchou.mineurultime.mineur.archetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.tchou.tchou.mineurultime.mineur.MineurAction;

public class RandomMineurTest {

	private final long seedRandom = 15151561615055L;

	@Test
	public void testDoAction() throws Exception {
		List<MineurAction> mineurActionsExpected = Arrays.asList(MineurAction.NORTH, MineurAction.WEST, MineurAction.SOUTH, MineurAction.WEST, MineurAction.PICK, MineurAction.DROP, MineurAction.EAST, MineurAction.SHOOT, MineurAction.PICK, MineurAction.NORTH);
		
		Random random = new Random(seedRandom);
		RandomMineur mineur = new RandomMineur(null, random);

		List<MineurAction> mineurActions = new ArrayList<MineurAction>();
		for (int i = 0; i < 10; i++) {
			mineurActions.add(mineur.doAction());
		}
		
		Assertions.assertThat(mineurActions).containsExactly(mineurActionsExpected.toArray(new MineurAction[]{}));
	}

}
