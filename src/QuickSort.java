public class QuickSort extends AbstractSort {

    private int array[];


    public QuickSort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
    }

    @Override
    public int[] divide(int i, int j) {

        int pivot = array[i+(j-i)/2];
        // Divide into two arrays
        while (i <= j) {
            while (array[i] < pivot && i < array.length) {
                i++;
            }
            while (array[j] > pivot && j >= 0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }

        int[] partitionValues = new int[2];
        partitionValues[0] = j;
        partitionValues[1] = i;
        return partitionValues;

    }

    @Override
    public void merge(int low, int middle, int high) {

    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String a[]){

        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        AbstractSort qSort = new QuickSort(input);
        qSort.sort(0,input.length-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}