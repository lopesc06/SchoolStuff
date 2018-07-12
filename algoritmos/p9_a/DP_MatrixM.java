package P9_A;

/*
    Arturo Escutia López
    12 Diciembre 2016
    Sesión 9a ejercicio 3
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DP_Matrix{
    
    private int cost[][],solution[][];
    private String Line=" ";
    private int p[],w;
    
    private int Mcost(int i,int j){
        if(cost[i][j]!=-1)
            return cost[i][j];
        else{
            if(i==j)
               cost[i][j]=0;
            else{
                cost[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    w=Mcost(i,k)+Mcost(k+1,j)+p[i-1]*p[k]*p[j];
                    if(w<cost[i][j]){
                        cost[i][j]=w;
                        solution[i][j]=k;
                    }
                }
            }
        }
        return cost[i][j];
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
    
    private void ReadFile(String fname){
        try {
                BufferedReader br = new BufferedReader(new FileReader(fname));
                String line[]=br.readLine().trim().split(",");
                p=new int[line.length];
                for(int i=0;i<line.length;i++)
                    p[i]=Integer.parseInt(line[i]);
                cost=new int[p.length][p.length];
                solution=new int[p.length][p.length];
                for (int[] cost1 : cost) {
                    Arrays.fill(cost1,-1);
            }
        } catch (IOException ex) {
            Logger.getLogger(DP_MatrixM2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void WFile(){
        try{
               Line=Line+" Costo:"+cost[1][cost.length-1];
               File file = new File("src\\P9_A\\newfile.txt");
               PrintWriter writer = new PrintWriter(file, "UTF-8");
               writer.println(Line);
               writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        DP_MatrixM2 m=new DP_MatrixM2();
        m.ReadFile("src\\P9_A\\File");
        m.Mcost(1,m.p.length-1);
        m.PrintS(m.solution,1,m.solution.length-1);
        m.WFile();
        System.out.println("");
        
/*/---------------------------------------------------------------------------------//
                    for (int[] aux1 : m.solution) {
                        for (int b = 0; b<m.solution.length; b++) {
                            System.out.print(aux1[b] + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");    
//-----------------------------------------------------------------------------------//     */ 
        m.Line=m.Line+" Costo:"+m.cost[1][m.cost.length-1];
        System.out.println(m.Line);
    }
}
