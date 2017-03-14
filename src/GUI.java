import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private BufferedImage cover, bone;
	public GUI(){
		setTitle("Animal Hospital");
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0, 1));
		JPanel coverImage = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel();
		
		//create custom font using google fonts
		try {
			GraphicsEnvironment ge = 
			    GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy.ttf")));
		} catch (IOException|FontFormatException e) {
			 e.printStackTrace();
		}
		 
		//background color and margins
		p.setBackground(new Color(134, 213, 224));//bluish theme for background
		coverImage.setBackground(new Color(134, 213, 224));
		p.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		//making title text at top of cover page and read in bone picture that appears next to title
		JLabel title = new JLabel("Animal Hospital", JLabel.LEFT);
		title.setFont(new Font("Chewy", Font.BOLD, 40));
		title.setForeground(new Color(242, 233, 208));//brownish theme for font color
		
		coverImage.add(title, BorderLayout.NORTH);
		try {
			bone = ImageIO.read(new File("bone.png"));
		} catch (IOException i){
			System.out.println(i.getMessage());
		}
		Image scale = bone.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
		ImageIcon imag = new ImageIcon(scale);
		JLabel b = new JLabel(imag);
		
		titlePane.setBackground(new Color(134, 213, 224));
		titlePane.setLayout(new BoxLayout(titlePane, BoxLayout.X_AXIS));
		titlePane.add(b);//add bone to left
		//creates space between the JLabels
		titlePane.add(title);//add title to right
	
		//making cover image at top of page
		try {
			cover = ImageIO.read(new File("cover.jpg"));
		} catch (IOException i){
			System.out.println(i.getMessage());
		}
		Image dimg = cover.getScaledInstance(800, 500,Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel image = new JLabel(imageIcon);
		coverImage.add(image, BorderLayout.CENTER);
		
		//adding text that goes with the cover image
		
		p.add(titlePane);
		p.add(coverImage);
		add(p);
		setVisible(true);
	}
	 
	public static void main(String[] args){
		new GUI();
	}
}
