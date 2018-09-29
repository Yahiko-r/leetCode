package leetCode;

public class MergeSortedArray {
	public int[] merge(int[] nums1, int m, int[] nums2, int n) {
		int j = m + n;
		for (; j > 0; j--) {
			if (m == 0){
				nums1[j - 1] = nums2[n - 1];
				n--;
			}
			else if (n == 0) {
				nums1[j - 1] = nums1[m - 1];
				m--;
			} else {
				if (nums1[m - 1] > nums2[n - 1]) {
					nums1[j - 1] = nums1[m - 1];
					m--;
				} else {
					nums1[j - 1] = nums2[n - 1];
					n--;
				}
			}

		}
		return nums1;
	}

	public static void main(String[] args) {
		MergeSortedArray m = new MergeSortedArray();
		int[] a1 = { 1, 2, 3, 0, 0, 0 };
		int[] a2 = { 2, 5, 6 };
		int[] rs = m.merge(a1, 3, a2, 3);
		System.out.println(rs);

	}
}
