public class TesteDecriptar {

    private Cifra cifra;

    public TesteDecriptar() {
        cifra = new Cifra(2);
    }

    public String deveDecriptar() {

        cifra.executar(1);
        return cifra.getTexto().equals("texto bonito para teste.:;- sera que funciona?\r\n- funciona sim!\r\n")
                ? "passou"
                : "não passou";
    }
}
