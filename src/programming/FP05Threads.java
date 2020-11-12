package programming;

public class FP05Threads {
    public static void main(String[] args) {
/*        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();*/

        Runnable runnable2 = () -> {
                for (int i=0; i<10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
        };

        Thread thread = new Thread(runnable2);
        thread.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        Thread thread3 = new Thread(runnable2);
        thread3.start();
    }
}
