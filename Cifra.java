// Eliezer, Gabriel

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Cifra
 */
public class Cifra {

    // cifra para decriptar e encriptar
    private int cifra;

    // lista para armazenar dinâmicamente os caracteres
    private ListCaracters listCaracters;

    private final String[] CARACTERES_PARA_SUBSTITUIR = { "wbrw", "wvrw", "wptw", "wpvw", "wdpw", "wexw", "winw",
            "whfw" };
    private final String[] CARACTERES_SER_SUBSTITUIDO = { " ", ",", ".", ";", ":", "!", "?", "-" };

    private File arquivo;
    private final String NOME_ARQUIVO = "text.txt";

    // construtor para criar o arquivo.txt e atribuir a cifra
    public Cifra(int cifra) {
        this.cifra = cifra;
        arquivo = new File(arquivo, NOME_ARQUIVO);
        listCaracters = new ListCaracters();
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
    private void substituicaoCaracteresEncriptar() {

        ListCaracters localLista = new ListCaracters();

        // percorre o array de caracters
        for (Character character : listCaracters.printList()) {
            // cria uma varável local do character fazendo conversão para string, assim
            // podendo usar .equals()
            String stringCharacter = character.toString();

            // para cada elemento do vetor compara se é igual a stringCharacter, se sim
            // entra no if
            for (int i = 0; i < CARACTERES_PARA_SUBSTITUIR.length; i++) {
                if (stringCharacter.equals(CARACTERES_SER_SUBSTITUIDO[i])) {

                    // armazena o primeira ao quarto elemento para substiruir "wbrw" 1°w, 2°b...
                    Character primeiro = CARACTERES_PARA_SUBSTITUIR[i].charAt(0);
                    Character segundo = CARACTERES_PARA_SUBSTITUIR[i].charAt(1);
                    Character terceiro = CARACTERES_PARA_SUBSTITUIR[i].charAt(2);
                    Character quarto = CARACTERES_PARA_SUBSTITUIR[i].charAt(3);

                    // armazena o valor de cada elemento já feito o chast para char e somado o valor
                    // da cifra
                    primeiro = (char) (primeiro.charValue() + cifra);
                    segundo = (char) (segundo.charValue() + cifra);
                    terceiro = (char) (terceiro.charValue() + cifra);
                    quarto = (char) (quarto.charValue() + cifra);

                    // insere pela cabeça na lista local
                    localLista.insertTail(primeiro);
                    localLista.insertTail(segundo);
                    localLista.insertTail(terceiro);
                    localLista.insertTail(quarto);
                    break;
                }
            }

            // condição para saber se o character é diferente de todos os caracters
            // especiais
            boolean condition = !stringCharacter.equals(" ") && !stringCharacter.equals(",")
                    && !stringCharacter.equals(".")
                    && !stringCharacter.equals(";") && !stringCharacter.equals(":") && !stringCharacter.equals("!")
                    && !stringCharacter.equals("?") && !stringCharacter.equals("-");

            // se for diferente irá fazer o chast e somar a cifra no valor char
            if (condition) {
                char letra = (char) (character.charValue() + cifra);
                localLista.insertTail(letra);
            }
        }

        // faz a lista apontar para a lista local, que possui todos os elementos
        // criptgrafados
        listCaracters = localLista;
    }

    // método para substituir os caracteres
    private void substituicaoCaracteresDecriptar() {

        ListCaracters localLista = new ListCaracters();

        // percorre o array de caracters
        for (Character character : listCaracters.printList()) {
            // cria uma varável local do character fazendo conversão para string, assim
            // podendo usar .equals()
            String stringCharacter = character.toString();

            // para cada elemento do vetor compara se é igual a stringCharacter, se sim
            // entra no if
            for (int i = CARACTERES_PARA_SUBSTITUIR.length - 1; i >= 0; i--) {
                if (stringCharacter.equals(CARACTERES_PARA_SUBSTITUIR[i])) {

                    // armazena o primeira ao quarto elemento para substiruir "wbrw" 1°w, 2°b...
                    Character primeiro = CARACTERES_SER_SUBSTITUIDO[i].charAt(0);

                    // armazena o valor de cada elemento já feito o chast para char e somado o valor
                    // da cifra
                    primeiro = (char) (primeiro.charValue() - cifra);

                    // insere pela cabeça na lista local
                    localLista.insertTail(primeiro);
                    break;
                }
            }

            // condição para saber se o character é diferente de todos os caracters
            // especiais
            boolean condition = !stringCharacter.equals(" ") && !stringCharacter.equals(",")
                    && !stringCharacter.equals(".")
                    && !stringCharacter.equals(";") && !stringCharacter.equals(":") && !stringCharacter.equals("!")
                    && !stringCharacter.equals("?") && !stringCharacter.equals("-");

            // se for diferente irá fazer o chast e somar a cifra no valor char
            if (condition) {
                char letra = (char) (character.charValue() - cifra);
                localLista.insertTail(letra);
            }
        }

        String aux = localLista.getList();

        for (int i = CARACTERES_SER_SUBSTITUIDO.length - 1; i >= 0; i--) {
            aux = aux.replaceAll(CARACTERES_PARA_SUBSTITUIR[i], CARACTERES_SER_SUBSTITUIDO[i]);
        }

        localLista = new ListCaracters();
        for (int i = 0; i < aux.length(); i++) {
            localLista.insertTail(aux.charAt(i));
        }

        // faz a lista apontar para a lista local, que possui todos os elementos
        // criptgrafados
        listCaracters = localLista;
    }

    private void encriptar() {

        try {
            // cria a variável para receber o que for lido
            String readString = "";

            // cria um leitor do arquivo
            FileReader reader = new FileReader(arquivo);

            // buffer para agilizar a leitura
            BufferedReader bReader = new BufferedReader(reader);
            readString = bReader.readLine();

            // cria o "escritor" para escrever no arquivo
            FileWriter fileWriter = new FileWriter(arquivo);

            // chamada do método para alocar dinâmicamente a lista
            alocardinamicamente(readString);

            // método para substituir os caracters
            substituicaoCaracteresEncriptar();

            // escreve a mensagem encriptogradada
            fileWriter.write(listCaracters.getList());

            // exibe a mensagem para o usuário
            System.out.println("Mensagem encriptada: \n" + listCaracters.getList());

            // fecha o buffer rader e write
            bReader.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void decriptar() {
        try {
            // cria a variável para receber o que for lido
            String readString = "";

            // cria um leitor do arquivo
            FileReader reader = new FileReader(arquivo);

            // buffer para agilizar a leitura
            BufferedReader bReader = new BufferedReader(reader);
            readString = bReader.readLine();

            // cria o "escritor" para escrever no arquivo
            FileWriter fileWriter = new FileWriter(arquivo);

            // chamada do método para alocar dinâmicamente a lista
            alocardinamicamente(readString);

            // método para substituir os caracters
            substituicaoCaracteresDecriptar();

            // escreve a mensagem encriptogradada
            fileWriter.write(listCaracters.getList());

            // exibe a mensagem para o usuário
            System.out.println("Mensagem decriptada: \n" + listCaracters.getList());

            // fecha o buffer rader e write
            bReader.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void alocardinamicamente(String texto) {

        for (int i = 0; i < texto.length(); i++) {
            listCaracters.insertTail(texto.charAt(i));
        }
    }
}