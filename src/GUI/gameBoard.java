package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Fileformat.CsvData;
import Fileformat.CsvReader;

public class gameBoard extends JFrame //implements MouseListener
{
	ImageBackground ImageBackground;
	public BufferedImage myImage1;
	private File file;
	private CsvData data;
	public gameBoard() {
		initGUI();	

	}

	private void initGUI() {
		try {
			 myImage1 = ImageIO.read(new File("C:\\Users\\moshe\\git\\Ex3\\src\\GUI\\pacman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageBackground=new ImageBackground();
		this.setContentPane(ImageBackground);
		this.setSize(1433,640);
		this.setIconImage(myImage1);
		this.setVisible(true);
		this.setDefaultCloseOperation(gameBoard.EXIT_ON_CLOSE);
		Menu Menu = new Menu("Menu"); 
		Menu add = new Menu("add");
		Menu Clear = new Menu ("Clear");
		Menu Run = new Menu ("RUN");
		MenuItem addPackman = new MenuItem("Add Packman");
		MenuItem addFruit = new MenuItem("Add Fruit");
		MenuItem addCsv = new MenuItem("Add Csv");
		MenuItem saveToCSV = new MenuItem("Save To CSV");
		MenuItem saveToKml = new MenuItem("Save To Kml");
		MenuItem clear = new MenuItem("Clear Game");
		MenuItem RunGame = new MenuItem("Run Game");
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);
		menuBar.add(Menu);
		menuBar.add(add);
		menuBar.add(Clear);
		menuBar.add(Run);
		Clear.add(clear);
		add.add(addPackman);
		add.add(addFruit);
		Run.add(RunGame);
		Menu.add(addCsv);
		Menu.add(saveToKml);
		Menu.add(saveToCSV);
		class addpackman implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			
				ImageBackground.setType("packman");
			}
			
		}
		class addfruit implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			
				ImageBackground.setType("fruit");
			}
			
		}
		class cleargame implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ImageBackground.clear();

			}
			
		}
		class Addcsv implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
			
					JFileChooser fileChooser= new JFileChooser();
					fileChooser.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
					fileChooser.setFileFilter(filter);
					fileChooser.showOpenDialog(null);
					file = fileChooser.getSelectedFile();
					data= new CsvData(file);
					ImageBackground.setGame(data);
			
			}
			
		}
		class Rungame implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				ImageBackground.RunGame();

			}
			
		}
		class saveTokml implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser= new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("KML file", "kml");
				fileChooser.setFileFilter(filter);
				fileChooser.showSaveDialog(null);
				File file2=fileChooser.getSelectedFile();
				String saveFile=file2.getPath()+".kml";
				ImageBackground.setSaveTo(saveFile);
				ImageBackground.saveToKML();
				System.out.println(saveFile);
			}
			
		}
		addCsv.addActionListener(new Addcsv());
		clear.addActionListener(new cleargame());
		addFruit.addActionListener(new addfruit());
		addPackman.addActionListener(new addpackman());
		RunGame.addActionListener(new Rungame());
		saveToKml.addActionListener(new saveTokml());
	}
	

	public static void main(String[] args) {
		new gameBoard();
	}
}
