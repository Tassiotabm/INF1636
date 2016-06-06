import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
public class Dado{
	private static Dado dadoSingleton = null;
	private static int number;
	static Vector<ImageIcon> faces = new Vector<ImageIcon>();
	
	private Dado(){
	faces.add(new ImageIcon("images/dice1.png"));
	faces.add(new ImageIcon("images/dice2.png"));
	faces.add(new ImageIcon("images/dice3.png"));
	faces.add(new ImageIcon("images/dice4.png"));
	faces.add(new ImageIcon("images/dice5.png"));
	faces.add(new ImageIcon("images/dice6.png"));
	}
	public static Dado getDado(){
		if(dadoSingleton == null){
			
			dadoSingleton = new Dado();
		}
		return dadoSingleton;
	}
	// retorna um número aleatóriamente gerado entre (1,6)
	public void _throw()
	{
		Random r = new Random();
		this.number = Math.abs((r.nextInt()%6)) + 1;
	}
	public int getNumber(){
		return this.number;
	}
	public ImageIcon getImage(){
		return faces.elementAt(this.number-1);
	}
}
