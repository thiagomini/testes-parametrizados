import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyFormatterTest {

    @ParameterizedTest(name = "{index} => valor=({0}), reais={1}")
    @MethodSource("numeroParaReaisProvider")
    public void testNumeroParaReais(double numero, String reais) {
        assertEquals(reais, CurrencyFormatter.numeroParaReais(numero));
    }

    private static Stream numeroParaReaisProvider() {
        return Stream.of(
                Arguments.of(0, "R$0,00"),
                Arguments.of(3, "R$3,00"),
                Arguments.of(1.5, "R$1,50"),
                Arguments.of(25.3847, "R$25,38"),
                Arguments.of(101.01, "R$101,01"),
                Arguments.of(225.256, "R$225,25"),
                Arguments.of(2000, "R$2.000,00"),
                Arguments.of(325000, "R$325.000,00"),
                Arguments.of(1415851, "R$1.415.851,00")
        );
    }
}