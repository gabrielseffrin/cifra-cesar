// Eliezer, Gabriel

public class TesteDecriptar {

    private Cifra cifra;

    public TesteDecriptar() {
        cifra = new Cifra(2);
    }

    // teste para decriptar
    public String deveDecriptar() {

        // chama a execução que irá desencadear a camanhada do lerTexto() e lerOpcao()
        cifra.executar();

        // retorna a mensagem decriptada e o tamanho dela se o retorna for igual ao
        // esperada no teste
        return cifra.getTexto().equals("texto bonito para teste.:;- sera que funciona?\r\n")
                ? "Decriptar passou\n Tamanho da mensagem decripatada: " + cifra.getTexto().length()
                : "Decriptar não passou";
    }
}
