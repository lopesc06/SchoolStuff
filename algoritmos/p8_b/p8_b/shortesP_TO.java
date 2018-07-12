
package p8_b;

/*
    Arturo Escutia López
    Daniel López Santiago
    27 Noviembre 2016
    Sesión 8b ejercicio 1.1
*/


import java.util.*;

public class shortesP_TO extends Ord_top {
    
    private int distance []=new int [Adj_L.size()];
    
    public shortesP_TO(String F_path) {
        super(F_path);
    }
    
    public static void main(String Args[]){
        shortesP_TO SP=new shortesP_TO("src\\p8_b\\file");
        SP.printL();
        SP.T_Order();
        SP.Path(1);
    }

    public void Path(int Start){
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[Start]=0;
        for(int i=TL.indexOf(Start);i<TL.size(); i++){
            int aux=TL.get(i);
            for(int j=0; j<Adj_L.get(aux).size();j++){
                int v=Adj_L.get(aux).get(j).getV();
                int w=Adj_L.get(aux).get(j).getW();
                if(distance[v]>(distance[aux]+w))
                    distance[v]=(distance[aux]+w);
            }    
        }
        System.out.print("Start:"+Start+"\n");
        for(int i=0;i<distance.length;i++ ){
            if(distance[i]==Integer.MAX_VALUE)
                System.out.println(i+":INF");
            else 
                System.out.println(i+":"+distance[i]);
        }
        
    }
    
    
}
