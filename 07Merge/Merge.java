public class Merge{
    public static void mergesort(int[] data){
	int[] temp=new int[data.length];
	for(int i=0;i<data.length;i++){
	    temp[i]=data[i];
	}
	msort(temp,data,0,data.length-1);
    }
    public static void msort(int[] temp, int[] data, int lo, int hi){
	int mid=(lo+hi)/2;
	String all="";
	for(int k=lo;k<hi+1;k++){
	    all+=temp[k]+" ";
	}
	System.out.println("merging00 "+all);
	if(lo<hi){
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	    all="";
	    for(int k=lo;k<hi;k++){
		all+=temp[k]+" ";
	    }
	    System.out.println("merging "+all);
	    merge(data,temp,lo,mid,hi);
	}
    }
    public static void merge(int[] data,int[] temp,int lo,int mid, int hi){
	int orig=mid;
	int origl=lo;	
	String all="";
	for(int l=lo;l<mid+1;l++){
	    all+=temp[l]+" ";
	}
	int i=lo;
	while(i<hi+1){
	    System.out.println("ok "+(all));
	    System.out.println(temp[lo]);
	    if(lo==orig){
		for(int j=mid;j<hi;j++){
		    System.out.println("temp "+temp[j]);
		    data[i]=temp[j];
		    i++;
		    mid++;
		}
	    }
	    if(hi==mid){
		for(int j=lo;j<orig+1;j++){
		    System.out.println("ok0 "+temp[lo]);
		    data[i]=temp[j];
		    lo++;
		    i++;
		}
	    }
	    else{
		if(temp[lo]>temp[mid]){
		    data[i]=temp[mid];
		    System.out.println("ok2 "+temp[lo]);
		    System.out.println("ok2 "+temp[mid]);
		    mid++;
		    i++;
		}
		else{
		    System.out.println("ok3 "+temp[lo]);
		    //swap(data,temp,i,lo);
		    data[i]=temp[lo];
		    System.out.println("ok34 "+data[i]);
		    lo++;
		    i++;
		}
	    }
	    all="";
	    for(int k=origl;k<hi;k++){
		all+=temp[k]+" ";
	    }
	    System.out.println("Resultstemp "+all);
	    all="";
	    for(int k=origl;k<hi;k++){
		all+=data[k]+" ";
	    }
	    System.out.println("Results "+all);
	}
	for(int k=origl;k<hi;k++){
	    temp[k]=data[k];
	}
	all="";
	for(int k=origl;k<hi;k++){
	    all+=temp[k]+" ";
	}
	System.out.println("alltemp "+all);
	all="";
	for(int k=origl;k<hi;k++){
	    all+=data[k]+" ";
	}
	System.out.println("all "+all);
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
    
    public static void swap(int[] data,int[] temp, int one, int two){
	int i=data[one];
	int j=temp[two];
	data[one]=j;
	//return data;
    }
    public static void toString(int[] data){
	String all="";
	for(int i=0;i<data.length;i++){
	    all+=data[i]+" ";
	}
	System.out.println(all);
    }
    public static void main(String[] args){
	int[] ary= { 2, 15, 10, 23,7, 0,  5};
	int[] ary2= { 2, 1, 15, 23, 0,  5};
	toString(ary);
	mergesort(ary);
	toString(ary);
    }
}
