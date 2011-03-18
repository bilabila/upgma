package icst.cyberlab.phylogenetic.upgma.core;

import icst.cyberlab.phylogenetic.upgma.action.MatrixAction;

public class UPGMA {
	private NodeTree[] tree = null;
	private float[][] distanceMatrix = null;
	
	public void run(float[][] matrix, NodeTree[] nodeList){
		// TODO Auto-generated method stub
		this.tree = nodeList;
		this.distanceMatrix = matrix;
		
		System.out.println("Matrix distance input : ");
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				System.out.print(" " + distanceMatrix[i][j]);
			}
			System.out.println();
		}
		
		int t = 1;
		
		/*while(!upgma.checkMatrixToTerminateIterate(matrix)){
			Point point = MatrixAction.findPointMinValueInMatrix(matrix);
			System.out.println("Cluster : " + t + " Value : " + point.getValue() + "  Row : " + point.getRow() + "  Column : " + point.getCol());
			nodeList = upgma.clusterTwoNode(nodeList, matrix[point.getRow()][point.getCol()], point.getRow(), point.getCol());
			matrix = upgma.clusterTwoMatrix(matrix, point.getRow(), point.getCol());
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(" " + matrix[j][i]);
				}
				System.out.println();
			}
			t++;
		}
		System.out.println("Finish");*/
		
		while(!this.checkMatrixToTerminateIterate(distanceMatrix)){
			Point point = MatrixAction.findPointMinValueInMatrix(distanceMatrix);
			System.out.println("Cluster : " + t + " Value : " + point.getValue() + "  Row : " + point.getRow() + "  Column : " + point.getCol());
			tree = this.clusterTwoNode(tree, distanceMatrix[point.getRow()][point.getCol()], point.getRow(), point.getCol());
			matrix = this.clusterTwoMatrix(distanceMatrix, point.getRow(), point.getCol());
			for (int i = 0; i < distanceMatrix.length; i++) {
				for (int j = 0; j < distanceMatrix.length; j++) {
					System.out.print(" " + distanceMatrix[i][j]);
				}
				System.out.println();
			}
			t++;
		}
		System.out.println("Finish");		
	}
	
	public boolean checkMatrixToTerminateIterate(float[][] matrixValue){		
		if(matrixValue.length == 1){
			return true;
		}
		return false;
	}
	
	public float[][] clusterTwoMatrix(float[][] oldMatrix, int firstNode, int secondNode){
		float[][] newMatrix = null;
		
		int numOfNode = oldMatrix.length;
		float[][] addNodeClusterMatrix = new float[numOfNode + 1][numOfNode + 1];
		for (int i = 0; i < addNodeClusterMatrix.length; i++) {
			if(i != numOfNode){
				for (int j = 0; j < addNodeClusterMatrix.length; j++) {
					if(j == numOfNode){
						addNodeClusterMatrix[i][j] = (oldMatrix[i][firstNode] + oldMatrix[i][secondNode]) / 2;
					}else{
						addNodeClusterMatrix[i][j] = oldMatrix[i][j];
					}
				}			
			}else{
				for (int j = 0; j < addNodeClusterMatrix.length; j++){
					addNodeClusterMatrix[i][j] = addNodeClusterMatrix[j][i];
				}
			}
		}
		
		/*for (int i = 0; i < addNodeClusterMatrix.length; i++) {
			for (int j = 0; j < addNodeClusterMatrix.length; j++) {
				System.out.print(" " + addNodeClusterMatrix[i][j]);
			}
			System.out.println();
		}*/
		
		newMatrix = new float[numOfNode - 1][numOfNode - 1];
		int row = 0, col = 0;
		for (int i = 0; i < addNodeClusterMatrix.length; i++) {
			if(i != firstNode && i != secondNode){
				col = 0;
				for (int j = 0; j < addNodeClusterMatrix.length; j++) {
					if(j != firstNode && j != secondNode){
						newMatrix[row][col] = addNodeClusterMatrix[i][j];
						col++;
					}					
				}
				row++;
			}else{
				col = 0;
				for (int j = 0; j < addNodeClusterMatrix.length; j++) {
					if(j != firstNode && j != secondNode){
						newMatrix[row][col] = addNodeClusterMatrix[j][i];
						col++;
					}					
				}
			}
		}
		
		return newMatrix;
	}
	
	public NodeTree[] clusterTwoNode(NodeTree[] sequences, float distance, int firstNode, int secondNode){
		NodeTree[] newSequence = new NodeTree[sequences.length - 1];
		
		NodeTree node = new NodeTree(firstNode + " " + secondNode);
		node.setNodeLeft(sequences[firstNode]);
		node.setNodeRight(sequences[secondNode]);
		node.setDistance(distance);
		
		sequences[firstNode] = node;
		sequences[secondNode] = null;
		
		int j = 0;
		for (int i = 0; i < sequences.length; i++) {
			if(sequences[i] != null){
				newSequence[j] = sequences[i];
				j++;
			}
		}		
		return newSequence;
	}
	
	public NodeTree[] getTree() {
		return tree;
	}

	public void setTree(NodeTree[] tree) {
		this.tree = tree;
	}

	public float[][] getDistanceMatrix() {
		return distanceMatrix;
	}

	public void setDistanceMatrix(float[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	public static void main(String[] args) {
		UPGMA upgma = new UPGMA();
		NodeTree[] nodeList = new NodeTree[5];
		String[] nodeString = {"A", "B", "C", "D", "E"};
		for (int i = 0; i < nodeList.length; i++) {
			nodeList[i] = new NodeTree(nodeString[i]);
		}
		
		float[][] matrix = {{0, 10, 12, 9, 7},
							{10, 0, 4, 4, 14},
							{12, 4, 0, 6, 16},
							{9, 4, 6, 0, 13}, 
							{7, 14, 16, 13, 0}};
		//upgma.run(matrix, nodeList);
		System.out.println("Matrix distance input : ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(" " + matrix[j][i]);
			}
			System.out.println();
		}
		
		int t= 1;
		while(!upgma.checkMatrixToTerminateIterate(matrix)){
			Point point = MatrixAction.findPointMinValueInMatrix(matrix);
			System.out.println("Cluster : " + t + " Value : " + point.getValue() + "  Row : " + point.getRow() + "  Column : " + point.getCol());
			nodeList = upgma.clusterTwoNode(nodeList, matrix[point.getRow()][point.getCol()], point.getRow(), point.getCol());
			matrix = upgma.clusterTwoMatrix(matrix, point.getRow(), point.getCol());
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(" " + matrix[j][i]);
				}
				System.out.println();
			}
			t++;
		}
		System.out.println("Finish");
	}
	
}
