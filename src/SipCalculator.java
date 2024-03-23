
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class SipCalculator 
{
	SipCalculator()
	{
		 ImageIcon bankLogo = new ImageIcon(SipCalculator.class.getResource("/images/bank.png"));

	        JFrame frame = new JFrame("SIP CALCULATOR");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 600);
	        frame.setLocationRelativeTo(null);
	        frame.setResizable(false);
	        frame.setIconImage(bankLogo.getImage());
	        frame.setLayout(null);
	        
	        ImageIcon  home = new ImageIcon(SipCalculator.class.getResource("/images/homeIcon.png"));
	        JLabel home_button = new JLabel(home);
	        home_button.setBounds(525,0,50,50);
	        frame.add(home_button);
	        
	        JSlider monthlyslider = new JSlider(500, 100000); 
		    JSlider returnrateslider = new JSlider(2, 30); 
		    JSlider timeslider = new JSlider(1,40); 
		    JButton calculateButton = new JButton();
		    JLabel monthlyL = new JLabel();
		    JTextField monthly = new JTextField();
		    JTextField returnrate = new JTextField();
		    JTextField time = new JTextField();
		    JLabel returnrateL = new JLabel();
		    JLabel timeL = new JLabel();
		    JLabel totalinvstL = new JLabel();
		    JLabel estreturnL = new JLabel();
		    JLabel totalvalueL = new JLabel();
		    JTextField totalinvst = new JTextField();
		    JTextField estreturn = new JTextField();
		    JTextField totalvalue = new JTextField();

		    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    frame.setLayout(null);


		    frame.add(monthlyslider);
	        monthlyslider.setBounds(80, 150, 320, 28);
		    
	        frame.add(returnrateslider);
	        returnrateslider.setBounds(80, 230, 320, 28);
		  
	        frame.add(timeslider);
	        timeslider.setBounds(80, 310, 320, 28);
	        frame.add(totalinvst);
	        totalinvst.setBounds(330, 340, 124, 32);


		    calculateButton.setBackground(new java.awt.Color(126, 0, 0));
		    calculateButton.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
		    calculateButton.setForeground(new java.awt.Color(255, 255, 255));
		    calculateButton.setText("Calculate");
		    calculateButton.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		        //  double mi=Double.parseDouble(monthly.getText());  //montly investments
				//  double err= Double.parseDouble(returnrate.getText()) / 100;  //expected return rate
	            // int td = Integer.parseInt(time.getText());   //time duration
				// int n=td*12;
				// double i=err/12/100;
				// double M=mi*(Math.pow(1+i,n)-1)/(i*1+i);

				// double intrest=M-(mi*n);

		     double monthlyRate = Double.parseDouble(returnrate.getText())/12/100;
			int months = Integer.parseInt(time.getText())*12;
			double amount = Double.parseDouble(monthly.getText())*(Math.pow(1+monthlyRate, months)-1)/(monthlyRate)*(1+monthlyRate);
			double interestEarned = amount- (Double.parseDouble(monthly.getText())*12*Integer.parseInt(time.getText()));
			double principal=Double.parseDouble(monthly.getText())*12*Integer.parseInt(time.getText());
				totalinvst.setText(String.format("%.2f", principal));
			    estreturn.setText(String.format("%.2f",interestEarned));
				totalvalue.setText(String.format("%.2f", amount));
		        }
		    });
		    frame.add(calculateButton);
	        calculateButton.setBounds(240, 500, 132, 35);

		    monthlyL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
		    monthlyL.setText("Monthly Investment :");
		    frame.add(monthlyL);
	        monthlyL.setBounds(90, 100, 190, 30);

		   
	        monthlyslider.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                // Update the JTextField value to match the JSlider value
	                monthly.setText(String.valueOf(monthlyslider.getValue()));
	            }
	        });

			monthly.addActionListener((ActionListener) new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Update the JSlider value to match the JTextField value
	                try {
	                    int value = Integer.parseInt(monthly.getText());
	                    if (value >= monthlyslider.getMinimum() && value <= monthlyslider.getMaximum()) {
	                        monthlyslider.setValue(value);
	                    }
	                } catch (NumberFormatException ex) {
	                    // Reset the JTextField value to the JSlider value
	                    monthly.setText(String.valueOf(monthlyslider.getValue()));
	                }
	            }
	        });

			frame.add(monthly);
	        monthly.setBounds(330, 100, 172, 41);

		    

			returnrateslider.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                // Update the JTextField value to match the JSlider value
	                returnrate.setText(String.valueOf(returnrateslider.getValue()));
	            }
	        });

		    returnrate.addActionListener((ActionListener) new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Update the JSlider value to match the JTextField value
	                try {
	                    int value = Integer.parseInt(returnrate.getText());
	                    if (value >= returnrateslider.getMinimum() && value <= returnrateslider.getMaximum()) {
	                        returnrateslider.setValue(value);
	                    }
	                } catch (NumberFormatException ex) {
	                    // Reset the JTextField value to the JSlider value
	                    returnrate.setText(String.valueOf(returnrateslider.getValue()));
	                }
	            }
	        });


		    frame.add(returnrate);
	        returnrate.setBounds(330, 180, 173, 41);

		    timeslider.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                // Update the JTextField value to match the JSlider value
	                time.setText(String.valueOf(timeslider.getValue()));
	            }
	        });

		    time.addActionListener((ActionListener) new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Update the JSlider value to match the JTextField value
	                try {
	                    int value = Integer.parseInt(time.getText());
	                    if (value >= timeslider.getMinimum() && value <= timeslider.getMaximum()) {
	                        timeslider.setValue(value);
	                    }
	                } catch (NumberFormatException ex) {
	                    // Reset the JTextField value to the JSlider value
	                    time.setText(String.valueOf(timeslider.getValue()));
	                }
	            }
	        });

		    frame.add(time);
	        time.setBounds(330, 260, 171, 40);

		    returnrateL.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
		    returnrateL.setText("Expected return rate (p.a) :");
		    frame.add(returnrateL);
	        returnrateL.setBounds(80, 180, 239, 41);

		    timeL.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
		    timeL.setText("Time period :");
		    frame.add(timeL);
	        timeL.setBounds(80, 260, 191, 41);

		    

		    totalinvstL.setFont(new java.awt.Font("Calibri", 1, 16)); 
		    totalinvstL.setText("Total Invested :");
	        totalinvst.setEditable(false);
		    frame.add(totalinvstL);
	        totalinvstL.setBounds(100, 340, 146, 35);

		    estreturnL.setFont(new java.awt.Font("Calibri", 1, 16)); 
		    estreturnL.setText("Estimated returns :");
		    frame.add(estreturnL);
	        estreturnL.setBounds(100, 390, 146, 35);

		    totalvalueL.setFont(new java.awt.Font("Calibri", 1, 16)); 
		    totalvalueL.setText("Total value :");
		    frame.add(totalvalueL);
	        totalvalueL.setBounds(100, 440, 202, 35);
	        frame.add(totalinvstL);
	        totalinvstL.setBounds(100, 340, 146, 35);

		    
	        frame.add(estreturn);
	        estreturn.setBounds(330, 390, 124, 32);
	        estreturn.setEditable(false);

		    
		    frame.add(totalvalue);
	        totalvalue.setBounds(330, 440, 124, 32);
	        totalvalue.setEditable(false);
	        
	        
	        home_button.addMouseListener(new MouseAdapter()
	        {
	        	public void mouseClicked(MouseEvent e)
	        	{
	        		frame.dispose();
	        		new Main();
	        		
	        		
	        	}
	        });
	        
	        
	        TemplateDesign panel = new TemplateDesign();
	        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
			panel.setOpaque(false);
	        frame.add(panel);

	        frame.setVisible(true);
	
	}
	
	public static void main(String []args)
	{
		new SipCalculator();
	}
	
}



    