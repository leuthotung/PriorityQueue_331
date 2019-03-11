
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			PriorityQueue PQ = new PriorityQueue(5);
			
			Element a = new Element("a",1);
			Element b = new Element("b",2);
			Element c = new Element("c",3);
			Element d = new Element("d",4);
			
			PQ.insert(a);
			PQ.insert(b);
			PQ.insert(c);
			PQ.insert(d);
			System.out.println(PQ.removeMin().name);
			System.out.println(PQ.removeMin().name);
			//System.out.println(PQ.removeMin().name);
			//System.out.println(PQ.removeMin().name);
	}

}
