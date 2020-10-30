import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class ProtocolTest {

    @ParameterizedTest
    @EnumSource(Protocol.class)
    void postRequestWithDifferentProtocols(Protocol protocol) {
        assertEquals("Protocolo usado: " + protocol, WebServer.postRequest(protocol));
    }

}