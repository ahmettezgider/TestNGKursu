package gun08;

public class ThreadOrnek {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                say(10);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t1 = new Thread(r, "A");
        Thread t2 = new Thread(r, "B");

        //say(10);
        t1.start();
        System.out.println("--------------");
        //say(10);
        t2.start();
    }

    public static void say(int n){
        for (int i = 0; i < n; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
