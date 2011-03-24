package icst.cyberlab.phylogenetic.upgma.action;


import java.util.Stack;

import icst.cyberlab.phylogenetic.upgma.core.NodeTree;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactoryConfigurationError;



import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NodeAction {
	public Document convertTreeToXML(NodeTree node) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		
		Element root = doc.createElement("phyloxml");
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:schemaLocation", "http://www.phyloxml.org http://www.phyloxml.org/1.10/phyloxml.xsd");
		root.setAttribute("xmlns", "http://www.phyloxml.org");
		
		Element rooted = doc.createElement("phylogeny");
		rooted.setAttribute("rooted", "true");
		
		
		Element clade = doc.createElement("clade");
		rooted.appendChild(clade);
		
		Element name = doc.createElement("name");
		name.setTextContent("Huynh Minh Duc");
		rooted.appendChild(name);
		
		Element description = doc.createElement("description");
		name.setTextContent("description");
		rooted.appendChild(description);
		
		//Create node tree
		doc.appendChild(root);	
		Stack<Element> branch = new Stack<Element>();
		Stack<NodeTree> nodeFatherStack = new Stack<NodeTree>();
		Stack<NodeTree> nodeChildStack = new Stack<NodeTree>();
		
		nodeChildStack.push(node);
		
		while(nodeChildStack.size() != 0){
			NodeTree topNode = nodeChildStack.pop();
			NodeTree fatherNode = null;		
			if(nodeFatherStack.size() != 0){
				fatherNode = nodeFatherStack.pop();
			}
			if(topNode.getNodeRight() != null && topNode.getNodeLeft() != null){
				//get two node left and right push into child Stack.
				NodeTree leftNode = topNode.getNodeLeft();
				NodeTree rightNode = topNode.getNodeRight();
				nodeChildStack.push(leftNode);
				nodeChildStack.push(rightNode);
				Element branch1 = doc.createElement("clade");
				if(fatherNode != null){
					fatherNode.setCount(fatherNode.getCount() + 1);
					nodeFatherStack.push(fatherNode);
					branch1.setAttribute("branch_length", Float.toString((fatherNode.getDistance() - topNode.getDistance()) / 2));	
				}
				//And push current node to parent Stack.
				nodeFatherStack.push(topNode);
				//Create a branch element for XML.
				branch.push(branch1);
				
			}else {
				if(fatherNode != null){
					Element leaf = doc.createElement("clade");
					leaf.setAttribute("branch_length", Float.toString(fatherNode.getDistance() / 2));	
					Element leaf2 = doc.createElement("name");
					leaf2.setTextContent(topNode.getNameNode());
					leaf.appendChild(leaf2);

					fatherNode.setCount(fatherNode.getCount() + 1);
					//nodeFatherStack.push(fatherNode);

					Element branch1 = branch.pop();
					branch1.appendChild(leaf);
					//branch.push(branch1);		
					
					if(nodeFatherStack.size() != 0){
						NodeTree grandFather = nodeFatherStack.pop();
						Element grandElement = branch.pop();
						
						if(fatherNode.getCount() == 2){
							grandElement.appendChild(branch1);								
							while(grandFather.getCount() == 2){
								grandElement.appendChild(branch1);
								branch1 = grandElement;
								if(branch.size() != 0){
									grandElement = branch.pop();
								}else {
									clade.appendChild(branch1);
								}
								fatherNode = grandFather;
								if(nodeFatherStack.size() != 0){
									grandFather = nodeFatherStack.pop();
								}else break;								
							}		
							branch.push(grandElement);
							nodeFatherStack.push(grandFather);
						}else {
							branch.push(grandElement);								
							nodeFatherStack.push(grandFather);

							branch.push(branch1);
							nodeFatherStack.push(fatherNode);
						}
					}else {
						clade.appendChild(branch1);
					}
				}
			}
		}
		root.appendChild(rooted);	
		return doc;
	}
}
