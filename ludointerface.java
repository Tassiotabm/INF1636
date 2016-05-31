import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Point;

public class Ludointerface extends JFrame {
	
	static int valor_dado = 0;
	static int vez_do_jogador = 0;
	static int index1 = 0;
	static int index2 = 0;
	public Ludointerface()
	{
		initUI();
	}

	class Tabuleiro extends JPanel{

		public void paintComponent(Graphics g){			

			//Pintar Pquadrados brancos na vertical
			int i,j;
			for(i=0;i<15;i++)
			{
				for(j=0;j<3;j++)
				{
					Graphics2D gbp = (Graphics2D)g;
					if( (i==1 && j==1) || (i==1 && j==2) || (6 > i && i > 1 && j == 1) )
						gbp.setPaint(Color.red);
					else if( (i==13 && j==0) || (i==13 && j==1) || (14 > i && i > 8 && j == 1) )
						gbp.setPaint(Color.yellow);
					else if( (i==1 && j == 0) || (i==13 && j == 2 ))
						gbp.setPaint(Color.black);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(120+j*20,i*20,20,20); //coluna linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(120+j*20,i*20,20,20);
				}
			}
			//Pintar Pquadrados brancos na horizontal
			for(i=0;i<3;i++)
			{
				for(j=0;j<15;j++)
				{
					Graphics2D gbp = (Graphics2D)g;
					if( (i==0 && j==1) || (i==1 && j==1) || (6 > j && j > 1 && i == 1) )
						gbp.setPaint(Color.green);
					else if( (i==2 && j==13) || (i==1 && j==13) || (14 > j && j > 8 && i == 1) )
						gbp.setPaint(Color.blue);
					else if( (i==2 && j == 1) || (i==0 && j == 13 ))
						gbp.setPaint(Color.black);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(j*20,120+i*20,20,20); //coluna linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(j*20,120+i*20,20,20);
				}
			}
			
			//pintar Gquadrado Green
			QuadradoGrande GGREEN = new QuadradoGrande(0,0,g,"green");
			//pintar Gquadrado Red
			QuadradoGrande GRED = new QuadradoGrande(180,0,g, "red");
			//pintar Gquadrado Yellow
			QuadradoGrande GYELLOW = new QuadradoGrande(0,180,g,"yellow");
			//pintar Gquadrado Blue
			QuadradoGrande GBLUE = new QuadradoGrande(180,180,g,"blue");
			
			/*
			 * Path2D.Double triangle = new Path2D.Double(); triangle.moveTo(x1,
			 * y1); triangle.pathTo(x2, y2); triangle.pathTo(x3, y3);
			 * triangle.closePath(); g2d.fill(triangle);
			 */

			// pintar triângulo 1 Green
			Graphics2D t1 = (Graphics2D) g;
			t1.setPaint(Color.green);
			Path2D.Double triangle = new Path2D.Double();
			triangle.moveTo(120, 120);
			triangle.lineTo(120, 180);
			triangle.lineTo(150, 150);
			triangle.closePath();
			t1.fill(triangle);
			// pintar triângulo 2 Red
			Graphics2D t2 = (Graphics2D) g;
			t2.setPaint(Color.red);
			Path2D.Double triangle2 = new Path2D.Double();
			triangle2.moveTo(120, 120);
			triangle2.lineTo(180, 120);
			triangle2.lineTo(150, 150);
			triangle2.closePath();
			t2.fill(triangle2);
			// g.drawPolygon(new int[] {120, 180, 150}, new int[] {120, 120,
			// 150}, 3);
			// pintar triângulo 3 Blue
			Graphics2D t3 = (Graphics2D) g;
			t3.setPaint(Color.blue);
			Path2D.Double triangle3 = new Path2D.Double();
			triangle3.moveTo(180, 120);
			triangle3.lineTo(180, 180);
			triangle3.lineTo(150, 150);
			triangle3.closePath();
			t3.fill(triangle3);
			// g.drawPolygon(new int[] {180, 180, 150}, new int[] {120, 180,
			// 150}, 3);
			// pintar triângulo 4 Yellow
			Graphics2D t4 = (Graphics2D) g;
			t4.setPaint(Color.yellow);
			Path2D.Double triangle4 = new Path2D.Double();
			triangle4.moveTo(120, 180);
			triangle4.lineTo(180, 180);
			triangle4.lineTo(150, 150);
			triangle4.closePath();
			t4.fill(triangle4);

			// Desenhar os Círculos Verdes
			Circulos Green1Big = new Circulos(15,15,g,"G");
			Circulos Green1Small = new Circulos(18,18,g,"S");
			Circulos Green2Big = new Circulos(75,15,g,"G");
			Circulos Green2Small = new Circulos(78,18,g,"S");
			Circulos Green3Big = new Circulos(15,75,g,"G");
			Circulos Green3Small = new Circulos(18,78,g,"S");
			Circulos Green4Big = new Circulos(75,75,g,"G");
			Circulos Green4Small = new Circulos(78,78,g,"S");
			//Desenhar Círculos Vermelhos
			Circulos Red1Big = new Circulos(195,15,g,"R");
			Circulos Red1Small = new Circulos(198,18,g,"S");
			Circulos Red2Big = new Circulos(255,15,g,"R");
			Circulos Red2Small = new Circulos(258,18,g,"S");
			Circulos Red3Big = new Circulos(195,75,g,"R");
			Circulos Red3Small = new Circulos(198,78,g,"S");
			Circulos Red4Big = new Circulos(255,75,g,"R");
			Circulos Red4Small = new Circulos(258,78,g,"S");
			//Dsenhar Circulos Azuis
			
			
			// Green3 Big
			Graphics2D gEllipseGreen3=(Graphics2D) g;
			gEllipseGreen3.setPaint(Color.green);
			// Green4 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseGreen4=(Graphics2D) g;
			gEllipseGreen4.setPaint(Color.black);
			
		
			// Desenhar os Círculos Amarelos
			
			// Yellow1 Big
			Graphics2D gEllipseYellow1=(Graphics2D) g;
			gEllipseYellow1.setPaint(Color.yellow);
			Ellipse2D ey1 = new Ellipse2D.Double(15,195,30,30);
			gEllipseYellow1.fill(ey1);
			g.setColor(Color.black);
			g.drawOval(15,195,30,30);
			// Yellow2 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseYellow2=(Graphics2D) g;
			gEllipseYellow2.setPaint(Color.black);
			Ellipse2D ey2 = new Ellipse2D.Double(18,198,24,24);
			gEllipseYellow2.fill(ey2);
			g.setColor(Color.black);
			g.drawOval(18,198,24,24);
			
			// Yellow3 Big
			Graphics2D gEllipseYellow3=(Graphics2D) g;
			gEllipseYellow3.setPaint(Color.yellow);
			Ellipse2D ey3 = new Ellipse2D.Double(75,195,30,30);
			gEllipseGreen3.fill(ey3);
			g.setColor(Color.black);
			g.drawOval(75,195,30,30);
			// Yellow4 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseYellow4=(Graphics2D) g;
			gEllipseYellow4.setPaint(Color.black);
			Ellipse2D ey4 = new Ellipse2D.Double(78,198,24,24);
			gEllipseYellow4.fill(ey4);
			g.setColor(Color.black);
			g.drawOval(78,198,24,24);
			
			// Yellow5 Big
			Graphics2D gEllipseYellow5=(Graphics2D) g;
			gEllipseYellow5.setPaint(Color.yellow);
			Ellipse2D ey5 = new Ellipse2D.Double(15,255,30,30);
			gEllipseYellow5.fill(ey5);
			g.setColor(Color.black);
			g.drawOval(15,255,30,30);
			// Yellow6 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseYellow6=(Graphics2D) g;
			gEllipseYellow6.setPaint(Color.black);
			Ellipse2D ey6 = new Ellipse2D.Double(18,258,24,24);
			gEllipseYellow6.fill(ey6);
			g.setColor(Color.black);
			g.drawOval(18,258,24,24);
			
			// Yellow7 Big
			Graphics2D gEllipseYellow7=(Graphics2D) g;
			gEllipseYellow7.setPaint(Color.yellow);
			Ellipse2D ey7 = new Ellipse2D.Double(75,255,30,30);
			gEllipseYellow7.fill(ey7);
			g.setColor(Color.black);
			g.drawOval(75,255,30,30);
			// Green8 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseYellow8=(Graphics2D) g;
			gEllipseYellow8.setPaint(Color.black);
			Ellipse2D ey8 = new Ellipse2D.Double(78,258,24,24);
			gEllipseYellow8.fill(ey8);
			g.setColor(Color.black);
			g.drawOval(78,258,24,24);
			
			//Desenhar Círculos Azuis
			
			// Blue1 Big
			Graphics2D gEllipseBlue1=(Graphics2D) g;
			gEllipseBlue1.setPaint(Color.blue);
			Ellipse2D eb1 = new Ellipse2D.Double(195,195,30,30);
			gEllipseBlue1.fill(eb1);
			g.setColor(Color.black);
			g.drawOval(195,195,30,30);
			// Blue2 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseBlue2=(Graphics2D) g;
			gEllipseBlue2.setPaint(Color.black);
			Ellipse2D eb2 = new Ellipse2D.Double(198,198,24,24);
			gEllipseBlue2.fill(eb2);
			g.setColor(Color.black);
			g.drawOval(198,198,24,24);
			
			// Blue3 Big
			Graphics2D gEllipseBlue3=(Graphics2D) g;
			gEllipseBlue3.setPaint(Color.blue);
			Ellipse2D eb3 = new Ellipse2D.Double(255,195,30,30);
			gEllipseBlue3.fill(eb3);
			g.setColor(Color.black);
			g.drawOval(255,195,30,30);
			// Blue4 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseBlue4=(Graphics2D) g;
			gEllipseBlue4.setPaint(Color.black);
			Ellipse2D eb4 = new Ellipse2D.Double(258,198,24,24);
			gEllipseBlue4.fill(eb4);
			g.setColor(Color.black);
			g.drawOval(258,198,24,24);
			
			// Blue5 Big
			Graphics2D gEllipseBlue5=(Graphics2D) g;
			gEllipseBlue5.setPaint(Color.blue);
			Ellipse2D eb5 = new Ellipse2D.Double(195,255,30,30);
			gEllipseBlue5.fill(eb5);
			g.setColor(Color.black);
			g.drawOval(195,255,30,30);
			// Blue6 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseBlue6=(Graphics2D) g;
			gEllipseBlue6.setPaint(Color.black);
			Ellipse2D eb6 = new Ellipse2D.Double(198,258,24,24);
			gEllipseBlue6.fill(eb6);
			g.setColor(Color.black);
			g.drawOval(198,258,24,24);
			
			// Blue7 Big
			Graphics2D gEllipseBlue7=(Graphics2D) g;
			gEllipseBlue7.setPaint(Color.blue);
			Ellipse2D eb7 = new Ellipse2D.Double(255,255,30,30);
			gEllipseBlue7.fill(eb7);
			g.setColor(Color.black);
			g.drawOval(255,255,30,30);
			// Blue8 Small (T(x,y,r,r) = (x+3, y+3, r-6, r-6))
			Graphics2D gEllipseBlue8=(Graphics2D) g;
			gEllipseBlue8.setPaint(Color.black);
			Ellipse2D eb8 = new Ellipse2D.Double(258,258,24,24);
			gEllipseBlue8.fill(eb8);
			g.setColor(Color.black);
			g.drawOval(258,258,24,24);
			
			//imprimir as peças
			// Como funciona: 
			// Quando dermos validate, na chamada do botao, temos que "ativar a criacao dos pinos. mas como?
			// Vamos deixar uma variavel para receber o valor jogado do dado, caso exista alguma valor, a jogada
			// foi realizada. Assim ela entra para colocar os icones o JFRAME.
			
			Trajeto greenPath = new Trajeto("Verde"); //Cria um trajeto dos tokens verdes
	        Trajeto yellowPath = new Trajeto("Amarelo"); //Cria um trajeto dos tokens azuis
	        Ellipse2D CirculoTeste2 = new Ellipse2D.Double(greenPath.path.get(index1).x,greenPath.path.get(index1).y,20,20);
	        Ellipse2D CirculoTeste4 = new Ellipse2D.Double(yellowPath.path.get(index2).x,yellowPath.path.get(index2).y,20,20);
	        Graphics2D CirculoTeste = (Graphics2D) g;
	        Graphics2D CirculoTeste3 = (Graphics2D) g;
	        System.out.println(" Valor do dado = " + valor_dado);
			if (valor_dado > 0)
			{
				if( (vez_do_jogador%2) == 0)
				{
					index1=index1+valor_dado;
					CirculoTeste.setPaint(Color.GREEN);
					CirculoTeste2.setFrame(greenPath.path.get(index1).x, greenPath.path.get(index1).y, 20, 20);
					// a ideia eh usar o tx1 e o ty1 obtidos do tabuleiro
					//Ellipse2D CirculoTeste2 = new Ellipse2D.Double(tx1,ty1,40,40);
					CirculoTeste.fill(CirculoTeste2);
					CirculoTeste.setPaint(Color.black);
					CirculoTeste.drawOval(greenPath.path.get(index1).x, greenPath.path.get(index1).y, 20, 20);
					CirculoTeste.setPaint(Color.yellow);
					CirculoTeste3.fill(CirculoTeste4);
					CirculoTeste.setPaint(Color.black);
					CirculoTeste.drawOval(yellowPath.path.get(index2).x,yellowPath.path.get(index2).y,20,20);
					vez_do_jogador++;
				}
				else
				{
					index2=index2+valor_dado;
					CirculoTeste3.setPaint(Color.YELLOW);
					CirculoTeste4.setFrame(yellowPath.path.get(index2).x,yellowPath.path.get(index2).y,20,20);
					CirculoTeste3.fill(CirculoTeste4);
					CirculoTeste.setPaint(Color.black);
					CirculoTeste.drawOval(yellowPath.path.get(index2).x,yellowPath.path.get(index2).y,20,20);
					CirculoTeste.setPaint(Color.green);
					CirculoTeste.fill(CirculoTeste2);
					CirculoTeste.setPaint(Color.black);
					CirculoTeste.drawOval(greenPath.path.get(index1).x, greenPath.path.get(index1).y, 20, 20);

					vez_do_jogador++;
				}
				valor_dado = 0;
			}

			
		}
	}
	private void initUI(){
		
		ArrayList<Trajeto> ListaTrajetos = new ArrayList<Trajeto>();
		ListaTrajetos.add(new Trajeto("Verde"));
		ListaTrajetos.add(new Trajeto("Azul"));
		ListaTrajetos.add(new Trajeto("Vermelho"));
		ListaTrajetos.add(new Trajeto("Amarelo"));
		
		// criar tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();	
		// caracteristicas do jframe
        setTitle("Ludo Game");
        setSize(420,340);  // Tive que ajustar manualmente o tamanho do JFRAME para o botão Jogar Dado ficar de boa.
        
        JPanel PainelDireito = new JPanel();     

        // Criar Botao Dado (Podemos Mudar para chamar a classe Dado e nela criar o botão....
        JButton buttDado = new JButton("Jogar Dado");
        
        // Imprimir no ContentPane o tabuleiro
        getContentPane().add(tabuleiro);

        // criar os boxlayout
        BoxLayout BlocoPrincipal = new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS);
        BoxLayout SubBloco = new BoxLayout(PainelDireito,  BoxLayout.Y_AXIS);
        
        // ajustar o JPanel que fica dentro do boxlayout
        PainelDireito.setAlignmentY(TOP_ALIGNMENT);
        PainelDireito.setLayout(SubBloco);
        setLayout(BlocoPrincipal); //adicionar ao JFRAME o layout do boxlayout que contem o JPanel do tabuleiro e do botao
        
         //Image image = dadoimg.getImage(); //RESIZE IMAGE
        //Image newimage = image.getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH);
        //dadoimg = new ImageIcon(newimage);
        //ImageIcon dadoimg = new ImageIcon(img);
       // ImageIcon dadoimg = new ImageIcon("images/dice6.png");
        JLabel dadolabel = new JLabel();
       buttDado.addActionListener(new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent event) {
       	     Dado dice = new Dado();
    	     int _throw = dice.newNumber();
    	     valor_dado = dice.getNumber();
    	     System.out.println("Valor o dado dentro do initUI = " + valor_dado);
    	     ImageIcon dadoimg = new ImageIcon();
    	     switch(_throw){
    	     case 1: dadoimg = dice.faces.elementAt(0);
    	     	break;
    	     case 2: dadoimg = dice.faces.elementAt(1);
    	     	break;
    	     case 3: dadoimg = dice.faces.elementAt(2);
 	     		break;
    	     case 4: dadoimg = dice.faces.elementAt(3);
 	     		break;
    	     case 5: dadoimg = dice.faces.elementAt(4);
    	     	break;
    	     case 6: dadoimg = dice.faces.elementAt(5);
	     		break;
	     	default :;
    	     }
    	     dadolabel.setIcon(dadoimg);
    	     PainelDireito.add(dadolabel);   
    	     revalidate();
    	     repaint();
    	   }

    	 });
       // JLabel dadolabel = new JLabel("", dadoimg, JLabel.CENTER);
      // repaint();
        PainelDireito.add(buttDado);	  
       // PainelDireito.add(dadolabel);  
        
        // Adicionar o painel direito ao JFrame 
        this.add(PainelDireito);
        
        // Trajetos das peças
        Trajeto greenPath = new Trajeto("Verde"); //Cria um trajeto dos tokens verdes
        Trajeto bluePath = new Trajeto("Azul"); //Cria um trajeto dos tokens azuis
        //Tokens Label
        JLabel greenTokenLabel = new JLabel(new Token("Verde").token); //JLabel possui a imagem do token verde como ícone
        JLabel blueTokenLabel = new JLabel(new Token("Azul").token); //JLabel possue a imagem do token azul como ícone
        
        blueTokenLabel.setLocation(bluePath.path.get(0)); // Ponto inicial do trajeto azul
        greenTokenLabel.setLocation(greenPath.path.get(0)); //ponto inicial do trajeto verde
        

        // Saida Padrao
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
