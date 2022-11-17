package bulls_and_cows;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		GuessMe game = new GuessMe();
		boolean new_game = true, new_game_response_ok;
		Scanner scan = new Scanner(System.in);
        String guess, bulls_and_cows, new_game_response;
		int bulls, cows;
		while (new_game) {
			game.restart();
			//While the guess is incorrect
			do {
				//Get new guess
				do {
					System.out.println("Enter a 4-number guess");
					guess= scan.nextLine();
				} while (!game.check_number(guess));
				game.add_guess();
				bulls_and_cows=game.compare_number(guess);
				bulls=bulls_and_cows.charAt(game.get_bulls_index())-'0';
				cows=bulls_and_cows.charAt(game.get_cows_index())-'0';
				game.print_bulls_and_cows(bulls, cows);
				game.print_history();
			} while (bulls!=4);
			System.out.println("Game finished! The number of guesses was "+game.get_guess_number());
			//Ask the user about a new game
			new_game_response_ok=false;
			do {
				System.out.println("Do you want to play a new game? (yes / no)");
				new_game_response= scan.nextLine();
				if(new_game_response.equals("yes")) {
					new_game=true;
					new_game_response_ok=true;
				}
				if(new_game_response.equals("no")) {
					new_game=false;
					new_game_response_ok=true;
				}
			} while (!new_game_response_ok);
		}
		scan.close();
	}
}
