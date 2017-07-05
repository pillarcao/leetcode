
import java.util.Arrays;

// 数组去重 
public class Solution {

	
	//数组中两个和满足target的index
	public static int[] twoSum(int[] numbers, int target) {
		int index[] = { -1, -1 };

		for (int i = 0; i < numbers.length; i++) {
			int tem = target - numbers[i];

			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] == tem) {
					index[0] = i;
					index[1] = j;
				}
			}

		}

		return index;
	}

	// 数组去重复并返回，新的长度
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		int test[] = { 2, 7, 11, 15 };
		int result[] = new int[2];
		result = Solution.twoSum(test, 17);
		System.out.println(result[0] + "," + result[1]);
	}
}
