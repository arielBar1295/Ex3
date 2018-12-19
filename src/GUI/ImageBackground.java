package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Fileformat.CsvData;
import Fileformat.Path2Kml;
import Fileformat.exportToCsv;
import Geom.Point3D;
import Maps.Convert;
import Type.Fruit;
import Type.Game;
import Type.Packman;
import algo.ShortestPathAlgo;
import java.util.Random;

/**
 * This class represents the image background, responsible for the game (saving ,running )
 * @author moshe and ariel
 *
 */
public class ImageBackground extends JPanel implements MouseListener

{
	public BufferedImage myImage;
	private Game game;
	double x = -1 ;
	double y = -1;
	private String type;
	private Convert c;
	public ShortestPathAlgo Path;
	private int counterP;
	private int counterF;
	private boolean run;
	private String saveTo;
	private Color[] co;

	public ImageBackground() {
		try {
			myImage = ImageIO.read(new File("image.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		setType("");
		this.addMouseListener(this); 
		game=new Game();
		c=new Convert();
		//for the packman and fruit id
		if(game.getFruit().size()>0&&game.getPackman().size()>0){
			this.counterF=Integer.parseInt(game.getFruit().get(game.getFruit().size()-1).getId())+1;
			this.counterP=Integer.parseInt(game.getPackman().get(game.getPackman().size()-1).getId())+1;
		}
		else {
			this.counterF=0;
			this.counterP=0;
		}

		run=false;
		saveTo="";

	}


	public void paint (Graphics g) {

		//****print the image****
		int w = this.getWidth();
		int h = this.getHeight();
		g.drawImage(myImage, 0, 0, w, h, this);
		//*****print the packman/fruit****
		for(int i=0;i<game.getPackman().size();i++) {

			if(x!=-1 && y!=-1)
			{
				int r = 40;

				Point3D pX=c.conToPix(game.getPackman().get(i).getPoint(), this.getWidth(), this.getHeight());
				x =pX.x() - (r / 2);
				y = pX.y() - (r / 2);
				Color co = new Color(0.0f, 0.3f, 1.0f);	
				g.setColor(co.ORANGE);
				g.fillOval((int)x, (int)y, r, r);
			}
		}
		for(int i=0;i<game.getFruit().size();i++) {

			if(x!=-1 && y!=-1)
			{
				int r = 20;
				Point3D pX=c.conToPix(game.getFruit().get(i).getPoint(), this.getWidth(), this.getHeight());
				x = pX.x() - (r / 2);
				y = pX.y() - (r / 2);
				Color co = new Color(0.0f, 0.3f, 1.0f);
				g.setColor(co.RED);
				g.fillOval((int)x, (int)y, r, r);	
			}
		}
		//***** print the line -represents the path per packman****
		if(run) {

			for (int i = 0; i < game.getPackman().size(); i++) {
				//saving the origin location of the packman .
				Point3D origin=game.getPackman().get(i).getPath().get(0).getP();

				for (int j = 1; j <game.getPackman().get(i).getPath().size(); j++) {
					//start point
					Point3D packmanpoint=c.conToPix(game.getPackman().get(i).getPath().get(0).getP(), this.getWidth(), this.getHeight());
					//end point
					Point3D fruitpoint=c.conToPix(game.getPackman().get(i).getPath().get(j).getP(),this.getWidth(),this.getHeight());
					g.setColor(co[i]);
					Graphics2D g2d = (Graphics2D) g;
					g2d.setStroke(new BasicStroke(2.5F));
					//drawing
					g.drawLine(packmanpoint.ix(),packmanpoint.iy() ,fruitpoint.ix(), fruitpoint.iy());
					//move forward the packman to the next fruit
					game.getPackman().get(i).getPath().get(0).setP(game.getPackman().get(i).getPath().get(j).getP());
				}
				//returning to the origin point 
				game.getPackman().get(i).getPath().get(0).setP(origin);
			}
		}


	}
	/**
	 * this function responsible for reading a game as a csv
	 * @param data is the new information for creating a game.
	 */
	public void setGame(CsvData data) {
		this.game=new Game(data);
		//For id of the elements,in case the user adds elements to the game from the csv
		this.counterF=Integer.parseInt(game.getFruit().get(game.getFruit().size()-1).getId())+1;
		this.counterP=Integer.parseInt(game.getPackman().get(game.getPackman().size()-1).getId())+1;
		x=1;
		y=1;
		repaint();

	}
	/**
	 * this function is running when the user push run game 
	 */
	public void RunGame() {
		//creating an array of random colors ,each packman has its own color for its path.
		co=new Color[ game.getPackman().size()];
		for (int i = 0; i < game.getPackman().size(); i++) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float v = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, v, b);
			co[i]=randomColor;
		}
		//if the user runs Game more than 1 .
		for (int i = 0; i < game.getPackman().size(); i++) {
			game.getPackman().get(i).getPath().removeAll(game.getPackman().get(i).getPath());

		}
		Path=new ShortestPathAlgo(game);
		Path.pathTofruit();
		for (int i = 0; i < game.getPackman().size(); i++) {
			System.out.print(game.getPackman().get(i).getId()+",");
			//			for (int j = 0; j < game.getPackman().get(i).getPath().size(); j++) {
			//				System.out.println(game.getPackman());
			//			}

		}
		run=true;
		repaint();
		//creating a thread for showing the movement of each packman.
		move moveThePackman;
		for (int i = 0; i < game.getPackman().size(); i++) {
			moveThePackman=new move(this,game.getPackman().get(i),1);

			moveThePackman.start();
		}
		//printing the results of the game
		double maxTime=game.getPackman().get(0).getTime();
		System.out.println("packman's "+0+" eating weight is:"+game.getPackman().get(0).getWeight());
		for (int i = 1; i < game.getPackman().size(); i++) {
			System.out.println("packman's "+i+" eating weight is:"+game.getPackman().get(i).getWeight());
			if(maxTime<game.getPackman().get(i).getTime()) {
				maxTime=game.getPackman().get(i).getTime();
			}
		}
		maxTime=maxTime/60;//convert to minutes
		System.out.println("the game run : "+maxTime);


	}
	/**
	 * this function runs when the user creating a new game or adding to an existing one ,by clicking on the screen.
	 */
	@Override

	public void mouseClicked(MouseEvent arg0) {
		run=false;
		x = arg0.getX();
		y = arg0.getY();
		Point3D p=new Point3D(x,y);
		Point3D newPoint=c.pixToCo(p, this.getWidth(), this.getHeight());

		if(type.equals("packman")) {
			String id=Integer.toString(counterP);

			counterP++;

			String time=new SimpleDateFormat("yyyy-MM-dd,hh:mm:ss").format(Calendar.getInstance().getTime());
			game.getPackman().add(new Packman(newPoint,id,time));
		}
		if (type.equals("fruit"))
		{
			String id=Integer.toString(counterF);

			counterF++;

			game.getFruit().add(new Fruit(newPoint,id));

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
	public String getSaveTo() {
		return saveTo;
	}


	public void setSaveTo(String saveTo) {
		this.saveTo = saveTo;
	}
	/**
	 * this function deletes the elements from the screen and its information,for starting a new game.
	 */
	public void clear() {
		game.getPackman().removeAll(game.getPackman());
		game.getFruit().removeAll(game.getFruit());
		repaint();
		run=false;


	}
	public synchronized void update() {

		repaint();
	}

	/**
	 * this function saving to kml by using Path2Kml class.
	 */
	public void saveToKML() {
		Path2Kml k = new Path2Kml();
		k.projectToKml(game, this.saveTo);

	}

	/**
	 * this function saving to csv by using exportToCsv class.
	 */
	public void saveToCSV() {
		exportToCsv csv = new exportToCsv();
		try {
			csv.toCsv(saveTo, game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}

