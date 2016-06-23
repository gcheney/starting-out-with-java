package dreamincode;

import java.io.Serializable;

/**
 * This class define is the object FirstName that will be stored in the DB
 * An object that wants to be stored in a DB needs to implement Serializable
 */
public class FirstName extends GenericName implements Serializable {

	// This a unique number that will be used during serialization
	private static final long serialVersionUID = 200906271625L;

	// Constructor that calls the father GenericName
	FirstName(String name) {
		super(name);
	}

}