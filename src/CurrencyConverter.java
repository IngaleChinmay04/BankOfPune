


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class CurrencyConverter {
	
	CurrencyConverter(){
		ImageIcon bankLogo = new ImageIcon(CurrencyConverter.class.getResource("/images/bank.png"));

        final JFrame frame = new JFrame("CURRENCY CONVERTER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(bankLogo.getImage());
        frame.setLayout(null);
       
        ImageIcon  home = new ImageIcon(CurrencyConverter.class.getResource("/images/homeIcon.png"));
        JLabel home_button = new JLabel(home);
        home_button.setBounds(525,0,50,50);
        frame.add(home_button);

        JLabel titleL = new JLabel();
        titleL.setFont(new java.awt.Font("Calibri", 1, 18)); 
        titleL.setText("CURRENCY CONVERTER");
        frame.add(titleL);
        titleL.setBackground(new java.awt.Color(153, 0, 0));
        titleL.setFont(new java.awt.Font("Calibri", 1, 30)); // 
        titleL.setForeground(new java.awt.Color(255, 255, 255));
        titleL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleL.setText("Currency Converter");
        titleL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleL.setOpaque(true);
        titleL.setBounds(135, 110, 300, 50);
        
        JLabel amountL = new JLabel();
        amountL.setFont(new java.awt.Font("Calibri", 1, 18)); 
        amountL.setText("Enter the amount :");
        frame.add(amountL);
        amountL.setBounds(110, 300, 150, 38);
        
        JLabel convertedamtL = new JLabel();
        convertedamtL.setFont(new java.awt.Font("Calibri", 1, 18)); 
        convertedamtL.setText("Converted Amount :");
        frame.add(convertedamtL);
        convertedamtL.setBounds(300, 300, 180, 30);
        
        JTextField amount = new JTextField();
        amount.setFont(new java.awt.Font("Calibri", 1, 18)); 
        frame.add(amount);
        amount.setBounds(110, 340, 160, 40);
        
        JComboBox<String> fromcombo = new JComboBox<String>();
        fromcombo.setFont(new java.awt.Font("Calibri", 1, 18)); 
        fromcombo.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "INR", "USD", "EURO", "AUD", "CAD" }));
        frame.add(fromcombo);
        fromcombo.setBounds(110, 230, 120, 40);
        
        JComboBox<String> tocombo = new JComboBox<String>();
        tocombo.setFont(new java.awt.Font("Calibri", 1, 18)); 
        tocombo.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "INR", "USD", "EURO", "AUD", "CAD" }));
        tocombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        frame.add(tocombo);
        tocombo.setBounds(300, 230, 110, 40);
        
        JLabel fromL = new JLabel();
        fromL.setFont(new java.awt.Font("Calibri", 1, 18)); 
        fromL.setText("From :");
        frame.add(fromL);
        fromL.setBounds(110, 200, 90, 23);
        
        JLabel toL = new JLabel();
        toL.setFont(new java.awt.Font("Calibri", 1, 18)); 
        toL.setText("To :");
        frame.add(toL);
        toL.setBounds(300, 200, 70, 23);
        
        JTextField convertedamt = new JTextField();
        convertedamt.setEditable(false);
        convertedamt.setFont(new java.awt.Font("Calibri", 1, 18)); 
        convertedamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        frame.add(convertedamt);
        convertedamt.setBounds(300, 340, 170, 40);

        JButton convertButton = new JButton();
        convertButton.setBackground(new java.awt.Color(126, 0, 0));
        convertButton.setFont(new java.awt.Font("Calibri", 1, 18)); 
        convertButton.setForeground(new java.awt.Color(255, 255, 255));
        convertButton.setText("Convert");
        convertButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        convertButton.setOpaque(true);
        convertButton.setVerifyInputWhenFocusTarget(false);
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                String fromCurrency = fromcombo.getSelectedItem().toString();
                String toCurrency = tocombo.getSelectedItem().toString();
                double Amount = Double.parseDouble(amount.getText());

                double inrTousdRate = 0.012; 
                double inrToeuroRate = 0.011;
                double inrTocadRate = 0.016;
                double inrToaudRate = 0.019;

                double usdToinrRate = 83.27;
                double usdToeuroRate = 0.95;
                double usdTocadRate = 1.36;
                double usdToaudRate = 1.58;

                double euroToinrRate = 87.47;
                double euroTousdRate =1.05;
                double euroTocadRate = 1.43;
                double euroToaudRate = 1.66;

                double cadToinrRate = 60.94;
                double cadToeuroRate = 0.69;
                double cadToaudRate = 1.16;
                double cadTousdRate = 0.73;

                double audToinrRate =52.4 ;
                double audTousdRate = 0.62;
                double audToeuroRate =0.59 ;
                double audTocadRate =0.85 ;

                double result = Amount;

            if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
                result *= inrTousdRate;
            } else if (fromCurrency.equals("INR") && toCurrency.equals("EURO")) {
                result *= inrToeuroRate;
            }else if (fromCurrency.equals("INR") && toCurrency.equals("CAD")) {
                result *= inrTocadRate;
            }else if (fromCurrency.equals("INR") && toCurrency.equals("AUD")) {
                result *= inrToaudRate;
            }else if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
                result *= usdToinrRate;
            }else if (fromCurrency.equals("USD") && toCurrency.equals("EURO")) {
                result *= usdToeuroRate;
            }else if (fromCurrency.equals("USD") && toCurrency.equals("CAD")) {
                result *= usdTocadRate;
            }else if (fromCurrency.equals("USD") && toCurrency.equals("AUD")) {
                result *= usdToaudRate;
            }else if (fromCurrency.equals("EURO") && toCurrency.equals("INR")) {
                result *= euroToinrRate;
            }else if (fromCurrency.equals("EURO") && toCurrency.equals("USD")) {
                result *= euroTousdRate;
            }else if (fromCurrency.equals("EURO") && toCurrency.equals("CAD")) {
                result *= euroTocadRate;
            }else if (fromCurrency.equals("EURO") && toCurrency.equals("AUD")) {
                result *= euroToaudRate;
            }else if (fromCurrency.equals("CAD") && toCurrency.equals("INR")) {
                result *= cadToinrRate;
            }else if (fromCurrency.equals("CAD") && toCurrency.equals("EURO")) {
                result *= cadToeuroRate;
            }else if (fromCurrency.equals("CAD") && toCurrency.equals("USD")) {
                result *= cadTousdRate;
            }else if (fromCurrency.equals("CAD") && toCurrency.equals("AUD")) {
                result *= cadToaudRate;
            }else if (fromCurrency.equals("AUD") && toCurrency.equals("INR")) {
                result *= audToinrRate;
            }else if (fromCurrency.equals("AUD") && toCurrency.equals("USD")) {
                result *= audTousdRate;
            }else if (fromCurrency.equals("AUD") && toCurrency.equals("EURO")) {
                result *= audToeuroRate;
            }else if (fromCurrency.equals("AUD") && toCurrency.equals("CAD")) {
                result *= audTocadRate;
            }
            
            convertedamt.setText(String.format("%.2f", result));

            }
        });
        frame.add(convertButton);
        convertButton.setBounds(230, 400, 110, 40);
        

        home_button.addMouseListener(new MouseAdapter()
        {
        	public void mouseClicked(MouseEvent e)
        	{
        		frame.dispose();
        		new Main();
        		
        		
        	}
        });
        
        // Add panel to insert shapes
        TemplateDesign panel = new TemplateDesign();
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
		panel.setOpaque(false);
        frame.add(panel);

        frame.setVisible(true);
        
	}
	
	public static void main(String[]args)
	{
		new CurrencyConverter();
	}

}


