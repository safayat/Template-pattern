public class MergeSort extends AbstractSort {
    private int[] numbers;
    private int[] helper;

    private int number;


    public MergeSort(int[] numbers) {
        this.numbers = numbers;
        this.helper = new int[numbers.length];
    }

    @Override
    public int[] divide(int i, int j) {
        int middle = i + (j - i) / 2;
        int[] partitionIndexes = new int[2];
        partitionIndexes[0] = middle;
        partitionIndexes[1] = middle+1;
        return partitionIndexes;
    }

    @Override
    public void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }
    public static void main(String a[]){

        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        AbstractSort mSort = new MergeSort(input);
        mSort.sort(0,input.length-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }

}
