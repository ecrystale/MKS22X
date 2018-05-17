import java.util.Arrays;
import java.util.Random;
public class Quick{
    public static void quicksort(int[] ary){
	int start=0;
	int end=ary.length-1;
	sortH(ary,start,end);
    }
    
    public static void sortH(int[] ary, int start, int end){
	if(end>start){
	    //if(end-1>start){
	    int[] place=partitionS(ary,start,end);
	    //if(0<=place[0] && place[1]<ary.length && place[0]<place[1]){
	    if(place[1]>=place[0]){
		//System.out.println(place[0]);
		if(start!=place[0]){
		    sortH(ary,start,place[0]);
		   }
		if(end!=place[1]){
		    sortH(ary,place[1],end);
		}
		// }
	    }
	    //end=start;
	    //}
	}
    }
    public static int[] partitionS ( int [] data, int start, int end){
	int[] places=new int[2];
	Random rand = new Random();
	int  pivot = rand.nextInt(end-start+1)+start;
	swap(data,start,pivot);
	//start++;
	int i=start+1;
	while(i<=end){
	     if(data[i]==data[start]){
		 i++;
		 //places[0]++; //random works with this, but small range doesn't- w/o this, small range works but random doesn't
		 //start++;
	     }
	     else if(data[i]<data[start]){
		swap(data,i,start);
		start++;
		//places[0]++;
		i++;
	    }
	    else{
		swap(data,i,end);
		//i++;
		end--;
		//places[1]--;
	    }
	}/**
	if(data[end]>data[lo]){
	    /**if(data[end-1]!=data[lo]){
	       swap(data,end-1,lo);
	       places[1]--;
	       }
	    if(places[0]!=lo){
		swap(data,places[0],lo);
	    }
	    places[1]--;
	}
	else {
	    if(data[end]<data[lo]){
		if(data[end-1]<data[lo]){
		    places[0]++;
		}
		swap(data,end,lo);
	    }
	    else{
		//if(places[0]!=lo){
		    swap(data,places[0],lo);
		    //places[0]++;
		    /**}
		else{
		    swap(data,places[1],lo);
		    }
	    }
	}*/
	places[0]=start;
	places[1]=i;
	return places;
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

    public static void toString(int[] data){
	String all="";
	for(int i=0;i<data.length;i++){
	    all+=data[i]+" ";
	}
	System.out.println(all);
    }

    /**   
    //Sort testing code
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  private static final int EMPTY = 4;

  private static String name(int i){
    if(i==0)return "Increassing";
    if(i==1)return "Decreassing";
    if(i==2)return "Normal Random";
    if(i==3)return "Random with Few Values";
    if(i==4)return "size 0 array";
    return "Error stat array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[]makeArray(int size,int type){
    int[]ans =new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    }
    if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    }
    if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    }
    if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    }
    if(type == EMPTY){
      ans = new int[0];
    }
    return ans;
  }

    
  public static void main(String[]args){
    if(args.length < 2)return;
    
    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int [] start = makeArray(size,type);
    int [] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);
    
    long startTime = System.currentTimeMillis();
    //toString(start);
    quicksort(start);
    // toString(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
    }else{
	System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
	for(int i=0;i<start.length-1;i++){
	    if(start[i]>start[i+1]){
		System.out.println(start[i-1]+" "+start[i]+ " "+start[i+1]);
	    }
	}
	//toString(start);
    }
    }*/
   
}
