
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\tSabiha Gökçen Havalimanına Hoşgeldiniz");

        String sartlar
                = "\t>Siyasi Yasağın Bulunmaması\n"
                + "\t>Harç Bedelinin (15 TL) Ödenmiş Olması\n"
                + "\t>Geçerli Vizenin Bulundurulması";
        String message = "Yurtdışına Çıkış için Belirliten Şatların Sağlanmış Olması Gerekmektedir";

        while (true) {
            System.out.println("********************************");
            System.out.println(message);
            System.out.println(sartlar);
            System.out.println("********************************");
            
            Yolcu yolcu =  new Yolcu();
            
            System.out.println("Harç Bedeli Kontrol Ediliyor...");
            Thread.sleep(3000);
            try {
                yolcu.yurtdisiHarcKontrol();
            } catch (HarcException ex) {
                ex.printStackTrace();
                continue;
            }
            System.out.println("Siyasi Yasak Kontrol Ediliyor...");
            Thread.sleep(3000);
            try {
                yolcu.siyasiYasakKontrol();
            } catch (SiyasiException ex) {
                ex.printStackTrace();
                continue;
            }
            System.out.println("Vize Durumu Kontrol Ediliyor...");
            Thread.sleep(3000);
            try {
                yolcu.vizeDurumuKontrol();
            } catch (VizeException ex) {
                ex.printStackTrace();
                continue;
            }
            System.out.println(">Sonuç : İşlemler tamamlanmıştır. Yurtdışına çıkabilirsiniz.");
            break;
        }
    }
}
