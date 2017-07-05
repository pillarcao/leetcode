
/**

����10���� ���ٵļ���С��1-88�� 
1 5 8 13 17 .....()
�����3���� A��B��C 
������㣬A+4 =B ��B+3=C ��ô��Major ���� 
������㣬A+3=B�� B+4=C ��ô�� min ����
������㣬A+4=B�� B+4=C ��ô�� aug ����
������㣬A+3=B�� B+3=C ��ô�� dim ����
���������A��B��C�� ������һ�����Ӽ�12 ��12���������� ��������������Ҳ��


����� ��Major��min��aug��dim�ĸ���


˼·�ǣ�10 ���� ��ѡ3��
��12ȡ�� ����������󣬴���4�������ж�



 
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

	// �ж������Ǹ�����
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

	// m����ѡn����������б�10 ѡ 3��
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

	// ���ݵ�ǰ��ϣ�����һ�������
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
		 * T ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */
		for (int test_case = 1; test_case <= T; ++test_case) {

			for (int i = 0; i < 10; i++) {
				Input[i] = sc.nextInt();
			}

			// ��ʼ��������
			maj = 0;
			min = 0;
			aug = 0;
			dim = 0;

			// ��ȡ����б�
			List lst = getCombine(10, 3);
			int[] tem = new int[3];

			System.out.println("10 ������ѡ3������ϣ�");
			// ��ÿ����ϣ��ж��Ƿ��������
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

				// �ж������Ǹ�����
				isChores(tem);

			}

			System.out.println("maj:" + maj + " min:" + min + " aug:" + aug + "  dim:" + dim);
		}

	}
}
