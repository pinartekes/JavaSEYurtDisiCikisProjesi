
import java.util.Scanner;

class SiyasiException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("\t>Siyasi Yasağını Bulunuyor.");
    }
}

class VizeException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("\t>Vizeniz Bulunmamaktadır.");
    }

}

class HarcException extends Exception {

    @Override
    public void printStackTrace() {
        System.out.println("\t>Harc Bedelini(15 TL) Doğru Yatırınız");
    }

}

public class Yolcu {

    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;

    public Yolcu() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Yatırdığınız Harç Bedeli : ");
        this.harc = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Herhangi Bir Siyasi Yasağınız Bulunuyor mu : ");
        String cevap = scanner.nextLine();
        if (cevap.equals("evet") || cevap.equals("Evet")) {
            this.siyasiYasak = true;
        } else {
            this.siyasiYasak = false;
        }

        System.out.print("Vizeniz Var mı : ");
        String cevap_vize = scanner.nextLine();
        if (cevap_vize.equals("Evet") || cevap_vize.equals("evet")) {
            this.vizeDurumu = true;
        } else {
            this.vizeDurumu = false;
        }
    }

    public void yurtdisiHarcKontrol() throws HarcException {
        if (this.harc < 15) {
            throw new HarcException();
        } else {
            System.out.println("\t>Harç Bedeli Ödenmiştir.");
        }
    }

    public void siyasiYasakKontrol() throws SiyasiException {
        if (this.siyasiYasak == true) {
            throw new SiyasiException();
        } else {
            System.out.println("\t>Herhangi Siyasi Yasağınız Bulunmamaktadır.");

        }
    }

    public void vizeDurumuKontrol() throws VizeException {
        if (vizeDurumu == true) {
            System.out.println("\t>Geçerli Vizeniz Bulunmaktadır.");
        } else {
            throw new VizeException();
        }
    }
}
