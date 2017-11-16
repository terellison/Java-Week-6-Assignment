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
		if(s.length() == 0) {
			return max;
		}
		
		
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
				String number = numString.toString();
				
				int wholeNumber = Integer.valueOf(number);
				
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
