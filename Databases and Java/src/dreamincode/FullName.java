package dreamincode;

import java.io.Serializable;

/**
 * This class define is the object FullName that will be stored in the DB
 * An object that wants to be stored in a DB needs to implement Serializable
 */
public class FullName implements Serializable, GetSetId {

	// This a unuique number that will be used during serialization
	private static final long serialVersionUID = 200906271650L;

	// the Id of both FirstName and LastName
	private int lastNameId, firstNameId;
	// the age of the person
	private int age;
	
	// all the other variables are transient, they are not stored in the database
	// my own unique id in the DB
	private transient int id;
	
	// The FirstName and LastName objects (these are transient because not stored in the DB)
	private transient LastName lastName;
	private transient FirstName firstName;
	
	// Constructor that calls the father
	FullName(FirstName firstName, LastName lastName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		lastNameId = lastName.getId();
		firstNameId = firstName.getId();
		this.age = age;
	}

	public String toString() {
		return lastName.getName() + ", " + firstName.getName() + "  " + age + " years old";
	}

	public int getId() {
		return id;
	}
	// this one is called when read from the DB
	// we have to fill our transient fields
	public void setId(int id) {
		this.id = id;
		//firstName = FirstNameTable.getInstance().getById(firstNameId);
		//lastName = LastNameTable.getInstance().getById(lastNameId);
	}

	public final int getLastNameId() {
		return lastNameId;
	}

	public final void setLastNameId(int lastNameId) {
		this.lastNameId = lastNameId;
	}

	public final int getFirstNameId() {
		return firstNameId;
	}

	public final void setFirstNameId(int firstNameId) {
		this.firstNameId = firstNameId;
	}
	
	public int getAge() {
		return age;
	}
}
