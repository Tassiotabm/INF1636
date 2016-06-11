import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class CasaFinal {
	
	private String cor;
	private int qtdToken;

	// Construtor
	public CasaFinal(String Cor) {
		this.cor = Cor;
		this.qtdToken = 0;
	}
	// Adicionar peça
	public boolean add(){
		if(qtdToken == 4){ // limite de peças na casa final
			System.out.println("Casa Final cheia, nao ha como adicionar mais tokens");
			return false;
		}
		else{
		qtdToken ++;
		return true;
		}
	}
	
	public int getQtdToken(){
		
		return this.qtdToken;
	}
	public void print(Graphics g){
		switch(this.cor){
		case "Verde" :
		// pintar triângulo 1 Green
				Graphics2D t1 = (Graphics2D) g;
				t1.setPaint(Color.green);
				Path2D.Double triangle = new Path2D.Double();
				triangle.moveTo(120, 120);
				triangle.lineTo(120, 180);
				triangle.lineTo(150, 150);
				triangle.closePath();
				t1.fill(triangle);
				if(this.qtdToken == 1){
					// uma bolinha no centro
					g.setColor(Color.black);
					g.drawOval(125,145,10,10);
				} else if(this.qtdToken == 2){
					//primeira bolinha
					g.drawOval(125,140,10,10);
					// segunda bolinha
					g.drawOval(125,150,10,10);
				}	else if(this.qtdToken == 3){
					//primeira bolinha
					g.drawOval(120,140,10,10);
					// segunda bolinha
					g.drawOval(120,150,10,10);
					// terceira bolinha
					g.drawOval(130,145,10,10);
				}else if(qtdToken == 4){
					//primeira bolinha
					g.drawOval(120,140,10,10);
					// segunda bolinha
					g.drawOval(120,150,10,10);
					// terceira bolinha
					g.drawOval(130,140,10,10);
					// quarta bolinha
					g.drawOval(130,150,10,10);
				}
				break;
		case "Vermelho" :
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
				if(this.qtdToken == 1){
					// uma bolinha no centro
					g.drawOval(145,125,10,10);
				} else if(this.qtdToken == 2){
					//primeira bolinha
					g.drawOval(140,125,10,10);
					// segunda bolinha
					g.drawOval(150,125,10,10);
				}	else if(this.qtdToken == 3){
					//primeira bolinha
					g.drawOval(140,120,10,10);
					// segunda bolinha
					g.drawOval(150,120,10,10);
					// terceira bolinha
					g.drawOval(145,130,10,10);
				}else if(this.qtdToken == 4){
					//primeira bolinha
					g.drawOval(140,120,10,10);
					// segunda bolinha
					g.drawOval(150,120,10,10);
					// terceira bolinha
					g.drawOval(140,130,10,10);
					// quarta bolinha
					g.drawOval(150,130,10,10);
				}
				break;
		case "Azul" : 
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
				if(this.qtdToken == 1){
					// uma bolinha no centro
					g.drawOval(165,145,10,10);
				} else if(this.qtdToken == 2){
					//primeira bolinha
					g.drawOval(165,140,10,10);
					// segunda bolinha
					g.drawOval(165,150,10,10);
				}	else if(this.qtdToken == 3){
					//primeira bolinha
					g.drawOval(170,140,10,10);
					// segunda bolinha
					g.drawOval(170,150,10,10);
					// terceira bolinha
					g.drawOval(160,145,10,10);
				}else if(this.qtdToken == 4){
					//primeira bolinha
					g.drawOval(160,140,10,10);
					// segunda bolinha
					g.drawOval(160,150,10,10);
					// terceira bolinha
					g.drawOval(170,140,10,10);
					// quarta bolinha
					g.drawOval(170,150,10,10);
				}
				break;
		case "Amarelo" : 
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
				if(this.qtdToken == 1){
					// uma bolinha no centro
					g.drawOval(145,165,10,10);
				} else if(this.qtdToken == 2){
					//primeira bolinha
					g.drawOval(140,165,10,10);
					// segunda bolinha
					g.drawOval(150,165,10,10);
				}	else if(this.qtdToken == 3){
					//primeira bolinha
					g.drawOval(140,170,10,10);
					// segunda bolinha
					g.drawOval(150,170,10,10);
					// terceira bolinha
					g.drawOval(145,160,10,10);
				}else if(this.qtdToken == 4){
					//primeira bolinha
					g.drawOval(140,160,10,10);
					// segunda bolinha
					g.drawOval(150,160,10,10);
					// terceira bolinha
					g.drawOval(140,170,10,10);
					// quarta bolinha
					g.drawOval(150,170,10,10);
				}
				break;
				
		default : ;
		}
	}
}
