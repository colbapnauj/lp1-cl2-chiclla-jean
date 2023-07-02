package listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("sessionCreated");
         System.out.println("SESSION LISTENER: CREATED - " + se.getSession().getId());
         System.out.println("SESSION LISTENER: CREATED - " + se.getSession().getCreationTime());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("sessionDestroyed");
         System.out.println("SESSION LISTENER: CREATED - " + se.getSession().getId());
         System.out.println("SESSION LISTENER: CREATED - " + se.getSession().getCreationTime());
    }
	
}
