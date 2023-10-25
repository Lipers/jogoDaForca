package org.example;

import java.util.Scanner;

public class Main {
    static String dica = "";
    public static void main(String[] args) {

        System.out.println("Digite qual palavra será a palavra da forca.");
        var sc = new Scanner(System.in);
        var palavraForca = sc.nextLine().toLowerCase();
        int tentativas = 10;

        String mensagemTentativas = "Você tem %s tentativas para acertar a palavra da forca.\n";
        System.out.printf(mensagemTentativas, tentativas);
        var dicaBuffer = new StringBuffer();
        for (char c: palavraForca.toCharArray()) {
            dicaBuffer.append("_");
        }
        dica = dicaBuffer.toString().trim();
        while (tentativas > 0) {
            var input = sc.nextLine().toLowerCase();
            if (input.equals(palavraForca)) {
                System.out.println("Parabéns, você ganhouuuuuuu!!!!!!!!!!!!!!!!");
                return;
            } else if (input.length() == 1 && palavraForca.contains(input)) {
                dica = revelarChar(input.charAt(0), palavraForca);
            } else {
                --tentativas;
            }

            System.out.println(dicaFormatada());
            System.out.printf(mensagemTentativas, tentativas);
        }
        System.out.println("Você perdeuuuuu, a palavra era: " + palavraForca);
    }

    private static StringBuffer dicaFormatada() {
        var novaDica = new StringBuffer();
        for (char c: dica.toCharArray()) {
            novaDica.append(c).append(" ");
        }
        return novaDica;
    }

    private static String revelarChar(char input, String palavraForca) {
        var novaDica = new StringBuffer();
        for (int i = 0; i < palavraForca.length(); i++) {
            if (input == palavraForca.charAt(i)) {
                novaDica.append(input);
            } else  {
                novaDica.append(dica.charAt(i));
            }
        }
        return novaDica.toString();
    }
}