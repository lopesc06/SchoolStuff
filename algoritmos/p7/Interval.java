
package peso_max;

public class Interval {
    private int s;
    private int f;
    private int v;
    private int p;
    
   public int order(String a){
       if (a.toLowerCase().equals("s"))
           return s;
       else
           return f;
   }
   
   public Interval(int s, int f, int v) {
        this.s = s;
        this.f = f;
        this.v = v;
    }
        
    
    public int getS() {
        return s;
    }


    public int getF() {
        return f;
    }


    public int getV() {
        return v;
    }

   

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    
}
