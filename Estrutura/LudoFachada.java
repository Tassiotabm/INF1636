package Estrutura;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Regra.regrasdojogo;

import java.awt.Point;

public class LudoFachada {
	
	private Dado 	dice= null;
	private static LudoFachada facadeInstance = null;
	private ArrayList<Token> gameTokens = null;
	MovementCheck mCheck = null;
	private LudoFachada(){
		dice = Dado.getDado();
		gameTokens = Token.gameTokens;
		mCheck = new MovementCheck();
	}
	public static LudoFachada getFacade(){
		if(facadeInstance == null)
			return new LudoFachada();
		return facadeInstance;
	}
	public void jogarDado(){

		this.dice._throw();
	}
	public boolean getState20(){
		return regrasdojogo.anda20;
	}
	public boolean clickToken(int x, int y){
		int number = dice.getNumber();
		Token toMove = mCheck.isAToken(x, y, gameTokens);
		if(toMove == null){
			System.out.println("toMove token is null");
			return false;
		}
		else{
			System.out.println("toMove token is not null");
			System.out.println("Dice number is " + dice.getNumber());
			System.out.println("toMove Color is " + toMove.getColor());
			System.out.println("toMove position is " + toMove.getPosition());
			if(regrasdojogo.anda20){
				return regrasdojogo.anda20(toMove);
			}
			return regrasdojogo.rulez(toMove);
		}
	}
	public boolean addToken(){
		if(!regrasdojogo.isHouseFree(Jogador.playerTurn().getColor())){
			return false;
		}
		for(Token t:Token.gameTokens){
			if(t.getPosition() == -1 && t.getColor() == Jogador.playerTurn().getColor()){
				t.add();
				return true;
			}
		}
		return false;
	}
}
