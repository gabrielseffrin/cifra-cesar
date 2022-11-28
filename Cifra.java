import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;

/**
 * Cifra
 */
public class Cifra {

    // cifra para decriptar e encriptar
    private int cifra;

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
    private ListCaracters substituicaoCaracteres(String string, String substituir, String substituido) {

        ListCaracters listCaracters = new ListCaracters();

        try {
            // cria um leitor do arquivo
            FileReader reader = new FileReader(arquivo);
            // buffer para agilizar a leitura
            BufferedReader bReader = new BufferedReader(reader);
            System.out.println(bReader.readLine());

            // fecha o buffer rader
            bReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    private void encriptar() {
        substituicaoCaracteres(null, null, null);
    }

    private void decriptar() {

    }

}