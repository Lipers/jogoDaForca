package org.example;

import java.util.Scanner;

public class Main {
    static String hint = "";
    public static void main(String[] args) {

        System.out.println("Digite qual palavra será a palavra da forca.");
        var sc = new Scanner(System.in);
        var palavraForca = sc.nextLine().toLowerCase();
        int tentativas = 10;

        String tentativasMessage = "Você tem %s tentativas para acertar a palavra da forca.\n";
        System.out.printf(tentativasMessage, tentativas);
        var hintBuffer = new StringBuffer();
        for (char c: palavraForca.toCharArray()) {
            hintBuffer.append("_");
        }
        hint = hintBuffer.toString().trim();
        while (tentativas > 0) {
            var input = sc.nextLine().toLowerCase();
            if (input.equals(palavraForca)) {
                System.out.println("Parabéns, você ganhouuuuuuu!!!!!!!!!!!!!!!!");
                return;
            } else if (input.length() == 1 && palavraForca.contains(input)) {
                hint = revelarChar(input.charAt(0), palavraForca);
            } else {
                --tentativas;
            }

            System.out.println(hintFormatted());
            System.out.printf(tentativasMessage, tentativas);
        }
        System.out.println("Você perdeuuuuu, a palavra era: " + palavraForca);
    }

    private static StringBuffer hintFormatted() {
        var newHint = new StringBuffer();
        for (char c: hint.toCharArray()) {
            newHint.append(c).append(" ");
        }
        return newHint;
    }

    private static String revelarChar(char input, String palavraForca) {
        var newHint = new StringBuffer();
        for (int i = 0; i < palavraForca.length(); i++) {
            if (input == palavraForca.charAt(i)) {
                newHint.append(input);
            } else  {
                newHint.append(hint.charAt(i));
            }
        }
        return newHint.toString();
    }
}