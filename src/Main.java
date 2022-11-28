public class Main {
    public static void main(String[] args) {
        CountDownLatch barreira = new CountDownLatch(3);
        for(int i = 0; i < 100; i++){
            Worker w = new Worker(i, barreira);
            w.start();
        }
        try {
            barreira.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}