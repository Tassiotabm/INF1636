import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ludointerface extends JFrame {
	
	public ludointerface()
	{
		initUI();
	}
	/*Quero fazer igual ao site:https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Ludo_board.svg/2000px-Ludo_board.svg.png*/
	// possiveis dicas: http://www.java-forums.org/new-java/8091-how-can-i-draw-board-2d-array.html
	class Squares extends JPanel{

		private static final long serialVersionUID = 1L;

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
					else if( (i==1 && j == 0) || (i==13 && j == 2 ))
						gbp.setPaint(Color.black);
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
					else if( (i==2 && j == 1) || (i==0 && j == 13 ))
						gbp.setPaint(Color.black);
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

			/*
			 * Path2D.Double triangle = new Path2D.Double(); triangle.moveTo(x1,
			 * y1); triangle.pathTo(x2, y2); triangle.pathTo(x3, y3);
			 * triangle.closePath(); g2d.fill(triangle);
			 */

			// pintar triângulo 1 Green
			Graphics2D t1 = (Graphics2D) g;
			t1.setPaint(Color.green);
			Path2D.Double triangle = new Path2D.Double();
			triangle.moveTo(120, 120);
			triangle.lineTo(120, 180);
			triangle.lineTo(150, 150);
			triangle.closePath();
			t1.fill(triangle);
			// pintar triângulo 2 Red
			Graphics2D t2 = (Graphics2D) g;
			t2.setPaint(Color.red);
			Path2D.Double triangle2 = new Path2D.Double();
			triangle2.moveTo(120, 120);
			triangle2.lineTo(180, 120);
			triangle2.lineTo(150, 150);
			triangle2.closePath();
			t2.fill(triangle2);
			// g.drawPolygon(new int[] {120, 180, 150}, new int[] {120, 120,
			// 150}, 3);
			// pintar triângulo 3 Blue
			Graphics2D t3 = (Graphics2D) g;
			t3.setPaint(Color.blue);
			Path2D.Double triangle3 = new Path2D.Double();
			triangle3.moveTo(180, 120);
			triangle3.lineTo(180, 180);
			triangle3.lineTo(150, 150);
			triangle3.closePath();
			t3.fill(triangle3);
			// g.drawPolygon(new int[] {180, 180, 150}, new int[] {120, 180,
			// 150}, 3);
			// pintar triângulo 4 Yellow
			Graphics2D t4 = (Graphics2D) g;
			t4.setPaint(Color.yellow);
			Path2D.Double triangle4 = new Path2D.Double();
			triangle4.moveTo(120, 180);
			triangle4.lineTo(180, 180);
			triangle4.lineTo(150, 150);
			triangle4.closePath();
			t4.fill(triangle4);

			// Desenhar os Círculos Verdes
			
			// Green1 Big
			Graphics2D gEllipseGreen1=(Graphics2D) g;
			gEllipseGreen1.setPaint(Color.green);
			Ellipse2D eg1 = new Ellipse2D.Double(15,15,30,30);
			gEllipseGreen1.fill(eg1);
			g.setColor(Color.black);
			g.drawOval(15,15,30,30);
			// Green2 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseGreen2=(Graphics2D) g;
			gEllipseGreen2.setPaint(Color.green);
			Ellipse2D eg2 = new Ellipse2D.Double(18,18,24,24);
			gEllipseGreen2.fill(eg2);
			g.setColor(Color.black);
			g.drawOval(18,18,24,24);
			
			// Green3 Big
			Graphics2D gEllipseGreen3=(Graphics2D) g;
			gEllipseGreen3.setPaint(Color.green);
			Ellipse2D eg3 = new Ellipse2D.Double(75,15,30,30);
			gEllipseGreen3.fill(eg3);
			g.setColor(Color.black);
			g.drawOval(75,15,30,30);
			// Green4 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseGreen4=(Graphics2D) g;
			gEllipseGreen4.setPaint(Color.green);
			Ellipse2D eg4 = new Ellipse2D.Double(78,18,24,24);
			gEllipseGreen4.fill(eg4);
			g.setColor(Color.black);
			g.drawOval(78,18,24,24);
			
			// Green5 Big
			Graphics2D gEllipseGreen5=(Graphics2D) g;
			gEllipseGreen5.setPaint(Color.green);
			Ellipse2D eg5 = new Ellipse2D.Double(15,75,30,30);
			gEllipseGreen1.fill(eg5);
			g.setColor(Color.black);
			g.drawOval(15,75,30,30);
			// Green6 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseGreen6=(Graphics2D) g;
			gEllipseGreen6.setPaint(Color.green);
			Ellipse2D eg6 = new Ellipse2D.Double(18,78,24,24);
			gEllipseGreen2.fill(eg6);
			g.setColor(Color.black);
			g.drawOval(18,78,24,24);
			
			// Green7 Big
			Graphics2D gEllipseGreen7=(Graphics2D) g;
			gEllipseGreen3.setPaint(Color.green);
			Ellipse2D eg7 = new Ellipse2D.Double(75,75,30,30);
			gEllipseGreen3.fill(eg7);
			g.setColor(Color.black);
			g.drawOval(75,75,30,30);
			// Green8 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseGreen8=(Graphics2D) g;
			gEllipseGreen4.setPaint(Color.green);
			Ellipse2D eg8 = new Ellipse2D.Double(78,78,24,24);
			gEllipseGreen4.fill(eg8);
			g.setColor(Color.black);
			g.drawOval(78,78,24,24);
			
			//Desenhar Círculos Vermelhos
			
			// Red1 Big
			Graphics2D gEllipseRed1=(Graphics2D) g;
			gEllipseGreen1.setPaint(Color.red);
			Ellipse2D er1 = new Ellipse2D.Double(195,15,30,30);
			gEllipseGreen1.fill(er1);
			g.setColor(Color.black);
			g.drawOval(195,15,30,30);
			// Red2 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseRed2=(Graphics2D) g;
			gEllipseGreen2.setPaint(Color.red);
			Ellipse2D er2 = new Ellipse2D.Double(198,18,24,24);
			gEllipseGreen2.fill(er2);
			g.setColor(Color.black);
			g.drawOval(198,18,24,24);
			
			// Red3 Big
			Graphics2D gEllipseRed3=(Graphics2D) g;
			gEllipseGreen3.setPaint(Color.red);
			Ellipse2D er3 = new Ellipse2D.Double(255,15,30,30);
			gEllipseGreen3.fill(er3);
			g.setColor(Color.black);
			g.drawOval(255,15,30,30);
			// Red4 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseRed4=(Graphics2D) g;
			gEllipseGreen4.setPaint(Color.red);
			Ellipse2D er4 = new Ellipse2D.Double(258,18,24,24);
			gEllipseGreen4.fill(er4);
			g.setColor(Color.black);
			g.drawOval(258,18,24,24);
			
			// Red5 Big
			Graphics2D gEllipseRed5=(Graphics2D) g;
			gEllipseGreen5.setPaint(Color.red);
			Ellipse2D er5 = new Ellipse2D.Double(195,75,30,30);
			gEllipseGreen1.fill(er5);
			g.setColor(Color.black);
			g.drawOval(195,75,30,30);
			// Red6 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseRed6=(Graphics2D) g;
			gEllipseGreen6.setPaint(Color.red);
			Ellipse2D er6 = new Ellipse2D.Double(198,78,24,24);
			gEllipseGreen2.fill(er6);
			g.setColor(Color.black);
			g.drawOval(198,78,24,24);
			
			// Red7 Big
			Graphics2D gEllipseRed7=(Graphics2D) g;
			gEllipseGreen3.setPaint(Color.red);
			Ellipse2D er7 = new Ellipse2D.Double(255,75,30,30);
			gEllipseGreen3.fill(er7);
			g.setColor(Color.black);
			g.drawOval(255,75,30,30);
			// Red8 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseRed8=(Graphics2D) g;
			gEllipseGreen4.setPaint(Color.red);
			Ellipse2D er8 = new Ellipse2D.Double(258,78,24,24);
			gEllipseGreen4.fill(er8);
			g.setColor(Color.black);
			g.drawOval(258,78,24,24);
			
			
		}
	}
	private void initUI(){

		Squares fp = new Squares();	
        setTitle("Ludo Game");
        setSize(320,340);
        getContentPane().add(fp);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
