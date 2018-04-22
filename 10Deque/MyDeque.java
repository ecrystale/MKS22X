import java.util.*;
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
	end=1;
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
	start=0;
	end=1;
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
	if(size==cap){
	    resize();
	    //start=(start+cap)%cap;
	}

	start=(cap+start-1)%cap;
	data[start]=ele;
	//start--;
	size++;
	//start=(cap+start-1)%cap;
    }
    public void addLast(E ele){
	if(ele==null){
	    throw new NullPointerException();
	}
	if(size==cap){
	    resize();
	    //end=(end)%cap;
	}
	end=(end+1)%cap;
	data[end]=ele;
	//end++;
	size++;
    }
    
    @SuppressWarnings("unchecked")
	public void resize(){
	int origcap=cap;
	cap=cap*2+1;
	E[] copy=(E[])new Object[cap];
	for(int i=0;i<size;i++){
	    copy[i]=data[(start+i)%origcap];
	}
	start=0;
	end=size-1;
	//end=(end+1)%cap;
	//start=(start-1)%cap;
	//end+=1;
	data=copy;
	
    }
    
    //The remove methods:
    //These will retrieve and remove the element from the specified side.
    //Throws:
    //NoSuchElementException - if this deque is empty
    public E removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E result=data[start];
	data[start]=null;
	start=(start+1)%cap;
	size--;
	return result;
    }
    public E removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E result=data[end];
	data[end]=null;
	end=(cap+end-1)%cap;
	size--;
	return result;
    }

    //The get methods:
    //These will retrieve but not remove the element from the specified side.
    //Throws:
    //NoSuchElementException - if this deque is empty
    public E getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[(start)%cap];
    }
    public E getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[(end)%cap];
    }
}
