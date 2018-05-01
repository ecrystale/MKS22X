public class MyHeap<T extends Comparable<T>>{
    private boolean max;
    private T[] data;
    private int size=0;
    @SuppressWarnings("unchecked")
    public MyHeap(){// - construct empty max heap
	max=true;
        data = (T[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean rule){// - true: construct empty max heap, false: construct empty min heap.
	max=rule;
	data = (T[])new Comparable[10];
    }
	// Methods
    public void add(T s){
	if(size==data.length){
	    resize();
	}
	data[size]=s;
	pull(size);
	size++;
    }
    public void pull(int index){
	int place=(index-1)/2;
	if(place>=0){
	    if(max==true){
		if(data[place].compareTo(data[index])>0){
		    swap(place,index);
		    //push(place);
		    pull(place);
		}
	    }
	    if(max==false){
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    //push(place);
		    pull(place);
		}
	    }
	}
    }
    public void swap(int one, int two){
 	T orig=data[one];
	data[one]=data[two];
	data[two]=orig;
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	int index=data.length*2;
	T[] copy=(T[])new Comparable[index];
	for(int i=0;i<size;i++){
	    copy[i]=data[i];
	}
	data=copy;
    }
    public T remove(){
	T original=data[0];
	data[0]=data[size-1];
	data[size-1]=null;
	size--;
	push(0);
	return original;
    }
    public void push(int index){
	int place=2*index+1;
	boolean switched=false;
	if(place<size){
	    if(max==true){
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    switched=true;
		    //push(place);
		}
		if(data[place+1].compareTo(data[index])<0){
		    swap(place+1,index);
		    push(place+1);
		}
		if(switched==true){
		    push(place);
		}
	    }
	    if(max==false){
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    switched=true;
		    //push(place);
		}
		if(data[place+1].compareTo(data[index])<0){
		    swap(place+1,index);
		    push(place+1);
		}
		if(switched==true){
		    push(place);
		}
	    }
	}
    }
    public T peek(){
	return data[0];
    }
    public int size(){
	return size;
    }
    
    public void toStringx(){
	String all="";
	for(int i=0;i<size;i++){
	    all+=data[i]+" ";
	}
	System.out.println(all);
    }
}
