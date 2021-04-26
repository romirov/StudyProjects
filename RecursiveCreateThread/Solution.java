/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread(){
            super(Integer.toString(createdThreadCount + 1));
            createdThreadCount++;
            start();
        }
        public void run() {
//            try {
//                sleep(2000);
               // while(createdThreadCount < Solution.count){
                    //System.out.println(new GenerateThread());
                //}
//            }catch(Exception e){
  //          }
            if(createdThreadCount < Solution.count)
                System.out.println(new GenerateThread());
        }

        @Override
        public String toString(){
            return getName() + " created";
        }
    }
}

