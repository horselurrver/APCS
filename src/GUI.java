import javax.swing.*;

public class GUI extends JFrame {
	public GUI(){
		setTitle("Animal Hospital");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
