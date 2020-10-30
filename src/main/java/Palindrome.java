public class Palindrome {

    public static boolean isPalindrome(String palavra) {
        char[] palavraReversa = palavra.toCharArray();
        String palavraInvertida = new String(palavraReversa);
        return palavraInvertida.equals(palavra);
    }
}
