/*
 * trial.java
 *
 * Created on April 29, 2012, 7:50 PM
 */

package controller;



import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

public class SessionCounter implements HttpSessionListener {
    private List sessions = new ArrayList();

    public SessionCounter() {
    }

    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessions.add(session.getId());

        session.setAttribute("counteronlineuser", this);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        sessions.remove(session.getId());

        session.setAttribute("counteronlineuser", this);
    }

    public int getActiveSessionNumber() {
        return sessions.size();
    }
}
