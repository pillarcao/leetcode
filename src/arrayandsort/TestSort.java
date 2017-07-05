package arrayandsort;

import java.util.Random;

public class TestSort {

	public static int[] insertSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					// TODO:
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					// 接下来是无用功
					break;
				}
			}
		}
		return arr;
	}

	// 二维数组选择排序
	public static void SelectSort2(int a[][]) {

		for (int i = 0; i < a.length; i++) {

			int temp = 0;
			for (int j = 0; j < a.length; j++) {

				if (a[i][1] < a[j][1]) {
					temp = a[i][1];
					a[i][1] = a[j][1];
					a[j][1] = temp;

					temp = a[i][0];
					a[i][0] = a[j][0];
					a[j][0] = temp;

				}
			}
		}

	}

	// 二维数组冒泡排序
	public static void PopSort2(int a[][]) {

		for (int i = 0; i < a.length; i++) {

			int temp = 0;
			for (int j = 0; j < a.length - i - 1; j++) {

				if (a[j][1] > a[j + 1][1]) {
					temp = a[j + 1][1];
					a[j + 1][1] = a[j][1];
					a[j][1] = temp;

					temp = a[j + 1][0];
					a[j + 1][0] = a[j][0];
					a[j][0] = temp;

				}
			}
		}

	}

	// 二维快速排序
	public static void quickSort2(int a[][], int start, int end) {
		int i = start;
		int j = end;
		int mark = end;
		int temp;

		if (i >= j)
			return;

		while (i < j) {
			while (i < j && a[i][1] <= a[mark][1])
				i++;

			temp = a[i][1];
			a[i][1] = a[mark][1];
			a[mark][1] = temp;

			temp = a[i][0];
			a[i][0] = a[mark][0];
			a[mark][0] = temp;

			mark = i;

			while (i < j && a[j][1] >= a[mark][1])
				j--;

			temp = a[j][1];
			a[j][1] = a[mark][1];
			a[mark][1] = temp;

			temp = a[j][0];
			a[j][0] = a[mark][0];
			a[mark][0] = temp;

			mark = j;

			quickSort2(a, start, mark - 1);
			quickSort2(a, mark + 1, end);
		}

	}

	// 一维快速排序
	public static void quickSort(int a[], int start, int end) {
		int i = start;
		int j = end;
		int mark = end;
		int temp;

		if (i >= j)
			return;

		while (i < j) {
			while (i < j && a[i] <= a[mark])
				i++;

			temp = a[i];
			a[i] = a[mark];
			a[mark] = temp;

			mark = i;

			while (i < j && a[j] >= a[mark])
				j--;

			temp = a[j];
			a[j] = a[mark];
			a[mark] = temp;

			mark = j;

			
		}
		
		if(start<mark-1)
		quickSort(a, start, mark - 1);
		
		if(end>mark+1)
		quickSort(a, mark + 1, end);

	}

	// 选择排序
	public static void SelectSort(int a[]) {
		int tem = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {

				if (a[i] >= a[j]) {
					tem = a[i];
					a[i] = a[j];
					a[j] = tem;
				}

			}

		}

	}

	// 选择排序
	public static void SelectSort1(int a[]) {
		int tem = 0;
		for (int i = 0; i < a.length; i++) {

			int maxindex = i;
			int maxvalue = a[i];
			for (int j = i + 1; j < a.length; j++) {

				if (maxvalue < a[j]) {
					maxindex = j;
					maxvalue = a[j];

				}

			}

			if (maxindex != i) {
				tem = a[i];
				a[i] = maxvalue;
				a[maxindex] = tem;
			}

			// System.out.print(maxvalue+" ,");

			// for(int e:a)
			// {
			// System.out.print(e+" ");
			// }
			//
			// System.out.println();

		}

	}

	// 冒泡排序
	public static void PopSort(int a[]) {

		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
			for (int e : a) {
				System.out.print(e + " ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {

		// System.out.println(2^3);
        int []b={2,3,1,4,6,9,10};
		int[] a = new int[1000000];

		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(1000000);
		}

		insertSort(b);
		System.out.println();
	
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}

		System.out.println("-----------------------");

	}

}
