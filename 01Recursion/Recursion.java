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
	if (n==0){
	    return 0;
	}
	if (n==1){
	    return 1;
	}
	return fib(n-1)+fib(n-2);
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
