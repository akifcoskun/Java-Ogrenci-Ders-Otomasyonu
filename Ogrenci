import java.util.ArrayList;

public class Ogrenci extends Ders {
    private static int nextOgrenciNo = 1;
    private String ad;
    private String soyad;
    private int ogrenciNo;
    private ArrayList<String> secilenDersler;

    public Ogrenci(String ad, String soyad, int ogrenciNo) {
        super("Öğrenci Dersi", "STU101"); // Varsayılan ders bilgisi
        this.ad = ad;
        this.soyad = soyad;
        this.ogrenciNo = nextOgrenciNo++;
        this.secilenDersler = new ArrayList<>();
    }

    // Getter ve setter metotları
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public ArrayList<String> getSecilenDersler() {
        return secilenDersler;
    }

    public void dersSec(String dersAdi) {
        secilenDersler.add(dersAdi);
    }

    public void dersIptal(String dersAdi) {
        secilenDersler.remove(dersAdi);
    }

    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Öğrenci No: " + ogrenciNo + ", Seçilen Dersler: " + secilenDersler;
    }
}
