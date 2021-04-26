/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

        Thread.sleep(3500);
        if(numSeconds <= 0){
            System.out.println("Марш!");
        }else{
            System.out.println(numSeconds + " Прервано!");
            clock.interrupt();
        }
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            //boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            try{
                while(numSeconds > 0){
                    Thread.sleep(1000);
                    //numSeconds--;
                    System.out.print(numSeconds + " ");
                    numSeconds--;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

