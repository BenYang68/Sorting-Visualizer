import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
	
	
	int size;
	int[] nums;
	ArrayList<Bars> barList;
	int newLayer =0;
	
	
	public MergeSort(ArrayList<Bars> rec, int size) {
		this.size=size;
		nums = new int[size];
		for(int i =0; i<rec.size(); i++) {
			nums[i] = rec.get(i).getHeight();
		}
	}
	
	
	// breaks apart and merges
	public int[] sort(int[] nums, int times) {
		int middle = nums.length - nums.length / 2;
		
		if (nums.length == 1) {
			return nums;
		}
		
		int[] left = sort(Arrays.copyOfRange(nums, 0, middle), times+1);
		int[] right = sort(Arrays.copyOfRange(nums, middle, nums.length),times+1);

		
		return merge(left, right);
	}


	// puts broken array parts into sorted order
	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int index = 0, l = 0, r = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				result[index++] = left[l++];
			} else {
				result[index++] = right[r++];
			}
		}
		while (l < left.length) {
			result[index++] = left[l++];
		}
		while (r < right.length) {
			result[index++] = right[r++];
		}
		return result;
	}
	
	
	
	public  ArrayList<Bars> getlist(){
		ArrayList<Bars> barList = new ArrayList<Bars>();
		for(int i : nums)
			barList.add(new Bars(0,0,10,i));
		
		return barList;
	}
}
