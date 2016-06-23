package dreamincode;

import java.io.Serializable;

/*
 * * This class will be overload by both FirstName and LastName
 * * It must implement Serializable
 */
public class GenericName implements Serializable, GetSetId {

	// use for serialization
	private static final long serialVersionUID = 200906292210L;
	
	// the actual only element stored in the DB
	private String name;
	
	// the unique Id whitin the table in the DB that will be generate by the DB
	// this element is not stored in the DB
	transient private int id;
	
	// constructor that receives the Name as parameter
	public GenericName(String name) {
		setName(name);
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	// displayed name
	@Override
	public String toString() {
		return "[" + id + "]" + " " + name;
	}

}

