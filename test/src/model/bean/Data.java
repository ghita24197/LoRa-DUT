package model.bean;

public class Data {
	private int temp;
	private int humi;
	private boolean door;
	private int lroom;
	private int lporch;
	private int fplace;
	private int fled;
	public Data(int temp, int humi, boolean door, int lroom, int lporch, int fplace, int fled) {
		super();
		this.temp = temp;
		this.humi = humi;
		this.door = door;
		this.lroom = lroom;
		this.lporch = lporch;
		this.fplace = fplace;
		this.fled = fled;
	}
	public int getFled() {
		return fled;
	}
	public void setFled(int fled) {
		this.fled = fled;
	}
	public boolean isDoor() {
		return door;
	}
	public void setDoor(boolean door) {
		this.door = door;
	}
	public int getLroom() {
		return lroom;
	}
	public void setLroom(int lroom) {
		this.lroom = lroom;
	}
	public int getLporch() {
		return lporch;
	}
	public void setLporch(int lporch) {
		this.lporch = lporch;
	}
	public int getFplace() {
		return fplace;
	}
	public void setFplace(int fplace) {
		this.fplace = fplace;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getHumi() {
		return humi;
	}
	public void setHumi(int humi) {
		this.humi = humi;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
