package algs;

public class MaxSubArray {
	
	public int Kadane(int[] arr){
		int max=0,soFar=0;
		for(int i = 0;i<arr.length;i++){
			soFar = Math.max(0, soFar+arr[i]);
			max = Math.max(soFar,max);
		}
		return max;
	}
	
	public static void mains(String[] args){
		int[] arr ={-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaxSubArray().Kadane(arr));
	}

}
