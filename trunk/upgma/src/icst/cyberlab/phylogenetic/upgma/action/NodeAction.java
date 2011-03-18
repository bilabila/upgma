package icst.cyberlab.phylogenetic.upgma.action;

import java.util.Stack;

import icst.cyberlab.phylogenetic.upgma.core.NodeTree;
import icst.cyberlab.phylogenetic.upgma.core.PointDraw;
import icst.cyberlab.phylogenetic.upgma.gui.DrawTreeSpacePanel;
import icst.cyberlab.phylogenetic.upgma.utilities.XMLUtilities;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class NodeAction {
	public Document convertTreeToXML(NodeTree node) throws ParserConfigurationException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("tree");
		doc.appendChild(root);	
		Stack<Element> branch = new Stack<Element>();
		
		Stack<NodeTree> nodeFatherStack = new Stack<NodeTree>();
		Stack<NodeTree> nodeChildStack = new Stack<NodeTree>();
		while(nodeChildStack.size() == 0){
			NodeTree topNode = nodeChildStack.pop();
			NodeTree father = nodeFatherStack.pop();
			if(father != null){
				father.setCount(father.getCount() + 1);
				// tinh toan vi tri cho not con tu not cha.
				topNode.setPonitFather(father.getPoint());
				if(father.getCount() == 1){
					
				} else {
					
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
					
				}else {
					nodeFatherStack.push(father);
				}				
			}			
			if(topNode.getNodeRight() != null && topNode.getNodeLeft() != null){
				nodeFatherStack.push(topNode);
			}else {
				
			}
		}
			
		
		//declaration node
		Element declarations = doc.createElement("declarations");
		Element attributeDecl = doc.createElement("attributeDecl");
		attributeDecl.setAttribute("name","name");
		attributeDecl.setAttribute("type","String");
		declarations.appendChild(attributeDecl);	
		root.appendChild(declarations);
				
		//Create branch ... with attribute...		
		Element branch1 = doc.createElement("branch");
		Element attribute = doc.createElement("attribute");
		attribute.setAttribute("name","name");
		attribute.setAttribute("value","9");
		branch1.appendChild(attribute);
		
		// create a leaf node.
		Element leaf = doc.createElement("leaf");
		Element childElement = doc.createElement("attribute");
		childElement.setAttribute("name","name");
		childElement.setAttribute("value","C");
		leaf.appendChild(childElement);
		
		branch1.appendChild(leaf);
		root.appendChild(branch1);
		
		return doc;
	}
	
	public static void main(String[] args) throws ParserConfigurationException{
		XMLUtilities xmlUtilities = new XMLUtilities();
		NodeAction nodeAction = new NodeAction();		
		//xmlUtilities.writeXmlFile(nodeAction.convertTreeToXML(), "a.xml");
	}
}
