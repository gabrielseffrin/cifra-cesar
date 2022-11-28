/**
 * Cifra
 */
public class Cifra {

    public void executar(int opcao) {

        switch (opcao) {
            case 0:
                encriptar();
                break;
            case 1:
                decriptar();
                break;
            default:
                break;
        }
    }

    private String replace(String string, String substituir, String substituido) {
        return string.replaceAll(substituir, substituido);
    }

    private void encriptar() {

    }

    private void decriptar() {

    }

}