import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        VendingMachine mesin = new VendingMachine("VM-001", 5, 3, 0,
                                                   5000, 7000, 6000);

        System.out.println("=========================================");
        System.out.println("  SELAMAT DATANG DI VENDING MACHINE TEL-U");
        System.out.println("=========================================");

        boolean running = true;

        while (running) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Masukkan Uang");
            System.out.println("2. Pilih Minuman");
            System.out.println("3. Batalkan Transaksi");
            System.out.println("4. Tampilkan Status Mesin");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu [1-5]: ");

            String inputMenu = scanner.nextLine().trim();

            switch (inputMenu) {

                case "1":
                    System.out.print("Masukkan jumlah uang (Rp): ");
                    try {
                        double jumlah = Double.parseDouble(scanner.nextLine().trim());
                        mesin.masukkanUang(jumlah);
                    } catch (NumberFormatException e) {
                        System.out.println("[ERROR] Input tidak valid. Masukkan angka.");
                    }
                    break;

                case "2":
                    System.out.print("Pilih minuman (teh / kopi / susu): ");
                    String pilihan = scanner.nextLine().trim();
                    mesin.pilihMinuman(pilihan);
                    break;

                case "3":
                    mesin.batalkanTransaksi();
                    break;

                case "4":
                    mesin.tampilkanStatus();
                    break;

                case "5":
                    System.out.println("\nTerima kasih telah menggunakan Vending Machine!");
                    System.out.println("Sampai jumpa :)");
                    running = false;
                    break;

                default:
                    System.out.println("[ERROR] Menu tidak valid. Pilih angka 1-5.");
            }
        }

        scanner.close();
    }
}