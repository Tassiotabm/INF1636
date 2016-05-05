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
	// possiveis dicas: http://www.java-forums.org/new-java/8091-how-can-i-draw-board-2d-array.html
	class Squares extends JPanel{
		public void paintComponent(Graphics g){
			//Pintar Gquadrado Green 
			super.paintComponents(g);
			Graphics2D g1 = (Graphics2D) g;
			g1.setPaint(Color.green);
			Rectangle2D g1r = new Rectangle2D.Double(0,0,120,120);				
			g1.fill(g1r);
			g.setColor(Color.black);
			g.drawRect(0,0,120,120);

			//Pintar Pquadrados brancos na vertical
			int i,j;
			for(i=0;i<15;i++)
			{
				for(j=0;j<3;j++)
				{
					Graphics2D gbp = (Graphics2D)g;
					if( (i==1 && j==1) || (i==1 && j==2) || (6 > i && i > 1 && j == 1) )
						gbp.setPaint(Color.red);
					else if( (i==13 && j==0) || (i==13 && j==1) || (14 > i && i > 8 && j == 1) )
						gbp.setPaint(Color.yellow);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(120+j*20,i*20,20,20); //coluna linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(120+j*20,i*20,20,20);
				}
			}
			//Pintar Pquadrados brancos na horizontal
			for(i=0;i<3;i++)
			{
				for(j=0;j<15;j++)
				{
					Graphics2D gbp = (Graphics2D)g;
					if( (i==0 && j==1) || (i==1 && j==1) || (6 > j && j > 1 && i == 1) )
						gbp.setPaint(Color.green);
					else if( (i==2 && j==13) || (i==1 && j==13) || (14 > j && j > 8 && i == 1) )
						gbp.setPaint(Color.blue);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(j*20,120+i*20,20,20); //coluna linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(j*20,120+i*20,20,20);
				}
			}
			//pintar Gquadrado Red
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(Color.red);
			Rectangle2D g2r =new Rectangle2D.Double(180,0,120,120);				
			g2.fill(g2r);
			g.setColor(Color.black);
			g.drawRect(180,0,120,120);
			//pintar Gquadrado Yellow
			Graphics2D g3 = (Graphics2D) g;
			g3.setPaint(Color.yellow);
			Rectangle2D g3r =new Rectangle2D.Double(0,180,120,120);				
			g3.fill(g3r);
			g.setColor(Color.black);
			g.drawRect(0,180,120,120);
			//pintar Gquadrado Blue
			Graphics2D g4 = (Graphics2D) g;
			g4.setPaint(Color.blue);
			Rectangle2D g4r =new Rectangle2D.Double(180,180,120,120);				
			g4.fill(g4r);
			g.setColor(Color.black);
			g.drawRect(180,180,120,120);
			//desenhar fucking triangles
			Graphics2D t1 = (Graphics2D) g;
			t1.setPaint(Color.green);
			
			
			/*Path2D.Double triangle = new Path2D.Double();
triangle.moveTo(x1, y1);
triangle.pathTo(x2, y2);
triangle.pathTo(x3, y3);
triangle.closePath();
g2d.fill(triangle);*/
		}
	}
	private void initUI(){
		Graphics g1;
		Squares fp = new Squares();
		
        setTitle("Ludo Game");
        setSize(320,340);
        
        //setContentPane(p);
        getContentPane().add(fp);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
