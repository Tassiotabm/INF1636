import java.util.Vector;

public class Peca {
	private String cor;
	public void GerarTodasPecas(Vector<Peca> A, Vector<Peca> B, Vector<Peca> C, Vector<Peca> D)
	{
		/*Vector<Peca> pecasverdes = new Vector();
	    Vector<Peca> pecasvermelhas = new Vector();
		Vector<Peca> pecasazuis = new Vector();
	    Vector<Peca> pecasamarelas = new Vector();*/
		int i;
		// Gerar Pecas
		for(i=0;i<4;i++){
			A.add(NovaPeca("Verde"));
			B.add(NovaPeca("Vermelha"));
			C.add(NovaPeca("Azul"));
			D.add(NovaPeca("Amarela"));
		}
	}
	public Peca NovaPeca(String novacor)
	{
		Peca PecaCriada = new Peca();
		PecaCriada.cor = novacor;
		return PecaCriada;
	}
}
