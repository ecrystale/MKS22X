public class MyHeap{
    boolean max;
    String[] data;
    int size=0;
    public MyHeap(){// - construct empty max heap
	max=true;
	data= new String[10];
    }
    public MyHeap(boolean rule){// - true: construct empty max heap, false: construct empty min heap.
	max=rule;
    }
	// Methods
    public void add(String s){
	if(max==true){
	    maxadd(s);
	}
	if(max==false){
	    minadd(s);
	}
    }
    public void maxadd(String s){
	if(size==data.length){
	    resize();
	}
	data[size]=s;
	pull(size);
	size++;
    }
    public void minadd(String s){
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
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    pull(place);
		}
	    }
	    if(max==false){
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    pull(place);
		}
	    }
	}
    }
    public void swap(int one, int two){
	String orig=data[one];
	data[one]=data[two];
	data[two]=orig;
    }
    public void resize(){
	int index=data.length*2;
	String[] copy=new String[index];
	for(int i=0;i<size;i++){
	    copy[i]=data[i];
	}
	data=copy;
    }
    public String remove(){
	String original=data[0];
	data[0]=data[size];
	data[size]=null;
	size--;
	push(0);
	return original;
    }
    public void push(int index){
	int place=2*index+1;
	if(place<=size){
	    if(max==true){
		if(data[place].compareTo(data[index])>0){
		    swap(place,index);
		    push(place);
		}
		if(data[place+1].compareTo(data[index])>0){
		    swap(place+1,index);
		    push(place+1);
		}
	    }
	    if(max==false){
		if(data[place].compareTo(data[index])<0){
		    swap(place,index);
		    push(place);
		}
		if(data[place+1].compareTo(data[index])<0){
		    swap(place+1,index);
		    push(place+1);
		}
	    }
	}
    }
    public String peek(){
	return data[0];
    }
    public int size(){
	return size;
    }
}
