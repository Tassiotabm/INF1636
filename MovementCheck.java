import java.awt.Point;
import java.util.ArrayList;

public class MovementCheck {
	public Token isAToken(int x, int y, ArrayList<Token> tokenList){
		int position;
		String cor;
		Trajeto thisPath = null;
		/*
		 *  Checar se o x e o y são correspondetes a algum token q está em jogo
		 */
		for(Token tok : tokenList){
			cor = tok.getColor();
			position = tok.getPosition();
			switch(cor){
			case "Verde": thisPath = Token.greenpath; break;
			case "Vermelho": thisPath = Token.redpath; break;
			case "Amarelo": thisPath = Token.yellowpath; break;
			case "Azul": thisPath = Token.bluepath; break;
			default :;
			}
			if(((x >= thisPath.path.get(position).x) && (x < thisPath.path.get(position).x + 20)) && 
					((y >= thisPath.path.get(position).y) && (y < thisPath.path.get(position).y + 20))){
				return tok;
			}
		}
		System.out.println("Isso não é uma peça");
		return null;
	}
}
