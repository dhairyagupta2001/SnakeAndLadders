package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Dice dice = new Dice(1);
		Players playerA = new Players("Dhairya", 1);
		Players playerB = new Players("Gupta", 2);
		Queue<Players> allPlayers = new LinkedList<>();
		allPlayers.add(playerA);
		allPlayers.add(playerB);
		Locations snake1 = new Locations(10, 2);
		Locations snake2 = new Locations(99, 12);
		List<Locations> Snake = new ArrayList<>();
		Snake.add(snake1);
		Snake.add(snake2);
		Locations ladder1 = new Locations(5, 25);
		Locations ladder2 = new Locations(40, 89);
		List<Locations> Ladder = new ArrayList<>();
		Ladder.add(ladder1);
		Ladder.add(ladder2);
		Map<String, Integer> current = new HashMap<>();
		current.put("Dhairya", 0);
		current.put("Gupta", 0);
		Board gb = new Board(allPlayers, Snake, Ladder, current, dice, 100);
		gb.MatchStarts();
	}

}
