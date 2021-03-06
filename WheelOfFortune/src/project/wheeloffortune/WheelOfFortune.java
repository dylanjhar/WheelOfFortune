package project.wheeloffortune;

import java.util.Scanner;

public class WheelOfFortune {

	public static void main(String[] args) {
		char[] userWord = {'-', '-', '-', '-', '-', '-', '-', '-'};
		String word = "computer";
		int attempts = word.length() + 5;
		char guess;
		
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		while (!done && attempts > 0) {
			System.out.println("You have " + attempts +" attempts left");
			System.out.println(userWord);
			System.out.println("Letter: ");
			guess = scan.next().charAt(0);
			attempts -= 1;
			find(word, userWord, guess);
			done = checkDone(word, userWord);
		}
		System.out.println(userWord);
		if (done) {
			System.out.println("You won!");
		} else {
			System.out.println("Uh oh, better luck next time champ");
		}
		scan.close();
	}
	
	public static void find(String word, char[] userWord, char guess) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess) {
				userWord[i] = guess;
			}
		}
		
	}
	
	public static boolean checkDone(String word, char[] userWord) {
		boolean match = true;
		int i = 0;
		while (i < word.length() && match == true) {
			if (word.charAt(i) != userWord[i]) {
				match = false;
			}
			i++;
		}
		return match;
	}
}
