
package p8_b;

/*
    Arturo Escutia López
    Daniel López Santiago
    27 Noviembre 2016
    Sesión 8b ejercicio 1.1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ord_top {
//-------------------------------------------------------------------------------------------------------------
    class LNode{
        private int v;
        private int weight;

        public LNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        public int getW() { return weight; }
        public int getV() { return v; }
    }
//---------------------------------------------------------------------------------------------------------------
    public ArrayList<ArrayList <LNode>> Adj_L=new ArrayList();
    public List<Integer> TL=new ArrayList();
    private boolean [] visited;
    private int [] active;
    private final String F_path;

    public Ord_top(String F_path) {
        this.F_path = F_path;
        ReadFile();
    }

    /*
    public static void main(String args[]){
        Ord_top O=new Ord_top("src\\orden_topologico\\file");
        O.ReadFile();
        O.printL();
        System.out.println();
        O.T_Order();
    }*/
    
    public void T_Order(){
        int aux;
        Queue Q=new LinkedList();
        for(int i=0;i<Adj_L.size();i++){
            if(active[i]==0)
                Q.add(i);
        }
        while(!Q.isEmpty()){
            aux=(Integer)Q.peek();
            TL.add(aux);
            Q.poll();
            for(int i=0;i<Adj_L.get(aux).size();i++){
                active[Adj_L.get(aux).get(i).getV()]-=1;
                if(active[Adj_L.get(aux).get(i).getV()]==0)
                    Q.add(Adj_L.get(aux).get(i).getV());
            }
        }
        if(TL.isEmpty())
            System.out.println("Cyclic Graph,there isn't topological order");
        else
            System.out.println("TOPOLOGICAL ORDER:"+TL+"\n");
    }
    
    public void printL(){
        System.out.println("\nPrint all adjacency lists with corresponding vertex:");
        for(int i=0; i<Adj_L.size(); i++){
            System.out.print(i + ": ");
            for(int j=0; j<Adj_L.get(i).size();j++)
                System.out.print("V:"+Adj_L.get(i).get(j).getV()+" W:"+Adj_L.get(i).get(j).getW()+" | ");
            System.out.println();
        }
        
        System.out.println();
      /*  for(int j=0;j<active.length;j++)
            System.out.println(j+" receives: "+active[j]);
        System.out.println();   */
    }
    
    private void ReadFile(){
        String nodes[],sCurrentLine;
        int idx,V,W;
	try {
		BufferedReader br = new BufferedReader(new FileReader(F_path));
                sCurrentLine = br.readLine();
                nodes=sCurrentLine.split(" ");
                idx=Integer.parseInt(nodes[0]);
                active=new int[idx+1];
                visited=new boolean[idx+1];
                Arrays.fill(visited,false);
                Arrays.fill(active,0);
                for(int i=0;i<=idx;i++)
                    Adj_L.add(new ArrayList());
                while ((sCurrentLine = br.readLine())!= null){ 
                    nodes=sCurrentLine.trim().split(" ");
                    idx=Integer.parseInt(nodes[0]);
                    V=Integer.parseInt(nodes[1]);
                    W=Integer.parseInt(nodes[2]);
                    Adj_L.get(idx).add(new LNode(V,W));
                    active[V]+=1;
                }
		br.close();
            
        } catch (IOException e) { e.printStackTrace(); } 
            
    }
    
    
      
}
