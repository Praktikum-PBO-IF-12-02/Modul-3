/**
 *
 * @author wahyuuuwid
 */

public class Main {
    public static void main(String[] args) {
        VendingMachine mesin = new VendingMachine("mesin01", 1, 1, 1, 5000, 7000, 6000);

        mesin.masukkanUang(10000);
        mesin.pilihMinuman("teh");
        mesin.masukkanUang(10000);
        mesin.pilihMinuman("teh");
        mesin.masukkanUang(3000);
        mesin.pilihMinuman("kopi");
        mesin.masukkanUang(5000);
        mesin.batalkanTransaksi();
        mesin.tampilkanStatus();
    }
}