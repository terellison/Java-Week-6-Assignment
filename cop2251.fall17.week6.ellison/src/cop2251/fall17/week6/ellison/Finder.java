// Terry Ellison SPC ID: 2335229

package cop2251.fall17.week6.ellison;


public class Finder {

	public int sumIt(String s) {
		if(Character.isDigit(s.charAt(0))) {
			if(s.length() > 1) {
				return (Character.getNumericValue(s.charAt(0)) + sumIt(s.substring(1)));
			}
			else
				return (Character.getNumericValue(s.charAt(0)));
		}
		
		else if(s.length() > 1) {
			return sumIt(s.substring(1));
		}
		return 0;
	}
		
	
	public int findMax(String s, int max) {
		
		// check if the length of the string is zero; this is our recursion fail-safe
		if(s.length() == 0) {
			return max;
		}
		
		/* Checks if there is more than one character in the given string,
		 * if so then builds a string to hold every consecutive number after our start point.
		 * This is how we have multi-digit numbers instead of single integers.
		 * (i.e. 12 instead of comparing 1, then 2 on the next iteration) */
		
		if(s.length() > 1) {
			if(Character.isDigit(s.charAt(0))) {
				StringBuilder numString = new StringBuilder();
				int charIndex = 0;
				while(Character.isDigit(s.charAt(charIndex)) && charIndex <= (s.length() - 1)) {
					numString.append(s.charAt(charIndex));
					if((charIndex + 1) > (s.length() - 1)) {
						break;
					}
					else
						charIndex++;
				}
				
				// after our string of numbers is built we convert to an integer for comparison purposes
				
				String number = numString.toString();
				
				int wholeNumber = Integer.valueOf(number);

				/* Compares our newly built integer to the current maximum
				 * that was passed in. If our number is greater than the aforementioned max,
				 * then our integer becomes the new max and the function is called again with
				 * the updated maximum. Otherwise, the function is called again with the max
				 * and is given a substring starting at the stop position of our number building
				 * loop. */
				
				
				if(Character.isDigit(s.charAt(0))) {
					if(wholeNumber > max) {
						max = wholeNumber;
						if((s.length() - number.length()) == 0) {
							return max;
						}
						return findMax(s.substring(s.length() - number.length()), max);
					}
					else
						return findMax(s.substring(1), max);
				}
			}
		}
		
		/* Our scenario when we have reached the last character in the string;
		 * checks if the character is a digit and appropriately compares it to
		 * the current max as needed.
		 */
		
		else {
			if(Character.isDigit((s.charAt(0)))) {
				if(Character.getNumericValue(s.charAt(0)) > max) {
					max = Character.getNumericValue(s.charAt(0));
					return max;
				}
				else
					return max;
			}
		}
		return findMax(s.substring(1), max);
	}
}
