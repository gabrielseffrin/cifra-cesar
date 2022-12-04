// Eliezer, Gabriel

public class TesteDecriptar {

    private Cifra cifra;

    public TesteDecriptar() {
        cifra = new Cifra(2);
    }

    // teste para decriptar
    public String deveDecriptar() {

        cifra.executar();
        return cifra.getTexto().equals("texto bonito para teste.:;- sera que funciona?\r\n")
                ? "Decriptar passou"
                : "Decriptar não passou";
    }
}
