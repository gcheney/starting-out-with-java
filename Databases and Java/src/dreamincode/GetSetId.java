package dreamincode;

/*
 ** All the objects stored in the DB must implements these 2 methods
 ** that allows to store/retreive the DB unique Id within a table
 */
public interface GetSetId {

	// to get the BD unique Id
	public int getId();
	// to set it in an object after reading the object from the DB
	public void setId(int id);
}
