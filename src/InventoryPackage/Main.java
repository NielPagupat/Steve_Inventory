package InventoryPackage;

public class Main {
	
	
    public static void main(String[] args) {
    	
    	String email;
    	
        Login.main(args);

        // Wait until the login window is closed
        while (Login.getLoginResult().isEmpty()) {
            try {
                Thread.sleep(100); // Small delay to reduce CPU usage
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Check login result
        if ("Valid".equals(Login.getLoginResult())) {
        	email = Login.getEmail();
            dashboardPOS.main(args, email);
            System.out.println(email);
            
        } else if ("Register".equals(Login.getLoginResult())) {
            Register.main(args);
		} 
    }
}
