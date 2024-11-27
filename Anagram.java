/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
        System.out.println(preProcess("what   to  do"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

        

		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1=preProcess(str1);
		str2=preProcess(str2);
		boolean anagram = true;
		char [] arr = new char [ str1.length() ];
		for(int i=0 ; i<str1.length() ; i++){
			arr[i]= str1.charAt(i);
		}
		for(int j=0 ; j<str2.length() && anagram ; j++){
			anagram=false;
			for(int r=0 ; r<arr.length && !anagram; r++){
				if(str2.charAt(j)==arr[r]){
					anagram=true;
					arr[r]=' ';
				}
			}
		}
		return anagram;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String upperabc= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean found= false;
		String newS = "" ;
		int mone = 0;
		String empty = " " ;
		String abc= "abcdefghijklmnopqrstuvwxyz";
		char [] arr = new char[str.length()];
		for( int i = 0 ; i < str.length() ; i++ ){
			for(int j = 0 ; j < abc.length() && !found ; j++ ){
				if( str.charAt(i) == upperabc.charAt(j) ){
                    arr[ mone ] = abc.charAt(j) ;
					mone++ ;
					found = true;
				}
			    else if(str.charAt(i)==abc.charAt(j) ){
					arr[mone]=str.charAt(i);
					mone++;
					found=true;
				} else if( str.charAt(i) == empty.charAt(0) ){
					arr[mone]=str.charAt(i);
					mone++;
					found=true;
				}
			}
			found=false;
		}
		for(int r = 0 ; r < mone ; r++ ){
			newS = newS + arr[r] ;
		}
		return newS ;
	} 
	 
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str=preProcess(str);
		String strchange=str;
		String strchange2="";
		String newstr = "" ;
		int rnd;
		for(int i=0 ; i<str.length(); i++ ){
			rnd = ( int )( Math.random() * strchange.length() ) ;
			for( int j = 0 ; j < strchange.length() ; j++ ){
				if(j!=rnd){
					strchange2 += strchange.charAt(j);
				}
                
			}
			newstr+= strchange.charAt(rnd);
			strchange=strchange2;
			strchange2="";
		}
		return newstr;
	}
}
