/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P9_A;

public class MatrixOrderOptimization {
    protected int[][]m;
    protected int[][]s;
    public void matrixChainOrder(int[] dims) {
        int n = dims.length - 1;
        m = new int[n][n];
        s = new int[n][n];

        for (int lenMinusOne = 1; lenMinusOne < n; lenMinusOne++) {
            for (int i = 0; i < n - lenMinusOne; i++) {
                int j = i + lenMinusOne;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    
                    int cost = m[i][k] + m[k+1][j] + dims[i]*dims[k+1]*dims[j+1];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public void printOptimalParenthesizations() {
        
        printOptimalParenthesizations(s, 0, s.length - 1);
    }

    void printOptimalParenthesizations(int[][]s, int i, int j) {
        if(i==j)
            System.out.print("A"+i+" ");
        else{
            System.out.print("( ");
            printOptimalParenthesizations(s,i,s[i][j]);
            printOptimalParenthesizations(s,s[i][j]+1,j);
            System.out.print(" ) ");
                    
        }
            
    }
    public static void main(String[] args) {
        int size[]={50,20,1,10,100};
         MatrixOrderOptimization m=new  MatrixOrderOptimization ();
         m.matrixChainOrder(size);
         m.printOptimalParenthesizations();
    }
    
}
