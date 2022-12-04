public class Main {

    public static void main(String[] args) {

        TesteDecriptar testeCifra = new TesteDecriptar();
        TesteEncriptar encriptar = new TesteEncriptar();

        System.out.println(encriptar.deveEncriptar());
        System.out.println(testeCifra.deveDecriptar());

        // System.out.println(testeCifra.teste());
    }
}
