import bt5.AccessControlService;
import bt5.Action;
import bt5.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class bt5_AccessControlServiceTest {

    private AccessControlService service;
    private User admin;
    private User moderator;
    private User user;

    @BeforeEach
    void setUp() {
        service = new AccessControlService();

        admin = new User("admin", "ADMIN");
        moderator = new User("mod", "MODERATOR");
        user = new User("user", "USER");
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        user = null;
    }

    @Test
    void adminCanDeleteUser() {
        boolean result = service.canPerformAction(admin, Action.DELETE_USER);
        assertTrue(result);
    }

    @Test
    void moderatorCannotDeleteUser() {
        boolean result = service.canPerformAction(moderator, Action.DELETE_USER);
        assertFalse(result);
    }

    @Test
    void moderatorCanLockUser() {
        boolean result = service.canPerformAction(moderator, Action.LOCK_USER);
        assertTrue(result);
    }

    @Test
    void userCanViewProfile() {
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        assertTrue(result);
    }
}