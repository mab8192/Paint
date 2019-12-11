package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DrawPanel extends JPanel{
	
	private HashMap<Integer, Scribble> scribbles;
	
	private int width, height;
	
	private Color background;
	
	public DrawPanel(){
		super();
		background = Color.WHITE;
	}
	
	public void onResize(int width, int height){
		this.width = width;
		this.height = height;
		scribbles = new HashMap<>();
	}
	
	public void addScribble(int id, Scribble s){
		scribbles.put(id, s);
	}
	
	public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		
		g.setColor(background);
		g.fillRect(0, 0, width, height);
		
		for (Scribble s : scribbles.values()){
			s.draw(g);
		}
		
	}
	
	public Color getBackground(){
		return background;
	}
	
}
