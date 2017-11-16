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
		return 0;
	}
}
