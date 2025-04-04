package questions;


import java.util.Scanner;

public class MobileNumberService {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
   
        System.out.print("Enter a number: ");
        String num = scanner.nextLine();
        int score = rateNumbers(num);
      
        System.out.println("Memorability rating for " + num + ": " + score);
	}
	
	public static int rateNumbers(String num) {
        int score = 0;    
        if (num.length() <= 3) {
            score += 3;
        } else if (num.length() <= 5) {
            score += 2;
        } else {
            score += 1;
        }
        if (isPalindrome(num)) {
            score += 3;
        }
        if (hasRepeatingDigits(num)) {
            score += 2;
        }
        return score;
    }

	public static boolean isPalindrome(String number) {
        for (int i = 1; i < number.length()/2; i++) {
            if (number.charAt(i) != number.charAt(number.length()-i-1)) {
                return false;
            }
        }
        return true;
    } 
	
	   public static boolean hasRepeatingDigits(String number) {
	        for (int i = 1; i < number.length(); i++) {
	            if (number.charAt(i) != number.charAt(0)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
}