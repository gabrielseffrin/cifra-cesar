import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Cifra
 */
public class Cifra {

    // cifra para decriptar e encriptar
    private int cifra;

    private final String[] CARACTERES_PARA_SUBSTITUIR = { "wbrw", "wvrw", "wptw", "wpvw", "wdpw", "wexw", "winw",
            "whfw" };
    private final String[] CARACTERES_SER_SUBSTITUIDO = { " ", ",", ".", ";", ":", "!", "?", "-" };

    private File arquivo;
    private final String NOME_ARQUIVO = "text.txt";

    // construtor para criar o arquivo.txt e atribuir a cifra
    public Cifra(int cifra) {
        this.cifra = cifra;
        arquivo = new File(arquivo, NOME_ARQUIVO);
    }

    // unica entrada: do usuário fora o arquivo.txt
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

    // método para substituir os caracteres
    private String substituicaoCaracteres(String string, String substituir, String substituido) {

        ListCaracters listCaracters = new ListCaracters();

        return string.replaceAll(substituir, substituido);
    }

    private void encriptar() {

        try {
            // cria a variável para receber o que for lido
            String readString = "aa";

            // cria um leitor do arquivo
            FileReader reader = new FileReader(arquivo);

            // buffer para agilizar a leitura
            BufferedReader bReader = new BufferedReader(reader);
            readString = bReader.readLine();

            for (int i = 0; i <= CARACTERES_PARA_SUBSTITUIR.length; i++) {
                if (readString.contains(CARACTERES_SER_SUBSTITUIDO[i])) {
                    readString = substituicaoCaracteres(readString, CARACTERES_SER_SUBSTITUIDO[i],
                            CARACTERES_PARA_SUBSTITUIR[i]);
                    System.out.println(readString);

                }
                System.out.println(readString);

            }

            // fecha o buffer rader
            bReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void decriptar() {

    }

}