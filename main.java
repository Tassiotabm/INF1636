import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
            	
            	//Criar a list ade Trajetos
            	ArrayList<Trajeto> ListaTrajetos = new ArrayList<Trajeto>();
            	ListaTrajetos.add(new Trajeto("Verde"));
            	ListaTrajetos.add(new Trajeto("Azul"));
            	ListaTrajetos.add(new Trajeto("Vermelho"));
            	ListaTrajetos.add(new Trajeto("Amarelo"));
            	
            	Ludointerface ex = new Ludointerface();
                ex.setVisible(true);
                
            }
        });
	}
}
