package Main;

/*
 * calculate the big mod of the numbers
 */
public class Main {
	
	public static void solve(int a , int b) {
		int res = 1;
		int m = 1000000007;
		while(b>0) {
			if((b&1) != 0) {
				res = res*a%m;
			}
			a = a*a%m;
			b>>=1;
		}
		System.out.println(res);
	}
	
	public static void solve(int x , int y, int n){
		x = x%n;
        int res = 1;
        while(y > 0){
            if((y & 1)!=0){
                res = res* x%n;
            }
            x = x * x%n;
            y>>=1;
        }
        System.out.println(res);
    }
	public static void main(String[] args) {
		//solve(2374859,3029382,36123);
		solve(123456,2);
	}
}

