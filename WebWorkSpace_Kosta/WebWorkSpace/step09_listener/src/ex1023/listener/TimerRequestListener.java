package ex1023.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TimerRequestListener
 *
 */
@WebListener
public class TimerRequestListener implements ServletRequestListener {
	long start, end;
   
    public TimerRequestListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("TimerRequestListener ª˝º∫¿⁄ »£√‚µ  ");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("TimerRequestListener¿« requestInitialized");
    	start = System.nanoTime();
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("TimerRequestListener¿« requestDestryed »£√‚µ  ");
    	end = System.nanoTime();
    	System.out.println("√— Ω««‡ ns : "+(end-start));
    }
	
}
