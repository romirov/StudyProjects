public class MinMaxUtil {
    //напишите тут ваш код
    public static int min(int x, int y){
        return (x < y) ? x : y;
    }
    
    public static int min(int x, int y, int w){
        int temp = min(x,y);
        return min(w,temp);
    }
    
    public static int min(int x, int y, int w, int z){
        int temp = min(x,y,w);
        
        return min(z,temp);
    }
    
    public static int min(int v, int x, int y, int w, int z){
        int temp = min(v,x,y,w);
        return min(z,temp);
    }
    
    public static int max(int x, int y){
        return (x > y) ? x : y;
    }
    
    public static int max(int x, int y, int w){
        int temp = max(x,y);
        return max(w,temp);
    }

    public static int max(int x, int y, int w, int z){
        int temp = max(x,y,w);
        return max(z,temp);
    }
    
    public static int max(int v, int x, int y, int w, int z){
        int temp = max(v,x,y,w);
        return max(z,temp);
    }
}
