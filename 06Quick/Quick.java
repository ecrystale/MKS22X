import java.util.Arrays;
import java.util.Random;
public class Quick{
    public static int quickselect(int []data, int k){
	int start=0;
	int end=data.length-1;
        for(int i=0;i<data.length;i++){
	    int place=partition(data,start,end);
	    if(place==k){
		return data[place];
	    }
	    if(k>place){
	        start=place+1;
	    }
	    if(k<place){
		end=place-1;
	    }
	}
	return -1;
    }

    public static int partition ( int [] data, int start, int end){
	Random rand = new Random();
	int  pivot = rand.nextInt(end-start+1)+start;
	int a=data[start];
	int b=data[pivot];
	data[start]=b;
	data[pivot]=a;
	int lo=start;
	int hi=end;
	start++;
	int i=start;
	while(i<end){
	    if(data[i]<=data[lo]){
		int s1=data[i];
		int s2=data[start];
		data[i]=s2;
		data[start]=s1;
		start++;
		i++;
	    }
	    if(data[i]>data[lo]){
		int s1=data[i];
		int s2=data[end];
		data[i]=s2;
		data[end]=s1;
		end--;
	    }
	}
	if(data[end]>data[lo]){
	    int s1=data[end-1];
	    int s2=data[lo];
	    data[end-1]=s2;
	    data[lo]=s1;
	    end--;
	}
        else{
	    int s1=data[end];
	    int s2=data[lo];
	    data[end]=s2;
	    data[lo]=s1;
	}

	return end;
    }
    
    public static void main(String[] args){
        int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	System.out.println(quickselect( ary , 0 ));// would return 0
	System.out.println(quickselect( ary , 1 ));//  would return 2
	System.out.println(quickselect( ary , 2 ));  //would return 5
	System.out.println(quickselect( ary , 3 ));//  would return 10
	System.out.println(quickselect( ary , 4 ));//  would return 15
	System.out.println(quickselect( ary , 5 ));//  would return 23
	
    }
}
