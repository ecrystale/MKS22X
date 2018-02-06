public class Recursion{
    //1.1a: factorial
    public static int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 1;
	}
	return n*fact(n-1);
    }
    
    //1.1b: Fibonacci
    public static int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return help(n,0,1,0);
    }
    public static int help(int n, int count, int place, int total){
	if (n==count){
	    return total;
	}
	return help(n,count+1,place+total,place);
    }


   //1.1c: Square Root
    public static double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return guess(n,1);
    }

    public static double guess(double n, double g){
	double y=((n/g)+g)/2;
	if (Math.abs(g-y)<0.00001){
	    return y;
	}
	return guess(n,y);
    }

    public static void main(String[] args){
	System.out.println(fact(0));
	System.out.println(fact(10));
	System.out.println(fib(0));
	System.out.println(fib(1));
	System.out.println(fib(2));
	System.out.println(fib(10));
	System.out.println(sqrt(100));
	System.out.println(sqrt(2));
    }

}
