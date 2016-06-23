package serialization;

import java.io.*;

public class DeserializeDemo {
   public static void main(String [] args) {
      Employee employee = null;
      
      try {
    	  System.out.println("Deserializing Employee class...");
    	  FileInputStream fileIn = new FileInputStream("employee.ser");
    	  ObjectInputStream in = new ObjectInputStream(fileIn);
    	  employee = (Employee) in.readObject(); //cast back to employee
         
    	  //close objects
    	  in.close();
    	  fileIn.close();
      } catch(IOException e) {
         e.printStackTrace();
         return;
      } catch(ClassNotFoundException e) {
         System.out.println("Employee class not found");
         e.printStackTrace();
         return;
      }
      
      //call mail check function
      employee.mailCheck();
      
      //SSN is reset to 0 because it is transient
    }
}