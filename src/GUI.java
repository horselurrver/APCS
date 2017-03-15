/**
 * Main user interface for animal hospital
 * @author Spoorthi Jakka, Amy Wang
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener{
	private BufferedImage bone;
	//private BufferedImage cover;
	private String[] options = {"Pet name", "Owner name", "Current residents","Available spots"};
	private JComboBox menu;
	private JTextArea textArea;
	private AnimalHospital h;
	private JPanel animalPics;
	public GUI(){
		try {
			h = new AnimalHospital("petData.txt");
			ArrayList<Pet> hospital = h.getHospital();
		} catch (FileNotFoundException f){
			System.out.println(f.getMessage());
		} catch (IllegalEmailException e){
			System.out.println(e.getMessage());
		} catch (IllegalDateException i){
			System.out.println(i.getMessage());
		}
		setTitle("The Clinique");
		setSize(800, 650);
		//setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		JPanel background = new JPanel();
		background.setLayout(new FlowLayout());
		
		ImageIcon icon = new ImageIcon("paws2.jpg"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		background.add(thumb);

		p.setLayout(new GridLayout(0, 1));
		JPanel coverImage = new JPanel(new BorderLayout());
		animalPics = new JPanel(new GridLayout(1, 0));
		//animalPics = new JPanel();
		animalPics.setBackground(new Color(134, 213, 224));
		//animalPics.setBackground(Color.BLACK);
		JPanel titlePane = new JPanel();
		JPanel searchBox = new JPanel();
		searchBox.setLayout(new BoxLayout(searchBox, BoxLayout.X_AXIS));
		searchBox.setBackground(new Color(134, 213, 224));
		JPanel textBox = new JPanel();
		textBox.setLayout(new BoxLayout(textBox, BoxLayout.Y_AXIS));
		
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
			
		//basic search box that calls the different methods
		JButton search = new JButton("Search by...");
		search.addActionListener(this);
		Font searchFont = new Font("Architects Daughter", Font.PLAIN, 17);
		search.setFont(searchFont);
		searchBox.add(search);
		
		//dropdown menu that goes with the search box
		menu = new JComboBox(options);
		menu.setFont(searchFont);
		menu.setSelectedIndex(0);
		searchBox.add(menu);
		
		//text area for printing out results
		textArea = new JTextArea(100, 60);
		textArea.setFont(new Font("Indie Flower", Font.PLAIN, 18));
		textArea.setText("Welcome to the Clinique!");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textBox.add(scrollPane);
		
		p.add(titlePane);
		p.add(coverImage);
		p.add(animalPics);
		p.add(searchBox);
		p.add(textBox);
		p.add(background);
		add(p, BorderLayout.CENTER);
		
		setVisible(true);			 
					 
	}
	
		  
	/**
	 * When search button is clicked, display different information on text 
	 * area depending on what is selected on the dropdown menu
	 * @param evt
	 */
	public void actionPerformed(ActionEvent evt){
	    Font f = new Font("Indie Flower", Font.PLAIN, 20);
		if (menu.getSelectedItem().toString().equals("Pet name")){
			//clear off animalPics, remove all components
			animalPics.removeAll();
			animalPics.revalidate();
			animalPics.repaint();
			JLabel j = new JLabel("Input a pet name");
			j.setFont(f);
			String input = (String)JOptionPane.showInputDialog(
                    null,
                    j,
                    "Pet Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Fluffy");
			 textArea.setText(h.printPetInfoByName(input));
			 ArrayList<Pet> pets = h.getPetByName(input);
			 if (pets.size() > 0){
				 for (Pet p : pets){
					JPanel pet = new JPanel();
					pet.setLayout(new GridLayout(0, 1));
					//pet.setLayout(new BoxLayout(pet, BoxLayout.Y_AXIS));
					//actual image of the pet
					ImageIcon img = new ImageIcon(new ImageIcon(p.getImageFileName()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
					JLabel picLabel = new JLabel();
					picLabel.setIcon(img);
					
					//label for the pet
					JLabel petLabel = new JLabel("Name: " + p.getPetName());
					petLabel.setFont(new Font("Indie Flower", Font.BOLD, 13));
					
					//put label and image together
					pet.add(picLabel);
					pet.add(petLabel);
					pet.setBackground(new Color(134, 213, 224));
					
					animalPics.add(pet);

				 }
			 }
			 validate();
			 repaint();
			 //figure out how to repaint jpanel
		} else if (menu.getSelectedItem().toString().equals("Owner name")){
			animalPics.removeAll();
			animalPics.revalidate();
			animalPics.repaint();
			JLabel j = new JLabel("Input an owner name");
			j.setFont(f);
			String input = (String)JOptionPane.showInputDialog(
                    null,
                    j,
                    "Owner Name",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "Sam");
			textArea.setText(h.printPetInfoByOwner(input));
			ArrayList<Pet> pets = h.getPetByOwnerName(input);
			 if (pets.size() > 0){
				 for (Pet p : pets){
					JPanel pet = new JPanel();
					pet.setLayout(new GridLayout(0, 1));
					//pet.setLayout(new BoxLayout(pet, BoxLayout.Y_AXIS));
					//actual image of the pet
					ImageIcon img = new ImageIcon(new ImageIcon(p.getImageFileName()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
					JLabel picLabel = new JLabel();
					picLabel.setIcon(img);
					
					//label for the pet
					JLabel petLabel = new JLabel("Name: " + p.getPetName());
					petLabel.setFont(new Font("Indie Flower", Font.BOLD, 13));
					
					//put label and image together
					pet.add(picLabel);
					pet.add(petLabel);
					pet.setBackground(new Color(134, 213, 224));
					
					animalPics.add(pet);

				 }
			 }
			 validate();
			 repaint();
		} else if (menu.getSelectedItem().toString().equals("Current residents")){
			animalPics.removeAll();
			animalPics.revalidate();
			animalPics.repaint();
			JLabel j = new JLabel("Input a date in the format of month/date/year");
			j.setFont(f);
			String input = "";
			while (true) {
				input = (String)JOptionPane.showInputDialog(
	                    null,
	                    j,
	                    "Owner Name",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    "Sam");
				if (!input.matches("\\d/\\d+/\\d\\d\\d\\d")){
					JOptionPane.showMessageDialog(null,
						    "Format incorrect.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				} else break;
			}
			String[] parts = input.split("/");
			textArea.setText(h.printPetsBoarding(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
			ArrayList<Pet> pets = h.getPetByBoarding(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
			 if (pets.size() > 0){
				 for (Pet p : pets){
					System.out.println(p.getImageFileName());
					JPanel pet = new JPanel();
					pet.setLayout(new GridLayout(0, 1));
					//pet.setLayout(new BoxLayout(pet, BoxLayout.Y_AXIS));
					//actual image of the pet
					ImageIcon img = new ImageIcon(new ImageIcon(p.getImageFileName()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
					JLabel picLabel = new JLabel();
					picLabel.setIcon(img);
					
					//label for the pet
					JLabel petLabel = new JLabel("Name: " + p.getPetName());
					petLabel.setFont(new Font("Indie Flower", Font.BOLD, 13));
					
					//put label and image together
					pet.add(picLabel);
					pet.add(petLabel);
					pet.setBackground(new Color(134, 213, 224));
					
					animalPics.add(pet);

				 }
			 }
			 validate();
			 repaint();
		} else if (menu.getSelectedItem().toString().equals("Available spots")){
			animalPics.removeAll();
			animalPics.revalidate();
			animalPics.repaint();
			textArea.setText(h.printAvailable());
		}
	}
	
	public static void main(String[] args){
		new GUI();
	}
}
