
public class NameGame {
	
	private String name;
	
	public NameGame(String name) {
		int strEnd = name.length() - 1;
		this.name = name.charAt(strEnd) == '!' ? name.substring(0, strEnd) : name;
	}
	
	public void playNameGame() {
		ryhmeWithB(name);
		rhymeWithF(name);
		rhymeWithM(name);
		System.out.println(name + "!");
	}
	
	private void ryhmeWithB(String name) {
		String line =  name + ", " + name + " bo";
		line += nameChange(name, "B");
		System.out.println(line);
	}
	
	private void rhymeWithF(String name) {
		String line =  "Banna fanna fo";
		line += nameChange(name, "F");
		System.out.println(line);
	}
	
	private void rhymeWithM(String name) {
		String line =  "Fee fy mo";
		line += nameChange(name, "M");
		System.out.println(line);
	}
	
	private String nameChange(String name, String toCheck) {
		if (name.startsWith(toCheck)) {
			return ("-" + name.substring(1)  + ",");
		} 
		else {
			return (" "+ toCheck + name.substring(1) + ",");
		}
	}

}
