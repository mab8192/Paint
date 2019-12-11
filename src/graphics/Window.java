package graphics;

import input.Pen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Window extends JFrame {
	
	private JPanel leftMenu;
	private JPanel topMenu;
	private DrawPanel drawPanel;
	
	private boolean closeRequested = false;
	
	public Window(int width, int height, String title){
		super();
		
		setSize(new Dimension(width, height));
		setTitle(title);
		setResizable(true);
		setLocationRelativeTo(null);
		
		addWindowListener(new closeHandler());
		addComponentListener(new resizeHandler());
		
		BorderLayout layout = new BorderLayout();
		
		setLayout(layout);
		
		topMenu = buildToolbar();
		add(topMenu, layout.NORTH);
		
		drawPanel = new DrawPanel();
		drawPanel.onResize(width, height);
		
		Pen p = new Pen(drawPanel);
		
		drawPanel.addMouseListener(p);
		drawPanel.addMouseMotionListener(p);
		
		add(drawPanel, layout.CENTER);
		
		setVisible(true);
	}
	
	private JPanel buildToolbar(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(getWidth(), getHeight() / 10));
		panel.setLocation(0,0);
		
		JButton button = new JButton();
		button.setText("File");
		panel.add(button);
		
		JButton button1 = new JButton();
		button1.setText("Edit");
		panel.add(button1);
		
		return panel;
	}
	
	public boolean shouldClose(){
		return closeRequested;
	}
	
	private class closeHandler extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.out.println("Window requested to be closed.");
			closeRequested = true;
			System.exit(0);
		}
	}
	
	private class resizeHandler extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			super.componentResized(e);
			
			// Handle resizing
		}
	}
	
	
	
}
