public class RunningMedians{
    private int[] min;
    int minsize=0;
    private int[] max;
    int maxsize=0;
    public RunningMedians(){
	min=new int[10];
	max=new int[10];
    }
    public void add(double value){
	if(minsize==0){
	    min[minsize]=value;
	}
	if(maxsize==0){
	    max[maxsize]=value;
	}
	if(min[0]<
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
    public double getMedian(){

    }
}
