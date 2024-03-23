import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.border.TitledBorder;

public class AccountDetails {
	AccountDetails()
	{
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/bank.png"));

        JFrame frame = new JFrame("Account Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setIconImage(icon.getImage());

        // Add the main panel to insert shapes and the account details section
        
        JLabel aName = new JLabel("Account Details");
		
        aName.setHorizontalAlignment(JLabel.CENTER);
        Font bold = new Font(aName.getFont().getName(), Font.BOLD, 20);
        aName.setFont(bold);
        aName.setForeground(Color.BLACK);
		

		JLabel username = new JLabel();
		TitledBorder t0 = new TitledBorder("Account Holder's Name");
		username.setBorder(t0);
		username.setOpaque(false);
        username.setBackground(Color.lightGray);
		
        JLabel accountno = new JLabel();
		TitledBorder t1 = new TitledBorder("Account Number");
		accountno.setBorder(t1);
		accountno.setOpaque(false);
        accountno.setBackground(Color.lightGray);
		
		JLabel upi_id = new JLabel();
		TitledBorder t2 = new TitledBorder("UPI ID");
		upi_id.setBorder(t2);
		upi_id.setOpaque(false);
        upi_id.setBackground(Color.lightGray);
		
		JTextArea address = new JTextArea();
		TitledBorder t3 = new TitledBorder("Residential Address");
		address.setEditable(false);
		address.setBorder(t3);
		address.setOpaque(false);

        JLabel mob = new JLabel();
        TitledBorder t4 = new TitledBorder("Mobile Number");
        mob.setBorder(t4);
        mob.setOpaque(false);
		
		JLabel ifsc_code = new JLabel();
        TitledBorder t5 = new TitledBorder("Bank IFSC Code");
        ifsc_code.setBorder(t5);
        ifsc_code.setOpaque(false);

        JLabel accountType = new JLabel();
        TitledBorder t6 = new TitledBorder("A/C Type");
        accountType.setBorder(t6);
        accountType.setOpaque(false);

        JLabel accountBalance = new JLabel();
        TitledBorder t7 = new TitledBorder("Balance");
        accountBalance.setBorder(t7);
        accountBalance.setOpaque(false);
        //Setting the formatting of the text retrieved from MySQL
        accountBalance.setFont(new Font(accountBalance.getFont().getName(), Font.BOLD, 30));
        accountBalance.setForeground(Color.blue);
        accountBalance.setVerticalAlignment(JLabel.TOP);
        accountBalance.setHorizontalAlignment(JLabel.LEFT);
        //We set the wrapping of text so that the input does not overflow the TextArea()
        address.setLineWrap(true); // Enable line wrap
        address.setWrapStyleWord(true); // Wrap at word boundaries
        int userId = Login.customerId;

        try {
           
            // Create a SQL query to retrieve data
            String query = "SELECT * FROM bankaccounts WHERE CustomerID = '"+userId+"'  "; // Assuming you have a user_id

            // Execute the query
            ResultSet resultSet = DBHandler.dbExecuteQuery(query);

            if (resultSet.next()) {
                // Retrieve data from the result set and set it in your labels
                username.setText(resultSet.getString("username"));
                accountno.setText(resultSet.getString("account_number"));
                upi_id.setText(resultSet.getString("upi_id"));
                address.setText(resultSet.getString("Address"));
                mob.setText(resultSet.getString("Phone"));
                ifsc_code.setText(resultSet.getString("IFSC_code"));
                accountType.setText(resultSet.getString("account_type"));
                accountBalance.setText(resultSet.getString("account_Balance"));
            }

            // Close database resources
            resultSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace(); // Handle any database connection or query errors here
        }

        
       

        frame.add(aName);
		frame.add(username);
		frame.add(accountno);
        frame.add(mob);
        frame.add(upi_id);
        frame.add(ifsc_code);
        frame.add(accountType);
        frame.add(accountBalance);

        
        aName.setBounds(10, 60, 200, 30); 
        username.setBounds(20,310,200,50);
		accountno.setBounds(20,380,200,50);
        upi_id.setBounds(20,450,270,50);
        address.setBounds(290, 100, 300,70);
        mob.setBounds(290, 90, 250,50);
        ifsc_code.setBounds(290, 170, 250,50);
        accountType.setBounds(290, 240, 250,50);
        accountBalance.setBounds(290,310, 250, 70);
        
        
		
        
        TemplateDesign panel = new TemplateDesign();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setOpaque(false);
		frame.add(panel);
        // Create the account details panel and add it to the main panel
		
		ImageIcon detail = new ImageIcon(AccountDetails.class.getResource("/images/personal_data.png"));
        JLabel details = new JLabel();
        details.setIcon(resizeImageIcon(detail, 200, 200)); // Resize to 200x200
        details.setBounds(20, 100, 200, 200);
        frame.add(details);
		
       
        ImageIcon  home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
        JLabel home_button = new JLabel(home);
        home_button.setBounds(525,0,50,50);
        frame.add(home_button);
        home_button.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
               
                frame.dispose(); // Close the About Us frame
                new Main();
            }
        	
        });

        frame.add(panel);
        frame.setVisible(true);
	}
    public static void main(String[] args) {
    	new AccountDetails();
        
    }
    private static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
