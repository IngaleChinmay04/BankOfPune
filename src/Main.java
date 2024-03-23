
import javax.swing.*;


public class Main {
	public static int id;
	Main(){
		
		id  = Login.customerId;
		
		ImageIcon bankLogo = new ImageIcon(Login.class.getResource("/images/bank.png"));
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(bankLogo.getImage());

        
        HomePageDesign panel = new HomePageDesign();
       
        
        frame.add(panel);

        frame.setVisible(true);
	}
    public static void main(String[] args) {
    	//int customerID =0;
    	new Main();
    }
}

