import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HexConverterTest {
    @Target({ ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @ConvertWith(HexConverter.class)
    public @interface HexValue {
    }

    @ParameterizedTest
    @CsvSource({
            "15, F",
            "16, 10",
            "233, E9"
    })
    void convertWithCustomHexConverter(int expected, @HexValue int actual) {
        assertEquals(expected, actual);
    }
}