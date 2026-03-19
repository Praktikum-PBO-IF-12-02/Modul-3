public class Main {
    public static void main(String[] args) {

        VendingMachine vm = new VendingMachine(
                "VM01", 
                1, 1, 1,   
                5000, 7000, 6000 
        );

        vm.masukkanUang(10000);
        vm.pilihMinuman("teh");

        vm.masukkanUang(10000);
        vm.pilihMinuman("teh");

        vm.masukkanUang(2000);
        vm.pilihMinuman("kopi");

        vm.masukkanUang(5000);
        vm.batalkanTransaksi();

        vm.tampilkanStatus();
    }
}