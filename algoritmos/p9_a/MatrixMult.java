
package P9_A;

/*
    Arturo Escutia López
    12 Diciembre 2016
    Sesión 9a ejercicio 1
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  DP_MatrixM{
    
    private String Line=" ";
    
    private void matrixC(int size[]){
        int n=size.length-1;
        int[][] Cost=new int[n][n];
        int solution[][]=new int[n][n];
        int j,w;
        for(int L=1;L<n;L++){
            for(int i=0;i<n-L;i++){
                j=i+L;
                Cost[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){           
                    w=Cost[i][k]+Cost[k+1][j]+size[i]*size[k+1]*size[j+1];
                    if(w<Cost[i][j]){
                        Cost[i][j]=w;
                        solution[i][j]=k;
                    }
                }
            }
        }
     
        PrintS(solution,0,solution.length-1);
        Line=Line+" Costo:"+Cost[0][Cost.length-1];
        WFile();
        //System.out.println(" Costo:"+Cost[0][Cost.length-1]);
    }
    
    private void PrintS(int[][]s,int i,int j) {
        if(i==j){
            Line=Line+"A"+i+" ";
            //System.out.print("A"+i+" ");
        }else{
            Line=Line+" ( ";
            //System.out.print("( ");
            PrintS(s,i,s[i][j]);
            PrintS(s,s[i][j]+1,j);
            Line=Line+" ) ";
            //System.out.print(" ) ");      
        }     
    }
    
    private void WFile(){
        try{
               File file = new File("src\\P9_A\\newfile.txt");
               PrintWriter writer = new PrintWriter(file, "UTF-8");
               writer.println(Line);
               writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
     private void ReadFile(String fname){
        try {
                BufferedReader br = new BufferedReader(new FileReader(fname));
                String line[]=br.readLine().trim().split(",");
                int []p=new int[line.length];
                for(int i=0;i<line.length;i++)
                    p[i]=Integer.parseInt(line[i]);
                DPmatrix(p);
        } catch (IOException ex) {
            Logger.getLogger(DP_MatrixM2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DP_MatrixM m=new DP_MatrixM();
        m.ReadFile("src\\P9_A\\File");
        
    }
    
}
