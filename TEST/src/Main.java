import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		findMax (new int[] {43, 54, 23, 65, 78, 85, 88, 92, 10});
		findMinMax (new int[] {43, 54, 23, 65, 78, 85, 88, 92, 10});
	}
	public static int[] findMax(int[] t) {
		Arrays.sort(t);
		int max = t[t.length - 1];
		int min = t[0];
		System.out.println("MAX = " + max);
		System.out.println("MIN = " + min);
		return new int[] {max, min};
	}

	public static int[] findMinMax(int[] t) {
		int max = t[0];
		int min = t[0];
		for (int i = 1; i < t.length; i++) {
			if(max < t[i]){
				max = t[i];
			}
			if(min > t[i]) {
				min = t[i];
			}
		}
		System.out.println("MAX = " + max);
		System.out.println("MIN = " + min);
		return new int[] {max, min};
	}
}
