// Eliezer, Gabriel

public class TesteEncriptar {

    private Cifra cifra;

    public TesteEncriptar() {
        cifra = new Cifra(2);
    }

    // teste para encriptar
    public String deveEncriptar() {

        cifra.executar();
        return cifra.getTexto().equals(
                "vgzvqydtydqpkvqydtyrctcydtyvguvgyrvyyfryyrxyyjhyydtyugtcydtyswgydtyhwpekqpcykpy")
                        ? "Encripar passou"
                        : "Encripar não passou";
    }
}
