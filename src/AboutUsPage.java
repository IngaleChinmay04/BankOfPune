

import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextArea;


public class AboutUsPage {
	public AboutUsPage() {
		// TODO Auto-generated constructor stub
		 ImageIcon bankLogo = new ImageIcon(AboutUsPage.class.getResource("/images/bank.png"));

	        final JFrame frame = new JFrame("About Us Page");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
	        frame.setIconImage(bankLogo.getImage());
	        frame.setLayout(null);

	        
	        ImageIcon  home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
	        JLabel home_button = new JLabel(home);
	        home_button.setBounds(525,0,50,50);
	        frame.add(home_button);
	        
	        
	        
	        JLabel titleLabel = new JLabel("About Us");
	        JTextArea aboutText = new JTextArea(
	                "Welcome to Bank Of Pune!\n\n" +
	                "At Our Bank, we are committed to providing the best banking services to our customers. " +
	                "Our dedicated team is here to assist you with all your banking needs.\n\n" +
	                "For more information or inquiries, please contact us at:\n" +
	                "Email: contact@bop.com\n" +
	                "Phone: (123) 456-7890"
	            );
	            aboutText.setEditable(false);
	            aboutText.setLineWrap(true);
	            aboutText.setWrapStyleWord(true);
	            aboutText.setFont(new Font("Arial", Font.PLAIN, 20));
	            aboutText.setOpaque(false);
	            
	            titleLabel.setBounds(5, 80, 300, 30); 
	            titleLabel.setHorizontalAlignment(JLabel.CENTER);
	            Font bold = new Font("Comic Sans", Font.BOLD, 24);
	            titleLabel.setFont(bold);
	            
	            ImageIcon about = new ImageIcon(getClass().getResource("/images/aboutUs.png"));
	            JLabel aboutL = new JLabel(about);
	            
	            
	        
	            aboutText.setBounds(100,150,400,300);
	            aboutL.setBounds(420,70,100,100);
	            
	          frame.add(aboutL);  
	          frame.add(titleLabel);
	          frame.add(aboutText);

	        frame.setVisible(true);
	        
	        // Add panel to insert shapes
	        
	        
	        TemplateDesign panel = new TemplateDesign();
	        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
			panel.setOpaque(false);
	        frame.add(panel);
	        
	        home_button.addMouseListener(new MouseAdapter() {
	        	
	        	public void mouseClicked(MouseEvent e) {
	               
	                frame.dispose(); // Close the About Us frame
	            }
	        	
	        });
	        
	        
	        
	        
		
	}
	
	public static void main(String[] args) {
		new AboutUsPage();
	}

}
