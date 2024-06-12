package generator;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @version 1.0
 * @author CEmmH
 */
public class Main{
	public static void main(String[] args) {
		Password p = new Password("Dbe&us");
		Map<CRITERIA,Boolean> mp = new HashMap<CRITERIA,Boolean>();
		mp = p.getPasswordStatus();
		CRITERIA[] result =  p.checkIfValid(mp); 
		int length = Array.getLength(result);
	
		if(length == 0 && p.checkLength()) {
			System.out.println("Congratulation, you set a stong password.");
		}else if(length == 0 && !p.checkLength()) {
			System.out.println("The password's minimum length must be 8.");
		}else {
			for(int i = 0; i < length; i++) {
				System.out.println("Your password needs contain at least 1 "+ result[i]+".");
			}
		}
		
		Set<CRITERIA> keys = mp.keySet();
		for(CRITERIA key : keys) {
			System.out.println(key + ":" + mp.get(key));
		}
		
	}
}