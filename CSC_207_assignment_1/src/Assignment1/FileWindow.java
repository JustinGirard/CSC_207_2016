package Assignment1;
import TestInterface.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

/**
* FileWindow
* 
* <P>Creates a file and browser window that is capable of opening a directory
* @author CSC 207 Instructors
* @version 1.0
*/
public class FileWindow implements ActionListener {
	private JButton openButton;// = new JButton("Disable middle button", leftButtonIcon);
	private JFileChooser fileChooser;// = new JFileChooser();
	private JFrame newFrame;
	private JLabel label;

	JTextArea textArea;

	/**
	* Constructor
	* 
	* <P> Creates the file window, assuming no specific starting directory
	*/
	public FileWindow() 
	{
		this.DoCreate();
	}
	
	/**
	* Show
	* 
	* <P> make the file window visible
	*/
	public void Show()
	{
		newFrame.setVisible(true);				
	}
	
	
	/**
	* main
	* 
	* <P> Create and show a window
	* 
	* @param argsv an array of arguments for the file window, currently unused
	*/
	public static void main(String argsv[]) 
	{
		FileWindow f = new FileWindow();
		f.Show();
	}
		
	/***
	 * runOnDirectory
	 * 
	 * <P> Build a directory tree given a string directory.
	 * 
	 * @param directory The directory to be searched for a tree structure
	 */
	public Node runOnDirectory(String directory)
	{
        File file = new File(directory);
        if(file.exists())
        {
        	label.setText("Selected File " +  file.getAbsolutePath());
	    	Node tree = this.createNewNode();
	    	tree.buildFileTree(file);  
        	this.printFileOutput(tree);
	    	return tree;
        }
        else
        {
	        label.setText("Directory does not exist");
	        return null;
        }
	}
	
/// --------------------------------------------------------------------------	
/// ---- Service methods below -----------------------------------------------	
/// --------------------------------------------------------------------------	
	
	/**
	* DoCreate
	* 
	* <P> Create the file browser window, which may or not be made visible.
	*/
	private void DoCreate()
	{
		// Create Frame
		newFrame = new JFrame("File Browser");		

		//Create File Chooser
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		//Button
		openButton = new JButton("Open File");
		openButton.setVerticalTextPosition(AbstractButton.CENTER);
		openButton.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
		openButton.setMnemonic(KeyEvent.VK_D);
		openButton.setActionCommand("disable");
		openButton.addActionListener(this);		
		
		// Label
		label = new JLabel("Select your file"); 
		//label.setPreferredSize(new Dimension(175, 300));
	
		// Container
		Container c = newFrame.getContentPane();

		// Text Area
		textArea = new JTextArea(15, 50);
		textArea.setEditable(true);

		// Scroll Pane
		JScrollPane scrollPane = new JScrollPane(textArea); 
		// Add Components
		c.add(label, BorderLayout.PAGE_START);
		c.add(scrollPane, BorderLayout.CENTER);
		c.add(openButton, BorderLayout.PAGE_END);
		
		newFrame.pack();		
	}

	/***
	 * printFileOutput
	 * 
	 * <P> Print the file output from a directory, as accessed from a depth first search.
	 * 
	 * @param e the event object.
	 * 
	 */
	private void printFileOutput(Node n) {
		this.textArea.setText("Searching .. ");
		if(n != null) {
			String toShow = "";
			ArrayList<String> lst = n.getChildrenNamesDepthFirst("-");
			for(Iterator<String> i = lst.iterator(); i.hasNext(); )  {
				toShow = toShow + "\n" +i.next();
			}
			this.textArea.setText(toShow);
		}
		else {
		}
	}
	
	/***
	 * actionPerformed
	 * 
	 * <P> Handle form events in a custom manner. Currently just implementation for a button
	 * 
	 * @param ActionEvent e -- the event object
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
	    //Handle open button action.
	    if (e.getSource() == this.openButton) {
	        int returnVal = fileChooser.showOpenDialog(newFrame.getContentPane());//fc.showOpenDialog(FileWindow.this);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            label.setText("Selected File" +  file.getAbsolutePath());
	        	Node fileTree = this.createNewNode();
	        	fileTree.buildFileTree(file);  
	        	this.printFileOutput(fileTree);
	        } 
	        else {
	            label.setText("No Path Selected");
	        }
	   }	
	}
	
	/**
	* createNewNode
	* 
	* <P> Create a File Node for use in the framework
	* 
	* @param String argsv, an array of arguments for the process
	*/
	private Node createNewNode() {
		return new DemoFileNode();
	}
	
}


