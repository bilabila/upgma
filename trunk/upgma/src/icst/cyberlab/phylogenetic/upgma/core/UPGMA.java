package icst.cyberlab.phylogenetic.upgma.core;

public class UPGMA {
	
	public void action(){
		
		
		
	}
	
	public float[][] clusterTwoMatrix(float[][] oldMatrix, int firstNode, int secondNode){
		float[][] newMatrix = null;
		
		
		
		return newMatrix;
	}
	
	public Node[] clusterTwoNode(Node[] sequences, float distance, int firstNode, int secondNode){
		Node[] newSequence = new Node[sequences.length - 1];
		
		Node node = new Node(firstNode + " " + secondNode);
		node.setNodeLeft(sequences[firstNode]);
		node.setNodeRight(sequences[secondNode]);
		node.setDistance(distance);
		
		sequences[firstNode] = node;
		sequences[secondNode] = null;
		
		int j = 0;
		for (int i = 0; i < sequences.length; i++) {
			if(sequences[i] != null){
				newSequence[j] = sequences[i];
			}
		}		
		return newSequence;
	}
}
