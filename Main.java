import java.util.Scanner;

class VendingMachine {

    private double saldo = 0;
    private int stokTeh = 3, stokKopi = 3, stokSusu = 3;
    private final double hargaTeh = 5000, hargaKopi = 7000, hargaSusu = 6000;
    private double totalPenjualan = 0;

    public void masukkanUang(double uang) {
        saldo += uang;
        System.out.println("Uang masuk: Rp" + uang + " | Saldo: Rp" + saldo);
    }

    public void beli(int pilihan) {
        double harga = 0;
        String jenis = "";

        switch (pilihan) {
            case 1:
                if (stokTeh == 0) {
                    System.out.println("Stok teh habis!");
                    return;
                }
                harga = hargaTeh;
                jenis = "teh";
                break;

            case 2:
                if (stokKopi == 0) {
                    System.out.println("Stok kopi habis!");
                    return;
                }
                harga = hargaKopi;
                jenis = "kopi";
                break;

            case 3:
                if (stokSusu == 0) {
                    System.out.println("Stok susu habis!");
                    return;
                }
                harga = hargaSusu;
                jenis = "susu";
                break;

            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        if (saldo < harga) {
            System.out.println("Saldo kurang!");
            return;
        }

        saldo -= harga;
        totalPenjualan += harga;

        if (pilihan == 1) stokTeh--;
        if (pilihan == 2) stokKopi--;
        if (pilihan == 3) stokSusu--;

        System.out.println("Berhasil: Silakan ambil " + jenis);
        System.out.println("Sisa saldo: Rp" + saldo);
    }

    public void status() {
        System.out.println("\n=== STATUS ===");
        System.out.println("Stok Teh  : " + stokTeh);
        System.out.println("Stok Kopi : " + stokKopi);
        System.out.println("Stok Susu : " + stokSusu);
        System.out.println("Saldo     : Rp" + saldo);
        System.out.println("Total Jual: Rp" + totalPenjualan);
    }

    public double getSaldo() {
        return saldo;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        VendingMachine vm = new VendingMachine();

        int pilih;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Masukkan Uang");
            System.out.println("2. Beli");
            System.out.println("3. Status");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4): ");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan uang: Rp");
                    double uang = input.nextDouble();
                    vm.masukkanUang(uang);
                    break;

                case 2:
                    System.out.println("\nPilih Minuman:");
                    System.out.println("1. Teh  (Rp5000)");
                    System.out.println("2. Kopi (Rp7000)");
                    System.out.println("3. Susu (Rp6000)");
                    System.out.print("Pilih (1-3): ");
                    int minum = input.nextInt();
                    vm.beli(minum);
                    break;

                case 3:
                    vm.status();
                    break;

                case 4:
                    if (vm.getSaldo() > 0) {
                        System.out.println("Kembalian: Rp" + vm.getSaldo());
                    }
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan salah!");
            }

        } while (pilih != 4);

        input.close();
    }
}