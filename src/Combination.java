
/**

输入10个数 钢琴的键大小（1-88） 
1 5 8 13 17 .....()
如果有3个数 A，B，C 
如果满足，A+4 =B ，B+3=C 那么是Major 和旋 
如果满足，A+3=B， B+4=C 那么是 min 和旋
如果满足，A+4=B， B+4=C 那么是 aug 和旋
如果满足，A+3=B， B+3=C 那么是 dim 和旋
但是如果（A，B，C） 中任意一个数加减12 或12的整数倍后 满足上述条件的也算


输出是 ：Major，min，aug，dim的个数


思路是：10 个数 任选3个
与12取余 ，余数排序后，带入4个条件判断



 
**/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Combination {

	static int Input[] = new int[10];

	static int maj = 0;
	static int min = 0;
	static int aug = 0;
	static int dim = 0;

	// 判断满足那个和弦
	public static void isChores(int[] a) {

		for (int i = 0; i < 3; i++) {
			a[i] = a[i] % 12;
		}

		Arrays.sort(a);

		if (a[0] + 4 == a[1] && a[1] + 3 == a[2]) {
			maj++;
		} else if (a[0] + 3 == a[1] && a[1] + 4 == a[2]) {
			min++;
		} else if (a[0] + 4 == a[1] && a[1] + 4 == a[2]) {
			aug++;
		} else if (a[0] + 3 == a[1] && a[1] + 3 == a[2]) {
			dim++;
		}

	}

	// m个数选n个数的组合列表（10 选 3）
	public static List getCombine(int m, int n) {
		List lst = new ArrayList();

		int s = (2 << (n - 1)) - 1;

		String minBinary = Integer.toBinaryString(s);
		String maxbinary = minBinary;
		String tem;

		for (int i = 0; i < m - n; i++) {
			maxbinary = maxbinary + '0';
		}

		for (int i = 0; i < m - n; i++) {
			minBinary = '0' + minBinary;
		}

		System.out.println("min/max:" + minBinary + "/" + maxbinary);

		lst.add(minBinary);
		System.out.println(minBinary);
		while (true) {

			tem = getMinNextBinary(minBinary);
			lst.add(tem);
			minBinary = tem;
			System.out.println(tem);

			if (tem.equals(maxbinary))
				break;

		}

		return lst;
	}

	// 根据当前组合，求下一个组合数
	public static String getMinNextBinary(String init_value) {

		char[] tem =init_value.toCharArray();
		

		int len = tem.length - 1;
		for (int i = tem.length - 1; i > 0; i--) {
			int sum = 0;

			if (tem[i] == '1' && tem[i - 1] == '0') {
				tem[i - 1] = '1';
				tem[i] = '0';
				for (int j = i + 1; j < tem.length; j++) {
					if (tem[j] == '1') {
						tem[j] = '0';
						sum++;
					}
				}

				for (int k = 0; k < sum; k++) {
					tem[len - k] = '1';
				}

				break;
			}

		}

		return new String(tem);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		/*
		 * T 俺狼 抛胶飘 纳捞胶啊 林绢瘤骨肺, 阿阿阑 贸府钦聪促.
		 */
		for (int test_case = 1; test_case <= T; ++test_case) {

			for (int i = 0; i < 10; i++) {
				Input[i] = sc.nextInt();
			}

			// 初始化和弦数
			maj = 0;
			min = 0;
			aug = 0;
			dim = 0;

			// 获取组合列表
			List lst = getCombine(10, 3);
			int[] tem = new int[3];

			System.out.println("10 个数任选3个的组合：");
			// 遍每个组合，判断是否满足和弦
			for (int i = 0; i < lst.size(); i++) {
				String combine = (String) lst.get(i);
				char[] a = combine.toCharArray();

				for (int j = 0, k = 0; j < a.length; j++) {
					if (a[j] == '1') {
						tem[k] = Input[j];
						k++;
						if (k > 2)
							break;
					}
				}

				System.out.println(tem[0] + "," + tem[1] + "," + tem[2]);

				// 判断满足那个和弦
				isChores(tem);

			}

			System.out.println("maj:" + maj + " min:" + min + " aug:" + aug + "  dim:" + dim);
		}

	}
}
