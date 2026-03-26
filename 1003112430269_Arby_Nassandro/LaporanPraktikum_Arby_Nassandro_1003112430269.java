import java.util.Scanner;

class VendingMachine {
  private int stokTeh;
  private int stokKopi;
  private int stokSusu;
  private double hargaTeh;
  private double hargaKopi;
  private double hargaSusu;
  private double saldoMasuk;
  private int totalPenjualan;
  private String kodeMesin;

  VendingMachine(String kodeMesin, int stokTeh, int stokKopi, int stokSusu, double hargaTeh, double hargaKopi, double hargaSusu) {
    this.kodeMesin = kodeMesin;
    this.stokTeh = stokTeh;
    this.stokKopi = stokKopi;
    this.stokSusu = stokSusu;
    this.hargaTeh = hargaTeh;
    this.hargaKopi = hargaKopi;
    this.hargaSusu = hargaSusu;
  }


  public double getSaldoMasuk() {
    return saldoMasuk;
  }


  public void masukkanUang(double jumlah) {
    if (jumlah > 0) {
      saldoMasuk += jumlah;
        System.out.println("Uang masuk: " + jumlah);
    } else {
        System.out.println("Uang harus lebih dari 0");
    }
  }

  public void pilihMinuman(String jenis) {
    if (jenis.equals("teh")){
      if (stokTeh <= 0) {
        System.out.println("Stok Teh kosong");
      } else if (saldoMasuk < hargaTeh) {
        System.out.println("Saldo tidak cukup");
      } else {
        double kembalian = saldoMasuk - hargaTeh;
        stokTeh--;
        totalPenjualan++;
        saldoMasuk = 0;

        System.out.println("Berhasil membeli Teh");
        if (kembalian > 0) {
          System.out.println("Kembalian: " + kembalian);
        }
      }

    } else if (jenis.equals("kopi")){
      if (stokKopi <= 0) {
        System.out.println("Stok Kopi kosong");
      } else if (saldoMasuk < hargaKopi) {
        System.out.println("Saldo tidak cukup");
      } else {
        double kembalian = saldoMasuk - hargaKopi;
        stokKopi--;
        totalPenjualan++;
        saldoMasuk = 0;

        System.out.println("Berhasil membeli Kopi");
        if (kembalian > 0) {
          System.out.println("Kembalian: " + kembalian);
        }
      }

    } else if (jenis.equals("susu")){
      if (stokSusu <= 0) {
        System.out.println("Stok Susu kosong");
      } else if (saldoMasuk < hargaSusu) {
        System.out.println("Saldo tidak cukup");
      } else {
        double kembalian = saldoMasuk - hargaSusu;
        stokSusu--;
        totalPenjualan++;
        saldoMasuk = 0;

        System.out.println("Berhasil membeli Susu");
        if (kembalian > 0) {
          System.out.println("Kembalian: " + kembalian);
        }
      }

    } else {
      System.out.println("Pilihan tidak valid");
    }
  }

  public void batalkanTransaksi() {
    if (saldoMasuk > 0) {
      System.out.println("Transaksi dibatalkan");
      System.out.println("Uang dikembalikan: " + saldoMasuk);
      saldoMasuk = 0;
    } else {
      System.out.println("Tidak ada saldo");
    }
  }

  public void tampilkanStatus() {
    System.out.println("\n===== STATUS MESIN =====");
    System.out.println("Kode Mesin     : " + kodeMesin);
    System.out.println("Saldo Masuk    : " + saldoMasuk);
    System.out.println("Stok Teh       : " + stokTeh);
    System.out.println("Stok Kopi      : " + stokKopi);
    System.out.println("Stok Susu      : " + stokSusu);
    System.out.println("Total Penjualan: " + totalPenjualan);
  }
}

public class LaporanPraktikum_Arby_Nassandro_1003112430269 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    VendingMachine vm = new VendingMachine("1003112430269", 0, 0, 12, 3000, 8000, 13000);

    while (true) {
      System.out.println("\n===== MENU =====");
      System.out.println("1. Masukkan Uang");
      System.out.println("2. Beli Minuman");
      System.out.println("3. Batalkan Transaksi");
      System.out.println("4. Tampilkan Status");
      System.out.println("5. Keluar");
      System.out.print("Pilih: ");

      int pilih = input.nextInt();
      input.nextLine();

      if (pilih == 1) {
        System.out.print("Masukkan uang: ");
        double uang = input.nextDouble();
        input.nextLine();
        vm.masukkanUang(uang);

      } else if (pilih == 2) {
        if (vm.getSaldoMasuk() == 0) {
          System.out.println("Silakan masukkan uang terlebih dahulu");
        } else {
          System.out.println("\n=== PILIH MINUMAN ===");
          System.out.println("1. Teh");
          System.out.println("2. Kopi");
          System.out.println("3. Susu");
          System.out.print("Pilih minuman: ");
          
          int pilihMinuman = input.nextInt();
          input.nextLine();

          if (pilihMinuman == 1) {
            vm.pilihMinuman("teh");
          } else if (pilihMinuman == 2) {
            vm.pilihMinuman("kopi");
          } else if (pilihMinuman == 3) {
            vm.pilihMinuman("susu");
          } else {
            System.out.println("Pilihan minuman tidak valid");
          }
        }
      } else if (pilih == 3) {
        vm.batalkanTransaksi();

      } else if (pilih == 4) {
        vm.tampilkanStatus();

      } else if (pilih == 5) {
        System.out.println("Terima kasih");
        break;

      } else {
        System.out.println("Menu tidak valid");
      }
    }
    input.close();
  }
}
