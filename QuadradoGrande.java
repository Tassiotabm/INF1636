import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class QuadradoGrande extends Observer {

	private String Cor;
	private static int greenTokens;
	private static int redTokens;
	private static int yellowTokens;
	private static int blueTokens;
	
	public QuadradoGrande()
	{
		greenTokens = 3;
		redTokens = 3;
		yellowTokens = 3;
		blueTokens = 3;
	}
	public void remove(String cor){
		switch(cor){
		case "Verde": greenTokens--; break;
		case "Vermelho": redTokens--; break;
		case "Amarelo": yellowTokens--; break;
		case "Azul": blueTokens--; break;
		}
	}
	public void add(String cor){
		switch(cor){
		case "Verde": greenTokens++; break;
		case "Vermelho": redTokens++; break;
		case "Amarelo": yellowTokens++; break;
		case "Azul": blueTokens++; break;
		}
	}
	public static int getTokens(String cor){
		switch(cor){
		case "Verde": return greenTokens; 
		case "Vermelho": return redTokens; 
		case "Amarelo": return yellowTokens; 
		case "Azul": return blueTokens; 
		}
		return -1;
	}
	public void Print(Graphics G)
	{
		Graphics2D g = (Graphics2D) G;
			g.setPaint(Color.red);
			Rectangle2D g1 =new Rectangle2D.Double(180,0,120,120);				
			g.fill(g1);
			G.setColor(Color.black);
			if(redTokens>0){
				Circulos Red1Big = new Circulos(195,15,g,"Vermelho");
				Circulos Red1Small = new Circulos(198,18,g,"Preto");
				}
			if(redTokens>1){
				Circulos Red2Big = new Circulos(255,15,g,"Vermelho");
				Circulos Red2Small = new Circulos(258,18,g,"Preto");
				}
			if(redTokens>2){
				Circulos Red3Big = new Circulos(195,75,g,"Vermelho");
				Circulos Red3Small = new Circulos(198,78,g,"Preto");
				}
			if(redTokens>3){
				Circulos Red4Big = new Circulos(255,75,g,"Vermelho");
				Circulos Red4Small = new Circulos(258,78,g,"Preto");
				}
			G.drawRect(180,0,120,120);
			
			g.setPaint(Color.yellow);
			Rectangle2D g2 =new Rectangle2D.Double(0,180,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
			if(yellowTokens>0){
				Circulos Yellow1Big = new Circulos(15,195,g,"Amarelo");
				Circulos Yellow1Small = new Circulos(18,198,g,"Preto");}
			if(yellowTokens>1){
				Circulos Yellow2Big = new Circulos(75,195,g,"Amarelo");
				Circulos Yellow2Small = new Circulos(78,198,g,"Preto");}
			if(yellowTokens>2){
				Circulos Yellow3Big = new Circulos(15,255,g,"Amarelo");
				Circulos Yellow3Small = new Circulos(18,258,g,"Preto");}
			if(yellowTokens>3){
				Circulos Yellow4Big = new Circulos(75,255,g,"Amarelo");
				Circulos Yellow4Small = new Circulos(78,258,g,"Preto");
				}
			G.drawRect(0,180,120,120);
			
			g.setPaint(Color.blue);
			Rectangle2D g3 =new Rectangle2D.Double(180,180,120,120);				
			g.fill(g3);
			G.setColor(Color.black);
			if(blueTokens>0){
				Circulos Blue1Big = new Circulos(195,195,g,"Azul");
				Circulos Blue1Small = new Circulos(198,198,g,"Preto");
			}
			if(blueTokens>1){
				Circulos Blue2Big = new Circulos(255,195,g,"Azul");
				Circulos Blue2Small = new Circulos(258,198,g,"Preto");
			}
			if(blueTokens>2){
				Circulos Blue3Big = new Circulos(195,255,g,"Azul");
				Circulos Blue3Small = new Circulos(198,258,g,"Preto");
			}
			if(blueTokens>3){
				Circulos Blue4Big = new Circulos(255,255,g,"Azul");
				Circulos Blue4Small = new Circulos(258,258,g,"Preto");}
			G.drawRect(180,180,120,120);
			
			g.setPaint(Color.green);
			Rectangle2D g4 =new Rectangle2D.Double(0,0,120,120);				
			g.fill(g4);
			G.setColor(Color.black);
			if(greenTokens>0){
				Circulos Green1Big = new Circulos(15,15,g,"Verde");
				Circulos Green1Small = new Circulos(18,18,g,"Preto");
			}
			if(greenTokens>1){
				Circulos Green2Big = new Circulos(75,15,g,"Verde");
				Circulos Green2Small = new Circulos(78,18,g,"Preto");
			}
			if(greenTokens>2){
				Circulos Green3Big = new Circulos(15,75,g,"Verde");
				Circulos Green3Small = new Circulos(18,78,g,"Preto");
			}
			if(greenTokens>3){
				Circulos Green4Big = new Circulos(75,75,g,"Verde");
				Circulos Green4Small = new Circulos(78,78,g,"Preto");
			}
			G.drawRect(0,0,120,120);
	}
	@Override
	public void update() {
		int greenCount = 0;
		int redCount = 0;
		int yellowCount =0;
		int blueCount = 0;
		for(Token t : Token.gameTokens){
			if(t.getPosition() == -1){
				switch(t.getColor()){
				case "Verde" : greenCount++; break;
				case "Vermelho" : redCount++; break;
				case "Amarelo" : yellowCount++; break;
				case "Azul" : blueCount++; break;
				}
			}
		}
		System.out.println("g = " +  greenCount);
		System.out.println("r = " +  redCount);
		System.out.println("y = " +  yellowCount);
		System.out.println("b = " +  blueCount);
		this.greenTokens = greenCount;
		this.redTokens = redCount;
		this.yellowTokens = yellowCount;
		this.blueTokens = blueCount;
	}
		
}
