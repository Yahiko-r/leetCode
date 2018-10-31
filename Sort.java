
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sort {
    public void insertSort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

        }
    }

    public void shellSort(int[] array) {
        //希尔增量，hk=h(k+1)/2
        for (int gap = array.length; gap > 0; gap /= 2) {
            //插入排序
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i;
                for (; j >= gap && temp < array[j - gap]; j -= gap)
                    array[j] = array[j - gap];
                array[j] = temp;
            }
        }
    }

    public void selectSort(int[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    /**
     * 1.建立堆，(从0开始，不是1，即a[0]是顶)
     * 2.堆顶删除，剩余重新排序
     *
     * @param a
     */

    public void heapSort(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            adjustHead(a, i, a.length);//把每个节点都调整一次（跟比节点大的叶子互换）length/2是最后的节点（从1开始的）这里似乎没有用，
        }
        //堆顶删除，将堆顶数据放到数组最后节约空间
        for (int j = a.length - 1; j > 0; j--) {
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            adjustHead(a, 0, j);
        }
    }

    public void adjustHead(int[] a, int i, int n) {
        int child;
        int temp;
        for (temp = a[i]; (2 * i + 1) < n; i = child) {
            child = 2 * i + 1;
            if (child != n - 1 && a[child] < a[child + 1])
                child++;
            if (temp < a[child])
                a[i] = a[child];
            else
                break;
        }
        a[i] = temp;
    }

    /**
     * 需要改进，改成void,
     *
     * @param a
     * @return
     */
    public int[] mergeSort(int[] a) {
        if (a.length < 2) return a;
        int middle = a.length / 2;
        int[] left = Arrays.copyOfRange(a, 0, middle);
        int[] right = Arrays.copyOfRange(a, middle, a.length);

        a = merge(mergeSort(left), mergeSort(right));//a指向了merge中返回的数组的地址，main中的a数组并没有变化
        return a;
    }

    public int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int leftPos = 0, rightPos = 0, i = 0;
        while (leftPos < left.length && rightPos < right.length) {
            if (left[leftPos] < right[rightPos]) {
                result[i++] = left[leftPos++];
            } else {
                result[i++] = right[rightPos++];
            }
        }
        while (leftPos < left.length)
            result[i++] = left[leftPos++];
        while (rightPos < right.length)
            result[i++] = right[rightPos++];
        return result;
    }

    //快速排序，pivot选择首，中，末三个的中值，减少因为数据基本有序情况下的复杂度。
    public void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(int[] a, int left, int right) {
        if (left + 2 > right) return;
        int pivot = findPivot(a, left, right);
        int i = 0, j = right - 1;
        while (true) {
            while (a[++i] < pivot) {
            }
            while (a[--j] > pivot) {
            }
            if (i < j) {
                swap(a, i, j);
            } else
                break;
        }
        swap(a, i, right - 1);
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    public int findPivot(int[] a, int left, int right) {
        int middle = (left + right) / 2;
        if (a[left] > a[middle])
            swap(a, left, middle);
        if (a[left] > a[right])
            swap(a, left, right);
        if (a[middle] > a[right])
            swap(a, middle, right);
        swap(a, middle, right - 1);
        return a[middle];
    }

    //一定范围内的整数，
    public static void countingSort(int[] a) {
        int min = 0, max = 0;

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                continue;
            }
            if (max < a[i]) max = a[i];
        }
        int[] b = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            int c = a[i];
            b[c]++;
        }
        int f = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i]; j++) {
                a[f++] = i;
            }
        }
    }

    //一趟a找最大最小值，一趟a给b赋值，一趟b相加，一趟a得到结果。好像没差，上面的方法更好。
    public static int[] countingSort2(int[] a) {
        int min = 0, max = 0;

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                continue;
            }
            if (max < a[i]) max = a[i];
        }
        int[] b = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            int c = a[i];
            b[c]++;
        }
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i] + b[i - 1];
        }
        int[] c = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            int f = a[j];
            c[b[f] - 1] = f;
            b[f]--;
        }
        return c;
    }

    /**
     * 将均匀分布的数组分散到桶里，和计数排序一样，只不过，计数排序每个桶里只有一个。
     */
    public static void bucketSort(int[] a) {
        int min = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                continue;
            }
            if (max < a[i]) {
                max = a[i];
            }
        }
        int bucketSize = 4;
        int buckets = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(buckets);
        for (int i = 0; i < buckets; i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            int n = (a[i] - min) / buckets;
            result.get(n).add(a[i]);
        }
        for (int i = 0; i < buckets; i++) {
            Collections.sort(result.get(i));
        }
        int flag = 0;
        for (int i = 0; i < buckets; i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                a[flag++] = result.get(i).get(j);
            }
        }
    }

    //默认非负整数
    public static void radixSort(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) max = a[i];
        }
        int num = 1;
        while (max / 10 != 0) {num++;max/=10;}

        for (int d = 1; d <= num; d++) {
            int[][] rs = new int[10][a.length + 1];
            for (int i = 0; i < a.length; i++) {
                int l;
                if (d == 1)
                     l = a[i] % 10;
                else
                     l=a[i]/((d-1)*10)%10;
                rs[l][rs[l][0] + 1] = a[i];
                rs[l][0]++;
            }
            int flag = 0;
            for (int i = 0; i < 10; i++) {
                int j = rs[i][0];
                for(int jj=1;jj<=j;jj++) {
                    a[flag++] = rs[i][jj];
                }
            }
        }
    }

    public void swap(int[] a, int b, int c) {
        int temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    public void printArray(int[] array) {
        int l = array.length;
        for (int i = 0; i < l; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 65, 7, 4, 9, 8, 4};
        Sort s = new Sort();
        radixSort(array);
//       int[] b= s.countingSort2(array);
        s.printArray(array);
//        s.quickSort(array);
//        s.printArray(array);
    }

}
