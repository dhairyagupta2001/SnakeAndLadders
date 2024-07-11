package main;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Board {
	Queue<Players> players;
	List<Locations> Snake;
	List<Locations> ladders;
	Map<String, Integer> postion;// save the position
	Dice dice;
	int boardsize;

	public Board(Queue<Players> players, List<Locations> Snake, List<Locations> ladders, Map<String, Integer> postion,
			Dice dice, int boardsize) {
		this.players = players;
		this.Snake = Snake;
		this.ladders = ladders;
		this.postion = postion;
		this.dice = dice;
		this.boardsize = boardsize;
	}

	public void MatchStarts() {
		while (players.size() > 1) {
			Players player = players.poll();
			int extra = dice.Roll();
			int AfterMoving = extra + postion.get(player.getName());
			if (AfterMoving > boardsize) {
				players.add(player);
				continue;
			} else if (AfterMoving == boardsize) {
				System.out.println("won the game:- " + player.getName());
			} else {
				int[] nextpostion = new int[1];
				nextpostion[0] = AfterMoving;
				boolean[] ladder = new boolean[1];
				Snake.forEach(v -> {
					if (v.getStart() == AfterMoving) {
						nextpostion[0] = v.getEnd();
					}
				});
				if (nextpostion[0] != AfterMoving) {
					System.out.println(player.getName() + " has been bitten");
				}
				ladders.forEach(v -> {
					if (v.getStart() == AfterMoving) {
						nextpostion[0] = v.getEnd();
						ladder[0] = true;
					}
				});
				if (nextpostion[0] != AfterMoving && ladder[0]) {
					System.out.println("he goes up to the ladder " + player.getName());
				}
				if (nextpostion[0] == boardsize) {
					System.out.println(player.getName() + " won");
				} else {
					postion.put(player.getName(), nextpostion[0]);
					System.out.println(player.getName() + " is at postion " + nextpostion[0]);
					players.add(player);
				}
			}
		}

	}
}
