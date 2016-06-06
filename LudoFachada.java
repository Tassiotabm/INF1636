import java.awt.event.MouseEvent;

public class LudoFachada {
	
	private Dado 	dice= Dado.getDado();;
	private int x,y;
	public LudoFachada(){
	}
	public void jogarDado(){
		this. x = 0;
		this. y = 0;
		this.dice._throw();
		MovementCheck mCheck = new MovementCheck();
	}
	public void clickToken(int x, int y){
		this.x = x;
		this.y = y;

	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}
