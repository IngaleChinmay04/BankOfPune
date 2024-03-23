import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class HomePageDesign extends JPanel implements MouseListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;

    private String welcomeText = "Bank Of Pune At Your Service!!";
    private int textX = -500; // Initial position outside the panel

    private Rectangle[] clickableRegions;
    private Rectangle2D accountDetailsClickableArea;
    private Rectangle2D viewTransactionClickableArea;
    private Rectangle2D signOutClickableArea;
    private Rectangle2D sidebarClickableArea;

    public HomePageDesign() {
        try {
            // Load the image from a file
            image1 = ImageIO.read(getClass().getResource("/images/rupee.png"));
            image2 = ImageIO.read(getClass().getResource("/images/menu.png"));
            image3 = ImageIO.read(getClass().getResource("/images/checkout.png"));
            image4 = ImageIO.read(getClass().getResource("/images/money1.png"));
            image5 = ImageIO.read(getClass().getResource("/images/image1.png"));
            image6 = ImageIO.read(getClass().getResource("/images/arrival1.png"));
            image7 = ImageIO.read(getClass().getResource("/images/investing.png"));
            image8 = ImageIO.read(getClass().getResource("/images/currency-exchange.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a timer to update the text position
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textX += 2; // Adjust the speed of animation
                if (textX > getWidth()) {
                    textX = -300; // Reset text position when it goes off-screen
                }
                repaint(); // Repaint the panel to update the text position
            }
        });
        timer.start();

        // Add a MouseListener to the panel
        addMouseListener(this);

        // Initialize the clickable regions
        initializeClickableRegions();
    }


    private void initializeClickableRegions() {
        clickableRegions = new Rectangle[5]; // 5 clickable regions for the options
        int optionX = 75;
        int optionY = 240;
        int optionCount = 0;
        for (int i = 0; i < 5; i++) {
            clickableRegions[i] = new Rectangle(optionX, optionY, 100, 100);
            optionX += 170;
            optionCount++;
            if (optionCount >= 3) {
                optionX = 160;
                optionY += 150;
                optionCount = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShapes(g);
        drawImage1(g);
        drawImage2(g);
        drawImage3(g);
        drawText(g);
    }

    private void drawShapes(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set the colors
        Color shapeColor = new Color(153, 0, 0);
        Color backgroundColor = new Color(241, 240, 238);
        Color container = new Color(231,220,218);

        //set Gradient
        Color color1 = new Color(103,5,5); // Start color
        Color color2 = new Color(254,21,21); // End color
        GradientPaint gradient = new GradientPaint(0, 0, color1, 0, 100, color2, true);

        // Set the background color of the panel
        this.setBackground(backgroundColor);

        // Draw a rectangle at the top
        g2d.setColor(shapeColor);
        float arcWidth = 60;
        float arcHeight = 60;
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, -50, 586, 100, arcWidth, arcHeight);
        g2d.fill(roundRect);

        g2d.setColor(shapeColor);
        g2d.fillRect(0, 463, 100, 100);

        g2d.setColor(backgroundColor);
        g2d.fillOval(0, 364, 200, 200);

        g2d.setColor(shapeColor);
        g2d.fillRect(472, 453, 115, 150);

        g2d.setColor(backgroundColor);
        g2d.fillOval(387, 364, 200, 200);

        //Account details
        g2d.setPaint(gradient);
        RoundRectangle2D accountDetails = new RoundRectangle2D.Float(30, 70, 250, 100, 30, 30);
        g2d.fill(accountDetails);
        accountDetailsClickableArea = new Rectangle2D.Float(30, 70, 250, 100);

        //Designing Account Details
        Ellipse2D.Double hollowCircle = new Ellipse2D.Double(38, 75, 50, 50);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(hollowCircle);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(85, 85, 250,85);
        
        g2d.setFont(new Font("Comic Sans", Font.BOLD, 25));
        g2d.setColor(Color.cyan);
        String text_num1 = "01";
        int textWidth0 = g2d.getFontMetrics().stringWidth(text_num1);
        int text_num_x = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth0) / 2);
        int text_num_y = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_num1, text_num_x-91, text_num_y-13);

        String text_a = "ACCOUNT";
        int textWidth1 = g2d.getFontMetrics().stringWidth(text_a);
        int text1_x = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth1) / 2);
        int text1_y = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_a, text1_x+5, text1_y-5);

        String text_b = "DETAILS";
        int textWidth2 = g2d.getFontMetrics().stringWidth(text_b);
        int text2_x = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth2) / 2);
        int text2_y = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_b, text2_x+30, text2_y+20);

        //View Transactions
        g2d.setPaint(gradient);
        RoundRectangle2D viewTransactions = new RoundRectangle2D.Float(310, 70, 250, 100, 30, 30);
        g2d.fill(viewTransactions);
        viewTransactionClickableArea = new Rectangle2D.Float(310, 70, 250, 100);

        //Designing View Transactions
        Ellipse2D.Double hollowCircle1 = new Ellipse2D.Double(318, 75, 50, 50);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(hollowCircle1);
        g2d.setColor(Color.orange);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(365, 85, 530,85);
        
        g2d.setFont(new Font("Comic Sans", Font.BOLD, 25));
        g2d.setColor(Color.cyan);
        String text_num2 = "02";
        int textWidth3 = g2d.getFontMetrics().stringWidth(text_num2);
        int text_num2_x = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth3) / 2);
        int text_num2_y = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_num2, text_num2_x+187, text_num2_y-13);

        String text_a2 = "VIEW";
        int textWidth4 = g2d.getFontMetrics().stringWidth(text_a2);
        int text1_x2 = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth4) / 2);
        int text1_y2 = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_a2, text1_x2+250, text1_y2-5);

        String text_b2 = "TRANSACTIONS";
        int textWidth5 = g2d.getFontMetrics().stringWidth(text_b2);
        int text2_x2 = (int) (accountDetails.getX() + (accountDetails.getWidth() - textWidth5) / 2);
        int text2_y2 = (int) (accountDetails.getY() + accountDetails.getHeight() / 2);
        g2d.drawString(text_b2, text2_x2+305, text2_y2+20);

        String main_menu = "BANKING SUVIDHA";
        g2d.setFont(new Font("Consolas", Font.TYPE1_FONT, 20));
        g2d.setColor(Color.black);
        g2d.drawString(main_menu, 30, 218);

        //Container
        g2d.setColor(container);
        RoundRectangle2D conatinerShape = new RoundRectangle2D.Float(30, 220, 530, 300, 30, 30);
        g2d.fill(conatinerShape);

        // Adding 5 rounded rectangles with labels
        int optionX = 75;
        int optionY = 240;
        int optionsPerRow = 3;
        int optionCount = 0;
        String[] labels = {"MONEY DEPOSIT", "MONEY TRANSFER", "DOORSTEP BANKING", "SIP CALCULATOR", "CURRENCY CONVERTER"};
        BufferedImage[] images = {image4, image5, image6, image7, image8};

        for (int i = 0; i < 5; i++) {
            g2d.setColor(shapeColor);
            RoundRectangle2D var = new RoundRectangle2D.Float(optionX, optionY, 100, 100, 20, 20);
            g2d.fill(var);

            // Draw the label below the shape
            String label = labels[i];
            Font font = new Font("Arial", Font.BOLD, 14);
            Color textColor = Color.BLACK;
            g2d.setFont(font);
            g2d.setColor(textColor);
            FontMetrics fm = g2d.getFontMetrics();
            int labelWidth = fm.stringWidth(label);
            int x = optionX + (50 - labelWidth / 2);
            int y = optionY + 120;
            g2d.drawString(label, x, y);

            // Draw the image on the shape
            BufferedImage image = images[i];
            int imageX = optionX + 10;
            int imageY = optionY + 10;
            g2d.drawImage(image, imageX, imageY, 80, 80, this);

            optionX += 170;
            optionCount++;

            if (optionCount >= optionsPerRow) {
                optionX = 160;
                optionY += 150;
                optionCount = 0;
            }
        }

    }

    private void drawImage1(Graphics g) {
        if (image1 != null) {
            Graphics2D g2d = (Graphics2D) g;

            int x = 110; 
            int y = 0; 
            g2d.drawImage(image1, x, y, 50, 50, this);
        }
    }

    private void drawImage2(Graphics g) {
        if (image2 != null) {
            Graphics2D g2d = (Graphics2D) g;

            // Draw the image at a specific position
            int x = 15; 
            int y = 15; 
            g2d.drawImage(image2, x, y, 20, 20, this);
            sidebarClickableArea = new Rectangle2D.Float(x, y, 20, 20);
        }
    }

    private void drawImage3(Graphics g) {
        if (image3 != null) {
            Graphics2D g2d = (Graphics2D) g;

            // Draw the image at a specific position
            int x = 540; 
            int y = 10; 
            g2d.drawImage(image3, x, y, 35, 35, this);
            signOutClickableArea = new Rectangle2D.Float(x, y, 35, 35);
        }
    }

    private void drawText(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font font = new Font("Dialog", Font.BOLD, 40);
        Color textColor = Color.WHITE;

        g2d.setFont(font);
        g2d.setColor(textColor);

        int x = 170; 
        int y = 40; 
        g2d.drawString("BANK OF PUNE", x, y);

        // Draw the animated text
        Font movingTextFont = new Font("Arial", Font.BOLD, 20); 
        Color movingTextColor = new Color(85,0,17); 

        g2d.setFont(movingTextFont);
        g2d.setColor(movingTextColor);
        g2d.drawString(welcomeText, textX, getHeight() - 5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (accountDetailsClickableArea.contains(x, y)) 
        {
            System.out.println("Account details clicked!");
            Component component = (Component) e.getSource();
            SwingUtilities.getWindowAncestor(component).dispose();
    		new AccountDetails();
        } 
        else if(sidebarClickableArea.contains(x,y)){
            System.out.println("Sidebar clicked!");
            displayButtonPanel();
        }
        else if (viewTransactionClickableArea.contains(x, y)) { 
            System.out.println("View transaction clicked!");
            Component component = (Component) e.getSource();
            SwingUtilities.getWindowAncestor(component).dispose();
            new Transactions();
        }
        else if(signOutClickableArea.contains(x,y)){
            System.out.println("View transaction clicked!");
            int choice = JOptionPane.showOptionDialog(
            null, 
            "Do you really want to sign out?", 
            "WARNING", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE, 
            null, 
            new Object[]{"Yes", "No"}, 
            "No" 
            );

            if (choice == JOptionPane.YES_OPTION) {
                System.out.println("User selected 'Yes'");
                Component component = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(component).dispose();
                new Login();
            } else if (choice == JOptionPane.NO_OPTION) {
                System.out.println("User selected 'No'");
                new Main();
            }
        }
        else {
            for (int i = 0; i < clickableRegions.length; i++) {
                if (clickableRegions[i].contains(x, y)) {
                	if(i==2)
                	{   
                		Component component = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(component).dispose();
                		new DoorstepBanking();
                	}
                	if(i==3)
                	{
                		Component component = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(component).dispose();
                		new SipCalculator();
                	}
                	if(i==4)
                	{
                		Component component = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(component).dispose();
                		new CurrencyConverter();
                	}
                	if(i==0) {
                		Component component = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(component).dispose();
                		new DepoWith();
                		
                	}
                	if(i==1) {
                		Component component = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(component).dispose();
                		new MoneyTransfer();
                	}
                    int j=i+1;
                    System.out.println("Option " + j + " clicked!");
            }
        }
    }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	//
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To do
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // To do
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // To do
    }

    private void displayButtonPanel() {
    // Create a new panel for the buttons
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 1)); // Create a 4X1 grid layout for buttons
    //String []str= {"FAQ,S","ABOUT US","PRIVACY POLICY"};
    // Create buttons and add them to the buttonPanel
    
        JButton button1= new JButton("FAQ'S");
        buttonPanel.add(button1);
        button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FAQ();
			}
		});
       JButton button2= new JButton( "ABOUT US");
       buttonPanel.add(button2);
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AboutUsPage();
			}
		});
       JButton button3= new JButton( "PRIVACY POLICY");
       buttonPanel.add(button3);
        button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new PrivacyPolicy();
			}
		});
        
    // Create a new frame to display the buttonPanel
    JFrame buttonFrame = new JFrame("More Options");
    buttonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the frame only
    buttonFrame.add(buttonPanel);
    buttonFrame.pack();
    buttonFrame.setBounds(350,100,200,200);
    buttonFrame.setVisible(true);
    }

}

