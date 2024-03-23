

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Date;

import java.text.SimpleDateFormat;

public class DoorstepBanking {
	
	DoorstepBanking()
	{
		ImageIcon bankLogo = new ImageIcon(DoorstepBanking.class.getResource("/images/bank.png"));

        JFrame frame = new JFrame("DOORSTEP BANKING FORM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(bankLogo.getImage());
        frame.setLayout(null);
        
        ImageIcon  home = new ImageIcon(DoorstepBanking.class.getResource("/images/homeIcon.png"));
        JLabel home_button = new JLabel(home);
        home_button.setBounds(525,0,50,50);
        frame.add(home_button);
        
        JDateChooser datechooser = new JDateChooser();
        frame.add(datechooser);
        datechooser.setBounds(320, 450, 160, 30);
        
        JDateChooser dob = new JDateChooser();
        frame.add(dob);
        dob.setBounds(230, 270, 214, 30);

   
        JLabel acctypeL = new JLabel();
        JLabel nameL = new JLabel();
        JTextField phone = new JTextField();
        JLabel genderL = new JLabel();
        JRadioButton maleradio = new JRadioButton();
        JRadioButton femaleradio = new JRadioButton();
        JLabel addressL = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTextArea address = new JTextArea();
        JLabel emailL = new JLabel();
        JTextField email = new JTextField();
        JLabel dobL = new JLabel();
        
        JLabel phoneL = new JLabel();
        JTextField name = new JTextField();
        JLabel aadharL = new JLabel();
        JTextField aadhar = new JTextField();
        JLabel panL = new JLabel();
        JTextField pan = new JTextField();
        JLabel appointmentL = new JLabel();
        JCheckBox checkbox = new JCheckBox();
        JButton submitButton = new JButton();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setLayout(null);
        
     
        
        

        
        acctypeL.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        acctypeL.setText("Account Type : Savings");
        frame.add(acctypeL);
        acctypeL.setBounds(20, 60, 320, 40);

        nameL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        nameL.setText("Name :");
        frame.add(nameL);
        nameL.setBounds(80, 110, 110, 22);

        frame.add(phone);
        phone.setBounds(230, 310, 214, 30);

        genderL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        genderL.setText("Gender :");
        frame.add(genderL);
        genderL.setBounds(80, 140, 155, 29);

        maleradio.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        maleradio.setText("Male");
        frame.add(maleradio);
        maleradio.setBounds(230, 140, 98, 25);

        femaleradio.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        femaleradio.setText("Female");
        frame.add(femaleradio);
        femaleradio.setBounds(330, 140, 98, 25);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(maleradio);
        bg.add(femaleradio);
        
        addressL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        addressL.setText("Address :");
        frame.add(addressL);
        addressL.setBounds(80, 180, 155, 28);

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        frame.add(jScrollPane1);
        jScrollPane1.setBounds(230, 170, 214, 52);

        emailL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        emailL.setText("Email-Id :");
        frame.add(emailL);
        emailL.setBounds(80, 230, 155, 30);
        frame.add(email);
        email.setBounds(230, 230, 214, 30);

        dobL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        dobL.setText("Date of Birth :");
        frame.add(dobL);
        dobL.setBounds(80, 270, 203, 30);

        
       

        phoneL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        phoneL.setText("Phone No :");
        frame.add(phoneL);
        phoneL.setBounds(80, 310, 203, 30);

        
        frame.add(name);
        name.setBounds(230, 100, 214, 31);

        aadharL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        aadharL.setText("Aadhar No :");
        frame.add(aadharL);
        aadharL.setBounds(80, 350, 203, 30);
        frame.add(aadhar);
        aadhar.setBounds(230, 350, 214, 30);

        panL.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        panL.setText("Pan No :");
        frame.add(panL);
        panL.setBounds(80, 390, 165, 30);
        frame.add(pan);
        pan.setBounds(230, 390, 214, 30);

        appointmentL.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        appointmentL.setText("Choose the date for Appointment :");
        frame.add(appointmentL);
        appointmentL.setBounds(20, 450, 296, 20);

        checkbox.setFont(new java.awt.Font("Segoe UI", 0, 15)); 
        checkbox.setText("I,have read all the terms and Conditions, agree to proceed......");
        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        frame.add(checkbox);
        checkbox.setBounds(80, 490, 461, 26);

        submitButton.setBackground(new java.awt.Color(126, 0, 0));
        submitButton.setFont(new java.awt.Font("Segoe UI", 1, 20)); 
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
           		        
            		if(checkbox.isSelected())
            		{	int count=0;
            			String Name=name.getText();
                		String gender=maleradio.isSelected()?"Male" : "Female";
                		String Address=address.getText();
                		String Email=email.getText();
        			
        				Date Dob = dob.getDate();
    				    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    			        String DOB = sdf1.format(Dob);
        			
    			        String Phone=phone.getText();
    			        String Aadhar=aadhar.getText();
    			        String Pan=pan.getText();
        			
        			
        				Date selectedDate = datechooser.getDate();
    				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    			        String doappointment = sdf.format(selectedDate);
       			               			               			               			        
    			        if(Name.isEmpty()){
                            count++;}
    			        if (gender.isEmpty()) {
    	                    count++;}
    			        if(Address.isEmpty()){
                           count++;}
    			        if(Email.isEmpty()){
                          count++;}
    			        if(DOB.isEmpty()){
                          count++;}
    			        if(Phone.isEmpty()){
                          count++;}
    			        if(Aadhar.isEmpty()){
                          count++;}
    			        if(Pan.isEmpty()){
                          count++;}
    			        if(doappointment.isEmpty()){
                          count++;}
    			        
       			        if(count>0) {  
                            JOptionPane.showMessageDialog(frame, "Field is empty. Please enter a value.", "Error", JOptionPane.ERROR_MESSAGE);
       			        }
       			        else {
       				    String insert = "insert into doorstep_banking(name,gender,address,email_id,DOB,Phone_No,Aadhar_no,Pan_no,date_for_appointment)values('"+Name+"','"+gender+"','"+Address+"','"+Email+"','"+DOB+"','"+Phone+"','"+Aadhar+"','"+Pan+"','"+doappointment+"')";
       				    DBHandler.dbExecuteUpdate(insert);
       				    System.out.println("Submitted");
       				    JOptionPane.showMessageDialog(frame,"Your Banking Appointment is fixed. ", "Submitted",JOptionPane.INFORMATION_MESSAGE);
       				    	frame.dispose();
       				    	new Main();
       			          }       
       		}   
          }
        });
        frame.add(submitButton);
        submitButton.setBounds(230, 520, 161, 39);
      
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
	
    
    

public static void main(String[] args) {
    new DoorstepBanking();
}

}


