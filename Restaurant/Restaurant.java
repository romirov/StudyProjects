import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* 
Ресторан
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}

class Manager {      //singleton
    private static Manager ourInstance = new Manager();

    private final List<Table> restaurantTables = new ArrayList<Table>(10);
    private int currentIndex = 0;

    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<Order>();        // очередь с заказами
    private final Queue<Dishes> dishesQueue = new ConcurrentLinkedQueue<Dishes>();     // очередь с готовыми блюдами

    public synchronized static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Table());
        }
    }

    public synchronized Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Dishes> getDishesQueue() {
        return dishesQueue;
    }
}

class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Order getOrder() {
        return new Order(number);
    }
}

class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
        manager.getDishesQueue().add(dishes);
    }
}

class Dishes {
    private byte tableNumber;

    public Dishes(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
class Order {
    private long time;
    private byte tableNumber;

    public Order(byte tableNumber) {
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}


class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
//                System.out.println("=========================");
                Dishes dishes = manager.getDishesQueue().poll();
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable();
                Order order = table.getOrder();
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order);
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}

