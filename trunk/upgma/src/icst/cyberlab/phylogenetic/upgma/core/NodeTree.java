package icst.cyberlab.phylogenetic.upgma.core;

public class NodeTree {
	private String nameNode = null;
	private NodeTree nodeLeft = null;
	private NodeTree nodeRight = null;
	private float distance = 0;
	private PointDraw point;
	private PointDraw ponitFather;
	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public NodeTree(NodeTree nodeLeft, NodeTree nodeRight, float distance){
		this.nodeLeft = nodeLeft;
		this.nodeRight = nodeRight;
		this.distance = distance;
	}
	
	public NodeTree(String nameNode){
		this.nameNode = nameNode;
	}
	
	public String getNameNode() {
		return nameNode;
	}

	public void setNameNode(String nameNode) {
		this.nameNode = nameNode;
	}

	public NodeTree getNodeLeft() {
		return nodeLeft;
	}
	public void setNodeLeft(NodeTree nodeLeft) {
		this.nodeLeft = nodeLeft;
	}
	public NodeTree getNodeRight() {
		return nodeRight;
	}
	public void setNodeRight(NodeTree nodeRight) {
		this.nodeRight = nodeRight;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}

	public PointDraw getPoint() {
		return point;
	}

	public void setPoint(PointDraw point) {
		this.point = point;
	}

	public PointDraw getPonitFather() {
		return ponitFather;
	}

	public void setPonitFather(PointDraw ponitFather) {
		this.ponitFather = ponitFather;
	}
}
