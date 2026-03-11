import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class bt3_UserProcessorTest {

    private bt3_UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new bt3_UserProcessor();
    }

    @Test
    void testValidEmail_shouldReturnSameEmail() {
        // Arrange
        String email = "user@gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailWithoutAtSymbol_shouldThrowException() {
        // Arrange
        String email = "usergmail.com";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testEmailWithoutDomain_shouldThrowException() {
        // Arrange
        String email = "user@";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testEmailNormalization_shouldConvertToLowercase() {
        // Arrange
        String email = "Example@Gmail.com";

        // Act
        String result = processor.processEmail(email);

        // Assert
        assertEquals("example@gmail.com", result);
    }
}