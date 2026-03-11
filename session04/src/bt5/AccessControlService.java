package bt5;

public class AccessControlService {

    public boolean canPerformAction(User user, String action) {

        String role = user.getRole();

        if (role.equals("ADMIN")) {
            return true;
        }

        if (role.equals("MODERATOR")) {
            return action.equals(Action.LOCK_USER) ||
                    action.equals(Action.VIEW_PROFILE);
        }

        if (role.equals("USER")) {
            return action.equals(Action.VIEW_PROFILE);
        }

        return false;
    }
}