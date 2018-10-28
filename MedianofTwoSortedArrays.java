public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 > l2) {
            int [] temp=nums1;
            nums1=nums2;
            nums2=temp;
            int tep=l1;
            l1=l2;
            l2=tep;

        }
        int imin = 0, imax = l1;
        int mid = (l1 + l2 + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = (l1 + l2 + 1) / 2 - i;
            if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1;
            } else if (i < imax && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
//                    if ((l1 + l2) % 2 == 1) return b[mid];
//                    else
//                        return (Math.max(a[0], b[j]) + b[j - 1]) / 2.0;
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
//                    return (a[i - 1] + b[0]) / 2.0;
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((l1 + l2) % 2 == 1) return maxLeft;
                int minRight = 0;
                if (i == nums1.length) {
                    minRight = nums2[j];
                } else if (j == nums2.length) minRight = nums1[i];
                else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;

            }
        }
        return 0;
    }
}
