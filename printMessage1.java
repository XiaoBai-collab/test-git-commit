import java.util.Arrays;

public class printMessage1 {

    public static void main(String[] args) {
        System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc ddd-conflict");
        System.out.println("ccc conflict");
        System.out.println("ddd");

        int[] arr = new int[] {2, 3, -1, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left, r = right;
        int flag = arr[left];
        int temp;

        while (l != r) {
            while (l < r && arr[r] >= flag) {
                r--;
            }

            while (l < r && arr[l] <= flag) {
                l++;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        arr[left] = arr[l];
        arr[l] = flag;

        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        int[] temp = new int[arr.length];
        int l = left, r = mid + 1;
        int k = left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[k++] = arr[l++];
            } else {
                temp[k++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[k++] = arr[l++];
        }

        while (r <= right) {
            temp[k++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
