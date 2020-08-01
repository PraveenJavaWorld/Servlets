package pack;
import javax.servlet.http.*;
public class MySessionListener implements HttpSessionListener,HttpSessionAttributeListener{
	
	public void sessionCreated(HttpSessionEvent hse){
		System.out.println("\tNew Session Created");
	}
	public void attributeAdded(HttpSessionBindingEvent hb){
		System.out.println("\tName:"+hb.getName());
		System.out.println("\tValue:"+hb.getValue());
		HttpSession hs=hb.getSession();
		System.out.println("\tNewValue:"+hs.getAttribute(hb.getName()));
	}
	public void attributeRemoved(HttpSessionBindingEvent hbe){
		System.out.println("\tAtribute removed from Session");
		System.out.println("\tName:"+hbe.getName());
		System.out.println("\tValue:"+hbe.getValue());
	}
	public void sessionDestroyed(HttpSessionEvent hse){
		System.out.println("\tSession Destroyed");
	}

}
