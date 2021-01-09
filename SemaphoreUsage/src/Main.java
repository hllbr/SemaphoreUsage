
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Javada Semaphore kullanımı =
ReentranrLock ve synchronized kod bloklarında sadece tek bir threadin alana girişine izin veriyorduk.Başka bir thread olduğunda bölgeye başka hiçbir thread giremiyor.

Ancak biz Semaphore kullanarak birden çok threadin bir yere girmesini sağlayabiliriz.Daha sonra başka threadlerin buraya girmesini engelleyebiliriz.
Aynı anda 3 - 4 threadi aynı anda çalıştırabiliriz veya başka threadlerimiz varsa bu threadleride burda engelleyebiliriz.

*/
public class Main {
    public static void main(String[] args) {
        SemaphoreOrnegi so = new SemaphoreOrnegi();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                so.threadFonksiyonu(1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
              so.threadFonksiyonu(2);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
             so.threadFonksiyonu(3);
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
              
                so.threadFonksiyonu(4);
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                so.threadFonksiyonu(5);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
