public class Merge{
    public static void mergesort(int[] data){
	int[] temp=new int[data.length];
	for(int i=0;i<data.length;i++){
	    temp[i]=data[i];
	}
	msort(data,temp,0,data.length-1);
    }
    public static void msort(int[] temp, int[] data, int lo, int hi){
	int mid=(lo+hi)/2;
	if(lo<mid+1 && mid<hi){
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	   
	}
	merge(data,temp,lo,mid,hi);
	for(int k=lo;k<hi+1;k++){
	    data[k]=temp[k];
	}
    }
    public static void merge(int[] data,int[] temp,int lo,int mid, int hi){
	int orig=mid;
	int i=lo;
	while(i<hi+1){
	    if(lo==orig+1){
		temp[i]=data[mid+1];
		i++;
		mid++;
	    }
	    else if(hi==mid){
		temp[i]=data[lo];
		lo++;
		i++;
	    }
	    else{
		if(data[lo]>data[mid+1]){
		    temp[i]=data[mid+1];
		    mid++;
		    i++;
		}
	        else{
		    temp[i]=data[lo];
		    lo++;
		    i++;
		}
	    }
	}
    }
    
    /**
    public static void swap(int[] data,int[] temp, int one, int two){
	int i=data[one];
	int j=temp[two];
	data[one]=j;
	//return data;
	}*/

    public static void toString(int[] data){
	String all="";
	for(int i=0;i<data.length;i++){
	    all+=data[i]+" ";
	}
	System.out.println(all);
    }

    /**
    public static void main(String[] args){
	int[] ary= { 2, 15, 23,3432,42,1,1,2,2,2,10, 23,7, 0,  5};
	toString(ary);
	mergesort(ary);
	toString(ary);
	}*/
}
