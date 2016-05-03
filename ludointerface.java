import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class ludointerface extends JFrame {
	
	public ludointerface()
	{
		initUI();
	}
	
	class Squares extends JPanel{
		
		public void paintComponent(Graphics g)
		{
			super.paintComponents(g);
			Graphics2D g2d = (Graphics2D) g;
			
			Rectangle2D rt=new Rectangle2D.Double(10,10,10,1);
			g2d.draw(rt);

		}
		
	}
	private void initUI()
	{
		Graphics g1;
		JPanel p = new JPanel();
		Squares fp = new Squares();
		
		p.setBackground(Color.black);
		
        setTitle("Ludo Game");
        setSize(300,300);
        
        setContentPane(fp);
        getContentPane().add(p);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
