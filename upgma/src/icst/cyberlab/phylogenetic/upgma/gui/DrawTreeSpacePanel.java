package icst.cyberlab.phylogenetic.upgma.gui;

import icst.cyberlab.phylogenetic.upgma.core.NodeTree;
import icst.cyberlab.phylogenetic.upgma.core.PointDraw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawTreeSpacePanel extends JPanel {
	
	NodeTree nodeRoot = null;
	
	public DrawTreeSpacePanel(){
		setSize(800, 800);
		setPreferredSize(new Dimension(200, 100));
        setBackground(Color.white);
	}
	
	@Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 10, 30);
    }
	
	public int sumChildLeftOfNode(NodeTree node){
		int sumChild = 0;
		
		
		
		return sumChild;
	}
	
	public void drawPhynogeneticTree(NodeTree node, Graphics gr){
		ArrayList<NodeTree> tree = new ArrayList<NodeTree>();
		Stack<NodeTree> nodeFatherStack = new Stack<NodeTree>();
		Stack<NodeTree> nodeChildStack = new Stack<NodeTree>();
		PointDraw point = new PointDraw(0, 400);		
		node.setPoint(point);
		nodeChildStack.push(node);
		int maxHeigh = 400;
		while(nodeChildStack.size() == 0){
			NodeTree topNode = nodeChildStack.pop();
			NodeTree father = nodeFatherStack.pop();
			if(father != null){
				father.setCount(father.getCount() + 1);
				// tinh toan vi tri cho not con tu not cha.
				topNode.setPonitFather(father.getPoint());
				if(father.getCount() == 1){
					int width = father.getPoint().getHeigh() - 10;
					int heigh = (int) (father.getPoint().getWidth() + father.getDistance());
					topNode.setPoint(new PointDraw(width, heigh));
				} else {
					int width = father.getPoint().getHeigh() + 10;
					int heigh = (int) (father.getPoint().getWidth() + father.getDistance());
					topNode.setPoint(new PointDraw(width, heigh));
				}
			}			
			//set 2 node in child node
			NodeTree right = topNode.getNodeRight();
			if(right != null){
				nodeChildStack.push(right);
			}
			NodeTree left = topNode.getNodeLeft();
			if(left != null){
				nodeChildStack.push(left);
			}
			//set 2 node in father node		
			if(father != null){
				if(father.getCount() == 2){
					tree.add(father);
				}else {
					nodeFatherStack.push(father);
				}				
			}			
			if(topNode.getNodeRight() != null && topNode.getNodeLeft() != null){
				nodeFatherStack.push(topNode);
			}else {
				tree.add(topNode);
			}
		}
	}
	
	public static void main(String[] args){
		DrawTreeSpacePanel drawTreeSpacePanel = new DrawTreeSpacePanel();
		drawTreeSpacePanel.setVisible(true);
		JFrame frame = new JFrame();
		frame.add(drawTreeSpacePanel);
		frame.setBounds(100, 100, 800, 800);
		frame.setVisible(true);
	}
}

