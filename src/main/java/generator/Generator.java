package generator;

import java.util.HashMap;
import java.util.Map;


/**
 * This program builds a password generator.
 * @version 1.0
 * @author CEmmH
 */
public class Generator{
	private int length;
	private Map<CRITERIA,Boolean> requestMap = new HashMap<CRITERIA, Boolean>();
	/**
	 * constructor declaration
	 * @param length: the password's length
	 * @param map: collect the criteria
	 */
	public Generator() {
		length = 16;
		requestMap.put(CRITERIA.UPPERCASE, true);
		requestMap.put(CRITERIA.LOWERCASE, true);
		requestMap.put(CRITERIA.NUMBER, true);
		requestMap.put(CRITERIA.SYMBOL, true);
	}
	public Generator(int length, Map<CRITERIA,Boolean> map) { 
		this.length = length;
		requestMap = map;
	}
	
	public String generatePassword() {
		Password password;
		Map<CRITERIA,Boolean> pMap = new HashMap<CRITERIA,Boolean>();
		
		StringBuilder pass;
		Alphabet pool = new Alphabet(requestMap);
		String charPool = pool.getAlphabat();
		int poolLength = charPool.length();
		
		do {
			pass = new StringBuilder();
			for(int i = 0; i < length; i++) {
				int index = (int)(Math.random()*poolLength);
				pass.append(charPool.charAt(index));
			}
			password = new Password(pass.toString());			
			pMap = password.getPasswordStatus();			
		}while(!pMap.equals(requestMap)); 	
		return password.toString();
	}
}