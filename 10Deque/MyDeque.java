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
	if(size==cap){
	    resize();
	    //start=(start+cap)%cap;
	}
	data[start]=ele;
	//start--;
	size++;
	start=(start-1)%cap;
    }
    public void addLast(E ele){
	if(ele==null){
	    throw new NullPointerException();
	}
	if(size==cap){
	    resize();
	    //end=(end)%cap;
	}
	data[end]=ele;
	//end++;
	size++;
	end=(end+1)%cap;
    }
    
    @SuppressWarnings("unchecked")
	public void resize(){
	int origcap=cap;
	if(origcap==0){
	    data=(E[])new Object[1];
	    cap=1;
	}
	else{
	    cap*=2;
	    E[] copy=(E[])new Object[cap];
	    start=cap/2/2;
	    for(int i=start;i<size;i++){
		copy[i]=data[(start+i)%origcap];
		end=i;
	    }
	    data=copy;
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

    public String toString(){
	String ans = "[";
	if(start < end){
	    for (int i = start; i <= end; i++){
		ans += data[i] + " , ";
	    }
	}
	else{
	    for(int i = start; i < data.length; i++){
		ans += data[i] + ", ";
	    }
	    for(int i = 0; i <= end; i++){
		ans += data[i] + ", ";
	    }
	}
	ans = ans.substring(0, ans.length() - 2) + "]";
	return ans;
    }

    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
}
