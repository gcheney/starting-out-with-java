package javaTutorials;

import java.util.*;

public class GenericListMethod {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("fuck");
		list.add("you");
		list.add("cocksucker");
		
		System.out.println(max(list, 0, list.size()));
	}
	
	public static <T extends Comparable<? super T>> T max(List<? extends T> list, int begin, int end) 
	{
		T maxElem = list.get(begin);

		for (++begin; begin < end; ++begin)
			if (maxElem.compareTo(list.get(begin)) < 0)
				maxElem = list.get(begin);
		
		return maxElem;
	}

}
