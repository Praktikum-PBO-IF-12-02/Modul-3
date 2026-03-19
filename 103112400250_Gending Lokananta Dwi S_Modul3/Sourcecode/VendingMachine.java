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

    // Masukkan uang
    public void masukkanUang(double jumlah) {
        if (jumlah > 0) {
            saldoMasuk += jumlah;
            System.out.println("Uang masuk: Rp" + jumlah);
            System.out.println("Saldo sekarang: Rp" + saldoMasuk);
        } else {
            System.out.println("Jumlah tidak valid!");
        }
    }

    // Pilih minuman
    public void pilihMinuman(String jenis) {
        double harga = 0;

        System.out.println("\nAnda memilih: " + jenis);
        System.out.println("Saldo anda: Rp" + saldoMasuk);

        switch (jenis.toLowerCase()) {
            case "teh":
                if (stokTeh <= 0) {
                    System.out.println("Stok teh habis!");
                    return;
                }
                harga = hargaTeh;
                break;

            case "kopi":
                if (stokKopi <= 0) {
                    System.out.println("Stok kopi habis!");
                    return;
                }
                harga = hargaKopi;
                break;

            case "susu":
                if (stokSusu <= 0) {
                    System.out.println("Stok susu habis!");
                    return;
                }
                harga = hargaSusu;
                break;

            default:
                System.out.println("Minuman tidak tersedia!");
                return;
        }

        System.out.println("Harga minuman: Rp" + harga);

        if (saldoMasuk < harga) {
            System.out.println("Uang kurang!");
            return;
        }

        // transaksi berhasil
        saldoMasuk -= harga;
        totalPenjualan += harga;

        if (jenis.equalsIgnoreCase("teh")) stokTeh--;
        if (jenis.equalsIgnoreCase("kopi")) stokKopi--;
        if (jenis.equalsIgnoreCase("susu")) stokSusu--;

        System.out.println("Berhasil membeli " + jenis);

        System.out.println("Sisa saldo: Rp" + saldoMasuk);
    }

    // Batalkan transaksi
    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan.");
            System.out.println("Uang kembali: Rp" + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi.");
        }
    }

    // Tampilkan status
    public void tampilkanStatus() {
        System.out.println("\n=== STATUS MESIN ===");
        System.out.println("Kode Mesin: " + kodeMesin);

        System.out.println("\n--- DAFTAR MINUMAN ---");
        System.out.println("Teh  | Harga: Rp" + hargaTeh + " | Stok: " + stokTeh);
        System.out.println("Kopi | Harga: Rp" + hargaKopi + " | Stok: " + stokKopi);
        System.out.println("Susu | Harga: Rp" + hargaSusu + " | Stok: " + stokSusu);

        System.out.println("\nSaldo Anda: Rp" + saldoMasuk);
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("====================\n");
    }
}