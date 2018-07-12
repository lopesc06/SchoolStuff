
package orden_topologico;

/*
    Arturo Escutia López
    Daniel López Santiago
    17 Noviembre 2016
    Sesión 8
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ord_top {
    
    private ArrayList<ArrayList <Integer>> Adj_L=new ArrayList();
    private boolean [] visited;
    private int [] active;

    public ArrayList<ArrayList<Integer>> getAdj_L() {
        return Adj_L;
    }
    
    public static void main(String args[]){
        Ord_top O=new Ord_top();
        O.ReadFile("src\\orden_topologico\\file");
        O.printL();
        System.out.println();
        O.T_Order();
    }
    
    private void T_Order(){
        int aux;
        Queue Q=new LinkedList();
        for(int i=0;i<Adj_L.size();i++){
            if(active[i]==0)
                Q.add(i);
        }
        List L=new ArrayList();
        while(!Q.isEmpty()){
            aux=(Integer)Q.peek();
            L.add(aux);
            Q.poll();
            for(int i=0;i<Adj_L.get(aux).size();i++){
                active[Adj_L.get(aux).get(i)]-=1;
                if(active[Adj_L.get(aux).get(i)]==0)
                    Q.add(Adj_L.get(aux).get(i));
            }
        }
        if(L.isEmpty())
            System.out.println("Cyclic Graph,there isn't topological order");
        else
            System.out.println(L);
    }
    
    private void printL(){
        System.out.println("\nPrint all adjacency lists with corresponding vertex:");
        
        for(int v=0; v<Adj_L.size(); v++)
            System.out.println(v + ": " +Adj_L.get(v));
        System.out.println();
        for(int j=0;j<active.length;j++)
            System.out.println(j+" le llegan: "+active[j]);
        
    }
    
    private void ReadFile(String file){
        String nodes[],sCurrentLine;
        int idx;
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
                sCurrentLine = br.readLine();
                nodes=sCurrentLine.split(" ");
                idx=Integer.parseInt(nodes[0]);
                active=new int[idx+1];
                visited=new boolean[idx+1];
                Arrays.fill(visited,false);
                Arrays.fill(active,0);
                for(int i=0;i<=idx;i++){
                    Adj_L.add(new ArrayList <Integer>());
                } 
                while ((sCurrentLine = br.readLine())!= null){ 
                    nodes=sCurrentLine.trim().split(" ");
                    idx=Integer.parseInt(nodes[0]);
                    Adj_L.get(idx).add(Integer.parseInt(nodes[1]));
                    active[Integer.parseInt(nodes[1])]+=1;
                }
		br.close();
            
        } catch (IOException e) { e.printStackTrace(); } 
            
    }
    
    
      
}
