import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Ting Zhang
 * 
 * The GUI for drawing triangles in fractal pattern
 * 
 */

public class TriangleGUI extends Canvas{
		
	/**
	 * paint figures on the canvas
	 */
	 public void paint(Graphics screen)
	 {
	   screen.clearRect(0, 0, this.getWidth(), this.getHeight());
	   
	   //initial value of w and d for the corners of the outer triangle
	   Corner x = new Corner(0, this.getHeight());
	   Corner y = new Corner(this.getWidth(), this.getHeight());
	   Corner z = new Corner(this.getWidth() / 2, 0);
	   
	   //call method to draw triangles in fractal pattern recursively or iteratively
	   drawTriangleRecursive(screen, new Triangle(x, y, z));
	   drawTriangleIterative(screen, new Triangle(x, y, z));
	   
	 }
	 
	 /**
	  * recursive method for drawing triangles
	  */
	 private void drawTriangleRecursive(Graphics g, Triangle t)
	 {
	   // Write your code here
		 if (t.size() > Triangle.SMALLEST) {
			 t.draw(g);
			 drawTriangleRecursive(g, t.getNextLevel().get(0));
			 drawTriangleRecursive(g, t.getNextLevel().get(1));
			 drawTriangleRecursive(g, t.getNextLevel().get(2));
		 }
		 else {
			 t.draw(g);
		 }
	 }
	 
	 /**
	  * Iterate method for drawing triangles
	  */
	 private void drawTriangleIterative(Graphics g, Triangle t) 
	 {
		 ArrayList<Triangle> tri = new ArrayList<Triangle>();
		 tri.add(t);
		 while (tri.isEmpty() == false) {
			 Triangle t1 = tri.remove(0);
			 if (t1.size() > Triangle.SMALLEST) {
				 tri.addAll(t1.getNextLevel());
				 t1.draw(g);
			 }
			 else {
				t1.draw(g); 
			 }
	 }
	 }
}
