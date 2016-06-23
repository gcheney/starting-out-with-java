package serialization;

import java.io.*;

public class SerializeDemo{
	
   public static void main(String [] args) {
	   
      Employee employee = new Employee("Reyan Ali", 
    		  "Phokka Kuan, Ambehta Peer", 11122333, 101);

      try {
    	 //Create output objects
         FileOutputStream fileOut = new FileOutputStream("employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         
         //write the serializable class
         out.writeObject(employee);
         
         //close objects
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in employee.ser");
      }
      catch (IOException ex) {
          ex.printStackTrace();
      }
   }
}