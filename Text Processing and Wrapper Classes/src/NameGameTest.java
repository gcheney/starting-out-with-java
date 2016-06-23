import java.util.Scanner;

public class NameGameTest {

	public static void main(String[] args) {	
		String name = getName();			
		NameGame game = new NameGame(name);
		game.playNameGame();
	}

	public static String getName(){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a name to rhyme: ");
		return in.nextLine();
	}
}

/* ---------NAME GAME IN JAVASCRIPT------------
//Constructor
function NameGame(name) {
	var end = name.length - 1;
	this.name = name.charAt(end) == '!' ? name.substring(0, end) : name;
}	

NameGame.prototype.ryhmeWithB = function(name) {
    var line =  name + ", " + name + " bo";
	line += nameChange(name, "B");
	console.log(line);
};

NameGame.prototype.rhymeWithF = function(name) {
	var line =  "Banna fanna fo";
	line += nameChange(name, "F");
	console.log(line);
};

NameGame.prototype.rhymeWithM = function(name) {
	var line =  "Fee fy mo";
	line += nameChange(name, "M");
	console.log(line);
};

NameGame.prototype.playNameGame = function() {
	this.ryhmeWithB(this.name);
	this.rhymeWithF(this.name);
	this.rhymeWithM(this.name);
	console.log(this.name + "!");
};
  
//Program Start
var name = getName();			
var game = new NameGame(name);
game.playNameGame();


function getName() {
    var name = prompt("Enter a name to rhyme: ");
	return name;
}

function nameChange(name, toCheck) {
    if (name.startsWith(toCheck)) {
        return ("-" + name.substring(1)  + ",");
    } 
    else {
        return (" "+ toCheck + name.substring(1) + ",");
    }
}


*/