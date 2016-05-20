import java.util.ArrayList;

/* A ideia é ter uma lista de OBJETOS da classe Trajetos, onde nesse trajeto possuimos a 
 * "posicao" do quadrado no Frame. 
 * 
 * Cada Trajeto possui uma cor que determina a qual trajeto ela pertence e a lista possui o caminho
 * que a peça da cor do trajeto deve seguir.*/
public class Trajetos extends ArrayList{

	private int px;
	private int py;
	
	public void Init_TrajetosPrincipal(ArrayList<Trajetos> ListaCaminhoPrincipal)
	{
		/* Deve ser ajustada cada uma das coordenadas X e Y abaixo]
		 * */
		/* Digamos que o trajeto comeca na posicao 10 e 10*/
		Trajetos CaminhoPrincipal = NewTrajetos(10,10);
		ListaCaminhoPrincipal.add(0,CaminhoPrincipal);
		
		/* Vamos popular essa lista, colocando em cada posicao da lista um novo
		 * objeto de Trajeto, que possui a posicao X e Y correspondente aos quadrados*/
		
		/*É nesse for que vai ser necessário os um milhao de ifs*/
		for(int i=1;i<52;i++){
			ListaCaminhoPrincipal.add(i,NewTrajetos(i*10,i*20));
		}
			
	}
	
	public Trajetos NewTrajetos(int x, int y)
	{
		Trajetos a = new Trajetos();
		a.px = x;
		a.py = y;
		return a;
	}
	
}
