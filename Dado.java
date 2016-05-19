import java.util.Random;
public class Dado {
	private int number;
	Random r = new Random();
	public Dado(){
	}
	// retorna um número aleatóriamente gerado entre (1,6)
	public int newNumber()
	{
		this.number = (r.nextInt()%6) + 1;
		return this.number;
	}
	
}
