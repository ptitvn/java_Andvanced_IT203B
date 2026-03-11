import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class bt2_UserServiceTest {

    bt2_UserService service = new bt2_UserService();

    @Test
    void testAge18_isValid() {
        // Arrange
        int age = 18;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testAge17_isInvalid() {
        // Arrange
        int age = 17;

        // Act
        boolean result = service.checkRegistrationAge(age);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void testAgeNegative_throwException() {
        // Arrange
        int age = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}