import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;

public class CreateAccount {

	public CreateAccount() {
		ImageIcon bankLogo = new ImageIcon(CreateAccount.class.getResource("/images/bank.png"));

		final JFrame frame = new JFrame("Create Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(bankLogo.getImage());

		frame.setLayout(null);

		final JTextField firstName = new JTextField();
		TitledBorder t1 = new TitledBorder("First Name");
		firstName.setBorder(t1);
		firstName.setOpaque(false);

		final JTextField lastName = new JTextField();
		TitledBorder t2 = new TitledBorder("Last Name");
		lastName.setBorder(t2);
		lastName.setOpaque(false);

		final JTextField phone = new JTextField();
		TitledBorder t3 = new TitledBorder("Phone No.");
		phone.setBorder(t3);
		phone.setOpaque(false);

		final JTextArea address = new JTextArea();
		TitledBorder t4 = new TitledBorder("Address");
		address.setBorder(t4);
		address.setOpaque(false);

		final JTextField usernameField = new JTextField();
		TitledBorder t5 = new TitledBorder("Username");
		usernameField.setBorder(t5);
		usernameField.setOpaque(false);

		final JPasswordField passwordField = new JPasswordField();
		TitledBorder t6 = new TitledBorder("Password");
		passwordField.setBorder(t6);
		passwordField.setOpaque(false);

		DecimalFormat decimalFormat = new DecimalFormat("#0.00"); // Format for two decimal places
		NumberFormatter formatter = new NumberFormatter(decimalFormat);
		formatter.setAllowsInvalid(false); // Only allow valid numbers
		formatter.setCommitsOnValidEdit(true); // Commit on valid input

		// Create the formatted text field with the number formatter
		JFormattedTextField decimalField = new JFormattedTextField(formatter);
		decimalField.setColumns(10); // Set the size of the field

		TitledBorder titledBorder = BorderFactory.createTitledBorder("Enter initial amount");
		decimalField.setBorder(titledBorder);
		decimalField.setOpaque(false);

		JLabel customerIdLabel;
		customerIdLabel = new JLabel("Customer ID:");

		JButton createAccountButton = new JButton("Create Account");
		createAccountButton.setForeground(Color.white);
		createAccountButton.setBackground(new Color(126, 0, 0));
		createAccountButton.setFocusable(false);
		createAccountButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
		createAccountButton.setBorder(BorderFactory.createLoweredBevelBorder());

		JLabel dobLabel = new JLabel("Date of Birth: ");

		final JDateChooser datechooser = new JDateChooser();
		Date currentDate = new Date();

		// Create a Calendar instance and set it to the current date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// Set the maximum selectable date as the current date
		datechooser.setMaxSelectableDate(calendar.getTime());

		final JToggleButton showPasswordToggle = new JToggleButton(); // Unicode eye character "👁"

		ImageIcon showIcon = new ImageIcon(getClass().getResource("/images/show.png"));
		ImageIcon hideIcon = new ImageIcon(getClass().getResource("/images/hide.png"));
		showPasswordToggle.setIcon(showIcon);
		showPasswordToggle.setSelectedIcon(hideIcon);
		showPasswordToggle.setFocusable(false);
		showPasswordToggle.setContentAreaFilled(false);
		showPasswordToggle.setBorder(null);
		showPasswordToggle.setBounds(545, 225, 30, 30);

		int customerId = getNextCustomerId();
		// int customerId = 1;
		customerIdLabel.setText("Customer ID: " + customerId);
		Font font = new Font(customerIdLabel.getFont().getName(), Font.BOLD, 20);
		customerIdLabel.setFont(font);

		JLabel createAccount = new JLabel("Create Your new Account Here");
		createAccount.setBounds(160, 70, 300, 30);
		createAccount.setFont(new Font("Dialog", Font.BOLD, 20));

		customerIdLabel.setBounds(20, 110, 300, 30);
		firstName.setBounds(20, 150, 250, 50);
		lastName.setBounds(20, 210, 250, 50);
		phone.setBounds(20, 270, 250, 50);
		address.setBounds(20, 330, 250, 80);
		usernameField.setBounds(290, 150, 250, 50);
		passwordField.setBounds(290, 210, 250, 50);
		dobLabel.setBounds(290, 260, 250, 50);
		datechooser.setBounds(290, 310, 200, 30);
		createAccountButton.setBounds(210, 430, 150, 50);
		decimalField.setBounds(290, 360, 200, 50);

		frame.add(createAccount);
		frame.add(customerIdLabel);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(phone);
		frame.add(address);
		frame.add(usernameField);
		frame.add(passwordField);
		frame.add(dobLabel);
		frame.add(datechooser);
		frame.add(createAccountButton);
		frame.add(showPasswordToggle);
		frame.add(decimalField);

		frame.setVisible(true);

		TemplateDesign panel = new TemplateDesign();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setOpaque(false);
		frame.add(panel);

		createAccountButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String userFirstName = firstName.getText();
				String userLastName = lastName.getText();
				String userPhone = phone.getText();
				String userAddress = address.getText();
				String username = usernameField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				if (userFirstName.isEmpty() || userLastName.isEmpty() || userPhone.isEmpty() || userAddress.isEmpty()
						|| username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill in all the fields.", "Empty Fields",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Date selectedDate = datechooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dobString = sdf.format(selectedDate);

				System.out.println(dobString);
				String ifsc = "BPUN0123456";
				String bankAccountType = "Savings";
				//int id = DBHandler.getCustomerIdByLogin(username, password);
				long accountNumbers = Integer.parseInt(generateAccountNumber(getNextCustomerId()));
				String accountNum = Long.toString(accountNumbers);
				// String accountBalance = decimalField.getText();
				Float accountBalance = Float.parseFloat(decimalField.getText());
				String upiID = generateUPIID(ifsc, accountNum);
				System.out.println(accountNumbers);

				try {
					String createTableQuery = "insert into bankaccounts ( FirstName, LastName, Phone, Address, DOB,username,password,upi_id,IFSC_code,account_type,account_balance,account_number) values ('"
							+ userFirstName + "','" + userLastName + "','" + userPhone + "','" + userAddress + "','"
							+ dobString + "','" + username + "','" + password + "', '" + upiID + "', '" + ifsc + "','"
							+ bankAccountType + "','" + accountBalance + "','" + accountNumbers + "')";

					DBHandler.dbExecuteUpdate(createTableQuery);
					JOptionPane.showMessageDialog(frame, "Account Created Successfully.", "Congratulations!!",
							JOptionPane.INFORMATION_MESSAGE);

					frame.dispose();
					new Login();

				} catch (Exception ex) {
					System.out.println("Exception: " + ex);
				}
			}
		});

		showPasswordToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char echoChar = showPasswordToggle.isSelected() ? 0 : '\u2022'; // Show/hide password
				passwordField.setEchoChar(echoChar);

			}
		});
	}

	public static void main(String[] args) {

		new CreateAccount();

	}

	int getNextCustomerId() {
		// Get the current maximum customer ID from the database
		int maxCustomerId = 0;
		try {
			String sql = "SELECT MAX(CustomerId) FROM bankaccounts";
			ResultSet rs = DBHandler.dbExecuteQuery(sql);
			if (rs.next()) {
				maxCustomerId = rs.getInt(1);

			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		}

		// Return the next customer ID
		return maxCustomerId + 1;
	}

	String generateAccountNumber(int customerId) {
		Set<String> existingAccountNumbers = new HashSet<>();

		// Get existing account numbers from the database
		try {
			String sql = "SELECT account_number FROM bankaccounts";
			ResultSet rs = DBHandler.dbExecuteQuery(sql);
			while (rs.next()) {
				existingAccountNumbers.add(rs.getString("account_number"));
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		}

		String fixedDigits = "123456789";
		String uniqueDigit;

		do {
			uniqueDigit = String.valueOf(customerId % 10);
		} while (existingAccountNumbers.contains(fixedDigits + uniqueDigit));

		return fixedDigits + uniqueDigit;
	}

	String generateUPIID(String bankCode, String uniqueIdentifier) {
		// Example format: bankCode.uniqueIdentifier@domain
		String domain = "example.com"; // Replace with your domain
		return bankCode + "." + uniqueIdentifier + "@" + domain;
	}

}
