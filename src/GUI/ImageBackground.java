package GUI;

import java.awt.BasicStroke;
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

import Fileformat.CsvData;
import Geom.Point3D;
import Maps.Convert;
import Type.Fruit;
import Type.Game;
import Type.Packman;
import algo.path;



public class ImageBackground extends JPanel implements MouseListener

{
	public BufferedImage myImage;
	private Game game;
	double x = -1 ;
	double y = -1;
	private String type;
	private Convert c;
	public path Path;
	private int counterP;
	private int counterF;
	private boolean run;
	public ImageBackground() {
		try {
			myImage = ImageIO.read(new File("C:\\Users\\moshe\\git\\Ex3\\src\\GUI\\image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setType("");
		this.addMouseListener(this); 
		game=new Game();
		c=new Convert();
		counterP=0;
		counterF=0;
		run=false;
	}

	public void paint (Graphics g) {

		//System.out.println("a");
		int w = this.getWidth();
		int h = this.getHeight();
		//System.out.println();
		g.drawImage(myImage, 0, 0, w, h, this);
		//System.out.println(game.getPackman());
		for(int i=0;i<game.getPackman().size();i++) {

			if(x!=-1 && y!=-1)
			{
				int r = 40;

				Point3D pX=c.conToPix(game.getPackman().get(i).getPoint(), this.getWidth(), this.getHeight());

				x =pX.x() - (r / 2);
				y = pX.y() - (r / 2);
				Color co = new Color(0.0f, 0.3f, 1.0f);

				// g.drawImage(myImage1,0, 0,(int)x,(int)y, this);		
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
				// g.drawImage(myImage1,0, 0,(int)x,(int)y, this);		
				g.setColor(co.RED);
				g.fillOval((int)x, (int)y, r, r);	
			}
		}
		if(run) {

			for (int i = 0; i < game.getPackman().size(); i++) {
				Point3D origin=game.getPackman().get(i).getPoint();
				for (int j = 0; j <game.getPackman().get(i).getPath().size(); j++) {
					Point3D packmanpoint=c.conToPix(game.getPackman().get(i).getPoint(), this.getWidth(), this.getHeight());
					Point3D fruitpoint=c.conToPix(game.getPackman().get(i).getPath().get(j).getP(),this.getWidth(),this.getHeight());
					g.drawLine(packmanpoint.ix(),packmanpoint.iy() ,fruitpoint.ix(), fruitpoint.iy());
					game.getPackman().get(i).setP(game.getPackman().get(i).getPath().get(j).getP());
				}
				game.getPackman().get(i).setP(origin);
			}
		}
	}
	public void setGame(CsvData data) {
		this.game=new Game(data);
		x=1;
		y=1;
		repaint();

	}
	public void RunGame() {
		for (int i = 0; i < game.getPackman().size(); i++) {
			game.getPackman().get(i).getPath().removeAll(game.getPackman().get(i).getPath());
		}
		Path=new path(game);
		Path.pathTofruit();
		run=true;
		repaint();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
//		System.out.println("mouse Clicked");
//		System.out.println("("+ arg0.getX() + "," + arg0.getY() +")");
		x = arg0.getX();
		y = arg0.getY();
		Point3D p=new Point3D(x,y);
		Point3D newPoint=c.pixToCo(p, this.getWidth(), this.getHeight());
		if(type.equals("packman")) {
			//Packman.add(p);
			System.out.println(newPoint);
			String id=Integer.toString(counterP);
			counterP++;
			game.getPackman().add(new Packman(newPoint,id));
		}
		if (type.equals("fruit"))
		{
			String id=Integer.toString(counterF);
			counterF++;
			System.out.println(newPoint);
			game.getFruit().add(new Fruit(newPoint,id));
			//			Fruit.add(p);
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
		game.getPackman().removeAll(game.getPackman());
		game.getFruit().removeAll(game.getFruit());
		repaint();


	}



}

