package dreamincode;

public class MultipleExceptions {
	
	public static void main(String Args[]){
		int[] array = new int[3];
		try{			
			for(int i=0;i<3;++i){
				array[i] = i;
			}
			array[0] = 2/0;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Oops, we went to far, better go back to 0!");
		}
		catch(ArithmeticException e){
			System.out.println("Cannot Divide by Zero!");
			//method call to continue program
		}
		catch(Exception e){
			System.out.println("An Unknown Error has Occured");
			e.printStackTrace();
		}
		finally{
			System.out.println(array);
			//method call to continue program	
		}
	}
}
