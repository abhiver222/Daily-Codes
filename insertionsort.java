import java.util.Arrays;


public class insertionsort {
	public static void main(String[] args){
		int[] arr = {2,9,1,6,8,0,3,3,5};
		System.out.println("before"+Arrays.toString(arr));
		insertionsort(arr);
		System.out.println("after"+Arrays.toString(arr));
	}
	public static void insertionsort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int val = arr[i];
			int j = i ;
			int swap=0;
			while(j>0 && arr[j-1]>val){
				swap=arr[j];
				arr[j]=arr[j-1];
				arr[j-1]= swap;
				j--;
			}
		}
		
	}
}
