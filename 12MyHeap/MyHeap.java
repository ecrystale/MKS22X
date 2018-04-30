public class MyHeap<T extends Comparable<T>>{
    private static boolean max;
    private static String[] data;
    private static int size=0;
    @SuppressWarnings("unchecked")
    public MyHeap(){// - construct empty max heap
	max=true;
        data = (String[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean rule){// - true: construct empty max heap, false: construct empty min heap.
	max=rule;
	data = (String[])new Comparable[10];
    }
	// Methods
    public static void add(String s){
	if(max==true){
	    maxadd(s);
	}
	if(max==false){
	    minadd(s);
	}
    }
    public static void maxadd(String s){
	if(size==data.length){
	    resize();
	}
	data[size]=s;
	pull(size);
	size++;
    }
    public static void minadd(String s){
	if(size==data.length){
	    resize();
	}
	data[size]=s;
	pull(size);
	size++;
    }
    public static void pull(int index){
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
    public static void swap(int one, int two){
	String orig=data[one];
	data[one]=data[two];
	data[two]=orig;
    }
    @SuppressWarnings("unchecked")
    public static void resize(){
	int index=data.length*2;
	String[] copy=(String[])new Comparable[index];
	for(int i=0;i<size;i++){
	    copy[i]=data[i];
	}
	data=copy;
    }
    public static String remove(){
	String original=data[0];
	data[0]=data[size-1];
	data[size-1]=null;
	size--;
	push(0);
	return original;
    }
    public static void push(int index){
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
    public static String peek(){
	return data[0];
    }
    public static int size(){
	return size;
    }

    public static void main(String[] args){
	MyHeap x=new MyHeap();
	x.add("x");
	System.out.println(x);
    }
}
