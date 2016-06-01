import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Triangulo {

	public Triangulo(Graphics g) {
		// TODO Auto-generated constructor stub
		// pintar triângulo 1 Green
		Graphics2D t1 = (Graphics2D) g;
		t1.setPaint(Color.green);
		Path2D.Double triangle = new Path2D.Double();
		triangle.moveTo(120, 120);
		triangle.lineTo(120, 180);
		triangle.lineTo(150, 150);
		triangle.closePath();
		t1.fill(triangle);
		// pintar triângulo 2 Red
		Graphics2D t2 = (Graphics2D) g;
		t2.setPaint(Color.red);
		Path2D.Double triangle2 = new Path2D.Double();
		triangle2.moveTo(120, 120);
		triangle2.lineTo(180, 120);
		triangle2.lineTo(150, 150);
		triangle2.closePath();
		t2.fill(triangle2);
		// g.drawPolygon(new int[] {120, 180, 150}, new int[] {120, 120,
		// 150}, 3);
		// pintar triângulo 3 Blue
		Graphics2D t3 = (Graphics2D) g;
		t3.setPaint(Color.blue);
		Path2D.Double triangle3 = new Path2D.Double();
		triangle3.moveTo(180, 120);
		triangle3.lineTo(180, 180);
		triangle3.lineTo(150, 150);
		triangle3.closePath();
		t3.fill(triangle3);
		// g.drawPolygon(new int[] {180, 180, 150}, new int[] {120, 180,
		// 150}, 3);
		// pintar triângulo 4 Yellow
		Graphics2D t4 = (Graphics2D) g;
		t4.setPaint(Color.yellow);
		Path2D.Double triangle4 = new Path2D.Double();
		triangle4.moveTo(120, 180);
		triangle4.lineTo(180, 180);
		triangle4.lineTo(150, 150);
		triangle4.closePath();
		t4.fill(triangle4);
	}
}
