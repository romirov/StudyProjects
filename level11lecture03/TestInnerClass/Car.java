public class Car {
    //напишите тут ваш код
    static Engine engine;
    public static void main(String[] args) {
        //напишите тут ваш код
        engine.start();
        engine.stop();
    }

    //напишите тут ваш код
    static class Engine{
        private boolean isRunning;
        public void start(){
            isRunning = true;
        }
        public void stop(){
            isRunning = false;
        }
    }
}

