package model;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//백그라운드에서 작업이 가능하게 하는 Listner 
@WebListener
public class AppContextListener implements ServletContextListener {
    private Thread backgroundThread;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        backgroundThread = new Thread(new BackgroundTask());
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (backgroundThread != null && backgroundThread.isAlive()) {
            backgroundThread.interrupt();
        }
    }
}