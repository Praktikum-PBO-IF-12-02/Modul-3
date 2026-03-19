public class Main {
    public static void main(String[] args) {
        // Membuat objek VendingMachine
        VendingMachine vm = new VendingMachine("VM01", 2, 1, 0, 5000, 7000, 8000);

        // Tampilkan status awal
        vm.tampilkanStatus();

        // Skenario 1: Masukkan uang dan beli kopi
        System.out.println("\n--- Skenario 1: Beli Kopi ---");
        vm.masukkanUang(10000);
        vm.pilihMinuman("kopi");
        vm.tampilkanStatus();

        // Skenario 2: Coba beli saat stok habis (susu)
        System.out.println("\n--- Skenario 2: Beli Susu (Stok Habis) ---");
        vm.masukkanUang(10000);
        vm.pilihMinuman("susu");
        vm.tampilkanStatus();

        // Skenario 3: Coba beli dengan uang kurang
        System.out.println("\n--- Skenario 3: Beli Teh (Uang Kurang) ---");
        vm.masukkanUang(3000);
        vm.pilihMinuman("teh");
        vm.tampilkanStatus();

        // Skenario 4: Batalkan transaksi
        System.out.println("\n--- Skenario 4: Batalkan Transaksi ---");
        vm.masukkanUang(10000);
        vm.batalkanTransaksi();
        vm.tampilkanStatus();

        // Skenario 5: Coba beli tanpa uang
        System.out.println("\n--- Skenario 5: Beli Tanpa Uang ---");
        vm.pilihMinuman("teh");
    }
}