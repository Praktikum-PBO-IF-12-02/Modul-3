public class Main {
    public static void main(String[] args) {
        VendingMachine mesin = new VendingMachine("TEL-U-01", 10, 0, 5, 5000, 7000, 8000);

        System.out.println("MESIN PENJUAL MINUMAN OTOMATIS");
        mesin.tampilkanStatus();

        System.out.println("--- 1. Beli Teh (Transaksi Berhasil) ---");
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("Teh");

        System.out.println("\n--- 2. Beli Kopi (Stok Habis) ---");
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("Kopi");
        mesin.batalkanTransaksi();

        System.out.println("\n--- 3. Beli Susu (Uang Kurang) ---");
        mesin.masukkanUang(5000);
        mesin.pilihMinuman("Susu");
        mesin.batalkanTransaksi();

        System.out.println("\n--- 4. Batal Beli ---");
        mesin.masukkanUang(20000);
        mesin.batalkanTransaksi();

        System.out.println("\n--- Status Akhir Mesin ---");
        mesin.tampilkanStatus();
    }
}