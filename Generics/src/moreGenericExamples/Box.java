package moreGenericExamples;

public class Box<T> {

	  private T element;

	  public void add(T element) {
	    this.element = element;
	  }

	  public T getElement() {
	    return element;
	  }

	  public static void main(String[] args) {
	     Box<Integer> integerBox = new Box<Integer>();
	     Box<String> stringBox = new Box<String>();
	    
	     integerBox.add(new Integer(10));
	     stringBox.add(new String("Hello World"));

	     System.out.printf("Integer Value :%d\n\n", integerBox.getElement());
	     System.out.printf("String Value :%s\n", stringBox.getElement());
	  }
	}