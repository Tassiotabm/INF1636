import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;

public class LudoFachada {
	
	private Dado 	dice= null;
	private ArrayList<Token> inGameTokens = null;
	MovementCheck mCheck = null;
	public LudoFachada(){
		dice = Dado.getDado();
		inGameTokens = Token.inGameTokens;
		mCheck = new MovementCheck();
	}
	public void jogarDado(){

		this.dice._throw();
	}
	public void clickToken(int x, int y){
		
		Token toMove = mCheck.isAToken(x, y, inGameTokens);
		if(toMove == null)
			return;
		else
			toMove.move(dice.getNumber());
		}
}
