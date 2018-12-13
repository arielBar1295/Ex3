package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ImageBackground extends JPanel implements MouseListener 
{
	public BufferedImage myImage;
	private ArrayList<Point2D> Packman=new ArrayList<Point2D>();
	private ArrayList<Point2D> Fruit=new ArrayList<Point2D>();
	double x = -1 ;
	double y = -1;
	private String type;
	public ImageBackground() {
		try {
			 myImage = ImageIO.read(new File("C:\\Users\\moshe\\eclipse-workspace\\test\\src\\test\\myImage.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setType("");
		this.addMouseListener(this); 
	}

	public void paint (Graphics g) {
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawImage(myImage, 0, 0, w, h, this);
		
		for(int i=0;i<Packman.size();i++) {
			
		if(x!=-1 && y!=-1)
		{
			int r = 40;
			x = Packman.get(i).getX() - (r / 2);
			y = Packman.get(i).getY() - (r / 2);
			Color c = new Color(0.0f, 0.3f, 1.0f);
			// g.drawImage(myImage1,0, 0,(int)x,(int)y, this);		
			g.setColor(c.ORANGE);
			g.fillOval((int)x, (int)y, r, r);
			
		}
		}
		
		
			for(int i=0;i<Fruit.size();i++) {
				
				if(x!=-1 && y!=-1)
				{
					int r = 20;
					x = Fruit.get(i).getX() - (r / 2);
					y = Fruit.get(i).getY() - (r / 2);
					Color c = new Color(0.0f, 0.3f, 1.0f);
					// g.drawImage(myImage1,0, 0,(int)x,(int)y, this);		
					g.setColor(c.RED);
					g.fillOval((int)x, (int)y, r, r);
					
				}
				}
		}
	
	
	public ArrayList<Point2D> getPackman() {
		return Packman;
	}

	public void setPackman(ArrayList<Point2D> packman) {
		Packman = packman;
	}

	public ArrayList<Point2D> getFruit() {
		return Fruit;
	}

	public void setFruit(ArrayList<Point2D> fruit) {
		Fruit = fruit;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg0.getX() + "," + arg0.getY() +")");
		x = arg0.getX();
		y = arg0.getY();
		Point2D p=new Point2D.Double(x,y);
		if(type.equals("packman")) {
		Packman.add(p);
		}
		if (type.equals("fruit"))
		{
			Fruit.add(p);
		}
		repaint();
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void clear() {
		Packman.removeAll(Packman);
		Fruit.removeAll(Fruit);
		repaint();

		
	}
}
//	public static void main(String[] args) {
//		JFrame myJFrame = new JFrame("Packman Game");
//		ImageBackground gameBoard = new ImageBackground();
//		BufferedImage myImage =null;
//		try {
//			 myImage = ImageIO.read(new File("C:\\Users\\moshe\\git\\Ex3\\src\\GUI\\pacman.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		myJFrame.setContentPane(gameBoard);
//		
//	
//		myJFrame.setSize(1433, 640);
//		myJFrame.setVisible(true);
//		myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		Menu menu = new Menu("Menu"); 
//		Menu menu1 = new Menu("add");
//		MenuItem item1 = new MenuItem("add packman");
//		MenuItem item2 = new MenuItem("add fruit");
//		MenuItem item3 = new MenuItem("add csv");
//		MenuItem item4 = new MenuItem("save to kml");
//		myJFrame.setIconImage(myImage);
//		MenuBar menuBar = new MenuBar();
//		myJFrame.setMenuBar(menuBar);
//		menuBar.add(menu);
//		menuBar.add(menu1);
//		menu1.add(item1);
//		menu1.add(item2);
//		menu.add(item3);
//		menu.add(item4);
//		
//		
//	
//	}
//}
