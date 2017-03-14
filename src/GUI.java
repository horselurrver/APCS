import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private BufferedImage cover, bone;
	private String[] options = {"Pet name", "Owner name", "Current residents","Available spots"};
	public GUI(){
		setTitle("Animal Hospital");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(0, 1));
		JPanel coverImage = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel();
		JPanel searchBox = new JPanel();
		searchBox.setLayout(new BoxLayout(searchBox, BoxLayout.X_AXIS));
		searchBox.setBackground(new Color(134, 213, 224));
		JPanel textBox = new JPanel();
		
		//create custom font using google fonts
		try {
			GraphicsEnvironment ge = 
			    GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Chewy.ttf")));
		} catch (IOException|FontFormatException e) {
			 e.printStackTrace();
		}
		try {
			GraphicsEnvironment ge = 
			    GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ArchitectsDaughter.ttf")));
		} catch (IOException|FontFormatException e) {
			 e.printStackTrace();
		}
		try {
			GraphicsEnvironment ge = 
			    GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("IndieFlower.ttf")));
		} catch (IOException|FontFormatException e) {
			 e.printStackTrace();
		}
		
		//background color and margins
		p.setBackground(new Color(134, 213, 224));//bluish theme for background
		coverImage.setBackground(new Color(134, 213, 224));
		p.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		//making title text at top of cover page and read in bone picture that appears next to title
		JLabel title = new JLabel("The Clinique", JLabel.LEFT);
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
		Image dimg = cover.getScaledInstance(800, 300, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel image = new JLabel(imageIcon);
		coverImage.add(image, BorderLayout.CENTER);
		
		//hello
		//basic search box that calls the different methods
		JButton search = new JButton("Search by...");
		search.addActionListener("this);
		Font searchFont = new Font("Architects Daughter", Font.PLAIN, 17);
		search.setFont(searchFont);
		searchBox.add(search);
		
		//dropdown menu that goes with the search box
		JComboBox menu = new JComboBox(options);
		menu.setFont(searchFont);
		menu.setSelectedIndex(0);
		searchBox.add(menu);
		
		//text area for printing out results
		JTextArea textArea = new JTextArea(100, 60);
		textArea.setFont(new Font("Indie Flower", Font.PLAIN, 16));
		textArea.setText("Welcome to the Clinique!");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textBox.add(scrollPane);
			
		p.add(titlePane);
		p.add(coverImage);
		p.add(searchBox);
		p.add(textBox);
		add(p);
		setVisible(true);
					 
		//When search button is clicked, display different information on text area depending on what is selected on the dropdown menu
		public void actionPerformed(ActionEvent evt) 
		{
			// TODO Auto-generated method stub
			
			if(evt.getSource() == btn1)
			{
				if(menu.getSelectedItem().toString().equals("Pet name"))
				{
					//still have to set up a JOptionPane so user can enter name of the pet
					//textArea.setText(printPetInfoByName(""));
				}
				else if(menu.getSelectedItem().toString().equals("Owner name"))
				{
					
				}
				if(menu.getSelectedItem().toString().equals("Current residents"))
				{
					
				}
				if(menu.getSelectedItem().toString().equals("Available spots"))
				{
					
				}
				
			}
		}			 
					 
	}
	 
	public static void main(String[] args){
		new GUI();
	}
}
