import java.awt.EventQueue;

public class main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
            	ludointerface ex = new ludointerface();
                ex.setVisible(true);
            }
        });
	}
}
