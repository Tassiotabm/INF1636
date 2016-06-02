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
			QuadradoGrande GGREEN = new QuadradoGrande(0,0,"Verde");
			GGREEN.Print(g);
			//pintar Gquadrado Red
			QuadradoGrande GRED = new QuadradoGrande(180,0,"Vermelho");
			GRED.Print(g);
			//pintar Gquadrado Yellow
			QuadradoGrande GYELLOW = new QuadradoGrande(0,180,"Amarelo");
			GYELLOW.Print(g);
			//pintar Gquadrado Blue
			QuadradoGrande GBLUE = new QuadradoGrande(180,180,"Azul");
			GBLUE.Print(g);
			
			// Casas de chegada
			CasaFinal greenHome = new CasaFinal("Verde");
			CasaFinal redHome = new CasaFinal("Vermelho");
			CasaFinal yellowHome = new CasaFinal("Amarelo");
			CasaFinal blueHome = new CasaFinal("Azul");
			
			// 1 token na casa verde
			greenHome.addToken();
			
			// 2 token na casa vermelha
			redHome.addToken();
			redHome.addToken();
			// 3 token na casa amarela
			yellowHome.addToken();
			yellowHome.addToken();
			yellowHome.addToken();
			
			// 4 token na casa azul
			blueHome.addToken();
			blueHome.addToken();
			blueHome.addToken();
			blueHome.addToken();
			
			//print homes
			greenHome.print(g);
			redHome.print(g);
			yellowHome.print(g);
			blueHome.print(g);
		

			
			//imprimir as pe�as
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
        setSize(420,340);  // Tive que ajustar manualmente o tamanho do JFRAME para o bot�o Jogar Dado ficar de boa.
        
        JPanel PainelDireito = new JPanel();     

        // Criar Botao Dado (Podemos Mudar para chamar a classe Dado e nela criar o bot�o....
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
        
        // Trajetos das pe�as
        //Trajeto greenPath = new Trajeto("Verde"); //Cria um trajeto dos tokens verdes
        //Trajeto bluePath = new Trajeto("Azul"); //Cria um trajeto dos tokens azuis
        //Tokens Label
        //JLabel greenTokenLabel = new JLabel(new Token("Verde").token); //JLabel possui a imagem do token verde como �cone
        //JLabel blueTokenLabel = new JLabel(new Token("Azul").token); //JLabel possue a imagem do token azul como �cone
        
        //blueTokenLabel.setLocation(bluePath.path.get(0)); // Ponto inicial do trajeto azul
        //greenTokenLabel.setLocation(greenPath.path.get(0)); //ponto inicial do trajeto verde
        

        // Saida Padrao
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
