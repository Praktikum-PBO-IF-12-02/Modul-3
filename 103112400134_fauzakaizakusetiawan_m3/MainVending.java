import java.util.Scanner;

class Produk {
    String nama;
    int harga;

    Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

public class MainVending {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Produk p1 = new Produk("Coke", 5000);
        Produk p2 = new Produk("Air Mineral", 3000);
        Produk p3 = new Produk("Snack Chips", 7000);

        System.out.println("VENDING MACHINE");
        System.out.println("1. " + p1.nama + " - Rp" + p1.harga);
        System.out.println("2. " + p2.nama + " - Rp" + p2.harga);
        System.out.println("3. " + p3.nama + " - Rp" + p3.harga);

        System.out.print("\nPilih nomor item: ");
        int pilihan = input.nextInt();

        System.out.print("Masukkan uang Anda: Rp");
        int uangUser = input.nextInt();

        Produk terpilih = null;
        if (pilihan == 1) terpilih = p1;
        else if (pilihan == 2) terpilih = p2;
        else if (pilihan == 3) terpilih = p3;

        if (terpilih != null) {
            if (uangUser >= terpilih.harga) {
                int kembalian = uangUser - terpilih.harga;
                System.out.println("\nTRANSAKSI BERHASIL");
                System.out.println("Item: " + terpilih.nama);
                System.out.println("Kembalian: Rp" + kembalian);
            } else {
                System.out.println("\nTRANSAKSI GAGAL");
                System.out.println("Uang tidak cukup. Kurang: Rp" + (terpilih.harga - uangUser));
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}