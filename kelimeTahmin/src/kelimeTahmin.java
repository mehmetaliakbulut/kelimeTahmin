import java.util.Random;
import java.util.Scanner;

public class kelimeTahmin {

    public static void main(String[] args) {
        String[] kelimeler = {"Oyun", "Bilgisayar", "Yazılım", "Java", "Kitap", "Telefon", "Proje", "Vize", "Final"};
        Random random = new Random();
        String kelime = kelimeler[random.nextInt(kelimeler.length)];

        StringBuilder gizliKelime = new StringBuilder();
        for (int i = 0; i < kelime.length(); i++) {
            gizliKelime.append("_");
        }

        int[] secilenHarfler = new int[2];
        secilenHarfler[0] = random.nextInt(kelime.length());
        do {
            secilenHarfler[1] = random.nextInt(kelime.length());
        } while (secilenHarfler[0] == secilenHarfler[1]);

        gizliKelime.setCharAt(secilenHarfler[0], kelime.charAt(secilenHarfler[0]));
        gizliKelime.setCharAt(secilenHarfler[1], kelime.charAt(secilenHarfler[1]));

        System.out.println("Kelime: " + gizliKelime);

        Scanner scanner = new Scanner(System.in);
        int tahminSayisi = 0;

        while (gizliKelime.toString().contains("_")) {
            System.out.print("Bir harf tahmin edin: ");
            char harf = scanner.nextLine().toLowerCase().charAt(0);

            boolean harfBulundu = false;
            for (int i = 0; i < kelime.length(); i++) {
                if (Character.toLowerCase(kelime.charAt(i)) == harf && gizliKelime.charAt(i) == '_') {
                    gizliKelime.setCharAt(i, kelime.charAt(i));
                    harfBulundu = true;
                }
            }

            if (harfBulundu) {
                System.out.println("Kelimenin içinde bu harf var!");
            } else {
                System.out.println("Kelimenin içinde bu harf yok.");
            }

            System.out.println("Kelime: " + gizliKelime);
            tahminSayisi++;
        }

        System.out.println("Tebrikler! Kelimeyi " + tahminSayisi + " hamlede doğru bildiniz.");
        scanner.close();
    }
}