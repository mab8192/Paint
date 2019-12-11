import graphics.Window;

public class Application {
	
	private Window w;
	
	public Application(){
		w = new Window(800, 600, "Paint");
		
		run();
	}
	
	public void run(){
	
		while(!w.shouldClose()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args){
		new Application();
		
	}
}
