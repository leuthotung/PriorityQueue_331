import java.util.*;

import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;
@invariant	({
	"$this.size >=0",
	"$this.capacity > 0",
	"$this.size <= $this.capacity"
	
	
})
public class PriorityQueue {
	public Element[] collection;
	public int capacity;
	public int size = 0;
	
	@requires ({"capacity >0"})
	@ensures ({"$this.collection != null"})
	PriorityQueue (int capacity){
		this.capacity = capacity;
		this.collection = new Element[capacity];
	}
	public int getLeft(int index) {
		return 2*index + 1;
	}
	public int getRight(int index) {
		return 2*index + 2;
	}
	public int getParent(int index) {
		return (index-1)/2;
		
	}
	public boolean hasParent(int index) {
		return getParent(index)>= 0;	
	}
	public boolean hasLeft(int index) {
		return getLeft(index)<capacity;
	}
	public boolean hasRight(int index) {
		return getRight(index)<capacity;
	}
	public void swap(int x, int y) {
		Element temp = collection[0];
		collection[x] = collection[y];
		collection[y] = temp;
	}
	@requires({
				"$this.isEmpty() == false"
	})
	@ensures({
				"$result != null",
				"$result == $old($this.min())",
				"$this.getSize() == $old($this.getSize()) - 1 "
			
	})
	public Element removeMin() {
		Element min = collection[0];
		collection[0] = collection[size-1];
		size --;
		bubbledown();
		return min;
	}
	
	@requires({"$this.isEmpty() == false"})
	@ensures ({
				"$result != null",
				"$this.getSize() == $old($this.getSize())"
	})
	public Element min() {
		Element result = collection[0];
		return result;
	}
	@requires ({
					"x != null",
					"$this.isFull() == false"
	})
	@ensures ({
					"$this.isContain(x)== true",
					"$this.getSize() == $old($this.getSize()) + 1 "
	})
	public void insert(Element x) {
		collection[size] = x;
		size ++;
		bubbleup();
	}
	public void bubbledown() {
		int index = 0;
		while (hasLeft(index)) {				
			int smallerindex= getLeft(index);
			if (hasRight(index)&& collection[getRight(index)].morePriority(collection[getLeft(index)]))
				smallerindex = getRight(index);
			if( collection[index].morePriority(collection[smallerindex]))
				break;
			else {
				swap(index, smallerindex);
				
			}
			index = smallerindex;
		}
	}
	public void bubbleup() {
		int index = size-1;
		while (hasParent(index) && collection[getParent(index)].morePriority(collection[index])) {
			swap(getParent(index),index);
			index = getParent(index);
		}
		
	}
	public boolean isFull() {
		return this.size == this.capacity;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}
	public boolean isContain(Element x) {
		for (int i=0;i < collection.length; i++) {
			if(collection[i].equals(x))
				return true;
		}
		return false;
	}
	@requires({"true"})
	@ensures({"$result >= 0"})
	public int getSize () {
		return this.size;
	}
	@requires({"true"})
	@ensures({"$result > 0"})
	public int getCapacity() {
		return this.capacity;
	}
}
