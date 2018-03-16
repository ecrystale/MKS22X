import java.util.Arrays;
import java.util.Random;
public class Quick{
    public static void quicksort(int[] ary){
	sortH(ary,0,ary.length);
    }

    public static void sortH(int[] ary, int start, int end){
	int lo=start;
	int hi=end;
	int a=partition(ary,lo,hi);
        if(hi-lo>0){
	    sortH(ary,lo,a-1);
	    sortH(ary,a+1,hi);
	}
    }

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
	swap(data,start,pivot);
	int lo=start;
	start++;
	int i=start;
	while(i<end){
	    if(data[i]==data[lo]){
		i++;
	    }
	    if(data[i]<data[lo]){
		swap(data,i,start);
		start++;
		i++;
	    }
	    if(data[i]>data[lo]){
		swap(data,i,end);
		end--;
	    }
	}
	if(data[end]>data[lo]){
	    swap(data,end-1,lo);
	    end--;
	}
        else{
	    swap(data,end,lo);
	}

	return end;
    }

    public static void swap(int[] data,int one, int two){
	int s1=data[one];
	int s2=data[two];
	data[one]=s2;
	data[two]=s1;
    }
    /**
    public static void main(String[] args){
        int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	System.out.println(quickselect( ary , 0 ));// would return 0
	System.out.println(quickselect( ary , 1 ));//  would return 2
	System.out.println(quickselect( ary , 2 ));  //would return 5
	System.out.println(quickselect( ary , 3 ));//  would return 10
	System.out.println(quickselect( ary , 4 ));//  would return 15
	System.out.println(quickselect( ary , 5 ));//  would return 23
	
	}*/
}
