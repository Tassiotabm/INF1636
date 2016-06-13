import java.awt.Point;
import java.util.ArrayList;

public class regrasdojogo {
	
	private static Dado dice;
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
		Point p = null;
	/*	for (Token t : Token.gameTokens) {
			if (t.getPosition() == 0 && t.getColor() == cor)
				return false;
		}*/
		switch (cor) {
		case "Verde":
			p = Token.greenpath.path.get(0);
			break;
		case "Vermelho":
			p = Token.redpath.path.get(0);
			break;
		case "Azul":
			p = Token.bluepath.path.get(0);
			break;
		case "Amarelo":
			p = Token.yellowpath.path.get(0);
			break;
		}
		for (Jogador j : Jogador.players) {
			for (Token t : j.playerTokens) {
				if (t.inGame && (t.getPath().path.get(t.getPosition()).x == p.x && t.getPath().path.get(t.getPosition()).y == p.y))
					return false;
			}
		}
		return true;
	}
	
	public static boolean isShelterfree(Point p) {
		if (p.x == 20 && p.y == 160) {
			return false;
		} else {
			if (p.x == 120 && p.y == 20) {
				return false;
			} else {
				if (p.x == 260 && p.y == 120) {
					return false;
				} else {
					if (p.x == 160 && p.y == 260) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isHomeFree(Point p) {
		if (p.x == 20 && p.y == 120) {
			return false;
		} else {
			if (p.x == 160 && p.y == 20) {
				return false;
			} else {
				if (p.x == 260 && p.y == 160) {
					return false;
				} else {
					if (p.x == 120 && p.y == 260) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean ableToMove(Token toMove) {
		ArrayList<Token> pT = null;
		dice = Dado.getDado();
		String cor = toMove.getColor();
		for(Jogador j: Jogador.players){
			if(j.getColor() == cor){
				pT = j.getPlayerTokens();
				break;
			}
		}
		//if(toMove.getPosition() + dice.getNumber() == 58)
			//return true;
		for(Token t: pT){
			if(t.getPosition() == toMove.getPosition() + dice.getNumber()){
				if(t.getPosition() == 58)
					return true;
				return false;
			}
		}
		return true;
	}
	
	public static boolean isHomeEmpty(String cor){
		int  countToken = 0;
		switch(cor){
		case "Verde" : countToken = QuadradoGrande.getTokens("Verde"); break;
		case "Vermelho" : countToken = QuadradoGrande.getTokens("Vermelho"); break;
		case "Azul" : countToken = QuadradoGrande.getTokens("Azul"); break;
		case "Amarelo" : countToken = QuadradoGrande.getTokens("Amarelo"); break;
		}
		if(countToken == 0)
			return true;
		else
			return false;
		
	}
	
	public static Token eaeComeu(Token comedor){
		dice = Dado.getDado();
		String cor = comedor.getColor();
		Point p = null;
		switch (cor) {
		case "Verde":
			p = Token.greenpath.path.get(comedor.getPosition() + dice.getNumber());
			break;
		case "Vermelho":
			p = Token.redpath.path.get(comedor.getPosition() + dice.getNumber());
			break;
		case "Azul":
			p = Token.bluepath.path.get(comedor.getPosition() + dice.getNumber());
			break;
		case "Amarelo":
			p = Token.yellowpath.path.get(comedor.getPosition() + dice.getNumber());
			break;
		}
		for (Jogador j : Jogador.players) {
			for (Token t : j.playerTokens) {
				if (t.inGame) {
					System.out.println(t.getPath().path.get(t.getPosition()).toString());
					if (t.getPath().path.get(t.getPosition()).x == p.x && t.getPath().path.get(t.getPosition()).y == p.y ){
						return t;
					}
				}
			}
		}
		return null;
	}
	
	public static boolean finalMove(Token f, int pos){
		
		if(f.getPosition() + pos > 58)
			return false;
		else
		{
			if(f.getPosition() + pos == 58)
				return true;
		}
		return false;
	}
	public static boolean gameFinished(){
		int countToken = 0;
		countToken = CasaFinal.getTokens("Verde");
		if(countToken == 4)
			return true;
		countToken = CasaFinal.getTokens("Vermelho");
		if(countToken == 4)
			return true;
		countToken = CasaFinal.getTokens("Azul");
		if(countToken == 4)
			return true;
		countToken = CasaFinal.getTokens("Amarelo");
		if(countToken == 4)
			return true;
		return false;
	}
	public static String finalScore(ArrayList<Jogador> jogadores){
		int greenScore = 0, redScore = 0, blueScore = 0, yellowScore = 0;
		int maior = 0;
		for(Jogador j:jogadores){
			ArrayList<Token> tokens = j.getPlayerTokens();
			switch(j.getColor())
			{		
			case "Verde" :
				for(Token t:tokens){
					greenScore+=t.getPosition();
				}
				Score green = new Score(j, greenScore);
				break;
			case "Vermelho" :
				for(Token t:tokens){
					redScore+=t.getPosition();
				}
				Score red = new Score(j, redScore);
				break;
			case "Azul" :
				for(Token t:tokens){
					blueScore+=t.getPosition();
				}
				Score blue = new Score(j,blueScore);
				break;
			case "Amarelo" :
				for(Token t:tokens){
					yellowScore+=t.getPosition();
				}
				Score yellow = new Score(j, yellowScore);
				break;
			}
			if(maior < greenScore)
				maior = greenScore;
			else
				if(maior<redScore)
					maior = redScore;
				else
					if(maior<blueScore)
						maior = blueScore;
					else
						if(maior<yellowScore)
							maior = yellowScore;
		} 
		String vencedor = "ninguém";
		String resultado;
		if(maior == greenScore)
			vencedor = "Verde";
			else
				if(maior == redScore)
					vencedor = "Vermelho";
				else
					if(maior == blueScore)
						vencedor = "Azul";
					else
						if(maior == yellowScore)
							vencedor = "Amarelo";
		
		resultado = "Verde : " + greenScore + "Pontos\n" + "Vermelho :" + redScore + "Pontos\n" + "Azul : " + 
						blueScore + "Pontos\n" + "Amarelo : " + yellowScore + "Pontos\n" + "\n O Vencedor é o jogador " + 
							vencedor;
		return resultado;
		}	
}
