import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OgrenciKayitSistemi {
    private ArrayList<Ogrenci> ogrenciListesi;
    private Map<String, Ders> dersler;

    public OgrenciKayitSistemi() {
        ogrenciListesi = new ArrayList<>();
        dersler = new HashMap<>();
        dersler.put("MAT1", new Ders("Matematik", "MAT1"));
        dersler.put("FİZ1", new Ders("Fizik", "FİZ1"));
        dersler.put("KİM1", new Ders("Kimya", "KİM1"));
        dersler.put("MÜZ1", new Ders("Müzik", "MÜZ1"));
        dersler.put("YAZ1", new Ders("Yazılım", "YAZ1"));
        dersler.put("RSM1", new Ders("Resim", "RSM1"));
    }

    public void ogrenciEkle(Ogrenci ogrenci) {
        ogrenciListesi.add(ogrenci);
    }

    public void ogrenciSil(int ogrenciNo) {
        for (int i = 0; i < ogrenciListesi.size(); i++) {
            if (ogrenciListesi.get(i).getOgrenciNo() == ogrenciNo) {
                ogrenciListesi.remove(i);
                System.out.println("Öğrenci silindi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");
    }

    public void tumOgrencileriListele() {
        for (Ogrenci ogrenci : ogrenciListesi) {
            if(ogrenciListesi == null){
                System.out.println("Henüz öğrenci girişi yapılmadı.");
            }
            System.out.println(ogrenci);
        }
    }

    public void dersleriListele() {
        System.out.println("Dersler:");
        for (Ders ders : dersler.values()) {
            System.out.println(ders);
        }
    }

    public void dersSecimiYap(int ogrenciNo, String dersKodu) {
        Ogrenci ogrenci = null;

        for (Ogrenci ogr : ogrenciListesi) {
            if (ogr.getOgrenciNo() == ogrenciNo) {
                ogrenci = ogr;
                break;
            }
        }

        if (ogrenci != null) {
            Ders secilenDers = dersler.get(dersKodu);
            if (secilenDers != null) {
                ogrenci.dersSec(secilenDers.getDersAdi());
                System.out.println("Ders seçimi yapıldı.");
            } else {
                System.out.println("Geçersiz ders kodu.");
            }
        } else {
            System.out.println("Öğrenci bulunamadı.");
        }
    }

    public void dersSecimiIptalEt(int ogrenciNo, String dersKodu) {
        Ogrenci ogrenci = null;
        for (Ogrenci o : ogrenciListesi) {
            if (o.getOgrenciNo() == ogrenciNo) {
                ogrenci = o;
                break;
            }
        }

        if (ogrenci != null) {
            if (ogrenci.getSecilenDersler().contains(dersKodu)) {
                ogrenci.dersIptal(dersKodu);
                System.out.println("Ders seçimi iptal edildi.");
            } else {
                System.out.println("Bu ders öğrenci tarafından seçilmemiş.");
            }
        } else {
            System.out.println("Öğrenci bulunamadı.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OgrenciKayitSistemi kayitSistemi = new OgrenciKayitSistemi();

        while (true) {
            System.out.println("\n1 - Yeni öğrenci ekle");
            System.out.println("2 - Öğrenci sil");
            System.out.println("3 - Tüm öğrencileri listele");
            System.out.println("4 - Ders seçimi yap");
            System.out.println("5 - Ders seçimini iptal et");
            System.out.println("6 - Dersleri listele");
            System.out.println("7 - Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            if (secim == 1) {
                System.out.print("Öğrenci adı: ");
                String ad = scanner.next();
                System.out.print("Öğrenci soyadı: ");
                String soyad = scanner.next();
                System.out.print("Öğrenci numarası: ");
                int ogrenciNo = scanner.nextInt();
                Ogrenci yeniOgrenci = new Ogrenci(ad, soyad, ogrenciNo);
                kayitSistemi.ogrenciEkle(yeniOgrenci);
                System.out.println("Öğrenci eklendi.");
            } else if (secim == 2) {
                System.out.print("Silmek istediğiniz öğrenci numarası: ");
                int ogrenciNo = scanner.nextInt();
                kayitSistemi.ogrenciSil(ogrenciNo);
            } else if (secim == 3) {
                kayitSistemi.tumOgrencileriListele();
            } else if (secim == 4) {
                System.out.print("Öğrenci numarası: ");
                int ogrenciNo = scanner.nextInt();
                System.out.println("Dersleri listelemek için 6'ya basınız.");
                System.out.print("Seçmek istediğiniz dersin kodunu girin: ");
                String dersKodu = scanner.next();
                kayitSistemi.dersSecimiYap(ogrenciNo, dersKodu);
            } else if (secim == 5) {
                System.out.print("Öğrenci numarası: ");
                int ogrenciNo = scanner.nextInt();
                System.out.print("İptal etmek istediğiniz dersin kodunu girin: ");
                String dersKodu = scanner.next();
                kayitSistemi.dersSecimiIptalEt(ogrenciNo, dersKodu);
            } else if (secim == 6) {
                kayitSistemi.dersleriListele();
            } else if (secim == 7) {
                System.out.println("Çıkış yapılıyor...");
                break;
            } else {
                System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }

        scanner.close();
    }
}
