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

    //Contructor
    public VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu, double hargaTeh, double hargaKopi, double hargaSusu) {

        this.kodeMesin = kodeMesin;
        this.stokTeh = stokTeh;
        this.stokKopi = stokKopi;
        this.stokSusu = stokSusu;

        this.hargaTeh = hargaTeh;
        this.hargaKopi = hargaKopi;
        this.hargaSusu = hargaSusu;

        this.saldoMasuk = 0;  //(uang yang dimasukkan user)
        this.totalPenjualan = 0;
}
    //Method
    public void masukkanUang(double uang) {
        if (uang > 0) {
            saldoMasuk += uang;
            System.out.println("Uang Masuk: " + uang);
            System.out.println("Saldo Saat Ini: " + saldoMasuk);
        }else{
            System.out.println("Uang Masuk Tidak Valid");
        }
    }

    public void pilihMinuman(String JenisMinuman){
        double harga = 0;
        boolean stokNyaAdaGak = false;

        if (JenisMinuman.equalsIgnoreCase("Teh")) {
            harga = hargaTeh;
            stokNyaAdaGak = stokTeh > 0;
        } else if (JenisMinuman.equalsIgnoreCase("Kopi")) {
            harga = hargaKopi;
            stokNyaAdaGak = stokKopi > 0;
        } else if (JenisMinuman.equalsIgnoreCase("Susu")) {
            harga = hargaSusu;
            stokNyaAdaGak = stokSusu > 0;
        }else{
            System.out.println("Minuman Tidak Tersedia");
        }

        if (!stokNyaAdaGak) {
            System.out.println("Stok minuman habis");
            return;
        }

        if (saldoMasuk < harga) {
            System.out.println("Uang tidak cukup");
            return;
        }

        // transaksi berhasil
        if (JenisMinuman.equalsIgnoreCase("teh")) {
            stokTeh--;
        } else if (JenisMinuman.equalsIgnoreCase("kopi")) {
            stokKopi--;
        } else if (JenisMinuman.equalsIgnoreCase("susu")) {
            stokSusu--;
        }

        totalPenjualan += harga;

        double kembalian = saldoMasuk - harga;
        saldoMasuk = 0;

        System.out.println("Berhasil membeli " + JenisMinuman);
        System.out.println("Kembalian: " + kembalian);
    }

    public void batalkanTransaksi() {
        if (saldoMasuk > 0) {
            System.out.println("Transaksi dibatalkan");
            System.out.println("Uang dikembalikan: " + saldoMasuk);
            saldoMasuk = 0;
        } else {
            System.out.println("Tidak ada transaksi");
        }
    }

    // Method menampilkan status mesin
    public void tampilkanStatus() {
        System.out.println("\nStatus Mesin: " + kodeMesin);
        System.out.println("Stok Teh  : " + stokTeh);
        System.out.println("Stok Kopi : " + stokKopi);
        System.out.println("Stok Susu : " + stokSusu);
        System.out.println("Total Penjualan : " + totalPenjualan);
        System.out.println("Saldo Masuk : " + saldoMasuk);
    }


}

public class Main{

    public static void main(String[] args) throws Exception {

    /*Simulasikan di kelas main:
	Masukkan uang
	Pilih minuman
	Coba beli saat stok habis
	Coba beli dengan uang kurang
	Batalkan transaksi*/


        VendingMachine mesin = new VendingMachine("VM001", 10, 5, 1, 5000, 6000, 7000);
    
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("Susu");

        mesin.tampilkanStatus();

        // Beli Dengan Uang Kurang
        mesin.masukkanUang(2000);
        mesin.pilihMinuman("Kopi");
        mesin.tampilkanStatus();

        //Beli Saat Stok Habis
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("Susu");
        mesin.tampilkanStatus();

        //Batalkan Transaksi
        mesin.masukkanUang(5000);
        mesin.batalkanTransaksi();
        
    }
}
