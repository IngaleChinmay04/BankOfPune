


import javax.sound.sampled.*;

import javax.swing.*;
import java.awt.*;

public class Splash {
	static JFrame splashFrame = new JFrame("Welcome to Bank of Pune!!");
	static Clip clip;
	public Splash() {
		splashFrame.setLayout(null);
		splashFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel splashLabel = new JLabel("Bank Of Pune");
		Font font = new Font(splashLabel.getFont().getName(), Font.BOLD, 64);
		splashLabel.setFont(font);
		splashLabel.setForeground(Color.white);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/bank.png"));

		splashLabel.setBounds(95, 20, 500, 50);
		Color maroon = new Color(128, 0, 0);

		JLabel load = new JLabel();
		ImageIcon loadIcon = new ImageIcon(getClass().getResource("/images/loadin.gif"));
		load.setIcon(loadIcon);
		
		JLabel label = new JLabel();
		JProgressBar progressBar = new JProgressBar();

		load.setBounds(150, 370, 311, 150);
		progressBar.setBounds(20, 510, 550, 30);
		label.setBounds(300, 510, 200, 30);

		int x;
		splashFrame.setVisible(true);
		Image();
		splashFrame.add(splashLabel);
		splashFrame.add(load);
		splashFrame.add(label);

		splashFrame.add(progressBar);
		progressBar.setForeground(new Color(0, 0, 0, 100));
		splashFrame.setIconImage(icon.getImage());
		splashFrame.setSize(600, 600);
		splashFrame.getContentPane().setBackground(maroon);
		splashFrame.setLocationRelativeTo(null);
		splashFrame.setResizable(false);
		
		    
            
		try {
			
			SoundGenerator.playSound("src//audio//bop.wav");
			
			for (x = 0; x <= 100; x++) {
				progressBar.setValue(x);
				Thread.sleep(160);
				label.setText(Integer.toString(x) + " %");
				if (x == 100) {
					splashFrame.dispose();
					
					new Login();

				}

			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		new Splash();

	}

	public void Image() {
		try {
			splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon image = new ImageIcon(getClass().getResource("/images/bop1.png"));
			JLabel lb2 = new JLabel(image);

			lb2.setBounds(100, 50, 400, 400);
			splashFrame.add(lb2);

		} catch (Exception e2) {
			System.out.println("Exception: " + e2);
		}
		splashFrame.pack();
	}

}
