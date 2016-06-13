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
	

	ArrayList<Token> greenList = new ArrayList<Token>();
	ArrayList<Token> redList = new ArrayList<Token>();
	ArrayList<Token> blueList = new ArrayList<Token>();
	ArrayList<Token> yellowList = new ArrayList<Token>();

	
	Jogador green = new Jogador("Verde");
	Jogador red = new Jogador("Vermelho");
	Jogador blue = new Jogador("Azul");
	Jogador yellow = new Jogador("Amarelo");

	
	CasaFinal finalHome = new CasaFinal();
	
	QuadradoGrande initialHome = new QuadradoGrande();
	
	
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
			
			initialHome.Print(g);

			finalHome.print(g);
			
			
			for(Token t:Token.gameTokens){
				if(t.inGame){
				t.printToken(g);
				}
			}

		}
	}

	private void initUI() {

		ArrayList<Trajeto> ListaTrajetos = new ArrayList<Trajeto>();
		ListaTrajetos.add(new Trajeto("Verde"));
		ListaTrajetos.add(new Trajeto("Azul"));
		ListaTrajetos.add(new Trajeto("Vermelho"));
		ListaTrajetos.add(new Trajeto("Amarelo"));
		
		green.setTurn(true);
		for(int i = 0; i < 4; i ++)
		{
			Token greenT = new Token("Verde");
			greenT.attach(green);
			greenT.attach(finalHome);
			greenT.attach(initialHome);
			greenList.add(i, greenT);
			
			
			Token redT = new Token("Vermelho");
			redT.attach(red);
			redT.attach(finalHome);
			redT.attach(initialHome);
			redList.add(i, redT);
			
			Token blueT = new Token("Azul");
			blueT.attach(blue);
			blueT.attach(finalHome);
			blueT.attach(initialHome);
			blueList.add(i, blueT);
			
			Token yellowT = new Token("Amarelo");
			yellowT.attach(yellow);
			yellowT.attach(finalHome);
			yellowT.attach(initialHome);
			yellowList.add(i, yellowT);
		}

		greenList.get(0).add();
		redList.get(0).add();
		blueList.get(0).add();
		yellowList.get(0).add();

		// criar tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		// caracteristicas do jframe
		setTitle("Ludo Game");
		setSize(420, 340); // Tive que ajustar manualmente o tamanho do JFRAME

		JPanel PainelDireito = new JPanel();

		JButton buttDado = new JButton("Jogar Dado");
		JButton buttInsereToken = new JButton("Inserir Peça");
		JButton buttPassaVez = new JButton("Passar a vez");

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
		LudoFachada lf = new LudoFachada();
		PainelDireito.add(buttInsereToken);
		buttInsereToken.setEnabled(false);
		buttPassaVez.setEnabled(true);
		PainelDireito.add(buttPassaVez);
		buttDado.setBackground(Jogador.getColorAtual());
		buttDado.setForeground(Color.black);
		
		buttDado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Dado dice = Dado.getDado();
				lf.jogarDado();
				ImageIcon dadoimg = dice.getImage();

				dadolabel.setIcon(dadoimg);
				PainelDireito.add(dadolabel);
				buttDado.setEnabled(false);
				Jogador j = Jogador.playerTurn();
				System.out.println("Jogador da vez é o " + j.getColor());
				if (dice.getNumber() == 5 && regrasdojogo.isHouseFree(j.getColor())) {
					buttInsereToken.setEnabled(true);
				}
				System.out.println("Dado n é 5 " + "Jogador da vez é " + j.getColor());
				tabuleiro.addMouseListener(new mouseHandler() {
					@Override
					public void mouseClicked(MouseEvent e) {
						buttInsereToken.setEnabled(false);
						if (!buttDado.isEnabled()) {
							int x = e.getX();
							int y = e.getY();
							if (lf.clickToken(x, y)) {
								buttDado.setEnabled(true);
								if (dice.getNumber() != 6) {
									Jogador j = Jogador.playerTurn();
									j.changeTurn();
								}
								if(regrasdojogo.gameFinished()){
									Popup.infoBox(regrasdojogo.finalScore(Jogador.players), "Fim de Jogo");
								}
							}
							System.out.println("x = " + x + " y = " + y);
						}
						buttDado.setBackground(Jogador.getColorAtual());
						buttDado.setForeground(Color.black);
						revalidate();
						repaint();
					}

				});
				revalidate();
				repaint();
			}
			
		});
		buttInsereToken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Jogador j = Jogador.playerTurn();
				buttInsereToken.setEnabled(false);

				System.out.println("about to add next token of the player " + j.getColor());
				Token.addNext(j.getColor());

				buttDado.setEnabled(true);
				j.changeTurn();
				buttDado.setBackground(Jogador.getColorAtual());
				buttDado.setForeground(Color.black);
				revalidate();
				repaint();
			}
		});
		buttPassaVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Jogador j = Jogador.playerTurn();
				buttInsereToken.setEnabled(false);

				buttDado.setEnabled(true);
				j.changeTurn();
				buttDado.setBackground(Jogador.getColorAtual());
				buttDado.setForeground(Color.black);
				revalidate();
				repaint();
			}
		});
		// System.out.println("Fora do button listener");
		PainelDireito.add(buttDado);

		// Adicionar o painel direito ao JFrame
		this.add(PainelDireito);

		// Saida Padrao
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public class mouseHandler implements MouseListener {

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
