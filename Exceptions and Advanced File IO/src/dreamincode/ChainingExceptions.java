package dreamincode;

public class ChainingExceptions {
	
	private static class A {
		public A() throws Exception {
			try {
				new B();
			}
			catch(Exception e) {
				throw new Exception(e.getMessage() + "from A ", e);
			}
		}
	}
	
	private static class B {
		public B() throws Exception {
			try {
				aMethod();
			}
			catch(Exception e){
				throw new Exception("from aMethodl, ", e);
			}
		}
		public void aMethod() throws Exception {
			System.out.println("We are now in A->B->aMethod()");
			System.out.println(1/0); //error here
		}
	}
	
	public static void main(String args[]) {
		try{
			new A();
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}

