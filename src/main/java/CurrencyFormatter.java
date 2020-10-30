public class CurrencyFormatter {

    public static String numeroParaReais(double numero) {
        String numeroParseado = String.valueOf(numero);

        numeroParseado = numeroParseado.indexOf('.') >= 0
                ? numeroParseado + "00"
                : numeroParseado + ".00";


        String[] parteInteiraEDecimal = numeroParseado.split("\\.");
        String parteInteiraComPontos = adicionarPontos(parteInteiraEDecimal[0]);
        String parteDecimal = parteInteiraEDecimal[1].substring(0, 2);

        return "R$" + parteInteiraComPontos + "," + parteDecimal;

    }

    private static String adicionarPontos(String numeroInteiro) {
        int pontos = numeroInteiro.length() / 3;


        if (pontos > 0) {
            StringBuilder valorFinal = new StringBuilder();
            int contador = 0;
            for (int i = 1; i <= numeroInteiro.length(); i++) {
                contador++;
                int posicaoNaString = numeroInteiro.length() - i;
                valorFinal.append(numeroInteiro.charAt(posicaoNaString));
                if ((contador % 3) == 0 && i != numeroInteiro.length()) {
                    valorFinal.append('.');
                    contador = 0;
                }
            }
            return valorFinal.reverse().toString();
        } else {
            return numeroInteiro;
        }

    }

}
