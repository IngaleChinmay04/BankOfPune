import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
class TemplateDesign extends JPanel {

	private BufferedImage image; 
	private String welcomeText = "Bank Of Pune At Your Service!!";
	private int textX = -500; // Initial position outside the panel

	public TemplateDesign() {
		try {
			image = ImageIO.read(getClass().getResource("/images/rupee.png"));
																		
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create a timer to update the text position
		Timer timer = new Timer(10, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textX += 2; // Adjust the speed of animation
				if (textX > getWidth()) {
					textX = -300; // Reset text position when it goes off-screen
				}
				repaint(); 
			}
		});
		timer.start();

	}

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawShapes(g);
		drawImage(g);
		drawText(g);
	}

	private void drawShapes(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Color shapeColor = new Color(153, 0, 0);
		Color backgroundColor = new Color(241, 240, 238);

		this.setBackground(backgroundColor);

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
	}

	private void drawImage(Graphics g) {
		if (image != null) {
			Graphics2D g2d = (Graphics2D) g;
			int x = 120;
			int y = 0; 
			g2d.drawImage(image, x, y, 50, 50, this);
		}
	}

	private void drawText(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Dialog", Font.BOLD, 40);
		Color textColor = Color.WHITE;

		g2d.setFont(font);
		g2d.setColor(textColor);

		// Draw the text "Bank of Pune"
		int x = 180; 
		int y = 40; 
		g2d.drawString("BANK OF PUNE", x, y);

		Font movingTextFont = new Font("Arial", Font.BOLD, 20); 
		Color movingTextColor = new Color(85, 0, 17);

		g2d.setFont(movingTextFont);
		g2d.setColor(movingTextColor);
		g2d.drawString(welcomeText, textX, 550);


	}

}
