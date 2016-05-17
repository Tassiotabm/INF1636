import java.util.ArrayList;

/* A ideia é ter uma lista de OBJETOS da classe Trajetos, onde nesse trajeto possuimos a 
 * "posicao" do quadrado no Frame. 
 * 
 * Cada Trajeto possui uma cor que determina a qual trajeto ela pertence e a lista possui o caminho
 * que a peça da cor do trajeto deve seguir.*/
public class Trajetos extends ArrayList{

	private int px;
	private int py;
	private String cores;
	
	public void Init_Trajetos()
	{
		/* Deve ser ajustada cada uma das coordenadas X e Y abaixo]
		 * */
		Trajetos Green = NewTrajetos(0,0,"Verde");
		Trajetos Red = NewTrajetos(0,0,"Vermelho");
		Trajetos Yellow = NewTrajetos(0,0,"Amarelo");
		Trajetos Blue = NewTrajetos(0,0,"Azul");		
		
		ArrayList<Trajetos> Verdes = new ArrayList<Trajetos>();
		ArrayList<Trajetos> Vermelho = new ArrayList<Trajetos>();
		ArrayList<Trajetos> Amarelo = new ArrayList<Trajetos>();
		ArrayList<Trajetos> Azul = new ArrayList<Trajetos>();
		
		Verdes.add(0,Green);
		Vermelho.add(0,Red);
		Amarelo.add(0,Yellow);
		Azul.add(0,Blue);
		
		/*É nesse for que vai ser necessário os um milhao de ifs*/
		for(int i=1;i<32;i++)
			Verdes.add(i,NewTrajetos(i*10,i*20,"Verde"));
		
		/*É nesse for que vai ser necessário os um milhao de ifs*/
		for(int i=1;i<32;i++)
			Azul.add(i,NewTrajetos(i*10,i*20,"Azul"));
		
		/*É nesse for que vai ser necessário os um milhao de ifs*/
		for(int i=1;i<32;i++)
			Amarelo.add(i,NewTrajetos(i*10,i*20,"Amarelo"));
		
		/*É nesse for que vai ser necessário os um milhao de ifs*/
		for(int i=1;i<32;i++)
			Vermelho.add(i,NewTrajetos(i*10,i*20,"Vermelho"));
	}
	
	public Trajetos NewTrajetos(int x, int y, String cor)
	{
		Trajetos a = new Trajetos();
		a.px = x;
		a.py = y;
		a.cores = cor;
		return a;
	}
	
}
