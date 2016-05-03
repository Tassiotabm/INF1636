import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class ludointerface extends JFrame {
	
	public ludointerface()
	{
		initUI();
	}
	/*Quero fazer igual ao site:https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Ludo_board.svg/2000px-Ludo_board.svg.png*/
	class Squares extends JPanel{
		public void paintComponent(Graphics g){
			//Pintar Gquadrado Green 
			super.paintComponents(g);
			Graphics2D g1 = (Graphics2D) g;
			g1.setPaint(Color.green);
			Rectangle2D g1r = new Rectangle2D.Double(0,0,120,120);				
			g1.fill(g1r);
			//Pintar Pquadrados brancos
			int i,j;
			for(i=0;i<6;i++)
			{
				for(j=0;j<3;j++)
				{
					Graphics2D gbp = (Graphics2D)g;
					gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(120+j*20,i*20,20,20); //coluna linha
					gbp.fill(gb2dr);
				}
			}
			//pintar Gquadrados Red
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.red);
			Rectangle2D g2r =new Rectangle2D.Double(180,0,120,120);				
			g2.fill(g2r);
		}
	}
	private void initUI(){
		Graphics g1;
		Squares fp = new Squares();
		
        setTitle("Ludo Game");
        setSize(320,320);
        
        //setContentPane(p);
        getContentPane().add(fp);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
