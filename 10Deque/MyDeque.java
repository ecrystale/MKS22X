public class MyDeque<E>{
    private E[] data;
    private int size;
    private int start;
    private int end;
    private int cap;
    @SuppressWarnings("unchecked")
    public void MyDeque(){ // Create an initial capacity of 10.
	data=(E[])new Object[10];
	size=0;
	start=0;
	end=0;
	cap=10;
    }
    @SuppressWarnings("unchecked")
    public void MyDeque(int initialCapacity){// - This creates a capacity that matches the parameter.Throws: IllegalArgumentException when the initialCapacity is negative.
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	data=(E[])new Object[initialCapacity];
	cap=initialCapacity;
	int mid=cap/2;
	size=0;
	start=mid;
	end=mid+1;
    }

    public int size(){
	return size;
    }

    //The add methods:
    //These will add the element to the specified side. The deque will double capacity if there is no space left.
    //Throws: (this is a subset of the real deque)
    //NullPointerException - if the specified element is null and this deque does not permit null elements
    public void addFirst(E ele){
	if(ele==null){
	    throw new NullPointerException();
	}
	data[start]=ele;
	start-=1;
	size++;
    }
    public void addLast(E ele){
	if(ele==null){
	    throw new NullPointerException();
	}
	if(size==cap){
	    resize();
	}
	data[end]=ele;
	end+=1;
	size++;
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
	cap*=2;
	E[] copy=(E[])new Object[cap];
	for(int i=0;i<size;i++){
	    
	}
    }
    
    //The remove methods:
    //These will retrieve and remove the element from the specified side.
    //Throws:
    //NoSuchElementException - if this deque is empty
    public E removeFirst(){
	E result=data[start];
	data[start]=null;
	start+=1;
	return result;
    }
    public E removeLast(){
	E result=data[end];
	data[end]=null;
	end-=1;
	return result;
    }

    //The get methods:
    //These will retrieve but not remove the element from the specified side.
    //Throws:
    //NoSuchElementException - if this deque is empty
    public E getFirst(){
	return data[start];
    }
    public E getLast(){
	return data[end];
    }

}
