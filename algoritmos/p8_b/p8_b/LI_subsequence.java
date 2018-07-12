
package p8_b;

/*
    Arturo Escutia López
    Daniel López Santiago
    27 Noviembre 2016
    Sesión 8b ejercicio 2.2
*/


import java.util.Stack;

public class LI_subsequence {

    public void longestSubsequence(int arr[]){
        
        int distance[] = new int[arr.length];
        int Solution[] = new int[arr.length];
        
        for(int i=0; i < arr.length; i++){
            distance[i] = 1;
            Solution[i] = i;
        }
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(distance[j] + 1 > distance[i]){
                        distance[i] = distance[j] + 1;
                        Solution[i] = j; //set the actualSolution to point to guy before me
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < distance.length; i++){
            if(distance[i] > distance[maxIndex])
                maxIndex = i;   
        }
        
        int t = maxIndex;
        int newT = maxIndex;
        Stack s=new Stack();
        System.out.print("Subsequence ");
        do{
            t = newT;
            s.push(arr[t]);
            newT = Solution[t];
        }while(t != newT);
        
        while(!s.isEmpty())
            System.out.print(s.pop()+" ");
             
    }
    
   
    public static void main(String args[]){
        LI_subsequence lis = new LI_subsequence();
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
        System.out.print("Original sequence ");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
        lis.longestSubsequence(arr);
    }
}