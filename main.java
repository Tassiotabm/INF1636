import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;

import Interface.Ludointerface;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
 
            	Ludointerface ex = new Ludointerface();
                ex.setVisible(true);
                
            }
        });
	}
}
