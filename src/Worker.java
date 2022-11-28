

public class Worker extends Thread {

    private int id;
    private int total = 0;
    CountDownLatch barreira;



    public Worker(int id, CountDownLatch barreira ){
       this.id = id;
       this.barreira = barreira;
    }

    public void count(int i){
        total = i;
    }

    public int getTotal(){
        return total;
    }

    public void run(){
        for(int i = 0; i < 5; i++){
            count(i);
            try {
                sleep((int)(Math.random()*5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        barreira.countDown(id);
    }

}
