public class Solution {
    public static void main(String[] args) {
        println(new WaterBridge());
        println(new SuspensionBridge());
    }

    //add println method here
    public void println(Bridge bridge){
        System.out.println(bridge.getCarsCount);
    }

    public interface Bridge{
        int getCarsCount();
    }

    public class WaterBridge implements Bridge{
        public int getCarsCount(){
            return 1;
        }
    }
    
    public class SuspensionBridge implements Bridge{
        public int getCarsCount(){
            return 2;
        }
    }
}
