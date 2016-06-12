import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class CasaFinal extends Observer {

	private String cor;
	private static int greenTokens;
	private static int redTokens;
	private static int yellowTokens;
	private static int blueTokens;
	

	// Construtor
	public CasaFinal() {
		this.greenTokens = 0;
		this.redTokens = 0;
		this.yellowTokens = 0;
		this.blueTokens = 0;
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

	public int getQtdToken(String cor) {
		switch (cor) {
		case "Verde":
			return this.greenTokens;
		case "Vermelho":
			return this.redTokens;
		case "Amarelo":
			return this.yellowTokens;
		case "Azul":
			return this.blueTokens;
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
		if (this.greenTokens == 1) {
			// uma bolinha no centro
			g.setColor(Color.black);
			g.drawOval(125, 145, 10, 10);
		} else if (this.greenTokens == 2) {
			// primeira bolinha
			g.drawOval(125, 140, 10, 10);
			// segunda bolinha
			g.drawOval(125, 150, 10, 10);
		} else if (this.greenTokens == 3) {
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
		if (this.redTokens == 1) {
			// uma bolinha no centro
			g.drawOval(145, 125, 10, 10);
		} else if (this.redTokens == 2) {
			// primeira bolinha
			g.drawOval(140, 125, 10, 10);
			// segunda bolinha
			g.drawOval(150, 125, 10, 10);
		} else if (this.redTokens == 3) {
			// primeira bolinha
			g.drawOval(140, 120, 10, 10);
			// segunda bolinha
			g.drawOval(150, 120, 10, 10);
			// terceira bolinha
			g.drawOval(145, 130, 10, 10);
		} else if (this.redTokens == 4) {
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
		if (this.blueTokens == 1) {
			// uma bolinha no centro
			g.drawOval(165, 145, 10, 10);
		} else if (this.blueTokens == 2) {
			// primeira bolinha
			g.drawOval(165, 140, 10, 10);
			// segunda bolinha
			g.drawOval(165, 150, 10, 10);
		} else if (this.blueTokens == 3) {
			// primeira bolinha
			g.drawOval(170, 140, 10, 10);
			// segunda bolinha
			g.drawOval(170, 150, 10, 10);
			// terceira bolinha
			g.drawOval(160, 145, 10, 10);
		} else if (this.blueTokens == 4) {
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
		if (this.yellowTokens == 1) {
			// uma bolinha no centro
			g.drawOval(145, 165, 10, 10);
		} else if (this.yellowTokens == 2) {
			// primeira bolinha
			g.drawOval(140, 165, 10, 10);
			// segunda bolinha
			g.drawOval(150, 165, 10, 10);
		} else if (this.yellowTokens == 3) {
			// primeira bolinha
			g.drawOval(140, 170, 10, 10);
			// segunda bolinha
			g.drawOval(150, 170, 10, 10);
			// terceira bolinha
			g.drawOval(145, 160, 10, 10);
		} else if (this.yellowTokens == 4) {
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
		this.greenTokens = greenCount;
		this.redTokens = redCount;
		this.yellowTokens = yellowCount;
		this.blueTokens = blueCount;
	}
}
