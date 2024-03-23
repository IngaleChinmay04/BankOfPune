
import javax.swing.*;

import java.awt.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.*;


public class DepoWith {
	public DepoWith() {

		ImageIcon bankLogo = new ImageIcon(CurrencyConverter.class.getResource("/images/bank.png"));

		JFrame frame = new JFrame("Account Details");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setIconImage(bankLogo.getImage());

		JLabel heading = new JLabel("Deposit/Withdraw");
		
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setFont(new Font("Serif", Font.BOLD, 32));

		JLabel lb2 = new JLabel("Account Number");
		lb2.setBounds(60, 150, 200, 50);
		lb2.setFont(new Font("Serif", Font.BOLD, 24));

		JLabel lb3 = new JLabel("Amount");
		lb3.setBounds(60, 240, 200, 50);
		lb3.setFont(new Font("Serif", Font.BOLD, 24));

		final JTextField accountNum = new JTextField();
		accountNum.setBounds(290, 150, 220, 50);
		accountNum.setFont(new Font("Serif", Font.BOLD, 24));

		final JTextField amount = new JTextField();
		amount.setBounds(290, 240, 220, 50);
		amount.setFont(new Font("Serif", Font.BOLD, 24));

		

		JRadioButton rb1 = new JRadioButton("Deposit");
		rb1.setBounds(70, 340, 110, 50);
		rb1.setFont(new Font("Serif", Font.BOLD, 24));

		JRadioButton rb2 = new JRadioButton("Withdraw");
		rb2.setBounds(300, 340, 110, 50);
		rb2.setFont(new Font("Serif", Font.BOLD, 24));
		
		ButtonGroup transactionGroup = new ButtonGroup();
		
		transactionGroup.add(rb1);
		transactionGroup.add(rb2);
		
		JPanel radioButtonPanel = new JPanel();
		
		//radioButtonPanel.setBackground(Color.white); // Setting the background color
		radioButtonPanel.add(rb1);
		radioButtonPanel.add(rb2);


		JButton proceed = new JButton("Proceed");
		proceed.setBounds(230, 400, 150, 50);
		proceed.setForeground(Color.white);
		proceed.setBackground(new Color(126, 0, 0));
		proceed.setFocusable(false);
		proceed.setFont(new Font("Comic Sans", Font.BOLD, 18));
		proceed.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JButton downloadReceipt = new JButton("Download Receipt");
		downloadReceipt.setBounds(215, 470, 180, 50);
		downloadReceipt.setForeground(Color.white);
		downloadReceipt.setBackground(new Color(126, 0, 0));
		downloadReceipt.setFocusable(false);
		downloadReceipt.setFont(new Font("Comic Sans", Font.BOLD, 18));
		downloadReceipt.setBorder(BorderFactory.createLoweredBevelBorder());
		// panel to insert shapes
		ImageIcon home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
		JLabel home_button = new JLabel(home);
		home_button.setBounds(525, 0, 50, 50);
		frame.add(home_button);


		frame.add(lb2);
		frame.add(heading);
		frame.add(lb3);
		frame.add(accountNum);
		frame.add(amount);
		frame.add(radioButtonPanel);
		frame.add(proceed);
		frame.add(downloadReceipt);
		
		heading.setBounds(170, 60, 300, 60);
		radioButtonPanel.setBounds(100, 330, 400, 60);

		TemplateDesign panel = new TemplateDesign();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setOpaque(false);
		frame.add(panel);

		frame.setVisible(true);

		proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performTransaction(accountNum.getText(),amount.getText(),rb1.isSelected(),rb2.isSelected());
			}
		});
		
		downloadReceipt.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 // Generate receipt
				String transactionType = "type";
				if (rb1.isSelected()) {
					transactionType = "Deposited";
					
				} else if (rb2.isSelected()) {
					transactionType = "Withdrawn";
					
				}
			    ReceiptGenerator.generateReceipt(transactionType, Double.parseDouble(amount.getText()), Long.parseLong(accountNum.getText()));

			   
			
			}
		});
		
		 


		
		home_button.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				frame.dispose(); // Close the About Us frame
				new Main();
			}

		});

	}
	

	public void performTransaction(String accountNo,String amount,boolean rb1,boolean rb2) {
		long accountNumber = Long.parseLong(accountNo);
		double transactionAmount = Double.parseDouble(amount);

		// Validate if account number is not empty
		if (accountNo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter an account number.");
			return;
		}

		// Validate if the withdrawal amount is positive
		if (rb2 && transactionAmount <= 0) {
			JOptionPane.showMessageDialog(null, "Please enter a positive withdrawal amount.");
			return;
		}

		// Check for insufficient funds for withdrawal
		if (rb2) {
			double currentBalance = getCurrentAccountBalance(accountNumber);
			if (currentBalance <= 0 || currentBalance < transactionAmount) {
				JOptionPane.showMessageDialog(null, "Insufficient funds for withdrawal.");
				return;
			}
		}

		String transactionType = "type";
		if (rb1) {
			transactionType = "Deposited";
			updateAccountBalance(accountNumber, transactionAmount);
			SoundGenerator.playSound("src//audio//gpay.wav");
			JOptionPane.showMessageDialog(null, "Amount " + transactionType + " successfully.");
			
		} else if (rb2) {
			transactionType = "Withdrawn";
			updateAccountBalance(accountNumber, -transactionAmount);
			JOptionPane.showMessageDialog(null, "Amount " + transactionType + " successfully.");
		}
		 // Generate receipt
	    //ReceiptGenerator.generateReceipt(transactionType, transactionAmount, accountNumber);

	    // Show success message
	   // JOptionPane.showMessageDialog(null, "Amount " + transactionType + " successfully.");
	}
	

	private double getCurrentAccountBalance(long accountNumber) {
		try {
			String selectQuery = "SELECT account_balance FROM bankAccounts WHERE account_number = '" + accountNumber
					+ "'";
			ResultSet rs = DBHandler.dbExecuteQuery(selectQuery);
			if (rs.next()) {
				return rs.getDouble("account_balance");
			} else {
				JOptionPane.showMessageDialog(null, "Account not found.");
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
			return 0;
		}
	}

	private void updateAccountBalance(long accountNumber, double transactionAmount) {
		try {
			// Get the current account balance from the bankAccounts table
			String selectQuery = "SELECT account_balance FROM bankAccounts WHERE account_number = '" + accountNumber
					+ "'";
			ResultSet rs = DBHandler.dbExecuteQuery(selectQuery);
			if (rs.next()) {
				double currentBalance = rs.getDouble("account_balance");
				double updatedBalance = currentBalance + transactionAmount;

				// Update the account balance in the bankAccounts table
				String updateQuery = "UPDATE bankAccounts SET account_balance = " + updatedBalance
						+ " WHERE account_number = '" + accountNumber + "'";
				DBHandler.dbExecuteUpdate(updateQuery);

				// Determine the transaction type
				String transactionType = (transactionAmount > 0) ? "Deposit" : "Withdrawal";

				// Insert a record into the transactions table
				LocalDate localDate = LocalDate.now();

				// Convert LocalDate to java.sql.Date
				Date sqlDate = Date.valueOf(localDate);
				String insertTransactionQuery = "INSERT INTO transactions (amount, transaction_type, account_number,date) VALUES ("
						+ Math.abs(transactionAmount) + ", '" + transactionType + "', '" + accountNumber + "','"
						+ sqlDate + "')";
				DBHandler.dbExecuteUpdate(insertTransactionQuery);
			} else {
				JOptionPane.showMessageDialog(null, "Account not found.");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
	}

	
	public static void main(String[] args) {
		new DepoWith();
	}
}
