package icst.cyberlab.phylogenetic.upgma.core;

public class PointDraw {
	int heigh;
	int width;
	 public PointDraw(int x, int y){
		 this.heigh = y;
		 this.width = x;
	 }
	public int getHeigh() {
		return heigh;
	}
	public void setHeigh(int x) {
		this.heigh = x;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int y) {
		this.width = y;
	}
}
