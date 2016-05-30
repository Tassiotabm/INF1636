import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class QuadradoGrande {

	private int x;
	private int y;
	
	public QuadradoGrande(int x1,int y1, Graphics G,String cor)
	{
		x = x1;
		y = y1;
		
		Graphics2D g = (Graphics2D) G;
		if(cor == "red"){
			g.setPaint(Color.red);
			Rectangle2D g2 =new Rectangle2D.Double(x1,y1,120,120);				
			g.fill(g2);
			G.setColor(Color.black);}
		else if(cor == "yellow"){
			g.setPaint(Color.yellow);
			Rectangle2D g2 =new Rectangle2D.Double(x1,y1,120,120);				
			g.fill(g2);
			G.setColor(Color.black);}
		else if(cor == "blue"){
			g.setPaint(Color.blue);
			Rectangle2D g2 =new Rectangle2D.Double(x1,y1,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
		}
		else{ //verde
			g.setPaint(Color.green);
			Rectangle2D g2 =new Rectangle2D.Double(x1,y1,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
		}
		
		G.drawRect(x1,y1,120,120);
	}
	
	
}
