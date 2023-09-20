package uniqueCharactersHW.java;

public class UniqueCharacterHW {

	public static void main(String[] args) {
        System.out.println(IsAllUnique("stack")); // Should print true
        System.out.println(IsAllUnique("unique")); // Should print false
        System.out.println(IsAllUnique("abcdefg")); // Should print true
        System.out.println(IsAllUnique("hello")); // Should print false
        System.out.println(IsAllUnique("12345")); // Should print true
        System.out.println(IsAllUnique("112233")); // Should print false
    }
	
	

	    public static boolean IsAllUnique(String str) {
	        // Create a boolean array to keep track of characters seen
	        boolean[] sameCharacter = new boolean[128]; // Assuming ASCII characters

	        for (int i = 0; i < str.length(); i++) {
	            char Characters = str.charAt(i);

	            // If the character is already seen, return false
	            if (sameCharacter[Characters]) {
	                return false;
	            }

	            // Mark the character as seen
	            sameCharacter[Characters] = true;
	        }

	        // If we've gone through the entire string without any repeats, return true
	        return true;
	    }
	}


	/*This code uses a boolean array of size 128 (assuming ASCII characters) to keep track of whether each character has been 
	seen or not. It iterates through the input string, and for each character, it checks if it has been seen before. 
	If a character has been seen already, the function returns false since it means the string has duplicate characters. 
	Otherwise, it marks the character as seen and continues checking the next characters. 
	If the function goes through the entire string without finding any repeats, it returns true, 
	indicating that all characters are unique.*/



