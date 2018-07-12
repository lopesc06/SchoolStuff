
package peso_max;
import java.util.ArrayList;
 
public class MergeSort {
    
    private ArrayList<Interval> inputArray;
    private String orderby;
     
    public ArrayList<Interval> getSortedArray() {
        return inputArray;
    }

    public void sortGivenArray(ArrayList<Interval> inputArray, String orderby){   
        this.inputArray = inputArray;
        this.orderby = orderby;
        divide(0, this.inputArray.size()-1);
    }
     
    public void divide(int startIndex,int endIndex){
         
        if(startIndex<endIndex ){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
            merge(startIndex,mid,endIndex);            
        }       
    }   
     
    public void merge(int startIndex,int midIndex,int endIndex){
         
        ArrayList<Interval> mergedSortedArray = new ArrayList();
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
         
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex).order(orderby)<=inputArray.get(rightIndex).order(orderby)){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }       
         
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }
         
        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }
         
        int i = 0;
        int j = startIndex;

        while(i<mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}