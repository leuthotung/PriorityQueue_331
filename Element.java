
public class Element {
	String name; 
	int priority; 
	
	
	
	public Element(String name, int key) {
			this.name = name;
			this.priority = key ;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPriority() {
		return priority;
	}



	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean morePriority(Element x) {
		if(this.priority<x.priority)
			return true;
		else
			return false;
	}

	
}

