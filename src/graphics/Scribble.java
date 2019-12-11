package graphics;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.LinkedList;

public class Scribble {
	
	private LinkedList<Point> points;
	private int size;
	private Color color;
	
	public Scribble(){
		points = new LinkedList<>();
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void addPoint(int x, int y){
		points.add(new Point(x, y));
	}
	
	public void draw(Graphics2D g){
		
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setRenderingHint(
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		int x0 = -1;
		int y0 = -1;
		int x1 = -1;
		int y1 = -1;
		
		for (Point p : points){
			
			if (x0 == -1){
				x0 = p.x;
				y0 = p.y;
				continue;
			}
			
			x1 = p.x;
			y1 = p.y;
			
			g.setColor(color);
			
			g.setStroke(new BasicStroke(size));
			g.draw(new Line2D.Float(x0, y0, x1, y1));
			
			x0 = x1;
			y0 = y1;
		}
	}
	
}
