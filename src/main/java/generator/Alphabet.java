package generator;
import java.util.HashMap;
import java.util.Map;

/**
 * This program is designed to create a pool that collects all available symbols.
 * @version 1.0 
 * @author CEmmaH
 */
public class Alphabet{
	public static final String UPERCASE_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTER = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
	
	static Map<CRITERIA,String> charMap = new HashMap<CRITERIA,String>();
	
	static {
		charMap.put(CRITERIA.UPPERCASE,UPERCASE_LETTER);
		charMap.put(CRITERIA.LOWERCASE, LOWERCASE_LETTER);
		charMap.put(CRITERIA.NUMBER,NUMBERS);
		charMap.put(CRITERIA.SYMBOL, SYMBOLS);
	}
	
	
	
	private final StringBuilder pool ;
	
	public Alphabet(Map<CRITERIA,Boolean> maps) {
		pool = new StringBuilder();
		for (Map.Entry<CRITERIA,Boolean> entry : maps.entrySet()) {
			if(entry.getValue() == true) {
				pool.append(charMap.get(entry.getKey()));
			}
		}		
	}
	
	public String getAlphabat() {
		return pool.toString();
	}
}