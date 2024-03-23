
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class PrivacyPolicy {
	public PrivacyPolicy() {
		// TODO Auto-generated constructor stub
		 ImageIcon bankLogo = new ImageIcon(PrivacyPolicy.class.getResource("/images/bank.png"));

	        final JFrame frame = new JFrame("Privacy Policy and Terms of Service.");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
	        frame.setIconImage(bankLogo.getImage());
	        frame.setLayout(null);

	       
	        
	        
	        JLabel pName = new JLabel("Privacy Policy and Terms of Service");

	        // Define your privacy policy and terms of service text
	        String privacyPolicyText = "Privacy Policy for Bank of Pune\n\n"
	            + "At Bank of Pune, we value your privacy and are committed to protecting your personal information. This Privacy Policy outlines how we collect, use, and safeguard your data when you use our services.\n\n"
	            + "Information We Collect:\n\n"
	            + "1. Personal Information: We collect and store your personal information, such as name, contact details, and identification, to create and manage your account.\n\n"
	            + "2. Financial Data: We collect transaction and financial data for account management, transactions, and security purposes.\n\n"
	            + "3. Cookies: We use cookies to improve your browsing experience and gather analytics on website usage.\n\n"
	            + "How We Use Your Information:\n\n"
	            + "We use your information for the following purposes:\n\n"
	            + "1. Account Management: To create and manage your account, process transactions, and provide customer support.\n\n"
	            + "2. Security: To protect your account and our services, we may use your information for verification and fraud prevention.\n\n"
	            + "3. Improvement: We analyze user data to improve our services and tailor offerings to user needs.\n\n"
	            + "Sharing Your Information:\n\n"
	            + "We do not share your personal information with third parties without your consent, except for legal or regulatory requirements.\n\n"
	            + "Security:\n\n"
	            + "We implement stringent security measures to protect your data. Your information is encrypted, and access is restricted to authorized personnel.\n\n";

			
	        String termsOfServiceText = "Terms of Service:\n\n"
	            + "Acceptance of Terms:\n\n"
	            + "By using our services, you agree to abide by these Terms of Service. These terms govern your relationship with Bank of Pune.\n\n"
	            + "Account Usage:\n\n"
	            + "1. You are responsible for maintaining the confidentiality of your account credentials.\n"
	            + "2. You may not use our services for illegal activities.\n\n"
	            + "Service Availability:\n\n"
	            + "We strive to maintain uninterrupted service but do not guarantee uninterrupted access.\n\n"
	            + "Liability:\n\n"
	            + "We are not liable for losses or damages incurred while using our services.\n\n"
	            + "Amendments:\n\n"
	            + "Bank of Pune reserves the right to amend these terms at any time.\n\n"
	            + "Contact Us:\n\n"
	            + "If you have questions or concerns about this Privacy Policy or the Terms of Service, please contact us through the provided contact details.\n\n"
	            + "Last Updated: [14-10-2023]";

	        JTextArea privacyPolicyTextArea = new JTextArea(privacyPolicyText);
	        privacyPolicyTextArea.setWrapStyleWord(true);
	        privacyPolicyTextArea.setLineWrap(true);
	        privacyPolicyTextArea.setEditable(false);
	     
	        privacyPolicyTextArea.setFont(new Font("Comic Sans",Font.PLAIN,16));
	        privacyPolicyTextArea.setBackground(new Color(238,238,238,255));
	        privacyPolicyTextArea.setBorder(null);

	        JTextArea termsOfServiceTextArea = new JTextArea(termsOfServiceText);
	        termsOfServiceTextArea.setWrapStyleWord(true);
	        termsOfServiceTextArea.setLineWrap(true);
	        termsOfServiceTextArea.setEditable(false);
	        termsOfServiceTextArea.setFont(new Font("Comic Sans",Font.PLAIN,16));
	        termsOfServiceTextArea.setBackground(new Color(238,238,238,255));

	        JTabbedPane tabbedPane = new JTabbedPane();
	        tabbedPane.addTab("Privacy Policy", privacyPolicyTextArea);
	        tabbedPane.addTab("Terms of Service", termsOfServiceTextArea);
	        tabbedPane.setBorder(null);
	        
	        
	        JScrollPane tabbedPaneScrollPane = new JScrollPane(tabbedPane); // Wrap the tabbed pane in a scroll pane
	        tabbedPaneScrollPane.setBounds(20,100,550,400);
	        //tabbedPaneScrollPane.setBorder(null);
	        
	        JScrollBar verticalScrollBar = tabbedPaneScrollPane.getVerticalScrollBar();
	        verticalScrollBar.setUnitIncrement(20);
	        verticalScrollBar.setBlockIncrement(60);
	        verticalScrollBar.setBorder(null);
	        
	        
	        pName.setBounds(50, 60, 500, 30);
	        pName.setHorizontalAlignment(JLabel.CENTER);
	        Font bold = new Font("Comic Sans", Font.BOLD, 24);
	        pName.setFont(bold);
	        
	        ImageIcon  home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
	        JLabel home_button = new JLabel(home);
	        home_button.setBounds(525,0,50,50);
	        frame.add(home_button);
	       
	        
	        
	        frame.add(pName);
	        frame.add(tabbedPaneScrollPane);
	        

	        frame.setVisible(true);
	        
	        // Add panel to insert shapes
	        
	        //RotatedShapesPanel5 panel = new RotatedShapesPanel5();
	        TemplateDesign panel = new TemplateDesign();
	        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
			panel.setOpaque(false);
	        frame.add(panel);
		
	        
	        home_button.addMouseListener(new MouseAdapter() {
	        	
	        	public void mouseClicked(MouseEvent e) {
	                
	                frame.dispose();
	               // new Main();// Close the About Us frame
	            }
	        	
	        });
	        
	        
	}
	public static void main(String[] args) {
		new PrivacyPolicy();
	}

}
