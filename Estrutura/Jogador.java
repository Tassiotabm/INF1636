package Estrutura;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.text.html.StyleSheet;

public class Jogador extends Observer {
	private String cor;
	private boolean turn;
	public static ArrayList<Jogador> players = new ArrayList<Jogador>();
	public ArrayList<Token> playerTokens = new ArrayList<Token>();
	
	public Jogador(String cor){
		this.cor = cor;
		players.add(this);
		this.turn = false;
	}
	
	public void changeTurn(){
		int index = players.indexOf(this);
		int nextIndex;
		if(index == 3)
			nextIndex = 0;
		else 
			nextIndex = index+1;
		players.get(index).turn = false;
		players.get(nextIndex).turn = true;	
	}
	public boolean getTurn(){
		return this.turn;
	}
	public void setTurn(boolean a){
		this.turn = a;
	}
	public static Jogador playerTurn(){
		for(Jogador j: players){
			if(j.turn == true)
				return j;
		}
		return null;
	}

	public String getColor() {
		return this.cor;
	}
	public ArrayList<Token> getPlayerTokens(){
		return this.playerTokens;
	}
	public static Color getColorAtual() {
		for (Jogador j : players) {
			if (j.turn == true) {
				Color color;
				String Temp = j.getColor();
				if (Temp == "Verde")
					Temp = "green";
				if (Temp == "Vermelho")
					Temp = "red";
				if (Temp == "Amarelo")
					Temp = "yellow";
				if (Temp == "Azul")
					Temp = "blue";
				try {
					Field field = Class.forName("java.awt.Color").getField(Temp);
					color = (Color) field.get(null);
				} catch (Exception e) {
					color = null; // Not defined
				}
				return color;
			}
		}
		return Color.BLACK;
	}

	public static void setAllTurns(String nowPlayer){
		for(Jogador j : players){
			if( new String(j.cor).equals(nowPlayer) == true)
				j.turn = true;
			else
				j.turn = false;
		}
	}
	
	@Override
	public void update() {
		for (Token t: Token.gameTokens){
			if(t.getColor() == this.cor && !playerTokens.contains(t)){
				playerTokens.add(t);
			}
		}
	}
}
