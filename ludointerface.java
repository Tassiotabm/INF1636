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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.Point;

public class Ludointerface extends JFrame {
	
	Token green1 = new Token("Verde");
	Token red1 = new Token("Vermelho");
	Token yellow1 = new Token("Amarelo");
	Token blue1 = new Token("Azul");
	
	CasaFinal greenFinal = new CasaFinal("Verde");
	CasaFinal redFinal = new CasaFinal("Vermelho");
	CasaFinal yellowFinal = new CasaFinal("Amarelo");
	CasaFinal blueFinal = new CasaFinal("Azul");
	
	QuadradoGrande GGREEN = new QuadradoGrande(0, 0, "Verde");
	QuadradoGrande GRED = new QuadradoGrande(180, 0, "Vermelho");
	QuadradoGrande GYELLOW = new QuadradoGrande(0, 180, "Amarelo");
	QuadradoGrande GBLUE = new QuadradoGrande(180, 180, "Azul");
	
	public Ludointerface() {
		initUI();
	}

	class Tabuleiro extends JPanel {

		public void paintComponent(Graphics g) {

			// Pintar Pquadrados brancos na vertical
			int i, j;
			for (i = 0; i < 15; i++) {
				for (j = 0; j < 3; j++) {
					Graphics2D gbp = (Graphics2D) g;
					if ((i == 1 && j == 1) || (i == 1 && j == 2) || (6 > i && i > 1 && j == 1))
						gbp.setPaint(Color.red);
					else if ((i == 13 && j == 0) || (i == 13 && j == 1) || (14 > i && i > 8 && j == 1))
						gbp.setPaint(Color.yellow);
					else if ((i == 1 && j == 0) || (i == 13 && j == 2))
						gbp.setPaint(Color.black);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(120 + j * 20, i * 20, 20, 20); // coluna
																								// linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(120 + j * 20, i * 20, 20, 20);
				}
			}
			// Pintar Pquadrados brancos na horizontal
			for (i = 0; i < 3; i++) {
				for (j = 0; j < 15; j++) {
					Graphics2D gbp = (Graphics2D) g;
					if ((i == 0 && j == 1) || (i == 1 && j == 1) || (6 > j && j > 1 && i == 1))
						gbp.setPaint(Color.green);
					else if ((i == 2 && j == 13) || (i == 1 && j == 13) || (14 > j && j > 8 && i == 1))
						gbp.setPaint(Color.blue);
					else if ((i == 2 && j == 1) || (i == 0 && j == 13))
						gbp.setPaint(Color.black);
					else
						gbp.setPaint(Color.WHITE);
					Rectangle2D gb2dr = new Rectangle2D.Double(j * 20, 120 + i * 20, 20, 20); // coluna
																								// linha
					gbp.fill(gb2dr);
					g.setColor(Color.black);
					g.drawRect(j * 20, 120 + i * 20, 20, 20);
				}
			}
			GGREEN.Print(g);
			GRED.Print(g);
			GYELLOW.Print(g);
			GBLUE.Print(g);

			greenFinal.print(g);
			redFinal.print(g);
			yellowFinal.print(g);
			blueFinal.print(g);
			
			
			green1.add(GGREEN);
			red1.add(GRED);
			yellow1.add(GYELLOW);
			blue1.add(GBLUE);
			
			for(Token t:Token.inGameTokens){
				t.printToken(g);
			}

		}
	}

	private void initUI() {

		ArrayList<Trajeto> ListaTrajetos = new ArrayList<Trajeto>();
		ListaTrajetos.add(new Trajeto("Verde"));
		ListaTrajetos.add(new Trajeto("Azul"));
		ListaTrajetos.add(new Trajeto("Vermelho"));
		ListaTrajetos.add(new Trajeto("Amarelo"));

		
		// criar tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		// caracteristicas do jframe
		setTitle("Ludo Game");
		setSize(420, 340); // Tive que ajustar manualmente o tamanho do JFRAME

		JPanel PainelDireito = new JPanel();

		JButton buttDado = new JButton("Jogar Dado");

		// Imprimir no ContentPane o tabuleiro
		getContentPane().add(tabuleiro);
		
		// criar os boxlayout
		BoxLayout BlocoPrincipal = new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS);
		BoxLayout SubBloco = new BoxLayout(PainelDireito, BoxLayout.Y_AXIS);

		// ajustar o JPanel que fica dentro do boxlayout
		PainelDireito.setAlignmentY(TOP_ALIGNMENT);
		PainelDireito.setLayout(SubBloco);
		setLayout(BlocoPrincipal); // adicionar ao JFRAME o layout do boxlayout
									// que contem o JPanel do tabuleiro e do
									// botao

		JLabel dadolabel = new JLabel();
		LudoFachada lf= new LudoFachada();
		buttDado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Dado dice = Dado.getDado();
				lf.jogarDado();
				ImageIcon dadoimg= dice.getImage();
				
				dadolabel.setIcon(dadoimg);
				PainelDireito.add(dadolabel);
				
				tabuleiro.addMouseListener(new mouseHandler() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
						int x=e.getX();
					    int y=e.getY();
					    lf.clickToken(x, y);
					    System.out.println("x = "+ x + " y = " + y);
					 //   Component c = e.getComponent();
					  //  System.out.println("Component é " + c.toString()); 
						revalidate();
						repaint();
				    }
				    
				});
				revalidate();
				repaint();
			}
		});

		//System.out.println("Fora do button listener");
		PainelDireito.add(buttDado);

		// Adicionar o painel direito ao JFrame
		this.add(PainelDireito);

		// Saida Padrao
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public class mouseHandler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
