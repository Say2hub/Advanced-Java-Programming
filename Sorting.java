import java.util.*;

interface SortingStrategy {
    void sort(int array[]);
}

class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int array[]) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int array[], int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class MergeSortStrategy implements SortingStrategy {
    @Override
    public void sort(int array[]) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int array[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}

class Main {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }

    public static void main(String[] args) {
        Main context = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(array));

        int[] bubbleSortedArray = array.clone();
        context.setStrategy(new BubbleSortStrategy());
        context.sortArray(bubbleSortedArray);
        System.out.println("BubbleSort: " + Arrays.toString(bubbleSortedArray));

        int[] quickSortedArray = array.clone();
        context.setStrategy(new QuickSortStrategy());
        context.sortArray(quickSortedArray);
        System.out.println("QuickSort: " + Arrays.toString(quickSortedArray));

        int[] mergeSortedArray = array.clone();
        context.setStrategy(new MergeSortStrategy());
        context.sortArray(mergeSortedArray);
        System.out.println("MergeSort: " + Arrays.toString(mergeSortedArray));

        sc.close();
    }
}
