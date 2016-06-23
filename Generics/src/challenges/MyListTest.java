package challenges;

public class MyListTest {

	public static void main(String[] args) {
		
		MyList<Integer> list = new MyList<Integer>();
		
		list.add(300);
		list.add(400);
		list.add(500);
		list.add(200);
		System.out.println(list.largest());
		System.out.println(list.smallest());
		

		MyList<String> strList = new MyList<String>();
		
		strList.add("fuck");
		strList.add("young");
		strList.add("ack");
		System.out.println(strList.largest());
		System.out.println(strList.smallest());
		
		System.exit(0);
	}

}
