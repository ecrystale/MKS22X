public class MyLinkedList{
  private Node start,end;
  private int size;

  //This method will help you write other
  //methods, it is private to protect your list
    private Node getNode(int index){
	return index.getNode();
    }


    public MyLinkedList(){
	size=0;
	start=0;
	end=0;
    }
    public String toString(){
	//for(
    }
    public void clear(){
	size=0;
	start=0;
	end=0;
    }
    public int size(){
	return size;
    }
    public Integer get(int index){//exceptions!

    }
    public Integer set(int index, Integer value){//exceptions!

    }

    public int indexOf(Integer value){

    }

    public boolean add(Integer newData){

    }
    public void add(int index, Integer value){//exceptions!

    }

  //The remove methods can cause a problem, this is why we shouldn't 
  //use an int as the data, we need objects to distinguish between index and data
    public boolean remove(Integer value){

    }
    public boolean remove(int index){//exceptions!
	if(0<=index && index<size){
	    index-1.setNext(null);
	}
    }

}
