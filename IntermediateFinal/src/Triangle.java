import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Bob Wilson
 * 
 * Triangle class for fractal pattern generation
 * 
 * Modified by Ting Zhang for Java 2 Project 3
 */

public class Triangle
{
  // smallest perimeter for triangle to be drawn
  public static final int SMALLEST = 30;
  
  private Corner x;
  private Corner y;
  private Corner z;
    
  public Triangle(Corner x, Corner y, Corner z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public void draw(Graphics screen)
  {
   screen.drawLine(x.w, x.d, y.w, y.d);
   screen.drawLine(y.w, y.d, z.w, z.d);
   screen.drawLine(z.w, z.d, x.w, x.d);
  }
  
  public int size()
  {
	  return (x.len(y) + y.len(z) + z.len(x));
  }
  
  public ArrayList<Triangle> getNextLevel()
  {
	  
	 Triangle tri = new Triangle(x, x.mid(z), x.mid(y));
	 Triangle tri2 = new Triangle(y, y.mid(z), x.mid(y));
	 Triangle tri3 = new Triangle(z, z.mid(y), x.mid(z));
	  // write your code here
	 ArrayList<Triangle> tri1 = new ArrayList<Triangle>();
	 tri1.add(tri);
	 tri1.add(tri2);
	 tri1.add(tri3);
    // modify the following line to return your ArrayList of triangles
    return tri1; // stub return;
  }
}