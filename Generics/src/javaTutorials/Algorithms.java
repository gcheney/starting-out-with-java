package javaTutorials;

import java.util.Collection;
import java.util.List;

public final class Algorithms {
	
    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c) {
            if (p.test(elem)) {
                ++count;
            }
        }
        
        return count;
    }
    
    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
    	//for {; begin < end; ++begin) {
	    for (int i = begin; i < end; i++) {
	        if (p.test(list.get(i))) {
	            return i;
	        }
	    }
	    
	    return -1;
	}
	
	// x > 0 and y > 0
	public static int gcd(int x, int y) {
		if (x < 0 || y < 0) {
			return -1;
		}
		
	    //for (int r; (r = x % y) != 0; x = y, y = r) { }
		int r;
		while ((r = x % y) != 0) {
			x = y;
			y = r;
		}
		
	    return y;
	}
}
