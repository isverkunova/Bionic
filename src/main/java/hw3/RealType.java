package hw3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealType {

	private Pattern pattern;
	private Matcher matcher;
	
	private String regex = "[+-]?(?:\\d+\\.\\d+)";
	
	public boolean verification(String number){
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(number);
		return matcher.matches();
	}
		
}
