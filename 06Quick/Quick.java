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
	    if(place<k){
	        start=place+1;
	    }
	    if(place>k){
		end=place;
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
	//data[pivot]=b;
	int origs=start;
	//end--;
	for(int i=start+1;start<end;i++){
	    if(data[i]<b){
		int s1=data[i];
		int s2=data[start];
		data[i]=s2;
		data[start]=s1;
		start++;
	    }
	    if(data[i]>b){
		int s1=data[i];
		int s2=data[end];
		data[i]=s2;
		data[end]=s1;
		end--;
	    }
	}
	int s1=data[origs];
	int s2=data[end];
	data[origs]=s2;
	data[end]=s1;
	//	end--;
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
