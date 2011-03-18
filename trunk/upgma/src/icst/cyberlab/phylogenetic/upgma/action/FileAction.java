package icst.cyberlab.phylogenetic.upgma.action;

import icst.cyberlab.phylogenetic.upgma.core.NodeTree;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class FileAction {
	
	public static float[][] readMatrixFromMatrixFile(File matrixFile){
		float[][] matrix = null;
		try{
			FileInputStream fstream = new FileInputStream(matrixFile);			
			DataInputStream input = new DataInputStream(fstream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
			String strLine;			
			ArrayList<String> linesOfFile = new ArrayList<String>();
			while ((strLine = bufferedReader.readLine()) != null)   {
				 linesOfFile.add(strLine);
			}
			int sizeMatrix = linesOfFile.size() - 1;
			matrix = new float[sizeMatrix][sizeMatrix];
			for (int i = 1; i < linesOfFile.size(); i++) {
				String[] object = linesOfFile.get(i).trim().split(" ");
				for (int j = 0; j < object.length; j++) {
					matrix[i - 1][j] = Float.parseFloat(object[j]);						
				}
			}
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
			return null;
		}
		return matrix;
	}
	
	public static NodeTree[] readNodeFromMatrixFile(File matrixFile){
		NodeTree[] node = null;
		try{
			FileInputStream fstream = new FileInputStream(matrixFile);			
			DataInputStream input = new DataInputStream(fstream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));			
			String strLine = bufferedReader.readLine();
			String[] object = strLine.split(" ");
			node = new NodeTree[Integer.parseInt(object[0])];
			for (int j = 1; j < object.length; j++) {
				node[j - 1] = new NodeTree(object[j]);							
			}
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
			return null;
		}
		return node;
	}

	public static File loadFileAction(String pathLocationFile){
		File file = new File(pathLocationFile);		
		return file;
	}	
	
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);		
		NodeTree[] node = readNodeFromMatrixFile(fileChooser.getSelectedFile());			
		float[][] matrix = readMatrixFromMatrixFile(fileChooser.getSelectedFile());
		if(matrix != null){
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(matrix[i][j] + " ");
				}
				if(node[i] != null) {
					System.out.println(node[i].getNameNode());
				}				
			}
		}		
		System.exit(0);		
	}
}
