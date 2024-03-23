import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;

import java.time.LocalDate;

public class ReceiptGenerator {

    public static void generateReceipt(String transactionType, double amount, long accountNumber) {
    	
    	ImageIcon bankLogo = new ImageIcon(ReceiptGenerator.class.getResource("/images/bank.png"));

        JFrame receiptFrame = new JFrame("Transaction Receipt");
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiptFrame.setSize(400, 400);
        receiptFrame.setResizable(false);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setLayout(null);
        receiptFrame.setIconImage(bankLogo.getImage());

       JPanel receiptPanel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{1}, 0);
                g2d.setStroke(dashed);
                g2d.drawLine(10,5,380,5);
                g2d.drawLine(10, 60, 380, 60); // First horizontal line
                g2d.drawLine(10, 90, 380, 90); // Second horizontal line
                g2d.drawLine(10, 215, 380, 215); // Third horizontal line
                g2d.drawLine(10, 250, 380, 250); // Fourth horizontal line
                g2d.drawLine(10, 295, 380, 295); // Fifth horizontal line
                g2d.drawLine(10,5,8,297);
                g2d.drawLine(380,5,378,297);
                
                
                g2d.setFont(new Font("Monospaced",Font.PLAIN,11));
               
                ImageIcon rupee = new ImageIcon(ReceiptGenerator.class.getResource("/images/rupee.png"));
                g2d.drawImage(rupee.getImage(), 130, 10,20,20,null);
                
                // Bank details
                g2d.drawString("Bank of Pune", 160, 22);
                g2d.drawString("Address: XYZ Street, Pune", 25, 50);
                g2d.drawString("Contact: 1234567890", 250, 50);
                
                // Transaction receipt
                g2d.drawString("Transaction Receipt", 130, 80);
                g2d.drawString("Date: " + LocalDate.now(), 25, 120);
                g2d.drawString("Transaction Type: " + transactionType, 200, 120);
                g2d.drawString("Amount: " + amount, 25, 160);
                g2d.drawString("Account Number: " + accountNumber, 25, 200);
                
                // Thank you message
                g2d.drawString("THANK YOU FOR BANKING WITH US!!", 90, 235);
                
                // Bank info
                g2d.drawString("Bank Of Pune", 160, 268);
                g2d.drawString("Vishwas aur Seva ki bank", 130, 290);
            }
        };
        //receiptPanel.setLayout(null);
        receiptPanel.setBackground(Color.WHITE);

        receiptFrame.add(receiptPanel);
        receiptPanel.setBounds(0,0,400,300);

        JButton downloadButton = new JButton("Download Receipt");
        downloadButton.setBounds(90, 310, 200, 40);
        downloadButton.setForeground(Color.white);
        downloadButton.setBackground(new Color(126, 0, 0));
		downloadButton.setFocusable(false);
		downloadButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
		downloadButton.setBorder(BorderFactory.createLoweredBevelBorder());
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save Receipt As");
                int userSelection = fileChooser.showSaveDialog(receiptFrame);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    try {
                        FileOutputStream outputStream = new FileOutputStream(filePath + ".pdf");
                        PdfGenerator.generatePdf(receiptPanel, outputStream);
                        JOptionPane.showMessageDialog(receiptFrame, "Receipt downloaded successfully!");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(receiptFrame, "Error downloading receipt: " + ex.getMessage());
                    }
                }
            }
        });
        receiptFrame.add(downloadButton);
        receiptFrame.getContentPane().setBackground(Color.white);

        receiptFrame.setVisible(true);
    }
    public static void main(String[] args) {
		new ReceiptGenerator();
		ReceiptGenerator.generateReceipt("type", 1000, 1234567891);
	}
}
