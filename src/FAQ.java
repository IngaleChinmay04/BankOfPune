import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class FAQ {
	
	FAQ(){
		ImageIcon bankLogo = new ImageIcon(FAQ.class.getResource("/images/bank.png"));

        final JFrame frame = new JFrame("Frequently Asked Questions.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(bankLogo.getImage());
        frame.setLayout(null);
        
        JLabel pName = new JLabel("Frequently Asked Questions.");
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Vertical layout

        String[][] faq = {
			    {"What is the Bank Management System?", 
			    "The Bank Management System is a software application designed to help users manage their bank accounts, perform financial transactions, and access various banking services online."},

			    {"How do I access the Bank Management System?", 
			    "To access the system, you need to log in with your credentials. If you're a new user, you can register for an account."},

			    {"Is the Bank Management System secure?", 
			    "Yes, we prioritize the security of your data. We use encryption, secure login methods, and regular security updates to protect your information."},

			    {"How can I open a new bank account through the application?", 
			    "You can open a new bank account by visiting a branch in person. We are working to introduce online account opening in the future."},

			    {"Can I have multiple accounts under the same login?", 
			    "No, you need a separate login for each account. Each account has a unique username and password."},

			    {"How do I update my contact information on my account?", 
			    "You can update your contact information by visiting the nearest branch or contacting our customer support."},

			    {"How do I make a deposit using the application?", 
			    "Log in to your account, go to the 'Deposit' page, and follow the instructions to make a deposit."},

			    {"What are the daily transaction limits?", 
			    "Transaction limits vary based on the type of account. You can find detailed information in your account terms and conditions."},

			    {"How long does it take for a fund transfer to reflect in my account?", 
			    "Fund transfer times depend on the type of transfer (e.g., intra-bank or inter-bank) and the recipient's bank. Typically, transfers may take a few hours to a day."},

			    {"What should I do if I forget my password?", 
			    "You can reset your password by clicking on the 'Forgot Password' link on the login page. Follow the instructions provided."},

			    {"How can I contact customer support for assistance?", 
			    "You can contact our customer support through the 'Contact Us' page or through the support details provided in the app."},

			    {"What should I do if I notice any suspicious activity in my account?", 
			    "Contact customer support immediately to report any suspicious activity. We take security seriously and will investigate the issue."}
			};
		
		for (String[] entry : faq) {
            JLabel questionLabel = new JLabel("Q: " + entry[0]);
            JLabel answerLabel = new JLabel("<html><body width='400'>" + "A: " + entry[1] + "</body></html>");
            // Increase font size
            
            questionLabel.setFont(new Font("Comic Sans", Font.BOLD, 16));
            answerLabel.setFont(new Font("Comic Sans", Font.PLAIN, 14));

            // Add spacing between questions and answers
            contentPanel.add(Box.createVerticalStrut(10));
            contentPanel.add(questionLabel);
             
            
            contentPanel.add(answerLabel);
        }
		
		
		JScrollPane scrollPane = new JScrollPane(contentPanel);
		scrollPane.setBounds(20,100,550,400);
		scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

       
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20); // Increase unit increment for faster scrolling
        verticalScrollBar.setBlockIncrement(60); // Increase block increment for faster scrolling

        pName.setBounds(100, 60, 400, 30); 
        pName.setHorizontalAlignment(JLabel.CENTER);
        Font bold = new Font("Comic Sans", Font.BOLD, 24);
        pName.setFont(bold);
        
        ImageIcon  home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
        JLabel home_button = new JLabel(home);
        home_button.setBounds(525,0,50,50);
        frame.add(home_button);
       
       

        frame.add(scrollPane);
        frame.add(pName);
        
        frame.setVisible(true);
        
        // Add panel to insert shapes
        
        
        TemplateDesign panel =new TemplateDesign();
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
		panel.setOpaque(false);
        frame.add(panel);
        
        
        home_button.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
                
                frame.dispose(); 
            }
        	
        });
        
        
        
	}
	
	
	 public static void main(String[] args) {
	        new FAQ();
	    }

}
