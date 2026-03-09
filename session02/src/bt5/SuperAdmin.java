package bt5;

public class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {

        // chọn method của AdminActions
        AdminActions.super.logActivity(activity);

    }

}