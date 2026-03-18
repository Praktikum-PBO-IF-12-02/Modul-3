import java.util.Scanner;

class VendingMachine {
    private String kodeMesin;
    private double saldoMasuk;
    private int stokTeh;
    private int stokKopi;
    private int stokSusu;
    private double hargaTeh;
    private double hargaKopi;
    private double hargaSusu;
    private double totalPenjualan;

    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu,
                          double hargaTeh, double hargaKopi, double hargaSusu) {
        this.kodeMesin      = kodeMesin;
        this.saldoMasuk     = 0;
        this.stokTeh        = stokTeh;
        this.stokKopi       = stokKopi;
        this.stokSusu       = stokSusu;
        this.hargaTeh       = hargaTeh;
        this.hargaKopi      = hargaKopi;
        this.hargaSusu      = hargaSusu;
        this.totalPenjualan = 0;
    }

    public void masukkanUang(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("[ERROR] Jumlah uang harus lebih dari 0.");
            return;
        }
        saldoMasuk += jumlah;
        System.out.println("[INFO] Uang dimasukkan: Rp" + jumlah);
        System.out.println("[INFO] Saldo saat ini  : Rp" + saldoMasuk);
    }

    public void pilihMinuman(String jenis) {
        if (saldoMasuk <= 0) {
            System.out.println("[GAGAL] Masukkan uang terlebih dahulu.");
            return;
        }

        double harga = 0;
        int stok     = 0;

        switch (jenis.toLowerCase()) {
            case "teh":
                harga = hargaTeh;
                stok  = stokTeh;
                break;
            case "kopi":
                harga = hargaKopi;
                stok  = stokKopi;
                break;
            case "susu":
                harga = hargaSusu;
                stok  = stokSusu;
                break;
            default:
                System.out.println("[ERROR] Minuman tidak tersedia: " + jenis);
                return;
        }

        if (stok <= 0) {
            System.out.println("[GAGAL] Stok " + jenis + " habis.");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("[GAGAL] Saldo tidak cukup.");
            System.out.println("        Harga  : Rp" + harga);
            System.out.println("        Saldo  : Rp" + saldoMasuk);
            return;
        }

        double kembalian = saldoMasuk - harga;

        switch (jenis.toLowerCase()) {
            case "teh":  stokTeh--;  break;
            case "kopi": stokKopi--; break;
            case "susu": stokSusu--; break;
        }

        saldoMasuk      = 0;
        totalPenjualan += harga;

        System.out.println("[BERHASIL] " + jenis + " dibeli seharga Rp" + harga);
        if (kembalian > 0) {
            System.out.println("[INFO] Kembalian: Rp" + kembalian);
        } else {
            System.out.println("[INFO] Tidak ada kembalian.");
        }
    }

    public void batalkanTransaksi() {
        if (saldoMasuk <= 0) {
            System.out.println("[INFO] Tidak ada transaksi aktif.");
            return;
        }
        System.out.println("[INFO] Transaksi dibatalkan. Uang kembali: Rp" + saldoMasuk);
        saldoMasuk = 0;
    }

    public void tampilkanStatus() {
        System.out.println("========================================");
        System.out.println("         STATUS VENDING MACHINE         ");
        System.out.println("========================================");
        System.out.println("Kode Mesin     : " + kodeMesin);
        System.out.println("Saldo Masuk    : Rp" + saldoMasuk);
        System.out.println("----------------------------------------");
        System.out.println("Stok Teh       : " + stokTeh  + " | Harga: Rp" + hargaTeh);
        System.out.println("Stok Kopi      : " + stokKopi + " | Harga: Rp" + hargaKopi);
        System.out.println("Stok Susu      : " + stokSusu + " | Harga: Rp" + hargaSusu);
        System.out.println("----------------------------------------");
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("========================================");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data mesin
        System.out.print("Masukkan Kode Mesin : ");
        String kodeMesin = sc.nextLine();

        System.out.print("Stok Teh            : ");
        int stokTeh = sc.nextInt();

        System.out.print("Stok Kopi           : ");
        int stokKopi = sc.nextInt();

        System.out.print("Stok Susu           : ");
        int stokSusu = sc.nextInt();

        System.out.print("Harga Teh           : ");
        double hargaTeh = sc.nextDouble();

        System.out.print("Harga Kopi          : ");
        double hargaKopi = sc.nextDouble();

        System.out.print("Harga Susu          : ");
        double hargaSusu = sc.nextDouble();
        sc.nextLine(); // flush

        VendingMachine mesin = new VendingMachine(
                kodeMesin, stokTeh, stokKopi, stokSusu,
                hargaTeh, hargaKopi, hargaSusu
        );

        // Menu utama
        int pilihan = 0;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Masukkan Uang");
            System.out.println("2. Pilih Minuman");
            System.out.println("3. Batalkan Transaksi");
            System.out.println("4. Tampilkan Status");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // flush

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah uang: Rp");
                    double jumlah = sc.nextDouble();
                    sc.nextLine();
                    mesin.masukkanUang(jumlah);
                    break;

                case 2:
                    System.out.println("Pilihan minuman: teh / kopi / susu");
                    System.out.print("Pilih minuman   : ");
                    String jenis = sc.nextLine();
                    mesin.pilihMinuman(jenis);
                    break;

                case 3:
                    mesin.batalkanTransaksi();
                    break;

                case 4:
                    mesin.tampilkanStatus();
                    break;

                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("[ERROR] Pilihan tidak valid.");
            }

        } while (pilihan != 5);

        sc.close();
    }
}