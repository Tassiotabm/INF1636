
public class regrasdojogo {
	
	static boolean isPlayerColor(String cor){
		
		Jogador j = Jogador.playerTurn();
		if(j.getColor() == cor)
			return true;
		else
			return false;
	}
	static boolean isPlayerTurn(String cor){
		Jogador j = Jogador.playerTurn();
		if(j.getTurn())
			return true;
		else
			return false;
	}
	public static boolean isHouseFree(String cor){
		for(Token t: Token.gameTokens){
			System.out.println("Token Position = " + t.getPosition());
			if(t.getPosition() == 0 && t.getColor() == cor)
				return false;
		}
		return true;
	}
}
