abstract public class AbstractSort {

     public abstract int[] divide(int i, int j);
     public abstract void merge(int low, int middle, int high);
     public void sort(int lowerIndex, int higherIndex){
         int[] partitionIndexes = divide(lowerIndex,higherIndex);

         if(lowerIndex<higherIndex){
             sort(lowerIndex, partitionIndexes[0]);
             sort(partitionIndexes[1], higherIndex);
             merge(lowerIndex,partitionIndexes[0],higherIndex);
         }

     }


}
