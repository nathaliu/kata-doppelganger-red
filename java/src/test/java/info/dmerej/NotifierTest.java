package info.dmerej;

import java.util.ArrayList;
import java.util.List;

public class NotifierTest implements Notifier {
    private final List<String> notifications = new ArrayList<>();

    @Override
    public void notify(User user, String message) {
        notifications.add(user.name() + " " + message);
    }

    public List<String> getNotifications(){
        return notifications;
    }

}
