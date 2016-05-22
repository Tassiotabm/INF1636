import java.util.ArrayList;
import java.awt.Point;

public class Trajeto{
	
	public ArrayList<Point> path = new ArrayList<Point>();
	public Trajeto (String Cor){
		/* Cada cor terá um trajeto diferente */
		switch (Cor){
		
		//Trajeto Verde
		case "Verde" :
			//right
			for(int i = 1; i < 6; i++)
				path.add(new Point(20*i, 120));
			//up
			for(int i = 5; i >= 0; i--)
				path.add(new Point(120,20*i));
			
			path.add(new Point(140, 0));
			//down
			for(int i = 0; i < 6; i++)
				path.add(new Point(160, i*20));
			//right
			for(int i = 0; i < 6; i++)
				path.add(new Point(180 + i*20, 120));
			
			path.add(new Point(280, 140));
			//left
			for(int i = 5; i >=0; i--)
				path.add(new Point(180 + i*20,160));
			//down
			for(int i = 0; i < 6; i ++)
				path.add(new Point(160,180 + i*20));
			
			path.add(new Point(140, 280));
			//up
			for(int i = 5; i >=0; i--)
				path.add(new Point(120, 180 + i*20));
			//left
			for(int i = 5; i >= 0; i--)
				path.add(new Point(i*20,160));
			//up
			path.add(new Point(0, 140));
			path.add(new Point(0, 120));
			path.add(new Point(20, 120));
			//inner path
			for(int i = 1; i < 6; i++)
				path.add(new Point(i*20, 140));
			//end of path
			break;
			
		// Trajeto Vermelho	
		case "Vermelho":
			//down
			for(int i = 1; i < 6; i++)
				path.add(new Point(160, i*20));
			//right
			for(int i = 0; i < 6; i++)
				path.add(new Point(180 + i*20, 120));
			
			path.add(new Point(280, 140));
			//left
			for(int i = 5; i >=0; i--)
				path.add(new Point(180 + i*20,160));
			//down
			for(int i = 0; i < 6; i ++)
				path.add(new Point(160,180 + i*20));
			
			path.add(new Point(140, 280));
			//up
			for(int i = 5; i >=0; i--)
				path.add(new Point(120, 180 + i*20));
			//left
			for(int i = 5; i >= 0; i--)
				path.add(new Point(i*20,160));
			
			path.add(new Point(0, 140));
			//right
			for(int i = 0; i < 6; i ++)
				path.add(new Point(i*20, 120));
			//up
			for(int i = 5; i >= 0; i--)
				path.add(new Point(120,20*i));
			
			path.add(new Point(140,0));
			path.add(new Point(160, 0));
			path.add(new Point(160, 20));
			//inner path
			for(int i = 1; i < 6; i++)
				path.add(new Point(140, i*20));
			//end of path
			break;
			
		// Trajeto Amarelo
		case "Amarelo":
			// up
			for(int i = 4; i >=0; i--)
				path.add(new Point(120, 180 + i*20));
			//left
			for(int i = 5; i >= 0; i--)
				path.add(new Point(i*20,160));
			
			path.add(new Point(0, 140));
			//right
			for(int i = 0; i < 6; i ++)
				path.add(new Point(i*20, 120));
			//up
			for(int i = 5; i >= 0; i--)
				path.add(new Point(120,20*i));
			path.add(new Point(140, 0));
			//down
			for(int i = 0; i < 6; i++)
				path.add(new Point(160, i*20));
			//right
			for(int i = 0; i < 6; i++)
				path.add(new Point(180 + i*20, 120));
			
			path.add(new Point(280, 140));
			//left
			for(int i = 5; i >=0; i--)
				path.add(new Point(180 + i*20,160));
			//down
			for(int i = 0; i < 6; i ++)
				path.add(new Point(160,180 + i*20));
			
			path.add(new Point(140, 280));
			path.add(new Point(120, 280));
			path.add(new Point(120,260));
			// inner path
			for(int i = 4; i >= 0; i--)
				path.add(new Point(140, 180 + 20*i));
			//end of path
			break;
			
		// Trajeto Azul
		case "Azul":
			//left 
			for(int i = 4; i >= 0; i--)
				path.add(new Point(180 + 20*i, 160));
			//down
			for(int i = 0; i < 6; i ++)
				path.add(new Point(160,180 + i*20));
			path.add(new Point(140, 280));
			//up
			for(int i = 5; i >=0; i--)
				path.add(new Point(120, 180 + i*20));
			//left
			for(int i = 5; i >= 0; i--)
				path.add(new Point(i*20,160));
			
			path.add(new Point(0, 140));
			//right
			for(int i = 0; i < 6; i ++)
				path.add(new Point(i*20, 120));
			//up
			for(int i = 5; i >= 0; i--)
				path.add(new Point(120,20*i));
			
			path.add(new Point(140,0));
			//down
			for(int i = 0; i < 6; i++)
				path.add(new Point(160, i*20));
			//right
			for(int i = 0; i < 6; i++)
				path.add(new Point(180 + i*20, 120));
			
			path.add(new Point(280, 140));
			path.add(new Point(280, 160));
			path.add(new Point(260, 160));
			//inner path
			for(int i = 4; i >=0; i--)
				path.add(new Point(180 + 20*i,140));
			//end of path
			break;
			default:
				//right
				for(int i = 1; i < 6; i ++)
					path.add(new Point(i*20, 120));
				//up
				for(int i = 5; i >= 0; i--)
					path.add(new Point(120,20*i));
				
				path.add(new Point(140, 0));
				//down
				for(int i = 0; i < 6; i++)
					path.add(new Point(160, i*20));
				//right
				for(int i = 0; i < 6; i++)
					path.add(new Point(180 + i*20, 120));
				
				path.add(new Point(280, 140));
				//left
				for(int i = 5; i >=0; i--)
					path.add(new Point(180 + i*20,160));
				//down
				for(int i = 0; i < 6; i ++)
					path.add(new Point(160,180 + i*20));
				
				path.add(new Point(140, 280));
				//up
				for(int i = 5; i >=0; i--)
					path.add(new Point(120, 180 + i*20));
				//left
				for(int i = 5; i >= 0; i--)
					path.add(new Point(i*20,160));
				
				path.add(new Point(0, 140));
				path.add(new Point(0, 120));
				//end of path
		
		}
	}
}
