package lab6;

public class MyLinkedList {
	Node header;
	private int size;
	
	MyLinkedList(){
		this.header = new Node (null, header, header);
		this.size=0;
	}
	public int size(){
		return this.size;
	}
	public void set(int index, Integer element){
		if (index >=size || index<0) throw new IndexOutOfBoundsException("incorrect index outs of Array bounds"); 
		if (size==0) throw new NullPointerException("The array is empty"); 
		Node temp = header.nextElement;
		int counter =0;
		while (counter<index){
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		temp.setElement(element);
	}
	public Integer remove(int index){
		if (size==0) throw new NullPointerException("The array is empty"); 
		if (index >=size || index<0) throw new IndexOutOfBoundsException("incorrect index outs of Array bounds"); 
		int counter = 0;
		Node temp = header.nextElement;
		while (counter<index){
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		Integer valueToReturn = temp.getElement();
		temp.remove();
		return valueToReturn;
		
	}
	public Integer removeFirst(){
		if (size==0) throw new NullPointerException("The array is empty"); 
		Node temp = header.nextElement;
		Integer value = temp.getElement();
		temp.remove();
		return value;
	}
	public Node removeFirstNode(){
		if (size==0) throw new NullPointerException("The array is empty"); 
		Node temp = header.nextElement;
		Node returnedNode = new Node (temp.getElement(),null,null);
		temp.remove();
		return returnedNode;
	}
	
	
	public Integer removeLast(){
		if (size==0) throw new NullPointerException("The array is empty"); 
		Node temp = header.previousElement;
		Integer value = temp.getElement();
		temp.remove();
		return value;
	}
	
	public void removeAll(){
		header.nextElement = header.previousElement = null;
		size = 0;
		return;
	}
	
	
	public void add(Integer e){
		if (size==0) addFirst(e);
		else {
			Node elem = new Node (e, header, header.previousElement);
			header.previousElement.nextElement = elem;
			header.previousElement = elem;
			size++;
		}
	}
	
	public void addLast(Integer e){
		this.add(e);
	}
	
	public void addFirst(Integer e){
		if (size==0) {
			Node elem = new Node (e, header, header);
			header.nextElement = header.previousElement = elem;
			size++;
		} else {
			Node elem = new Node (e, header.nextElement, header);
			header.nextElement.previousElement = elem;
			header.nextElement = elem;
			size++; 
		}
	}
	
	public Integer getFirst() {
		if (size==0) throw new NullPointerException("The array is empty"); 
		return header.nextElement.getElement();
		}
	public Node getFirstNode() {
		if (size==0) throw new NullPointerException("The array is empty"); 
		return new Node(header.nextElement.getElement(),null,null);
		}
	
	
	public Integer get(int index) {		
		if (size==0) throw new NullPointerException("The array is empty"); 
		if (index >=size || index<0) throw new IndexOutOfBoundsException("incorrect index outs of Array bounds"); 
		int counter = 0;
		Integer valueToReturn;
		Node temp = header.nextElement;
		while (counter<size){
			valueToReturn = temp.getElement();
			if (counter==index) return valueToReturn;
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		return 0;
	}	
	
	public int indexOf(Integer o) {
		if (size==0) throw new NullPointerException("The array is empty"); 
		int counter = 0;
		Node temp = header.nextElement;
		while (counter<size){
			if (o.equals(temp.getElement())) return counter;
			if (temp.hasNext()) temp = temp.next();
			counter++;
		}
		return -1;
	}
	
	public Integer getLast() {
		if (size==0) throw new NullPointerException("The array is empty"); 
		return header.previousElement.getElement();
		}	
	public Node getLastNode() {
		if (size==0) throw new NullPointerException("The array is empty"); 
		return header.previousElement;
		}	
	
	public void print(){
		if (size==0) throw new NullPointerException("The array is empty"); 
		for (int i=0; i<size; i++)
			System.out.print("["+get(i)+"] ");
		System.out.println();
	}
	
public class Node {
	private	Integer element;
	private Node nextElement;
	private Node previousElement;
	
	
	public Node (Integer element){
		this.element=element;
		this.nextElement = null;
		this.previousElement = null;
	}
		
	
	public Node (Integer element, Node nextElement, Node previousElement){
			this.element=element;
			this.nextElement = nextElement;
			this.previousElement = previousElement;
		}
	private boolean hasNext(){
			if (this.nextElement!=null) return true;
			else return false;
		}
		
	private Node next(){
			return this.nextElement;
		}
	public void remove(){
			this.previousElement.nextElement = this.nextElement;
			this.nextElement.previousElement = this.previousElement;
			this.nextElement = this.previousElement = null;
			this.element = null;
			size--;
		}
		
	public Integer getElement(){
			return this.element;
			
		}
	private void setElement(Integer element){
			this.element=element;
		}
	@Override
	public String toString(){
		return "["+this.getElement()+"] ";
		}
		
		
	}
	
	
	
}
