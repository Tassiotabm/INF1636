import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class CasaFinal extends Observer {

	private String cor;
	private static int greenTokens;
	private static int redTokens;
	private static int yellowTokens;
	private static int blueTokens;
	

	// Construtor
	public CasaFinal() {
		greenTokens = 0;
		redTokens = 0;
		yellowTokens = 0;
		blueTokens = 0;
	}

	// Adicionar peça
	public void add(String cor) {
		switch (cor) {
		case "Verde":
			greenTokens++;
			break;
		case "Vermelho":
			redTokens++;
			break;
		case "Amarelo":
			yellowTokens++;
			break;
		case "Azul":
			blueTokens++;
			break;
		}
	}

	public static int getTokens(String cor) {
		switch (cor) {
		case "Verde":
			return greenTokens;
		case "Vermelho":
			return redTokens;
		case "Amarelo":
			return yellowTokens;
		case "Azul":
			return blueTokens;
		}
		return -1;
	}

	public void print(Graphics g) {
		// pintar triângulo 1 Green
		Graphics2D t1 = (Graphics2D) g;
		t1.setPaint(Color.green);
		Path2D.Double triangle = new Path2D.Double();
		triangle.moveTo(120, 120);
		triangle.lineTo(120, 180);
		triangle.lineTo(150, 150);
		triangle.closePath();
		t1.fill(triangle);
		if (greenTokens == 1) {
			// uma bolinha no centro
			g.setColor(Color.black);
			g.drawOval(125, 145, 10, 10);
		} else if (greenTokens == 2) {
			// primeira bolinha
			g.drawOval(125, 140, 10, 10);
			// segunda bolinha
			g.drawOval(125, 150, 10, 10);
		} else if (greenTokens == 3) {
			// primeira bolinha
			g.drawOval(120, 140, 10, 10);
			// segunda bolinha
			g.drawOval(120, 150, 10, 10);
			// terceira bolinha
			g.drawOval(130, 145, 10, 10);
		} else if (greenTokens == 4) {
			// primeira bolinha
			g.drawOval(120, 140, 10, 10);
			// segunda bolinha
			g.drawOval(120, 150, 10, 10);
			// terceira bolinha
			g.drawOval(130, 140, 10, 10);
			// quarta bolinha
			g.drawOval(130, 150, 10, 10);
		}
		// pintar triângulo 2 Red
		Graphics2D t2 = (Graphics2D) g;
		t2.setPaint(Color.red);
		Path2D.Double triangle2 = new Path2D.Double();
		triangle2.moveTo(120, 120);
		triangle2.lineTo(180, 120);
		triangle2.lineTo(150, 150);
		triangle2.closePath();
		t2.fill(triangle2);
		g.setColor(Color.black);
		if (redTokens == 1) {
			// uma bolinha no centro
			g.drawOval(145, 125, 10, 10);
		} else if (redTokens == 2) {
			// primeira bolinha
			g.drawOval(140, 125, 10, 10);
			// segunda bolinha
			g.drawOval(150, 125, 10, 10);
		} else if (redTokens == 3) {
			// primeira bolinha
			g.drawOval(140, 120, 10, 10);
			// segunda bolinha
			g.drawOval(150, 120, 10, 10);
			// terceira bolinha
			g.drawOval(145, 130, 10, 10);
		} else if (redTokens == 4) {
			// primeira bolinha
			g.drawOval(140, 120, 10, 10);
			// segunda bolinha
			g.drawOval(150, 120, 10, 10);
			// terceira bolinha
			g.drawOval(140, 130, 10, 10);
			// quarta bolinha
			g.drawOval(150, 130, 10, 10);
		}

		// pintar triângulo 3 Blue
		Graphics2D t3 = (Graphics2D) g;
		t3.setPaint(Color.blue);
		Path2D.Double triangle3 = new Path2D.Double();
		triangle3.moveTo(180, 120);
		triangle3.lineTo(180, 180);
		triangle3.lineTo(150, 150);
		triangle3.closePath();
		t3.fill(triangle3);
		g.setColor(Color.black);
		if (blueTokens == 1) {
			// uma bolinha no centro
			g.drawOval(165, 145, 10, 10);
		} else if (blueTokens == 2) {
			// primeira bolinha
			g.drawOval(165, 140, 10, 10);
			// segunda bolinha
			g.drawOval(165, 150, 10, 10);
		} else if (blueTokens == 3) {
			// primeira bolinha
			g.drawOval(170, 140, 10, 10);
			// segunda bolinha
			g.drawOval(170, 150, 10, 10);
			// terceira bolinha
			g.drawOval(160, 145, 10, 10);
		} else if (blueTokens == 4) {
			// primeira bolinha
			g.drawOval(160, 140, 10, 10);
			// segunda bolinha
			g.drawOval(160, 150, 10, 10);
			// terceira bolinha
			g.drawOval(170, 140, 10, 10);
			// quarta bolinha
			g.drawOval(170, 150, 10, 10);
		}
		// pintar triângulo 4 Yellow
		Graphics2D t4 = (Graphics2D) g;
		t4.setPaint(Color.yellow);
		Path2D.Double triangle4 = new Path2D.Double();
		triangle4.moveTo(120, 180);
		triangle4.lineTo(180, 180);
		triangle4.lineTo(150, 150);
		triangle4.closePath();
		t4.fill(triangle4);
		g.setColor(Color.black);
		if (yellowTokens == 1) {
			// uma bolinha no centro
			g.drawOval(145, 165, 10, 10);
		} else if (yellowTokens == 2) {
			// primeira bolinha
			g.drawOval(140, 165, 10, 10);
			// segunda bolinha
			g.drawOval(150, 165, 10, 10);
		} else if (yellowTokens == 3) {
			// primeira bolinha
			g.drawOval(140, 170, 10, 10);
			// segunda bolinha
			g.drawOval(150, 170, 10, 10);
			// terceira bolinha
			g.drawOval(145, 160, 10, 10);
		} else if (yellowTokens == 4) {
			// primeira bolinha
			g.drawOval(140, 160, 10, 10);
			// segunda bolinha
			g.drawOval(150, 160, 10, 10);
			// terceira bolinha
			g.drawOval(140, 170, 10, 10);
			// quarta bolinha
			g.drawOval(150, 170, 10, 10);
		}
	}
	
	static String printaCasaFinal(){

		String retorno = greenTokens+"\n";
		retorno = retorno+redTokens+"\n";
		retorno = retorno+yellowTokens+"\n";
		retorno = retorno+blueTokens;
		
		return retorno;
	}

	@Override
	public void update() {
		int greenCount = 0;
		int redCount = 0;
		int yellowCount = 0;
		int blueCount = 0;
		for(Token t : Token.gameTokens){
			if(t.getPosition() == 58){
				switch(t.getColor()){
				case "Verde" : greenCount++; break;
				case "Vermelho" : redCount++; break;
				case "Amarelo" : yellowCount++; break;
				case "Azul" : blueCount++; break;
				}
			}
		}
		greenTokens = greenCount;
		redTokens = redCount;
		yellowTokens = yellowCount;
		blueTokens = blueCount;
	}
}
