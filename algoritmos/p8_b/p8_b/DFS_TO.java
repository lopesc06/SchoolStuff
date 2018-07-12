
package p8_b;

/*
    Arturo Escutia López
    Daniel López Santiago
    27 Noviembre 2016
    Sesión 8b ejercicio 2.1
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS_TO {
    
    private ArrayList<ArrayList <Integer>> Adj_L=new ArrayList();
    private boolean [] visited;
    private int [] active;
    private final String F_path;
    private Stack stack = new Stack();
    
    public DFS_TO(String F_path) {
        this.F_path = F_path;
        ReadFile();
    }
    
    public static void main(String args[]){
        DFS_TO a=new DFS_TO("src\\orden_topologico\\file");
        a.Topological();
    }
    
    private void Topological(){
        for(int i=0;i<Adj_L.size();i++)
            if(visited[i]==false)
                DFS(i);
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
    
    private void DFS(int V){
        if(visited[V]==true) return;
        visited[V]=true;
        for(int i=0;i<Adj_L.get(V).size();i++)
            DFS(Adj_L.get(V).get(i));
        stack.push(V);
    }
    
    private void ReadFile(){
        String nodes[],sCurrentLine;
        int idx;
	try {
		BufferedReader br = new BufferedReader(new FileReader(F_path));
                sCurrentLine = br.readLine();
                nodes=sCurrentLine.split(" ");
                idx=Integer.parseInt(nodes[0]);
                active=new int[idx+1];
                visited=new boolean[idx+1];
                Arrays.fill(visited,false);
                Arrays.fill(active,0);
                for(int i=0;i<=idx;i++){
                    Adj_L.add(new ArrayList());
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
