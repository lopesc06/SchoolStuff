/*
    Arturo Escutia López
    Juan Daniel López Santiago
    14 Octubre 2016
    Sesión 6 - Ejercicio 1
*/
import java.io.*;
import java.util.Arrays;
public class Strassen {

    public static void main(String args[]){
        int[][] X=ReadFile(args[0]);
        int[][] Y=ReadFile(args[1]);
        PrintM(Strassen(X,Y));
    }

    private static int[][] ReadFile(String file){
        int matrix[][]=null,row=0;
        String numbers[],sCurrentLine=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ( (sCurrentLine = br.readLine())!= null){ 
                numbers=sCurrentLine.split(",");
                if(matrix==null)
                    matrix=new int[numbers.length][numbers.length];
                for(int column=0;column<numbers.length;column++)
                    matrix[row][column]=Integer.parseInt(numbers[column]);
                row+=1;    
            }
            br.close();
        } catch (IOException e) { e.printStackTrace(); } 
        return matrix;
    }
        
    private static void PrintM(int A[][]){
        for (int[] A1 : A) {
            for (int i = 0; i<A.length; i++) 
                System.out.print(A1[i]+" ");
            System.out.println("");
        }
        System.out.println("");
    }
        
    private static int [][] OpM(int a[][],int b[][],String op){
        int matrix[][]=new int[a.length][a.length];
        for(int row = 0; row<a.length; row++){
            for (int column=0; column<a.length; column++) {
                if(op.equals("+"))
                    matrix[row][column]=a[row][column]+b[row][column];
                else
                    matrix[row][column]=a[row][column]-b[row][column];
            }
        }
        return matrix;
    }
        //getting submatrix from [0,n/2]-[n/2-1,n/2-1] and [n/2,n/2]-[n,n]
    private static int [][] RSubmatrix(int m[][],int start){
        int aux;
        int r[][]=new int[m.length/2][m.length/2];
        for(int row=0; row<r.length; row++){
            aux=(m.length/2);
            for(int column=0; column<r.length; column++)
                r[row][column]=m[start][aux++];
            start+=1;
        }
        return r;
    }
    private static int [][] JoinM(int R1[][],int R2[][],int R3[][],int R4[][]){
        int R[][]=new int[R1.length*2][R1.length*2];
        int row,column,aux,aux2;
        for(row=0;row<R1.length;row++){     //filling matrix from [0,0] to [n/2-1,/n/2-1]
            aux=R.length/2;
            for(column=0;column<R1.length;column++){    
                R[row][column]=R1[row][column];
                R[row][aux++]=R2[row][column];
            }
        }
        aux=R.length/2;
        for(row=0;row<R3.length;row++){     //filling matrix from  [0,/n/2] to [n,n]
            aux2=R.length/2;
            for(column=0;column<R3.length;column++){
                R[aux][column]=R3[row][column];
                R[aux][aux2++]=R4[row][column];
            }
            aux+=1;
        }
        return R;
    }    
    private static int[][] Strassen(int X[][], int Y[][]){
            
            if(X.length==1) {
                 int R[][]=new int [1][1]; 
                 R[0][0]=X[0][0]*Y[0][0];
                 return R;
            }
            int A[][]=Arrays.copyOfRange(X,0,X.length/2);
            int B[][]=RSubmatrix(X,0);
            int C[][]=Arrays.copyOfRange(X,X.length/2,X.length);
            int D[][]=RSubmatrix(X,X.length/2);
            int E[][]=Arrays.copyOfRange(Y,0,Y.length/2);
            int F[][]=RSubmatrix(Y,0);
            int G[][]=Arrays.copyOfRange(Y,Y.length/2,Y.length);
            int H[][]=RSubmatrix(Y,Y.length/2);
            
            int P1[][]=Strassen(A,OpM(F,H,"-"));
            int P2[][]=Strassen(OpM(A,B,"+"),H);
            int P3[][]=Strassen(OpM(C,D,"+"),E);
            int P4[][]=Strassen(D,OpM(G,E,"-"));
            int P5[][]=Strassen(OpM(A,D,"+"),OpM(E,H,"+"));
            int P6[][]=Strassen(OpM(B,D,"-"),OpM(G,H,"+"));
            int P7[][]=Strassen(OpM(A,C,"-"),OpM(E,F,"+"));
            
            int R1[][]=OpM(OpM(P5,P4,"+"),OpM(P2,P6,"-"),"-");
            int R2[][]=OpM(P1,P2,"+");
            int R3[][]=OpM(P3,P4,"+");
            int R4[][]=OpM(OpM(P5,P1,"+"),OpM(P3,P7,"+"),"-");; 
           
            return JoinM(R1,R2,R3,R4);
            
    }
}