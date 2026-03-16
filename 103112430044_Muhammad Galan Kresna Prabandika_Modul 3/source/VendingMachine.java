public class VendingMachine {
    private String kodeMesin;
    private int saldoMasuk;
    private int stokTeh;
    private int stokKopi;
    private int stokSusu;
    private int hargaTeh;
    private int hargaKopi;
    private int hargaSusu;
    private int totalPenjualan;

    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu, 
        int hargaTeh, int hargaKopi, int hargaSusu) {
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

    public void masukkanUang(int uang) {
        if (uang > 0) {
            saldoMasuk += uang;
            System.out.println("Uang masuk: Rp" + uang + " | Saldo: Rp" + saldoMasuk);
        } else {
            System.out.println("Nominal tidak valid.");
        }
    }

    public void pilihMinuman(String jenis) {
        if (saldoMasuk <= 0) {
            System.out.println("Gagal: Masukkan uang dulu.");
            return;
        }

        int harga = 0, stok = 0;

        if (jenis.equalsIgnoreCase("Teh")) {
            harga = hargaTeh; stok = stokTeh;
        } else if (jenis.equalsIgnoreCase("Kopi")) {
            harga = hargaKopi; stok = stokKopi;
        } else if (jenis.equalsIgnoreCase("Susu")) {
            harga = hargaSusu; stok = stokSusu;
        } else {
            System.out.println("Gagal: Minuman tidak tersedia.");
            return;
        }

        if (stok <= 0) {
            System.out.println("Gagal: Stok " + jenis + " habis.");
        } else if (saldoMasuk < harga) {
            System.out.println("Gagal: Saldo kurang. Harga " + jenis + " Rp" + harga);
        } else {
            System.out.println("Berhasil: Silakan ambil " + jenis + ".");
            saldoMasuk -= harga;
            totalPenjualan += harga;
            
            if (jenis.equalsIgnoreCase("Teh")) stokTeh--;
            else if (jenis.equalsIgnoreCase("Kopi")) stokKopi--;
            else if (jenis.equalsIgnoreCase("Susu")) stokSusu--;
            
            kembalikanUang("kembalian");
        }
    }

    public void batalTransaksi() {
        kembalikanUang("batal");
    }

    private void kembalikanUang(String tipe) {
        if (saldoMasuk > 0) {
            if (tipe.equals("batal")) System.out.println("Uang kembali: Rp" + saldoMasuk);
            else System.out.println("Kembalian: Rp" + saldoMasuk);
            saldoMasuk = 0;
        } else if (tipe.equals("batal")) {
            System.out.println("Tidak ada uang untuk dikembalikan.");
        }
    }

    public void cekStatusMesin() {
        System.out.println("Status Mesin " + kodeMesin);
        System.out.println("Stok: Teh: " + stokTeh + " | Kopi: " + stokKopi + " | Susu: " + stokSusu);
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
    }
}