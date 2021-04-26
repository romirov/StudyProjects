class MyThread extends Thread{
	private int threadNumber;
	//определяем конструктор вместо сеттера
	public MyThread(int threadNumber){
		this.threadNumber = threadNumber;
	}

	//перезаписываем метод run из Thread
	public void run(){
		for(int i = 0; i < 100; i++ ){
			System.out.println(threadNumber + " => " + i);//вывод номера потока
			//необходимо предусмотреть возможную ошибку для таймаута
			try{
				sleep(1000);
			}catch(InterruptedException e){
				System.out.print("Ошибка: ");
				e.printStackTrace();
				System.out.println();
			}
		}
	}
}

public class MyThreadTestDrive{
	public static void main(String[] args){
		MyThread myThread1 = new MyThread(1);
		MyThread myThread2 = new MyThread(2);
		
		myThread1.start();
		myThread2.start();
	}
}
