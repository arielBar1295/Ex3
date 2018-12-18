package algo;

import Geom.Point3D;

/**
 * This object contains a pacman and a Fruit ID and the time it takes the pacman eat the specific fruit.
 * The class contains getters and setters.
 * @author ariel and moshe
 *
 */
public class shortestTime {
private String fruitId;
private String packmanId;
private double time;
private Point3D p;
private int Weight;


public shortestTime(String idF,String idP,double time,Point3D _p,int _Weight) { 
	this.fruitId=idF;
	this.packmanId=idP;
	this.time=time;
	this.p=_p;
	Weight=_Weight;
}
public int getWeight() {
	return Weight;
}
public void setWeight(int weight) {
	Weight = weight;
}
public String getFruitId() {
	return fruitId;
}
public void setFruitId(String fruitId) {
	this.fruitId = fruitId;
}
public String getPackmanId() {
	return packmanId;
}
public void setPackmanId(String packmanId) {
	this.packmanId = packmanId;
}
public double getTime() {
	return time;
}
public void setTime(double time) {
	this.time = time;
}
public Point3D getP() {
	return p;
}
public void setP(Point3D p) {
	this.p = p;
}
}
