import java.util.*;
public class RunningMedians{
    private double[] min;
    int minsize=0;
    private double[] max;
    int maxsize=0;
    public RunningMedians(){
	min=new double[10];
	max=new double[10];
    }
    public void add(double value){
	if(minsize==0){
	    min[minsize]=value;
	}
	if(maxsize==0){
	    max[maxsize]=value;
	}
	if(min[0]<=value){
	    if(minsize==min.length){
		resize(false);
	    }
	    min[minsize]=value;
	    pull(minsize,false);
	    minsize++;
	}
	if(max[0]>=value){
	    if(maxsize==max.length){
		resize(true);
	    }
	    max[maxsize]=value;
	    pull(maxsize,true);
	    maxsize++;
	}
	while(minsize-maxsize>1){
	    max[maxsize]=min[minsize-1];
	    pull(maxsize,true);
	    maxsize++;
	    min[minsize-1]=Double.NaN;
	    minsize--;
	}
	while(maxsize-minsize>1){
	    min[minsize]=max[maxsize-1];
	    pull(minsize,true);
	    minsize++;
	    max[maxsize-1]=Double.NaN;
	    maxsize--;
	}
    }

    
    public void resize(boolean maxi){
	if(maxi==true){
	    double[] copy=new double[maxsize*2];
	    for(int i=0;i<maxsize;i++){
		max[i]=copy[i];
	    }
	    max=copy;
	}
	if(maxi==false){
	    double[] copy=new double[minsize*2];
	    for(int i=0;i<minsize;i++){
		min[i]=copy[i];
	    }
	    min=copy;
	}
    }

    
    public void pull(int index, boolean maxi){
	int place=(index-1)/2;
	if(place>=0){
	    if(maxi==true){
		if(max[place]<(max[index])){
		    swap(place,index,true);
		    //push(place);
		    pull(place,true);
		}
	    }
	    if(maxi==false){
		if(min[place]>(min[index])){
		    swap(place,index,false);
		    //push(place);
		    pull(place,false);
		}
	    }
	}
    }

    
    public void swap(int one, int two,boolean maxi){
	if(maxi==true){
	    double orig=max[one];
	    max[one]=max[two];
	    max[two]=orig;
	}
	if(maxi==false){
	    double orig=min[one];
	    min[one]=min[two];
	    min[two]=orig;
	}
    }

    
    public double getMedian(){
	if(minsize+maxsize==0){
	    throw new NoSuchElementException();
	}
	if(minsize>maxsize){
	    return min[0];
	}
	if(maxsize>minsize){
	    return max[0];
	}
	else{
	    return (min[0]+max[0])/2;
	}
    }
    public int size(){
	return minsize+maxsize;
    }
}