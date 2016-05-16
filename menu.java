import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class menu extends JFrame{
	
	//Buttons Size
	private static final int BUTTON_SIZE_X = 100;      // size height
	private static final int BUTTON_SIZE_Y = 50;       // size width
	private static final int BUTTON_LOCATION_X = 100;  // location x (NAO MUDA) 
	
	//JPanel
	JPanel jmenu = new JPanel();
	// JButton
	JButton buttStart = new JButton("New Game");
	JButton buttLoad = new JButton("Load Game");
	JButton buttQuit = new JButton("Quit");
	

	public void paintComponent(Graphics g){
		
		super.paintComponents(g);
		
		//final BufferedImage image = ImageIO.read(new File("C:\\Users\\Felipe\\workspace\\MegaLudo\\src\\Ronnie-Coleman.jpg"));
		
		//JPanel Layout
		jmenu.setLayout(null);
		
		buttStart.setBounds(BUTTON_LOCATION_X, 60, BUTTON_SIZE_X, BUTTON_SIZE_Y);
		buttLoad.setBounds(BUTTON_LOCATION_X, 130, BUTTON_SIZE_X, BUTTON_SIZE_Y);	
		buttQuit.setBounds(BUTTON_LOCATION_X, 200, BUTTON_SIZE_X, BUTTON_SIZE_Y);
		
		// Add Components
		jmenu.add(buttStart);
		jmenu.add(buttLoad);
		jmenu.add(buttQuit);
		add(jmenu);
	
	}

}
