package Estrutura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circulos {
	
	// Desenhar os Círculos Verdes
	private int x;
	private int y;
	
	public Circulos(int x1,int y1,Graphics G,String cor)
	{
		x = x1;
		y = y1;
		
		Graphics2D g = (Graphics2D) G;
		
		if(cor == "Verde"){ // Green Big
			Graphics2D gEllipseGreen=(Graphics2D) g;
			gEllipseGreen.setPaint(Color.green);
			Ellipse2D eg1 = new Ellipse2D.Double(x1,y1,30,30);
			gEllipseGreen.fill(eg1);
			g.setColor(Color.black);
			g.drawOval(x1,y1,30,30);
		}
		else if(cor == "Vermelho"){ // Red Big
			Graphics2D gEllipseRed=(Graphics2D) g;
			gEllipseRed.setPaint(Color.red);
			Ellipse2D er1 = new Ellipse2D.Double(x1,y1,30,30);
			gEllipseRed.fill(er1);
			g.setColor(Color.black);
			g.drawOval(x1,y1,30,30);
		}
		else if(cor == "Preto"){ // Black
			Graphics2D gSmall=(Graphics2D) g;
			gSmall.setPaint(Color.black);
			Ellipse2D eg2 = new Ellipse2D.Double(x1,y1,24,24);
			gSmall.fill(eg2);
			g.setColor(Color.black);
			g.drawOval(x1,y1,24,24);
		}
		else if(cor == "Amarelo"){
			Graphics2D gEllipseYellow=(Graphics2D) g;
			gEllipseYellow.setPaint(Color.yellow);
			Ellipse2D ey1 = new Ellipse2D.Double(x1,y1,30,30);
			gEllipseYellow.fill(ey1);
			g.setColor(Color.black);
			g.drawOval(x1,y1,30,30);
		}
		else if(cor == "Azul"){ // cor == "B"
			Graphics2D gEllipseBlue=(Graphics2D) g;
			gEllipseBlue.setPaint(Color.blue);
			Ellipse2D eb1 = new Ellipse2D.Double(x1,y1,30,30);
			gEllipseBlue.fill(eb1);
			g.setColor(Color.black);
			g.drawOval(x1,y1,30,30);
		}
	}
}
