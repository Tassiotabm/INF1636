import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
public class Dado {
	private int number;
	Random r = new Random();
	Vector<ImageIcon> faces = new Vector<ImageIcon>();
	
	public Dado(){
		faces.add(new ImageIcon("images/dice1.png"));
		faces.add(new ImageIcon("images/dice2.png"));
		faces.add(new ImageIcon("images/dice3.png"));
		faces.add(new ImageIcon("images/dice4.png"));
		faces.add(new ImageIcon("images/dice5.png"));
		faces.add(new ImageIcon("images/dice6.png"));
		
	}
	// retorna um número aleatóriamente gerado entre (1,6)
	public int newNumber()
	{
		this.number = Math.abs((r.nextInt()%6)) + 1;
		return this.number;
	}
	public int getNumber(){
		return this.number;
	}
	
}
