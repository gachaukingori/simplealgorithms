
public class Fibonacci {
	public static int fibonacci(int n ){
		if(n <=1){
			return n;
		}else{
			int fib = fibonacci(n-1) + fibonacci(n-2);
			return fib;
		}
	}
	public static int series(int n){
	if(n <= 1){
		return 1;
	}
	else{
		int tempN  = series(n-1);
		System.out.println("" +tempN);
		return tempN;
		
	}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		System.out.println(" "+ fibonacci(n));
		for(int i = 0; i<n; ++i){
			System.out.println(fibonacci(i));
		}
		
		
		//series(5);

	}

}
