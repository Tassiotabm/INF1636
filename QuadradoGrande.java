import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class QuadradoGrande {

	private int x;
	private int y;
	private String Cor;
	private int QntPecas;
	
	public QuadradoGrande(int x1,int y1,String cor)
	{
		x = x1;
		y = y1;
		Cor = cor;
		QntPecas = 4;
	}
	public void RemovePeca(){
		QntPecas--;
	}
	public void AdicionarPeca(){
		QntPecas++;
	}
	public void Print(Graphics G)
	{
		Graphics2D g = (Graphics2D) G;
		if(Cor == "Vermelho"){
			g.setPaint(Color.red);
			Rectangle2D g2 =new Rectangle2D.Double(x,y,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
			if(QntPecas>0){
				Circulos Red1Big = new Circulos(195,15,g,"Vermelho");
				Circulos Red1Small = new Circulos(198,18,g,"Preto");}
			if(QntPecas>1){
				Circulos Red2Big = new Circulos(255,15,g,"Vermelho");
				Circulos Red2Small = new Circulos(258,18,g,"Preto");}
			if(QntPecas>2){
				Circulos Red3Big = new Circulos(195,75,g,"Vermelho");
				Circulos Red3Small = new Circulos(198,78,g,"Preto");}
			if(QntPecas>3){
				Circulos Red4Big = new Circulos(255,75,g,"Vermelho");
				Circulos Red4Small = new Circulos(258,78,g,"Preto");}
			}
		else if(Cor == "Amarelo"){
			g.setPaint(Color.yellow);
			Rectangle2D g2 =new Rectangle2D.Double(x,y,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
			if(QntPecas>0){
				Circulos Yellow1Big = new Circulos(15,195,g,"Amarelo");
				Circulos Yellow1Small = new Circulos(18,198,g,"Preto");}
			if(QntPecas>1){
				Circulos Yellow2Big = new Circulos(75,195,g,"Amarelo");
				Circulos Yellow2Small = new Circulos(78,198,g,"Preto");}
			if(QntPecas>2){
				Circulos Yellow3Big = new Circulos(15,255,g,"Amarelo");
				Circulos Yellow3Small = new Circulos(18,258,g,"Preto");}
			if(QntPecas>3){
				Circulos Yellow4Big = new Circulos(75,255,g,"Amarelo");
				Circulos Yellow4Small = new Circulos(78,258,g,"Preto");}
			}
		else if(Cor == "Azul"){
			g.setPaint(Color.blue);
			Rectangle2D g2 =new Rectangle2D.Double(x,y,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
			if(QntPecas>0){
				Circulos Blue1Big = new Circulos(195,195,g,"Azul");
				Circulos Blue1Small = new Circulos(198,198,g,"Preto");
			}
			if(QntPecas>1){
				Circulos Blue2Big = new Circulos(255,195,g,"Azul");
				Circulos Blue2Small = new Circulos(258,198,g,"Preto");
			}
			if(QntPecas>2){
				Circulos Blue3Big = new Circulos(195,255,g,"Azul");
				Circulos Blue3Small = new Circulos(198,258,g,"Preto");
			}
			if(QntPecas>3){
				Circulos Blue4Big = new Circulos(255,255,g,"Azul");
				Circulos Blue4Small = new Circulos(258,258,g,"Preto");}
			}
		else if(Cor == "Verde"){ //verde
			g.setPaint(Color.green);
			Rectangle2D g2 =new Rectangle2D.Double(x,y,120,120);				
			g.fill(g2);
			G.setColor(Color.black);
			if(QntPecas>0){
				Circulos Green1Big = new Circulos(15,15,g,"Verde");
				Circulos Green1Small = new Circulos(18,18,g,"Preto");
			}
			if(QntPecas>1){
				Circulos Green2Big = new Circulos(75,15,g,"Verde");
				Circulos Green2Small = new Circulos(78,18,g,"Preto");
			}
			if(QntPecas>2){
				Circulos Green3Big = new Circulos(15,75,g,"Verde");
				Circulos Green3Small = new Circulos(18,78,g,"Preto");
			}
			if(QntPecas>3){
				Circulos Green4Big = new Circulos(75,75,g,"Verde");
				Circulos Green4Small = new Circulos(78,78,g,"Preto");
			}
		}
		G.drawRect(x,y,120,120);
	}
}
