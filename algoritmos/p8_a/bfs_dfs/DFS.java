/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs_dfs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DFS {
    
    private ArrayList<ArrayList <Integer>> Adj_L=new ArrayList();
    private boolean [] visited;
    private int [] parent;

    public ArrayList<ArrayList<Integer>> getAdj_L() {
        return Adj_L;
    }
    
    public static void main(String args[]){
        DFS O=new DFS();
        O.ReadFile("src\\bfs_dfs\\file");
        O.printL();
        int Origin=0;
        System.out.println();
        O.getDFS(Origin);
    }
    
    private void getDFS(int Origin){
        int aux;
        Stack s=new Stack();
        s.push(Origin);
        visited[Origin]=true;
        while(!(s.isEmpty())){
            aux=(int)s.peek();
            System.out.println(s);
            //System.out.print(aux+" ");
            s.pop();
            for(int i=0;i<Adj_L.get(aux).size();i++){
                if(visited[Adj_L.get(aux).get(i)]==false){
                    s.push(Adj_L.get(aux).get(i));
                    visited[Adj_L.get(aux).get(i)]=true;
                    parent[Adj_L.get(aux).get(i)]=aux;
                }
            }
        } 
        System.out.println();
        for(int i=0;i<parent.length;i++)
            System.out.println("Parent "+i+" is:"+parent[i]);
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
                parent=new int[idx+1];
                Arrays.fill(visited,false);
                Arrays.fill(parent,-1);
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

