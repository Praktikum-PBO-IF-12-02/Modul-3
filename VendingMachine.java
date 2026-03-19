import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        VendingMachine vm = new VendingMachine(
                "VM01",
                1,   // stok teh
                2,   // stok kopi
                2,   // stok susu
                5000,
                7000,
                6000
        );

        int pilihan;

        do {
            vm.tampilkanStatus();

            System.out.println("=== MENU ===");
            System.out.println("1. Masukkan Uang");
            System.out.println("2. Beli Minuman");
            System.out.println("3. Batalkan Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan uang: ");
                    double uang = input.nextDouble();
                    vm.masukkanUang(uang);
                    break;

                case 2:
                    System.out.print("Pilih minuman (teh/kopi/susu): ");
                    String minuman = input.next();
                    vm.pilihMinuman(minuman);
                    break;

                case 3:
                    vm.batalkanTransaksi();
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan vending machine!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}