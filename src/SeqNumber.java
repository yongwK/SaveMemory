import java.util.Scanner;

public class SeqNumber {

	static int SeqNumber(int[] a, int n, int key) {
		//정렬(보호법)
		int i;
		a[n] = key;
		for(i=0; a[i]!=key; i++);
		return i==n ? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("배열의 요소수 : ");
		int number = scan.nextInt();
		int[] x = new int[number];
		
		for(int i=0; i<number; i++) {
			System.out.print("x["+i+"] = ");
			x[i] = scan.nextInt();
		}
		System.out.println("찾고 싶은 값 : ");
		int key = scan.nextInt();
		int idx = SeqNumber(x, number, key);
		if(idx==-1) {
			System.out.println("찾는 값이 없습니다.");
		}else {
			
		}
	}
}
