public class Merge{
    public static void mergesort(int[] temp, int[] data, int lo, int hi){
	int mid=(lo+hi)/2;
	if(lo<hi){
	    mergesort(temp,data,lo,mid);
	    mergesort(temp,data,mid+1,hi);
	}
	merge(data,temp,lo,mid,hi);
    }
    public static void merge(int[] data,int[] temp,int lo,int mid, int hi){
	int orig=mid;
	for(int i=lo;i<hi;i++){
	    if(lo==mid){
		for(int j=mid+1;j<=hi;j++){
		    data[i]=temp[j];
		    i++;
		}
	    }
	    if(hi==mid+1){
		for(int j=lo;j<=mid;j++){
		    data[i]=temp[j];
		    i++;
		}
	    }
	    if(temp[lo]>temp[mid+1]){
		data[i]=temp[mid+1];
		mid++;
	    }
	    if(temp[lo]<temp[mid+1]){
		data[i]=temp[lo];
		lo++;
	    }
	}
	/**
	   while(hi!=mid+1 && lo!=orig){
	   if(temp[lo]>temp[mid+1]){
	   data[lo]=mid+1;
	   mid++;
	   }
	   if(temp[lo]<temp[mid+1]){
	   lo++;
	   }
	   }
	   while(hi>lo){
	   if(data[lo]<data[hi]){
	   data=swap(data,lo,hi);
	   lo++;
	   }
	   hi++;
	   }*/
    }
    public static int[] swap(int[] data,int lo, int hi){
	int i=data[lo];
	int j=data[hi];
	data[lo]=j;
	data[hi]=i;
	return data;
    }
    public static void toString(int[] data){
	String all="";
	for(int i=0;i<data.length;i++){
	    all+=data[i]+" ";
	}
	System.out.println(all);
    }
    public static void main(String[] args){
	int[] ary = { 2, 10, 15, 23, 0,  5};
	toString(ary);
	mergesort(ary,ary,0,ary.length-1);
	toString(ary);
    }
}
