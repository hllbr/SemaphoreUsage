
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SemaphoreOrnegi {
    private Semaphore sem = new Semaphore(3);//int permits = aynı anda kaç thread girebilir kaç threade izin verilsin anlamına geliyor
    //eğer semaphore içerisine 1 yazarsak snchronized kod bloku gibi davranıcaktır.
    
    public void threadFonksiyonu(int id){
        try {
            sem.acquire();//bu değer 0 ise ben alt tarafa gidemeyeceğim bunu kontrol ediyoruz.bu yapımız sayesinde aynı anda 3 threadimizin çalışmasını sağlıyoruz
        //değerimizi (-1) yapıyor
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Başlıyor...."+id);
        try {
            Thread.sleep(3550);
        } catch (InterruptedException ex) {
            Logger.getLogger(SemaphoreOrnegi.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread Çıkıyor....\nThread Çıktı : "+id);
        sem.release();//bu yapımızs ise semaphore değerimiz 0 ise bunun değerini (+1) yapıyor.
        //başka threadler bu bloka girebilsin diye bu bloku bırakıyor.Başka Threadler girebilsin diye izin vermiş oluyor
        
    }
    
}
/*
işletim sistemi derslerinde bu semaphoreları direkt olarak class değil kendinizin yazması isteniyor.
*/