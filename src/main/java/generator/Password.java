package generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @version 1.0
 * @author CEmmH
 */
public class Password{
	String password;
	int length;
	    
	
	public Password(String p) {
		password = p;
		length = p.length();
	}

	/**
	 * This method checks if the password reach the minimum length.
	 * @return 
	 */
	public boolean checkLength() {
		if(length>=8) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * This method checks if the password meet criteria.
	 * @return Map<CRITERIA,Boolean> 
	 */
	public Map<CRITERIA,Boolean> getPasswordStatus() {	
		Map<CRITERIA,Boolean> mCriteria = new HashMap<>();
		mCriteria.put(CRITERIA.UPPERCASE, false);
		mCriteria.put(CRITERIA.LOWERCASE, false);
		mCriteria.put(CRITERIA.NUMBER, false);
		mCriteria.put(CRITERIA.SYMBOL, false);
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			CRITERIA type = charType(c);
			mCriteria.put(type, true);			
		}
		return mCriteria;
	}
	/**
	 * This method checks if the password contain all the needs.
	 * @param map
	 * @return CRITERIA[] shows the criteria that are not met, 
	 * 			if it is empty, it means the password is valid.
	 */
	public CRITERIA[] checkIfValid(Map<CRITERIA,Boolean> map) {
		Set<CRITERIA> list = new HashSet<CRITERIA>();
		
		if(map.containsValue(false)) {
			for(Map.Entry<CRITERIA, Boolean> entry : map.entrySet() ) {
				if(entry.getValue()==false) {
					list.add(entry.getKey());
				}
			}
		}
		
		CRITERIA[] result = new CRITERIA[list.size()];
		result = list.toArray(result);
		return result;
	}
	
	
	/**
	 * This method verifies the characters' format
	 * @param character
	 * @return the character's type
	 */
	public CRITERIA charType(char c) {
		CRITERIA type;
		int a = (int)c;
		
		//char is upper case Letter
		if(a >= 65 && a <= 90)
			type = CRITERIA.UPPERCASE;
		//char is lower case letter
		else if(a >= 97 && a <= 122)
			type = CRITERIA.LOWERCASE;
		//char is number
		else if(a >= 48 && a <= 57)
			type = CRITERIA.NUMBER;
		//char is special characters
		else
			type = CRITERIA.SYMBOL;
		return type;
	}
	
	public String toString() {
		return password;
	}
}