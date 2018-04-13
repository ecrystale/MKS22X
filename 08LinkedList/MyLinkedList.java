public class MyLinkedList{
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


    public MyLinkedList(){
	size=0;
	start=null;
        end=null;
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
	start=null;
	end=null;
    }
    public int size(){
	return size;
    }
    public Integer get(int index){//exceptions!
	if(0<=index && index<size){ 
	return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();
    }
    public Integer set(int index, Integer value){//exceptions!
	if(0<=index && index<size){ 

	    getNode(index).setValue(value);
	    return getNode(index).getValue();
	}
	throw new IndexOutOfBoundsException();

    }

    public int indexOf(Integer value){
	for(int i=0;i<size;i++){
	    if(getNode(i).getValue()==value){
		return i;
	    }
	}
	return -1;
    }

    public boolean add(Integer newData){
	if(newData!=null){
	    if(size==0){
		start=new Node(newData);
		end=start;
		size++;
		return true;
	    }
	    if(size==1){
		// Node prev=end;
		end=new Node(newData);
		end.setPrev(start);
		start.setNext(end);
		size++;
		return true;
	    }
	    else{
		Node prev=end;
		end=new Node(newData);
		end.setPrev(prev);
		prev.setNext(end);
		size++;
		return true;
	    }
	}
	return false;
    }
   public void add(int index, Integer value){//exceptions!
	int current=value;
	int next;
	//Node NN;

	if(0<=index && index<=size){ 
	    if(index==0 && size==0){
		Node NN=new Node(value);
		//NN.setValue(value);
		start=NN;
		size++;
	    }
	    if(index==0){
		Node NN=new Node(value);
		Node work=getNode(index);
		//NN.setValue(value);
		work.setPrev(NN);
		NN.setNext(work);
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
    public boolean remove(Integer value){
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

    public Integer remove(int index){//exceptions!
	int num;
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


    
    private class Node{
	Node next,prev;
	int data;

	public Node(int index){
	    data=index;
	    //next=null;
	    //prev=null;
	}
	private Node getNext(){
	    return next;
	}
	private Node getPrev(){
	    return prev;
	}
	private int getValue(){
	    return data;
	}
	private void setNext(Node i){
	    next=i;
	    //return next;
	}
	private void setPrev(Node n){
	    prev=n;
	    //return prev;
	}
	private int setValue(Integer i){
	    data=i;
	    return data;
	}
	public String toString(){
	    return data+" ";
	}
    }

    /**
  public static void main(String[] args){
     MyLinkedList a = new MyLinkedList();

     System.out.println("Testing add(Integer value)");
     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
       System.out.println("size: " + a.size() + " LinkedList: " + a.toString());
     } //adds the integers from 0 to 9 inclusive and prints out the LinkedList

     System.out.println("\nTesting get(int index)");
     for (int i = 0; i < 10; i++){
       System.out.println("index: " + i + " data: " + a.get(i));
     } //prints the integers from 0 to 9 inclusive

     System.out.println("\nTesting exception for get(int index)");
     try{
       System.out.println(a.get(10));
       System.out.println(a.size());
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.get(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     for (int i = 0; i < 10; i++){
       a.add(new Integer(i));
     }

     System.out.println("\nTesting indexOf(Integer value)");
     for (int i = 0; i < 10; i++){
       System.out.println("Value: " + i + " Index: " + a.indexOf(i));
     } //prints 0 to 9 inclusive

     System.out.println("\nTesting remove(Integer value)");
     for(int i = 0; i < 10; i++){
       a.remove(new Integer(i));
       System.out.println(a);
     } //removes first half of the LinkedList

     System.out.println("\nTesting set(int index, Integer value)");
     for (int i = 0; i < 10; i++){
       a.set(i, new Integer(i * 10));
       System.out.println(a);
     } //sets the data of each node to 10 * index

     System.out.println("\nTesting exceptions for set(int index, Integer value)");
     try{
       System.out.println(a.set(-1, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.set(10, new Integer(1)));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesing add(int index, Integer value)");
     for (int i = 0; i < 9; i++){
       a.add(i, new Integer(i * 3));
       System.out.println("index added: " + i + " LinkedList: " + a.toString());
     } //adds multiples of 3 up to 24 to the LinkedList at the beginning
     a.add(19, new Integer(100)); //adds 100 to the LinkedList at the end
     System.out.println("index added: " + 19 + " LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for add(int index, Integer value)");
     try{
       a.add(-1, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       a.add(21, new Integer(5));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting remove(int index)");
     System.out.println("Original LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(0) + " index removed: 0"); //removes 0
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(a.size() - 1) + " index removed: 18"); //removes 100
     System.out.println("LinkedList: " + a.toString());
     System.out.println("data removed: " + a.remove(2) + " index removed: 2 "); //removes 9
     System.out.println("LinkedList: " + a.toString());

     System.out.println("\nTesting exceptions for remove(int index)");
     try{
       System.out.println(a.remove(-1));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"
     try{
       System.out.println(a.remove(17));
     }catch(IndexOutOfBoundsException e){
       System.out.println("This size is out of bounds");
     } //prints "This size is out of bounds"

     System.out.println("\nTesting clear()");
     a.clear();
     System.out.println("LinkedList: " + a.toString()); //prints an empty LinkedList
   }*/

}
