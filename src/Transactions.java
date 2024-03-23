
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.*;

import com.toedter.calendar.JDateChooser;

public class Transactions {
	public Transactions() {
		// TODO Auto-generated constructor stub
		ImageIcon bankLogo = new ImageIcon(FAQ.class.getResource("/images/bank.png"));

		final JFrame frame = new JFrame("Transactions.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(bankLogo.getImage());
		frame.setLayout(null);

		ImageIcon home = new ImageIcon(getClass().getResource("/images/homeIcon.png"));
		JLabel home_button = new JLabel(home);
		home_button.setBounds(525, 0, 50, 50);
		frame.add(home_button);

		JLabel text = new JLabel();
		text.setText("E-Statement");
		text.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel from = new JLabel();
		from.setText("From: DD:MM:YYYY");
		from.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel to = new JLabel();
		to.setText("To : DD:MM:YYYY");
		to.setFont(new Font("Dialog", Font.BOLD, 18));

		JDateChooser fromChoose = new JDateChooser();
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		fromChoose.setMaxSelectableDate(calendar.getTime());

		JDateChooser toChoose = new JDateChooser();
		toChoose.setMaxSelectableDate(calendar.getTime());

		JButton getStatement = new JButton("Get E-Statement");
		getStatement.setForeground(Color.white);
		getStatement.setBackground(new Color(126, 0, 0));
		getStatement.setFocusable(false);
		getStatement.setFont(new Font("Comic Sans", Font.BOLD, 18));
		getStatement.setBorder(BorderFactory.createLoweredBevelBorder());

		JTextField accNum = new JTextField();
		accNum.setText("Enter your account number here:");
		accNum.setAlignmentX(JTextField.TOP);
		accNum.setHorizontalAlignment(JTextField.LEFT);

		String[] columnNames = { "Serial No", "Amount", "Type", "Date", "Account NO."};
		Object[][] data = { {} };
		DefaultTableModel model = new DefaultTableModel(data, columnNames);

		getStatement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Date fromDate2 = fromChoose.getDate();
					Date toDate2 = toChoose.getDate();

					java.sql.Date sqlFromDate = new java.sql.Date(fromDate2.getTime());
					java.sql.Date sqlToDate = new java.sql.Date(toDate2.getTime());

					String query = "SELECT * FROM transactions WHERE date BETWEEN '" + sqlFromDate + "' AND '"
							+ sqlToDate + "'";

					// Add a condition to the query based on the account number
					if (!accNum.getText().isEmpty()) {
						Long accountNum = Long.parseLong(accNum.getText());
						query += " AND account_number = " + accountNum;
					}

					ResultSet rs = DBHandler.dbExecuteQuery(query);

					model.setRowCount(0);

					while (rs.next()) {
						int sNo = rs.getInt("serial_no");
						double amount = rs.getDouble("amount");
						String type = rs.getString("transaction_type");
						String date = rs.getString("date");
						int accountNum = rs.getInt("account_number");
						model.addRow(new Object[] { sNo, amount, type, date, accountNum });
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		JTable transactions = new JTable(model);
		transactions.setEnabled(false);

		JScrollPane scrollpane = new JScrollPane(transactions);

		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		frame.add(text);
		frame.add(from);
		frame.add(to);
		frame.add(fromChoose);
		frame.add(toChoose);
		frame.add(getStatement);
		frame.add(scrollpane);
		frame.add(accNum);

		text.setBounds(20, 70, 300, 30);
		from.setBounds(50, 120, 300, 30);
		to.setBounds(330, 120, 300, 30);
		fromChoose.setBounds(50, 160, 200, 30);
		toChoose.setBounds(330, 160, 200, 30);
		getStatement.setBounds(200, 200, 175, 40);
		scrollpane.setBounds(20, 250, 550, 250);
		accNum.setBounds(200, 70, 200, 30);

		frame.setVisible(true);

		TemplateDesign panel = new TemplateDesign();
		frame.add(panel);
		panel.setOpaque(false);
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		home_button.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				frame.dispose();
				new Main();
			}

		});

	}

	public static void main(String[] args) {
		new Transactions();
	}
}
