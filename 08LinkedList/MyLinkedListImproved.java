import java.util.Iterator;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node start,end;
    private int size;

    //This method will help you write other
    //methods, it is private to protect your list
    private Node getNode(int index){
	Node current=start;
	int i=0;
	while(current!=null){
	    if(i==index){
		return current;
	    }
	    current=current.getNext();
	    i++;
	}	
	return current;
        
    }


    public MyLinkedListImproved(){
	size=0;
	//start=null;
        //end=null;
    }
    public String toString(){
	String all="{";
	for(int i=0;i<size;i++){
	    if(i<size-1){
		all+=getNode(i).getValue()+ ", ";
	    }else{
		all+=""+getNode(i).getValue();
	    }
	}
	all+="}";
	return all;
    }
    public void clear(){
	size=0;
	//start=null;
	//end=null;
    }
    public int size(){
	return size;
    }
    public T get(int index){//exceptions!
	if(0<=index && index<size){ 
	return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();
    }
    public T set(int index, T value){//exceptions!
	if(0<=index && index<size){ 

	    getNode(index).setValue(value);
	    return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();

    }

    public int indexOf(T value){
	for(int i=0;i<size;i++){
	    if(getNode(i).getValue()==value){
		return i;
	    }
	}
	return -1;
    }

    public boolean add(T newData){
	//	if(newData!=null){
	    if(size==0){
		start=new Node(newData);
		end=start;
		size++;
		return true;
	    }/**
	    if(size==1){
		// Node prev=end;
		end=new Node(newData);
		end.setPrev(start);
		start.setNext(end);
		size++;
		return true;
		}*/
	    else{
		//Node prev=end;
		Node current=new Node(newData);
		//Node prev=getNode(size-1);
		//current.setValue(newData);
		//current.setNext(end);
		current.setPrev(end);
		end.setNext(current);
		size++;
		end=current;
		return true;
		
	    }
	    //}
	    //return false;
    }

   public void add(int index, T value){//exceptions!
	T current=value;
	T next;
	//Node NN;

	if(0<=index && index<=size){
	    if(index>size){
		throw new IndexOutOfBoundsException();
	    } 
	    if(index==0 && size==0){
		Node NN=new Node(value);
		//NN.setValue(value);
		start=NN;
		end=NN;
		size++;
	    }
	    else if(index==0){
		Node NN=new Node(value);
		//Node work=getNode(index);
		//NN.setValue(value);
		start.setPrev(NN);
		NN.setNext(start);
		start=NN;
		size++;
		//end=end.getNext();
	    }
	    else if(index==size){
	    	add(value);
		//Node work= new Node(size);
		//work.setValue(value);
	    }   
	    else{
		Node NN=new Node(value);
		Node work=getNode(index);
		work.getPrev().setNext(NN);
		NN.setPrev(work.getPrev());
		NN.setNext(work);
		work.setPrev(NN);
		size++;
		/**
		   for(int i=index;i<=size;i++){
		   Node work=getNode(i);
		   //	orig=work;
		   next=work.getValue();
		   NN=work;
		   work.setValue(current);
		   work.setNext(NN);
		   current=next;
		   }
		   size++;
		   }*/
	    }
	}
	else{
	    throw new IndexOutOfBoundsException();
	}
   }

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(T value){
	boolean found=false;
        Node work=start;
	while(work!=null){
	    //getNode(size).setNext(size);
	    //Node work=getNode(i);
	    if(work.getValue()==value){
		if(work==start){
		    start=work.getNext();
		    size--;
		    return true;
		}
		if(work==end){
		    end=end.getPrev();
		    end.setNext(null);
		    size--;
		    return true;
		}
		else{
		    work.getNext().setPrev(work.getPrev());
		    work.getPrev().setNext(work.getNext());
		    size--;
		    return true;
		}
	    }
	    work=work.getNext();
	
	}
	return false;
    }

    public T remove(int index){//exceptions!
	T num;
	Node work;
	if(0<=index && index<size){
	    work=getNode(index);
	    num=getNode(index).getValue();
	    getNode(index).setValue(getNode(index).getValue());
	
	    if(work==start){
		start=work.getNext();
		size--;
		return num;
	    }
	    if(work==end){
		end=end.getPrev();
		end.setNext(null);
		size--;
		return num;
	    }
	    else{
		work.getNext().setPrev(work.getPrev());
		work.getPrev().setNext(work.getNext());
		size--;
		return num;
	    }
	}
	
	throw new IndexOutOfBoundsException();
    }

    // -> return the index of the largest value, or -1 if the list is empty
    public int max(){
	int val=0;
	if (size==0){
	    return -1;
	}
	Node work=start;
	for(int i=0;i<size;i++){
	    Node now=getNode(i);
	    if(now.getValue().compareTo(work.getValue())>0){
		val=i;
		work=getNode(i);
	    }
	}
	return val;
    }
    // -> return the index of the largest value, or -1 if the list is empty
    public int min(){
	int val=0;
	if (size==0){
	    return -1;
	}
	Node work=start;
	for(int i=0;i<size;i++){
	    Node now=getNode(i);
	    if(now.getValue().compareTo(work.getValue())<0){
		val=i;
		work=getNode(i);
	    }
	}
	return val;
    }
    
    private class Node{
	Node next,prev;
        T data;

	public Node(T index){
	    data=index;
	    //next=null;
	    // prev=null;
	}
	private Node getNext(){
	    return next;
	}
	private Node getPrev(){
	    return prev;
	}
	private T getValue(){
	    return data;
	}
	private Node setNext(Node i){
	    next=i;
	    return next;
	}
	private Node setPrev(Node i){
	    prev=i;
	    return prev;
	}
	private T setValue(T i){
	    data=i;
	    return data;
	}
	public String toString(){
	    return data+" ";
	}
    }

    public Iterator<T> iterator(){
	return new LLIterator(start);
    }
    public class LLIterator implements Iterator<T>{
	Node next;
	T current;
	public LLIterator(Node data){
	    next=data;
	}
	public boolean hasNext(){
	    return (next!=null);
	}
	public T next(){
	    if(hasNext()){
	        current=next.getValue();
		next=next.getNext();
		return current;
	    }else{
		return null;
	    }
	}
	public void remove(){
	    remove();
	}

    }

    public void extend(MyLinkedListImproved<T> other){
	getNode(size-1).setNext(other.getNode(0));
	getNode(size).setPrev(getNode(size-1));
	size=other.size()+size;
	other.clear();
        //in O(1) runtime, move the elements from other onto the end of this
        //The size of other is reduced to 0
        //The size of this is now the combined sizes of both original lists
    }

}
