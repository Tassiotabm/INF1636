import java.util.ArrayList;

public class Jogador extends Observer {
	private String cor;
	public ArrayList<Token> playerTokens = new ArrayList<Token>();
	public Jogador(String cor){
		this.cor = cor;
	}
	
	@Override
	public void update() {
		for(Token t: Token.gameTokens){
			if(t.getColor() == this.cor && !playerTokens.contains(t)){
				playerTokens.add(t);
			}
		}
	}
	

}
