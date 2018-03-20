public class Merge{
    public void mergesort(int[] data,int lo, int hi){
	int mid=(lo+hi)/2;
	if(hi!=lo){
	    mergesort(data,lo,mid);
	    mergesort(data,mid+1,hi);
	}
	sort(data,lo,mid);
	sort(data,mid+1,hi);
	merge(data,lo,hi);
    }
    public void sort(int[] data,int lo,int hi){
	while(hi>lo){
	    if(data[lo]<data[hi]){
		data=swap(data,lo,hi);
	    }
	}
    }
    public int[] swap(int[] data,int lo, int hi){
	int i=data[lo];
	int j=data[hi];
	data[lo]=j;
	data[hi]=i;
	return data;
    }
    public void merge(int[] data,int lo, int hi){

    }
}
