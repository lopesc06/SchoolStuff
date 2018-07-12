package P9_A;

/*
    Arturo Escutia López
    12 Diciembre 2016
    Sesión 9a ejercicio 2
*/

import static java.lang.Math.max;
import static java.lang.Math.min;

public class D1 {

    private int matrix[][];
            
    public static void main(String[] args) {
        String s1="GAATTCAGTTA";
        String s2="GGATCGA";
        D1 d=new D1();
        if(s2.length()>s1.length())
            d.Alignment(s1,s2);
        else
            d.Alignment(s2,s1);    
    }
    
    private void Alignment(String s1, String s2){
        int n=min(s1.length(),s2.length())+1;
        int m=max(s1.length(),s2.length())+1;
        int match,gap1,gap2,s;
        matrix=new int[n][m];
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    s=1;
                else
                    s=0;
                match=matrix[i-1][j-1]+s;
                gap1=matrix[i-1][j];
                gap2=matrix[i][j-1];
                matrix[i][j]=max(match,max(gap1,gap2));
            }
        }
        
        String align_A="",align_B="";
        int i=s1.length();
        int j=s2.length();
        //System.out.println(i+" "+j);
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1))
                s=1;
            else
                s=0;
            if(i>0 && j>0 && matrix[i][j]==matrix[i-1][j-1]+s){
                align_A=s1.charAt(i-1)+align_A;
                align_B=s2.charAt(j-1)+align_B;
                i=i-1;
                j=j-1;
            }else if(i>0 && matrix[i][j]==matrix[i-1][j]){
                align_A=s1.charAt(i-1)+align_A;
                align_B="-"+align_B;
                i=i-1;
            }else{
                align_A="-"+align_A;
                align_B=s2.charAt(j-1)+align_B;
                j=j-1;
            }
            
        }
        while(j>0){
            align_A="-"+align_A;
            align_B=s2.charAt(j-1)+align_B;
            j=j-1;
        }
        
        System.out.println(align_B);
        System.out.println(align_A);
        
        
        
 //--------------------------------------------------------------------------------------------------//       
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                System.out.print(matrix[x][y]+" ");
            }
            System.out.println("");
        }
 //--------------------------------------------------------------------------------------------------/*/       
        
    }
    
    
}
