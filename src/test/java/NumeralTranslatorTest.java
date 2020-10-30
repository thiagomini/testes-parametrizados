import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class NumeralTranslatorTest {

    @ParameterizedTest
    @MethodSource("arabicToRomanProvider")
    void convertArabicToRomanNumeral(int arabic, String roman) {
        assertEquals(roman, NumeralTranslator.arabicToRoman(arabic));
    }

    private static Stream arabicToRomanProvider() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(50, "L")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "3, III",
            "4, IV",
            "100, C",
            "1050, ML"
    })
    void convertArabicToRomanNumeralFromInlineCsv(int arabic, String roman) {
        assertEquals(roman, NumeralTranslator.arabicToRoman(arabic));
    }

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @CsvFileSource(resources = "/roman-numerals.csv")
    void convertArabicToRomanNumeralFromCsvFile(int arabic, String roman) {
        assertEquals(roman, NumeralTranslator.arabicToRoman(arabic));
    }
}