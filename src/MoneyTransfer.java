

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class MoneyTransfer {
	public MoneyTransfer() {

		ImageIcon bankLogo = new ImageIcon(Login.class.getResource("/images/bank.png"));

		JFrame frame = new JFrame("Money Transfer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setIconImage(bankLogo.getImage());

		// Add panel to insert shapes

		JLabel heading = new JLabel("Money Transfer");
		heading.setHorizontalAlignment(JLabel.CENTER);
		Font headingFont = new Font("Serif", Font.BOLD, 35);
		heading.setBounds(170, 60, 300, 60);
		heading.setFont(headingFont);

		JLabel senderAccNum = new JLabel("Sender's account no.");
		senderAccNum.setFont(new Font("Serif", Font.BOLD, 15));
		senderAccNum.setBounds(150, 120, 300, 40);

		JTextField senderAccNumText = new JTextField();
		senderAccNumText.setBounds(150, 150, 300, 30);
		senderAccNumText.setFont(new Font("Serif", Font.BOLD, 14));

		JLabel receiverAccNum = new JLabel("Receiver's account no.");
		receiverAccNum.setFont(new Font("Serif", Font.BOLD, 15));
		receiverAccNum.setBounds(150, 180, 300, 40);

		JTextField receiverAccNumText = new JTextField();
		receiverAccNumText.setBounds(150, 210, 300, 30);
		receiverAccNumText.setFont(new Font("Serif", Font.BOLD, 14));

		JLabel senderName = new JLabel("Sender's Name");
		senderName.setBounds(150, 230, 300, 40);
		senderName.setFont(new Font("Serif", Font.BOLD, 15));
		frame.add(senderName);

		JTextField senderNameText = new JTextField();
		senderNameText.setBounds(150, 260, 300, 30);
		senderNameText.setFont(new Font("Serif", Font.BOLD, 14));
		frame.add(senderNameText);

		JLabel bankIFSC = new JLabel("Bank's IFSC code");
		bankIFSC.setBounds(150, 290, 300, 40);
		bankIFSC.setFont(new Font("Serif", Font.BOLD, 15));
		frame.add(bankIFSC);

		JTextField bankIFSCText = new JTextField();
		bankIFSCText.setText("BPUN0123456");
		bankIFSCText.setEditable(false);
		bankIFSCText.setBounds(150, 320, 300, 30);
		bankIFSCText.setFont(new Font("Serif", Font.BOLD, 14));

		JLabel amount = new JLabel("Enter Amount");
		amount.setFont(new Font("Serif", Font.BOLD, 15));
		amount.setBounds(150, 350, 300, 40);

		JTextField amountText = new JTextField();
		amountText.setBounds(150, 380, 300, 30);
		amountText.setFont(new Font("Serif", Font.BOLD, 14));

		JButton transfer = new JButton("Transfer");
		transfer.setForeground(Color.white);
		transfer.setBackground(new Color(126, 0, 0));
		transfer.setFocusable(false);
		transfer.setFont(new Font("Comic Sans", Font.BOLD, 18));
		transfer.setBorder(BorderFactory.createLoweredBevelBorder());
		transfer.setBounds(120, 450, 150, 50);

		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
		JLabel imageLabel = new JLabel(imageIcon);
		imageLabel.setBounds(525, 0, 50, 50);
		
		JButton downloadReceipt = new JButton("Download Receipt");
		downloadReceipt.setBounds(300, 450, 180, 50);
		downloadReceipt.setForeground(Color.white);
		downloadReceipt.setBackground(new Color(126, 0, 0));
		downloadReceipt.setFocusable(false);
		downloadReceipt.setFont(new Font("Comic Sans", Font.BOLD, 18));
		downloadReceipt.setBorder(BorderFactory.createLoweredBevelBorder());
		// panel to insert shapes
		frame.add(imageLabel);
		frame.add(downloadReceipt);

		frame.add(heading);
		frame.add(senderAccNum);
		frame.add(senderAccNumText);
		frame.add(receiverAccNum);
		frame.add(receiverAccNumText);
		frame.add(amountText);
		frame.add(bankIFSCText);
		frame.add(amount);
		frame.add(transfer);

		TemplateDesign panel = new TemplateDesign();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setOpaque(false);
		frame.add(panel);

		// moneytransfer panel and add it to main panel

		frame.setVisible(true);

		imageLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				frame.dispose(); // Close the About Us frame
				new Main();
			}

		});
		
downloadReceipt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 // Generate receipt
				String transactionType = "Transfer";
				
			    ReceiptGenerator.generateReceipt(transactionType, Double.parseDouble(amountText.getText()), Long.parseLong(senderAccNumText.getText()));

			   
			
			}
		});


		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int senderAccountNumber = Integer.parseInt(senderAccNumText.getText());
				int receiverAccountNumber = Integer.parseInt(receiverAccNumText.getText());

				double amountTransfer = Double.parseDouble(amountText.getText());

				// Deduct amount from sender's account
				updateAccountBalance(senderAccountNumber, -amountTransfer);

				// Add amount to receiver's account
				updateAccountBalance(receiverAccountNumber, amountTransfer);

				// Record the transaction for the sender
				insertTransaction(senderAccountNumber, -amountTransfer);

				// Record the transaction for the receiver
				insertTransaction(receiverAccountNumber, amountTransfer);
				
				SoundGenerator.playSound("src//audio//gpay.wav");
				JOptionPane.showMessageDialog(null, "Amount Transferred successfully.");
//				frame.dispose();
//				new Main();
			}
		});

	}
	
	public static void updateAccountBalance(int accountNumber, double amount) {
		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database",
		// "username", "password");
		String query = "UPDATE bankAccounts SET account_balance = account_balance + " + amount
				+ " WHERE account_number = " + accountNumber;
		// Statement statement = connection.createStatement();
		DBHandler.dbExecuteUpdate(query);
		// statement.close();
		// connection.close();
	}

	public static void insertTransaction(int accountNumber, double amount) {
		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database",
		// "username", "password");
		LocalDate localDate = LocalDate.now();

		// Convert LocalDate to java.sql.Date
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
		String query = "INSERT INTO transactions (amount, transaction_type, account_number,date) VALUES (" + Math.abs(amount)
				+ ", '" + "Money transfer" + "', " + accountNumber + ",'" + sqlDate + "')";
		// Statement statement = connection.createStatement();
		DBHandler.dbExecuteUpdate(query);
		// statement.close();
		// connection.close();

		// RotatedShapesPanel1400 mainPanel = new RotatedShapesPanel1400();

	}

	public static void main(String[] args) {
		new MoneyTransfer();

	}
}

@SuppressWarnings("serial")
class MoneyTransferPanel extends JPanel {
	public MoneyTransferPanel() {
		setLayout(null);
		setOpaque(false);

	}

}
