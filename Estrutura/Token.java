package Estrutura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Token implements Subject{
	private String cor;
	private int position;
	public boolean inGame;
	// Trajetos est�ticos, s�o os mesmos para cada pe�a
	public static Trajeto greenpath = new Trajeto("Verde");
	public static Trajeto redpath = new Trajeto("Vermelho");
	public static Trajeto bluepath = new Trajeto("Azul");
	public static Trajeto yellowpath = new Trajeto("Amarelo");
	public static ArrayList<Token> gameTokens = new ArrayList<Token>();
	private  ArrayList<Observer> observers = new ArrayList<Observer>();
	public Token(String Cor){
		this.cor = Cor;
		this.position = -1;
		this.inGame = false;
		gameTokens.add(this);
		notifyAllObservers();
	}

	public Token() {
		this.cor = "Preto";
		this.position = -1;
		this.inGame = false;
	}

	public void move(int pos) {
		Dado dice = Dado.getDado();
		System.out.println("Moving Token");
		this.position = this.position + pos;
		notifyAllObservers();
	}

	public void add() {

		if (this.inGame == false) {
			System.out.println("adicionando Token da cor " + this.cor);
			this.inGame = true;
			this.position = 0;
		}
		notifyAllObservers();
	}
	static void addNext(String cor){
		for(Token t:Token.gameTokens){
			if(t.getPosition() == -1 && t.getColor() == cor){
				t.add();
				return;
			}
		}
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
	
	public Trajeto getPath(){
		switch(this.cor){
		case "Verde" : return Token.greenpath;
		case "Vermelho" : return Token.redpath;
		case "Azul" : return Token.bluepath;
		case "Amarelo" : return Token.yellowpath;
		}
		return null;
	}
	
	public void setPosition(int pos){
		this.position = pos;
		notifyAllObservers();
	}
	
	public static Vector<Vector<String>> printTokens(){
		Vector<String> posicaoVerde = new Vector<String>();
		Vector<String> posicaoVermelho = new Vector<String>();
		Vector<String> posicaoAzul= new Vector<String>();
		Vector<String> posicaoAmarelo = new Vector<String>();
		Vector<Vector<String>> posicao = new Vector<Vector<String>>();
		
		for(Token t:Token.gameTokens){
			if(t.getColor() == "Vermelho"){
				posicaoVermelho.add(Integer.toString(t.position));
			}
		}
		posicao.add(posicaoVerde);
		for(Token t:Token.gameTokens){
			if(t.getColor() == "Azul"){
				posicaoAzul.add(Integer.toString(t.position));
			}
		}
		posicao.add(posicaoVermelho);
		for(Token t:Token.gameTokens){
			if(t.getColor() == "Verde"){
				posicaoVerde.add(Integer.toString(t.position));
			}
		}
		posicao.add(posicaoAzul);
		for(Token t:Token.gameTokens){
			if(t.getColor() == "Amarelo"){
				posicaoAmarelo.add(Integer.toString(t.position));
			}
		}
		posicao.add(posicaoAmarelo);
		return posicao;
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
		this.observers.add(observer);
		
	}
	@Override
	public void notifyAllObservers() {
		for(Observer o:observers){
			o.update();
		}
		
	}
}
