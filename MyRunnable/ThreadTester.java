package MyRunnable;

class MyRunnable implements Runnable{
  //у Runnable всего один метод, который надо реализовать - public void run()
  //Именно сюда помещается задача, которую поток должен выполнить
  //Этот метод появится на дне нового стека
  public void run(){
    go();
  }

  public void go(){
    doMore();
  }
  
  public void doMore(){
    System.out.println("Вершина стека");
  }
}

class ThreadTester{
  public static void main(String[] args){
    Runnable threadJob = new MyRunnable();
    //Передаем экземпляр Runnable в конструктор Thread
    //Теперь поток знает, какой метод нужно поместить на дно нового стека
    //То есть это первый метод, который будет запущен
    Thread myThread = new Thread(threadJob);

    //поток запустится только после вызова start()
    myThread.start();

    System.out.println("Возвращаемся в метод main");
  }
}
