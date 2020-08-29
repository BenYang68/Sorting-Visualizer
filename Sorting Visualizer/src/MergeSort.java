import java.util.Arrays;

public class MergeSort {
	// breaks apart and merges
	public static int[] sort(int[] nums) {
		int middle = nums.length - nums.length / 2;
		
		if (nums.length == 1) {
			return nums;
		}
		

		int[] left = sort(Arrays.copyOfRange(nums, 0, middle));
		int[] right = sort(Arrays.copyOfRange(nums, middle, nums.length));
		
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
}
