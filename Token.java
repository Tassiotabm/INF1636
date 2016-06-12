import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Token implements Subject{
	private String cor;
	private int position;
	public boolean inGame;
	// Trajetos estáticos, são os mesmos para cada peça
	static Trajeto greenpath = new Trajeto("Verde");
	static Trajeto redpath = new Trajeto("Vermelho");
	static Trajeto bluepath = new Trajeto("Azul");
	static Trajeto yellowpath = new Trajeto("Amarelo");
	static ArrayList<Token> gameTokens = new ArrayList<Token>();
	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	public Token(String Cor){
		this.cor = Cor;
		this.position = -1;
		this.inGame = false;
		gameTokens.add(this);
		notifyAllObservers();
	}
	public Token(){
		this.cor = "Preto";
		this.position = -1;
		this.inGame = false;
	}
	public boolean move(int pos){
		
		System.out.println("Moving Token");
		if(regrasdojogo.isPlayerColor(this.cor))
		{
			if(pos == 6){
			this.position = this.position + pos + 1;
			notifyAllObservers();
			return true;
			}
			else
			{
				this.position = this.position + pos ;
				notifyAllObservers();
				return true;
			}
		}
		return false;
	}	
	public void add(){
		if(this.inGame == false)
			this.inGame = true;
		this.position = 0;
		
		notifyAllObservers();
	}
	public void remove(){
		this.inGame = false;
		if(this.position != 58){
			this.position = -1;
		}
		notifyAllObservers();
	}
	
	public String getColor(){
		return this.cor;
	}
	
	public int getPosition(){
		return this.position;
	}
	public void printToken(Graphics G){
		switch (this.cor){
		case "Verde" :
		Graphics2D gEllipseGreen=(Graphics2D) G;
		gEllipseGreen.setPaint(Color.green);
		Ellipse2D eg1 = new Ellipse2D.Double(greenpath.path.get(this.position).x,
				greenpath.path.get(this.position).y,20,20);
		gEllipseGreen.fill(eg1);
		G.setColor(Color.black);
		G.drawOval(greenpath.path.get(this.position).x,
				greenpath.path.get(this.position).y,20,20);
		break;
		case "Vermelho" :
			Graphics2D gEllipseRed=(Graphics2D) G;
			gEllipseRed.setPaint(Color.red);
			Ellipse2D eg2 = new Ellipse2D.Double(redpath.path.get(this.position).x,
					redpath.path.get(this.position).y,20,20);
			gEllipseRed.fill(eg2);
			G.setColor(Color.black);
			G.drawOval(redpath.path.get(this.position).x,
					redpath.path.get(this.position).y,20,20);
			break;
		case "Amarelo" : 
			Graphics2D gEllipseYellow=(Graphics2D) G;
			gEllipseYellow.setPaint(Color.yellow);
			Ellipse2D eg3 = new Ellipse2D.Double(yellowpath.path.get(this.position).x,
					yellowpath.path.get(this.position).y,20,20);
			gEllipseYellow.fill(eg3);
			G.setColor(Color.black);
			G.drawOval(yellowpath.path.get(this.position).x,
					yellowpath.path.get(this.position).y,20,20);
			break;
		case "Azul" : 
			Graphics2D gEllipseBlue=(Graphics2D) G;
			gEllipseBlue.setPaint(Color.blue);
			Ellipse2D eg4 = new Ellipse2D.Double(bluepath.path.get(this.position).x,
					bluepath.path.get(this.position).y,20,20);
			gEllipseBlue.fill(eg4);
			G.setColor(Color.black);
			G.drawOval(bluepath.path.get(this.position).x,
					bluepath.path.get(this.position).y,20,20);
			break;
			
			default: ;
		}
	}
	@Override
	public void attach(Observer observer) {
		Token.observers.add(observer);
		
	}
	@Override
	public void notifyAllObservers() {
		for(Observer o:observers){
			o.update();
		}
		
	}
}
