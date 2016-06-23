package javaTutorials;

import java.util.Collection;

public class RelativelyPrimePredicate implements UnaryPredicate<Integer> {
	 private Collection<Integer> c;
	 
     public RelativelyPrimePredicate(Collection<Integer> c) {
        this.c = c;
     }

    public boolean test(Integer x) {
        for (Integer i : c) {
            if (Algorithms.gcd(x, i) != 1) {
                return false;
            }
        }

        return c.size() > 0;
    }

}
