import java.awt.Image;

import javax.swing.ImageIcon;

public class Token {
	private String cor;
	ImageIcon token;
	public Token(String Cor){
		this.cor = Cor;
		Image image;
		Image newimg;
		switch (Cor){
		case "Vermelho":
			token = new ImageIcon("images/redToken.jpg");
			image = token.getImage(); // transform it 
			newimg = image.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			token = new ImageIcon(newimg);  // transform it back
			break;
		case "Verde" :
			token = new ImageIcon("images/greenToken.jpg");
			image = token.getImage(); // transform it 
			newimg = image.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			token = new ImageIcon(newimg);
			break;
		case "Amarelo":
			token = new ImageIcon("images/yellowToken.jpg");
			image = token.getImage(); // transform it 
			newimg = image.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			token = new ImageIcon(newimg);
			break;
		case "Azul" :
			token = new ImageIcon("images/blueToken.jpg");
			image = token.getImage(); // transform it 
			newimg = image.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			token = new ImageIcon(newimg);
			break;
		default:
			token = new ImageIcon("images/blackToken.jpg");
			image = token.getImage(); // transform it 
			newimg = image.getScaledInstance(19, 19,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			token = new ImageIcon(newimg);
			break;
		}
	}
	public Token(){
		this.cor = "Desprovida";
		token = new ImageIcon("images/blackToken.jpg");
	}
}
