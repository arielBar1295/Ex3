package Type;
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

public shortestTime(String idF,String idP,double time) {
	this.fruitId=idF;
	this.packmanId=idP;
	this.time=time;
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

}
