// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {  
	    // Tests some of the operations
	     //System.out.println(plus(2,3));   // 2 + 3
	  //  System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
		System.out.println(7 % 0);
		System.out.println(0 % 8);
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x1 <0 && x2<0){
			for( int i = 0 ; i < -x2 ; i++ ){
				sum --  ;
				}
		}
		else if(x2 > 0){
			for( int i = 0 ; i < x2 ; i++ ){
			sum ++  ;
		    }
		}
		else if(x1>0){
			sum = x2;
			for( int i = 0 ; i < x1 ; i++ ){
				sum ++  ;
			}
		}
		return sum ;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int minus = x1;
		if(x2 < 0){
			for( int i = 0 ; i < -x2 ; i++ ){
				minus ++  ;
			}
		}
		else{
			for( int i = 0 ; i < x2 ; i++ ){
			    minus --  ;
		    }
		}
		return minus;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int times = x1 ;
		if( x1 == 0 || x2 == 0 ){
			return 0;
		}
		if(x2 < 0){
			for( int i = 1 ; i < -x2 ; i++ ){
				times = plus( times , x1 );
			}
			times= minus(0, times);
		}
		else {
			for( int i = 1 ; i < x2 ; i++ ){
			    times = plus( times , x1 );
		    }
		}
		return times ;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = x ;
		if(n == 0){
			return 1;
		}
		else if(n < 0 ){
			return 0;
		}
		for( int i = 1 ; i < n ; i++ ){
			pow = times ( pow , x );
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int mone = 0;
		int y = x2; 
		if(x1 < 0 && x2 < 0){
			y = -x2;
			while(y <= -x1){
				mone ++ ;
				y = plus( y , -x2 ) ;
			}
		}
		else if( x1 < 0 ){
			while(y <= -x1){
				mone ++ ;
				y = plus( y , x2 ) ;
			}
			mone= minus(0, mone);
		}
		else if( x2 < 0 ){
			while(y <= x1){
				mone ++ ;
				y = plus( y , -x2 ) ;
			}
			mone= minus(0, mone);
		} else{
			while(y <= x1){
			    mone ++ ;
			    y = plus( y , x2 ) ;
	    	}
		}
		
		return mone;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if( x1 == 0 || x2 == 0 ){
			return 0;
		}
		if (x1 <0){
			x1=minus(0, x1);
		}
		if (x2 <0){
			x2=minus(0, x2);
		}
		int div = div(x1 , x2);
		int times = times(x2 , div);
		return minus( x1 , times );
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sqrt = 0;
		if( x <= 0 ){
			return x ;
		}
		for( int i = 1 ; i <= x && pow(sqrt , 2) <= x ; i++ ){
			if( x == pow( i , 2 )){
				return i;
			}
			sqrt = i;
		}
		sqrt--;
		return sqrt;
	}	//  	

}