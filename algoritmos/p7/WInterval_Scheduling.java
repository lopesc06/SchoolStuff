
package peso_max;

import java.io.*;
import static java.lang.Integer.max;
import java.util.*;

public class WInterval_Scheduling{
    
    private static  ArrayList <Interval> sorted_end;
    private static  int M[];
    
    public static void main(String args[]){
        
        int cont=0; 
        MergeSort ms=new MergeSort(); 
        ms.sortGivenArray(new WInterval_Scheduling().ReadFile(args[0]),"f");
        sorted_end=ms.getSortedArray();
        
        for(Interval i:sorted_end){
              CalculateP(1,sorted_end.size()-1,i);
              System.out.println("#"+(cont++)+" I:"+i.getS()+" F:"+i.getF()+" V:"+i.getV()+" P:"+i.getP());
        }
       
        M=new int[sorted_end.size()];
        Arrays.fill(M,-1);
        M[0]=0;
       
        for(int i=sorted_end.size()-1;i>0;i--)
            OPT(i);
        System.out.print("Memoization: ");
        for(int i=0;i<M.length;i++)
            System.out.print(M[i]+",");
       
        System.out.print("\nSolution: ");
        FindS(M.length-1);
    }
    
    private static void FindS(int j){
        if(j==0) return;
        else if(sorted_end.get(j).getV()+M[sorted_end.get(j).getP()] > M[j-1]){
            System.out.print(j+" ");
            FindS(sorted_end.get(j).getP());
        }
        else 
            FindS(j-1);
    }
    
    private static int OPT(int j){
        if(j==0) return 0;      
        if (M[j]==-1)       //calculate optimal of j if it hasn´t been calculated
           M[j]=max(sorted_end.get(j).getV()+OPT(sorted_end.get(j).getP()) , OPT(j-1));   //calculate Vj+ Opt[Pj]   and Opt[j-1]
        return M[j];
    }
    
    private static void CalculateP(int low,int high, Interval i){
        if(i.getV()<1)  return;
        int middle;
        //finding lower bound with binary search
	while(low<high){
            middle=low+(high-low+1)/2;    
            if(sorted_end.get(middle).getF()<=i.getS())    //if middle finishes before i starts,search  to the right
                low=middle;                                //for a nearest not overlapping interval for  i 
            else
                high=middle-1;              //search to the left for not overlapping interval 
        } 
        if (sorted_end.get(low).getF()>i.getS())   //there isn't any not overlapping interval for i
            i.setP(0);
        else 
            i.setP(low);             //nearest interval that  doesn't overlap i  
    }

    private ArrayList <Interval> ReadFile(String file){
        String numbers[],sCurrentLine;
        Interval inter;
        ArrayList <Interval> r=new ArrayList();
        inter=new Interval(-1,-1,-1);   //adding an extra interval in position 0 to  avoid confusion with intervals and indexes
        inter.setP(-1);
        r.add(inter);
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
                while ((sCurrentLine = br.readLine())!= null){ 
                    numbers=sCurrentLine.trim().split(",");
                    inter=new Interval(Integer.parseInt(numbers[0]),
                                       Integer.parseInt(numbers[1]),
                                       Integer.parseInt(numbers[2]));
                    r.add(inter);
                }
		br.close();
            
        } catch (IOException e) { e.printStackTrace(); } 
            return r;
    }
    
}
