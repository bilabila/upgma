package icst.cyberlab.phylogenetic.upgma.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

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
	private JButton jButton0;
	private JTable jTable0;
	private JScrollPane jScrollPane0;
	private JPanel jPanel0;
	private JTextArea jTextArea0;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JSplitPane jSplitPane0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public UPGMAApplication() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJSplitPane0(), new Constraints(new Bilateral(12, 12, 202), new Bilateral(12, 12, 28)));
		setJMenuBar(getJMenuBar0());
		setSize(1037, 715);
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
			jPanel2.setLayout(new GroupLayout());
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

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "Matrix distance input", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new Font(
					"Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJButton0(), new Constraints(new Trailing(12, 12, 12), new Trailing(12, 51, 482)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Bilateral(11, 12, 22), new Bilateral(13, 50, 26, 403)));
		}
		return jPanel0;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTable0());
		}
		return jScrollPane0;
	}

	private JTable getJTable0() {
		if (jTable0 == null) {
			jTable0 = new JTable();
			jTable0.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Title 0", "Title 1", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return jTable0;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Run");
		}
		return jButton0;
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
		}
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
