package javaTutorials;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class TestAlgorithm {
	
    public static void main(String[] args) {
    	//test odd predicate
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4);
        int count = Algorithms.countIf(ci, new OddPredicate());
        System.out.println("Number of odd doubles = " + count);
        
        //test realtively prime predicate
        List<Integer> list = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate<Integer> p = new RelativelyPrimePredicate(c);

        int first = Algorithms.findFirst(list, 0, list.size(), p);

        if (first != -1) {
            System.out.print(list.get(first) + " is relatively prime to ");
            for (Integer k : c) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
