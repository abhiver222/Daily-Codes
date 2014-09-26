import java.awt.datatransfer.StringSelection;
import java.util.Arrays;


public class quicksort {
	public static void main(String[] args){
		int[] array = {2,4,1,7,6,5,5,0,9};
		int pivot;
		int low = 0;
		int high = array.length-1;
		System.out.println("before"+Arrays.toString(array));
		quicksort(array,low,high);
		System.out.println("After"+Arrays.toString(array));
	}
	
	public static int quicksortpart(int[] array,int low,int high){
		if(array==null||array.length==0)
			return 0;
		if(low<=high)
			return 0;
		
		int pivot = array[high];
		int i =low;
		int pind=i;
		int j =high;
		int swap=0;
		int p =low;
		for(p=low;p<high;p++){
			if(array[p]<pivot){
				swap=array[p];
				array[p]=array[pind];
				array[pind]=swap;
				pind++;
			}
		}
		swap=array[high];
		array[high]=array[pind];
		array[pind]=swap;
		return pind;
		
	}
	public static void quicksort(int[] array,int low,int high){
		if(low<high){
			
		int part=quicksortpart(array,low,high);
		if(part!=0){
		quicksort(array,low,part-1);
		quicksort(array,part+1,high);
		}}
		else
			return;
	}
}
