import java.util.Arrays;


public class quicksort2 {
	public static void main(String[] args){
		int[] arr = {5,2,6,3,4,4,9,0};
		int left = 0;
		int right = arr.length-1;
		System.out.println("before"+Arrays.toString(arr));
		quicksort(arr,left,right);
		System.out.println("After"+Arrays.toString(arr));
	}
	public static int part(int[] arr,int left,int right){
		int i =left;
		int j =right;
		int swap=0;
		int pivot=arr[(left+right)/2];
		while(i<=j){
			while(arr[i]<pivot)
				i++;
			while(arr[j]>pivot)
				j--;
			if(i<=j){
				swap=arr[i];
				arr[i]=arr[j];
				arr[j]=swap;
				i++;
				j--;
			}
		}
		return i;
	}
	public static void quicksort(int[] arr, int left, int right){
		int pind = part(arr,left,right);
		if(left<pind-1)
			quicksort(arr,left,pind-1);
		if(pind<right)
			quicksort(arr,pind,right);		
	}
}
