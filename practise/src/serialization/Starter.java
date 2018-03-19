package serialization;

public class Starter implements Runnable{
    @Override
    public void run() {
        go(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId() + " ");
        new Thread(new Starter()).start();

    }
    void go(long id){
        System.out.println(id);
    }
}