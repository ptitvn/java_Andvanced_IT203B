import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class bt4_PasswordServiceTest {

    private bt4_PasswordService service;

    @BeforeEach
    void setUp() {
        service = new bt4_PasswordService();
    }

    @Test
    void testStrongPassword() {
        String result = service.evaluatePasswordStrength("Abc123!@");

        assertAll(
                () -> assertEquals("Mạnh", result)
        );
    }

    @Test
    void testMissingUppercase() {
        String result = service.evaluatePasswordStrength("abc123!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingLowercase() {
        String result = service.evaluatePasswordStrength("ABC123!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingNumber() {
        String result = service.evaluatePasswordStrength("Abcdef!@");

        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingSpecialCharacter() {
        String result = service.evaluatePasswordStrength("Abc12345");

        assertEquals("Trung bình", result);
    }

    @Test
    void testTooShortPassword() {
        String result = service.evaluatePasswordStrength("Ab1!");

        assertEquals("Yếu", result);
    }

    @Test
    void testOnlyLowercase() {
        String result = service.evaluatePasswordStrength("password");

        assertEquals("Yếu", result);
    }

    @Test
    void testUppercaseAndNumberOnly() {
        String result = service.evaluatePasswordStrength("ABC12345");

        assertEquals("Yếu", result);
    }
}