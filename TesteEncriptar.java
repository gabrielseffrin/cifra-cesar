public class TesteEncriptar {

    private Cifra cifra;

    public TesteEncriptar() {
        cifra = new Cifra(2);
    }

    public String deveEncriptar() {

        cifra.executar(0);
        return cifra.getTexto().equals(
                "vgzvqydtydqpkvqydtyrctcydtyvguvgyrvyyfryyrxyyjhyydtyugtcydtyswgydtyhwpekqpcykpyyjhyydtyhwpekqpcydtyukoygzyss")
                        ? "passou"
                        : "não passou";
    }
}
