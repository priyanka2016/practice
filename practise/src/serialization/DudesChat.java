package serialization;

public class DudesChat implements Runnable {
    static Dudes d;

    public static void main(String[] args) {
        new DudesChat().go();
    }

    private void go() {
        d=new Dudes();
        new Thread(new DudesChat()).start();
        new Thread(new DudesChat()).start();

    }

    @Override
    public void run() {
        d.chat(Thread.currentThread().getId());

    }
}