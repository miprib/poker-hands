package poker;

import java.time.Duration;
import java.time.Instant;

public class Main {
	public static void main(String[] args) {
		Instant start = Instant.now();
		PokerFacade pokerFacade = new PokerFacade();
		//pokerFacade.playOneGame("6H TD 9D AS JH", "6C QC 9S KD JC");
		pokerFacade.playAllGames("src/main/resources/poker.txt");      
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("Time: " + timeElapsed + " ms");
	}
}
