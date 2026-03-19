public class VendingMachine {
    private String kodeMesin;
    private double saldoMasuk;
    private int stokTeh;
    private int stokKopi;
    private int stokSusu;
    private double hargaTeh;
    private double hargaKopi;
    private double hargaSusu;
    private double totalPenjualan;

    public VendingMachine(String kodeMesin,
                          int stokTeh, int stokKopi, int stokSusu,
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
            System.out.println("[ERROR] Jumlah uang tidak valid. Harap masukkan nominal positif.");
            return;
        }
        
        saldoMasuk += jumlah;
        System.out.println("[INFO] Uang masuk  : Rp" + jumlah);
        System.out.println("[INFO] Total saldo : Rp" + saldoMasuk);
    }

    public void pilihMinuman(String jenis) {
        if (saldoMasuk <= 0) {
            System.out.println("[GAGAL] Silakan masukkan uang terlebih dahulu!");
            return;
        }

        double harga = 0;
        int    stok  = 0;

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
                System.out.println("[ERROR] Minuman '" + jenis + "' tidak tersedia.");
                System.out.println("        Pilihan: teh / kopi / susu");
                return;
        }

        if (stok <= 0) {
            System.out.println("[GAGAL] Stok " + jenis + " habis! Transaksi dibatalkan.");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("[GAGAL] Uang kurang! Harga " + jenis + " = Rp" + harga
                    + ", saldo Anda = Rp" + saldoMasuk);
            return;
        }

        double kembalian = saldoMasuk - harga;

        switch (jenis.toLowerCase()) {
            case "teh":  stokTeh--;  break;
            case "kopi": stokKopi--; break;
            case "susu": stokSusu--; break;
        }

        totalPenjualan += harga;
        saldoMasuk      = 0;  

        System.out.println("------------------------------------------");
        System.out.println("[SUKSES] " + jenis.toUpperCase() + " berhasil dibeli!");
        System.out.println("         Harga     : Rp" + harga);
        System.out.println("         Kembalian : Rp" + kembalian);  // Aturan 5
        System.out.println("------------------------------------------");
    }

    public void batalkanTransaksi() {
        if (saldoMasuk <= 0) {
            System.out.println("[INFO] Tidak ada transaksi aktif untuk dibatalkan.");
            return;
        }
        System.out.println("[INFO] Transaksi dibatalkan.");
        System.out.println("[INFO] Uang Anda dikembalikan: Rp" + saldoMasuk);
        saldoMasuk = 0;
    }

    public void tampilkanStatus() {
        System.out.println("==========================================");
        System.out.println("   STATUS VENDING MACHINE [" + kodeMesin + "]");
        System.out.println("==========================================");
        System.out.println(" Saldo masuk      : Rp" + saldoMasuk);
        System.out.println("------------------------------------------");
        System.out.println(" Minuman   | Harga     | Stok");
        System.out.println("------------------------------------------");
        System.out.printf(" %-9s | Rp%-7.0f | %d%n", "Teh",  hargaTeh,  stokTeh);
        System.out.printf(" %-9s | Rp%-7.0f | %d%n", "Kopi", hargaKopi, stokKopi);
        System.out.printf(" %-9s | Rp%-7.0f | %d%n", "Susu", hargaSusu, stokSusu);
        System.out.println("------------------------------------------");
        System.out.println(" Total penjualan  : Rp" + totalPenjualan);
        System.out.println("==========================================");
    }
}