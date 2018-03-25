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
	String all="";
	for(int k=lo;k<hi+1;k++){
	    all+=temp[k]+" ";
	}
	//System.out.println("merging00 "+all);
	if(lo<mid+1 && mid<hi){
	    System.out.println("merging0000 "+all);
	    msort(temp,data,lo,mid);
	    msort(temp,data,mid+1,hi);
	   
	}
	System.out.println("merging99 "+all);
	// merge(data,temp,lo,mid,hi);
	merge(data,temp,lo,mid,hi);
	for(int k=lo;k<hi+1;k++){
	    data[k]=temp[k];
	}
    }
    public static void merge(int[] data,int[] temp,int lo,int mid, int hi){
	int orig=mid;
	int origl=lo;	
	String all="";
	for(int l=lo;l<hi+1;l++){
	    all+=temp[l]+" ";
	}
	int i=lo;
	while(i<hi+1){
	    System.out.println("ok "+(all));
	    System.out.println(data[lo]);
	    //System.out.println(data[mid]);
	    System.out.println(data[hi]);
	    if(lo==orig+1){
		//if(data[mid]<data[lo]){
		//while(i<hi+1){
			System.out.println("temp "+data[mid+1]);
			temp[i]=data[mid+1];
			System.out.println("temp "+temp[i]);
			i++;
			//lo++;
			mid++;
			// }
			//}
	    }
	    else if(hi==mid){
		//if(data[lo]<data[mid]){
		// while(i<orig+1){
		System.out.println("ok0 "+data[lo]);
		temp[i]=data[lo];
		System.out.println("ok0 "+temp[i]);
		lo++;
		i++;
			//  }
		    //}/
	    }
	    else{
		if(data[lo]>data[mid+1]){
		    temp[i]=data[mid+1];
		    System.out.println("ok2 "+temp[i]);
		    System.out.println("ok2 "+data[mid+1]);
		    mid++;
		    i++;
		}
	        else{
		    System.out.println("ok3 "+temp[i]);
		    //swap(data,temp,i,lo);
		    temp[i]=data[lo];
		    System.out.println("ok34 "+data[i]);
		    lo++;
		    i++;
		}
	    }
	    String allk="";
	    all="";
	    for(int k=origl;k<hi+1;k++){
		all+=temp[k]+" ";
		}
	    System.out.println("Resultstemp "+all);
	    //allk="";
	    for(int k=origl;k<hi+1;k++){
		allk+=data[k]+" ";
	    }
	    System.out.println("Results "+allk);
	}/**
	for(int k=origl;k<hi;k++){
	    data[k]=temp[k];
	    }*/
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
	int[] ary= { 2, 15, 23,3432,42,1,1,2,2,2,10, 23,7, 0,  5};
	toString(ary);
	mergesort(ary);
	toString(ary);
    }
}
