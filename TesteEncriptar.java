// Eliezer, Gabriel

public class TesteEncriptar {

    private Cifra cifra;

    public TesteEncriptar() {
        cifra = new Cifra(2);
    }

    // teste para encriptar
    public String deveEncriptar() {

        // chama a execução que irá desencadear a camanhada do lerTexto() e lerOpcao()
        cifra.executar();

        // retorna a mensagem encriptada e o tamanho dela se o retorna for igual ao
        // esperada no teste
        return cifra.getTexto().equals(
                "vgzvqydtydqpkvqydtyrctcydtyvguvgyrvyyfryyrxyyjhyydtyugtcydtyswgydtyhwpekqpcykpy")
                        ? "Encripar passou\n Tamanho da mensagem encriptada: " + cifra.getTexto().length()
                        : "Encripar não passou";
    }
}
