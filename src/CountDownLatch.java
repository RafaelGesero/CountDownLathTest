import java.util.ArrayList;

public class CountDownLatch {

    private int count;
    ArrayList<Integer> finalizadores = new ArrayList<>();


    public CountDownLatch(int count){
        this.count = count;
    }

    public synchronized void await () throws InterruptedException {
        while ( count >0)
            wait ();
    }

    public synchronized void countDown (int id){
        finalizadores.add(id);
        count --;
        if( count ==0){
            podio();
        }


    }

    private void podio(){
        System.out.println("os tres que terminaram primeiro foram :");
        for(int i = 0; i < 3; i++){
            int classi = finalizadores.get(i);
            System.out.println(i + 1 + "º lugar:" + classi);
        }
             System.exit(0);
    }

}
