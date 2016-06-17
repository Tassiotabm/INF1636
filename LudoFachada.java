import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;

public class LudoFachada {
	
	private Dado 	dice= null;
	private ArrayList<Token> gameTokens = null;
	MovementCheck mCheck = null;
	public LudoFachada(){
		dice = Dado.getDado();
		gameTokens = Token.gameTokens;
		mCheck = new MovementCheck();
	}
	public void jogarDado(){

		this.dice._throw();
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
