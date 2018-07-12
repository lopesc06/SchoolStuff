
package bfs_dfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BFS {
    
    private ArrayList<ArrayList <Integer>> Adj_L=new ArrayList<ArrayList <Integer>>();
    private boolean [] visited;

    public ArrayList<ArrayList<Integer>> getAdj_L() {
        return Adj_L;
    }
    
    public static void main(String args[]){
        BFS bfs=new BFS();
        bfs.ReadFile("src\\bfs_dfs\\file");
        bfs.printL();
        int Origin=1;
        System.out.println();
        bfs.getBFS(Origin);
    }
    
    private void getBFS(int Origin){
        int aux;
        Queue Q=new LinkedList();
        Q.add(Origin);
        visited[Origin]=true;
        while(!(Q.isEmpty())){
            aux=(int) Q.peek();
            System.out.println("Q:"+Q);
            System.out.print(aux+" <- ");
            Q.poll();
            for(int i=0;i<Adj_L.get(aux).size();i++){
                if(visited[Adj_L.get(aux).get(i)]==false){
                    Q.add(Adj_L.get(aux).get(i));
                    visited[Adj_L.get(aux).get(i)]=true;
                }
            }
        }
            
    }
    
    private void printL(){
        System.out.println("\nPrint all adjacency lists with corresponding vertex:");
        for(int v=0; v<Adj_L.size(); v++)
            System.out.println(v + ": " +Adj_L.get(v));
    }
    
    private void ReadFile(String file){
        String nodes[],sCurrentLine;
        int idx;
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
                sCurrentLine = br.readLine();
                nodes=sCurrentLine.split(" ");
                idx=Integer.parseInt(nodes[0]);
                visited=new boolean[idx+1];
                Arrays.fill(visited,false);
                for(int i=0;i<=idx;i++){
                    Adj_L.add(new ArrayList <Integer>());
                } 
                while ((sCurrentLine = br.readLine())!= null){ 
                    nodes=sCurrentLine.trim().split(" ");
                    idx=Integer.parseInt(nodes[0]);
                    Adj_L.get(idx).add(Integer.parseInt(nodes[1]));
                    idx=Integer.parseInt(nodes[1]);
                    Adj_L.get(idx).add(Integer.parseInt(nodes[0]));   
                }
		br.close();
            
        } catch (IOException e) { e.printStackTrace(); } 
            
    }
    
}
