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

    // Constructor
    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu,
                          double hargaTeh, double hargaKopi, double hargaSusu) {
        this.kodeMesin = kodeMesin;
        this.stokTeh = stokTeh;
        this.stokKopi = stokKopi;
        this.stokSusu = stokSusu;
        this.hargaTeh = hargaTeh;
        this.hargaKopi = hargaKopi;
        this.hargaSusu = hargaSusu;
        this.saldoMasuk = 0;
        this.totalPenjualan = 0;
    }

    // Method masukkan uang
    public void masukkanUang(double jumlah) {
        if (jumlah > 0) {
            saldoMasuk += jumlah;
            System.out.println("Uang masuk: Rp" + jumlah + " | Saldo sekarang: Rp" + saldoMasuk);
        } else {
            System.out.println("Jumlah uang tidak valid.");
        }
    }

    // Method pilih minuman
    public void pilihMinuman(String jenis) {
        double harga = 0;
        int stok = 0;

        switch (jenis.toLowerCase()) {
            case "teh":
                harga = hargaTeh;
                stok = stokTeh;
                break;
            case "kopi":
                harga = hargaKopi;
                stok = stokKopi;
                break;
            case "susu":
                harga = hargaSusu;
                stok = stokSusu;
                break;
            default:
                System.out.println("Minuman tidak tersedia.");
                return;
        }

        if (saldoMasuk <= 0) {
            System.out.println("Silakan masukkan uang terlebih dahulu.");
            return;
        }

        if (stok <= 0) {
            System.out.println("Stok " + jenis + " habis. Transaksi gagal.");
            kembalikanUang();
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Uang tidak cukup. Kembalian: Rp" + saldoMasuk);
            saldoMasuk = 0;
            return;
        }

        // Transaksi berhasil
        saldoMasuk -= harga;
        totalPenjualan += harga;
        switch (jenis.toLowerCase()) {
            case "teh":
                stokTeh--;
                break;
            case "kopi":
                stokKopi--;
                break;
            case "susu":
                stokSusu--;
                break;
        }

        System.out.println("Berhasil membeli " + jenis + ". Kembalian: Rp" + saldoMasuk);
        saldoMasuk = 0; // uang kembalian diambil user
    }

    // Method batalkan transaksi
    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan. Uang dikembalikan: Rp" + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi yang dapat dibatalkan.");
        }
    }

    // Method kembalikan uang (digunakan internal)
    private void kembalikanUang() {
        if (saldoMasuk > 0) {
            System.out.println("Uang dikembalikan: Rp" + saldoMasuk);
            saldoMasuk = 0;
        }
    }

    // Method tampilkan status mesin
    public void tampilkanStatus() {
        System.out.println("\n=== Status Mesin " + kodeMesin + " ===");
        System.out.println("Stok Teh: " + stokTeh + " (Rp" + hargaTeh + ")");
        System.out.println("Stok Kopi: " + stokKopi + " (Rp" + hargaKopi + ")");
        System.out.println("Stok Susu: " + stokSusu + " (Rp" + hargaSusu + ")");
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("Saldo Masuk Saat Ini: Rp" + saldoMasuk);
    }
}
