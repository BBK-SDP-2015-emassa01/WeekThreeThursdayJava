package interfaces;

public interface Thing {
	public default boolean alive() { //NOTE KEYWORD DEFAULT. IF WE DO NOT OVERRIDE IT, IT WILL RUN. NO COLLISION.
		//WE CAN ALSO GET RID OF THE CODE FURTHER DOWN.BUT IF WE LEAVE IT IN, IT WILL BE OVERRIDDEN.
		return false;
	}
}

interface Fly extends Thing {
	public String eat();
}

interface Person extends Thing {
	public String eat();
}

interface Huly extends Fly, Person { //MI!!! Multiple inheritance
}

class FlyImpl implements Fly{
	public boolean alive(){
		return false;
	}
	public String eat(){
		return "vomit, absorb...repeat.";
	}
	
class PersonImpl implements Person{
	public boolean alive(){
		return false;
	}
	
	public String eat(){
		return "chewing and swallow.";
	}
}

class HulyImpl implements Huly{ 
	//cant extend 2 concrete classes, could choose which to Person or Fly...but I dont want to do that either.
//I COULD HAVE PRIVATE IMPLEMENTATIONS OF PERSONIMPL AND FLYIMPL.
	
	private PersonImpl pi;
	private FlyImpl fi;
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return pi.eat();
	}

	@Override
	public boolean alive() {
		// TODO Auto-generated method stub
		return fi.alive();
	}
	
	//choosing which one we want to use!
	//what else can we do??? well we could add things into the interface so we dont have to choose.
	//bury implementation into the interface.
}

}