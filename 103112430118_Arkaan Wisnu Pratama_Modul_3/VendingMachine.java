package Modul3;

public class VendingMachine {

    // ── Atribut private ──────────────────────────────────────────────
    private String kodeMesin;
    private double saldoMasuk;

    private int    stokTeh;
    private int    stokKopi;
    private int    stokSusu;

    private double hargaTeh;
    private double hargaKopi;
    private double hargaSusu;

    private double totalPenjualan;

    // ── Constructor ──────────────────────────────────────────────────
    public VendingMachine(String kodeMesin,
                          int stokTeh,   double hargaTeh,
                          int stokKopi,  double hargaKopi,
                          int stokSusu,  double hargaSusu) {
        this.kodeMesin     = kodeMesin;
        this.stokTeh       = stokTeh;
        this.hargaTeh      = hargaTeh;
        this.stokKopi      = stokKopi;
        this.hargaKopi     = hargaKopi;
        this.stokSusu      = stokSusu;
        this.hargaSusu     = hargaSusu;
        this.saldoMasuk    = 0;
        this.totalPenjualan = 0;
    }

    // ── Method: masukkanUang ─────────────────────────────────────────
    public void masukkanUang(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("[ERROR] Jumlah uang tidak valid.");
            return;
        }
        saldoMasuk += jumlah;
        System.out.printf("[INFO] Uang diterima: Rp %.0f | Saldo saat ini: Rp %.0f%n",
                          jumlah, saldoMasuk);
    }

    // ── Method: pilihMinuman ─────────────────────────────────────────
    public void pilihMinuman(String jenis) {
        // 1. Pastikan ada saldo dulu
        if (saldoMasuk <= 0) {
            System.out.println("[GAGAL] Masukkan uang terlebih dahulu.");
            return;
        }

        double harga;
        int    stok;

        // 2. Tentukan harga & stok berdasarkan jenis
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
                System.out.println("[GAGAL] Minuman '" + jenis + "' tidak tersedia.");
                return;
        }

        // 3. Cek stok
        if (stok <= 0) {
            System.out.println("[GAGAL] Maaf, stok " + jenis + " habis.");
            return;
        }

        // 4. Cek kecukupan saldo
        if (saldoMasuk < harga) {
            System.out.printf("[GAGAL] Saldo kurang. Harga %s: Rp %.0f | Saldo: Rp %.0f%n",
                              jenis, harga, saldoMasuk);
            return;
        }

        // 5. Transaksi berhasil — kurangi stok, hitung kembalian
        double kembalian = saldoMasuk - harga;
        totalPenjualan  += harga;
        saldoMasuk       = 0;   // reset saldo

        switch (jenis.toLowerCase()) {
            case "teh":  stokTeh--;  break;
            case "kopi": stokKopi--; break;
            case "susu": stokSusu--; break;
        }

        System.out.printf("[BERHASIL] %s keluar! Kembalian: Rp %.0f%n",
                          jenis.toUpperCase(), kembalian);
    }

    // ── Method: batalkanTransaksi ────────────────────────────────────
    public void batalkanTransaksi() {
        if (saldoMasuk <= 0) {
            System.out.println("[INFO] Tidak ada saldo untuk dikembalikan.");
            return;
        }
        System.out.printf("[BATAL] Transaksi dibatalkan. Uang kembali: Rp %.0f%n", saldoMasuk);
        saldoMasuk = 0;
    }

    // ── Method: tampilkanStatus ──────────────────────────────────────
    public void tampilkanStatus() {
        System.out.println("\n==============================");
        System.out.println(" STATUS MESIN : " + kodeMesin);
        System.out.println("==============================");
        System.out.printf(" Teh   | Stok: %2d | Harga: Rp %.0f%n", stokTeh,  hargaTeh);
        System.out.printf(" Kopi  | Stok: %2d | Harga: Rp %.0f%n", stokKopi, hargaKopi);
        System.out.printf(" Susu  | Stok: %2d | Harga: Rp %.0f%n", stokSusu, hargaSusu);
        System.out.println("------------------------------");
        System.out.printf(" Saldo masuk    : Rp %.0f%n", saldoMasuk);
        System.out.printf(" Total penjualan: Rp %.0f%n", totalPenjualan);
        System.out.println("==============================\n");
    }
}