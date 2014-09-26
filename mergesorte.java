import java.util.Arrays;


public class mergesorte {

	public static void main(String[] args){
		int[] list = {2,1,4,6,3,9,7};
		System.out.println("Before : "+ Arrays.toString(list));
		merge(list);
		System.out.println("After : "+ Arrays.toString(list));
	}
	
	public static void merge(int[] array){
		if(array.length>1){
			int[] left = getleft(array);
			int[] right = getright(array);
			
			merge(left);
			merge(right);
			mergeboth(array,left,right);
			
		}
	}
	
	public static int[] getleft(int[] array){
		int size1 = array.length/2;
		int[] left1 = new int[size1];
		for(int i=0;i<size1;i++){
			left1[i] = array[i];
		}
		return left1;
	}
	
	public static int[] getright(int[] array){
		int size1 = array.length/2;
		int size2 = array.length - size1;
		int[] right1 = new int[size2];
		for(int i=0;i<size2;i++){
			right1[i] = array[i+size1];
		}
		return right1;
	}
	
	public static void mergeboth(int[] array, int[] left, int[] right){
		int i1 = 0;
		int i2 = 0;
		
		for(int i=0;i<array.length;i++){
			if((i2>=right.length) || (i1<left.length && left[i1]<right[i2])){
				array[i]=left[i1];
				i1++;
			}
			else{
				array[i]=right[i2];
				i2++;
			}
		}
	}
}
