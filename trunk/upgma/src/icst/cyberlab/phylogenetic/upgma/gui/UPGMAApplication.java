package icst.cyberlab.phylogenetic.upgma.gui;

import icst.cyberlab.phylogenetic.upgma.action.FileAction;
import icst.cyberlab.phylogenetic.upgma.core.NodeTree;
import icst.cyberlab.phylogenetic.upgma.core.UPGMA;
import info.bioinfweb.treegraph.document.Document;
import info.bioinfweb.treegraph.document.io.DocumentReader;
import info.bioinfweb.treegraph.document.io.ReadWriteFactory;
import info.bioinfweb.treegraph.gui.dialogs.io.loadlogger.LoadLoggerDialog;
import info.bioinfweb.treegraph.gui.treeframe.TreeViewPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class UPGMAApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem openFile;
	private JMenuItem saveMenuItem;
	private JMenuItem exitMenuItem;
	private JMenu fileMenu;
	private JMenuItem jMenuItem1;
	private JMenu optionMenu;
	private JMenuItem jMenuItem5;
	private JMenu helpMenu;
	private JMenuBar jMenuBar0;
	private JButton runButton;
	private JScrollPane jScrollPane0;
	private JPanel jPanel0;
	private JTextArea jTextArea0;
	private JTextArea matrixTextArea;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JSplitPane jSplitPane0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	private UPGMA upgma;
	
	public UPGMAApplication() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJSplitPane0(), new Constraints(new Bilateral(12, 12, 202), new Bilateral(12, 12, 28)));
		setJMenuBar(getJMenuBar0());
		setSize(1037, 715);
		//initial upgma object
		upgma = new UPGMA();
	}

	private JSplitPane getJSplitPane0() {
		if (jSplitPane0 == null) {
			jSplitPane0 = new JSplitPane();
			jSplitPane0.setDividerLocation(484);
			jSplitPane0.setLeftComponent(getJPanel0());
			jSplitPane0.setRightComponent(getJPanel1());
		}
		return jSplitPane0;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD,
					12), new Color(51, 51, 51)));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJScrollPane1(), new Constraints(new Bilateral(11, 12, 22), new Leading(12, 184, 10, 10)));
			jPanel1.add(getJPanel2(), new Constraints(new Bilateral(11, 12, 0), new Bilateral(208, 12, 0)));
		}
		return jPanel1;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Phynogenetic Tree", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel2.setLayout(new BorderLayout());
		}
		return jPanel2;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBorder(BorderFactory.createTitledBorder(null, "Process", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font("Dialog",
					Font.BOLD, 12), new Color(51, 51, 51)));
			jScrollPane1.setViewportView(getJTextArea0());
		}
		return jScrollPane1;
	}

	private JTextArea getJTextArea0() {
		if (jTextArea0 == null) {
			jTextArea0 = new JTextArea();
		}
		return jTextArea0;
	}
	
	private JTextArea getMatrixTextArea() {
		if (matrixTextArea == null) {
			matrixTextArea = new JTextArea();			
		}
		return matrixTextArea;
	}
	
	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Matrix distance input", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font(
					"Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getRunButton(), new Constraints(new Trailing(12, 12, 12), new Trailing(12, 51, 482)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Bilateral(11, 12, 22), new Bilateral(13, 50, 26, 403)));
		}
		return jPanel0;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getMatrixTextArea());
		}
		return jScrollPane0;
	}	

	private JButton getRunButton() {
		if (runButton == null) {
			runButton = new JButton();
			runButton.setText("Run");
			runButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Thread thread = new Thread(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							String outProcess = upgma.run();
							jTextArea0.setText(outProcess);
							///thu nghiep
							Document doc = null;
							File file = new File("b.xml");
							if ((file != null)) {
								if (file.canRead()) {
									DocumentReader reader = ReadWriteFactory.getInstance().getReader(file);
									if (reader != null) {
										try {
											doc = reader.read(file, LoadLoggerDialog.getInstance());
										}
										catch (Exception ex) {
											ex.printStackTrace();
											JOptionPane.showMessageDialog(null, "The error \"" + ex.getMessage() + 
													"\" occured when trying to open the file \"" + file.getAbsolutePath() + 
													"\"", "Error", JOptionPane.ERROR_MESSAGE);
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "The file \"" + file.getAbsolutePath() + 
												"\" does not have a supported format.", "Format error", 
												JOptionPane.ERROR_MESSAGE);
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "The file \"" + file.getAbsolutePath() + 
											"\" cannot be opened.", "File error", JOptionPane.ERROR_MESSAGE);
								}
							}
							
							final TreeViewPanel treeViewPanel = new TreeViewPanel(doc);
							treeViewPanel.setLayout(new GridBagLayout());			
							treeViewPanel.addMouseListener(new MouseListener(){

								@Override
								public void mouseClicked(MouseEvent arg0) {
									// TODO Auto-generated method stub
									if(arg0.getButton() == MouseEvent.BUTTON1){
										float zoom = treeViewPanel.getZoom();
										zoom++;
										treeViewPanel.setZoom(zoom);
										treeViewPanel.requestFocus();
									}
									if(arg0.getButton() == MouseEvent.BUTTON3){
										float zoom = treeViewPanel.getZoom();
										zoom--;
										treeViewPanel.setZoom(zoom);
										treeViewPanel.requestFocus();
									}
								}

								@Override
								public void mouseEntered(MouseEvent arg0) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mouseExited(MouseEvent arg0) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mousePressed(MouseEvent arg0) {
									// TODO Auto-generated method stub
									
								}

								@Override
								public void mouseReleased(MouseEvent arg0) {
									// TODO Auto-generated method stub
									
								}
								
							});
							JScrollPane treeScrollPane = new JScrollPane();
							treeScrollPane.setViewportView(treeViewPanel);
					        jPanel2.add(treeScrollPane, BorderLayout.CENTER);
					        jPanel2.repaint();
					        
						}
						
					});
					
					thread.start();
				}
			});
		}
		return runButton;
	}

	private JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getFileMenu());
			jMenuBar0.add(getOptionMenu());
			jMenuBar0.add(getHelpMenu());
		}
		return jMenuBar0;
	}

	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getJMenuItem5());
		}
		return helpMenu;
	}

	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("About");
		}
		return jMenuItem5;
	}

	private JMenu getOptionMenu() {
		if (optionMenu == null) {
			optionMenu = new JMenu();
			optionMenu.setText("Option");
			optionMenu.setOpaque(false);
			optionMenu.add(getJMenuItem1());
		}
		return optionMenu;
	}

	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Configuration");
		}
		return jMenuItem1;
	}

	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.setOpaque(false);
			fileMenu.add(getOpenFile());
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
		}
		return exitMenuItem;
	}

	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
		}
		return saveMenuItem;
	}

	private JMenuItem getOpenFile() {
		if (openFile == null) {
			openFile = new JMenuItem();
			openFile.setText("Open");
			openFile.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub				
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showOpenDialog(null);

					File file = fileChooser.getSelectedFile();
					if(file != null){							
						upgma.setTree(FileAction.readNodeFromMatrixFile(file));			
						upgma.setDistanceMatrix(FileAction.readMatrixFromMatrixFile(file));
						StringBuffer matrixInput = new StringBuffer();
						matrixInput.append("Matrix input : ");
						matrixInput.append("\n");
						float[][] matrix = upgma.getDistanceMatrix();
						NodeTree[] node = upgma.getTree();
						if(matrix != null){
							for (int i = 0; i < matrix.length; i++) {
								StringBuffer line = new StringBuffer();
								for (int j = 0; j < matrix.length; j++) {
									line.append(matrix[i][j] + " ");
								}
								if(node[i] != null) {
									line.append(node[i].getNameNode());
									line.append("\n");
								}				
								matrixInput.append(line);
							}
							matrixTextArea.setText(matrixInput.toString());
							matrixTextArea.repaint();
						}		
					}
				}
				
			});					}
		return openFile;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
				UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UPGMAApplication frame = new UPGMAApplication();
				frame.setDefaultCloseOperation(UPGMAApplication.EXIT_ON_CLOSE);
				frame.setTitle("UPGMAApplication");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
