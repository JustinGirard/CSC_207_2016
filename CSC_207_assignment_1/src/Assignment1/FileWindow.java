package Assignment1;
import TestInterface.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.tools.JavaCompiler;

public class FileWindow implements ActionListener {
	private JButton openButton;// = new JButton("Disable middle button", leftButtonIcon);
	private JFileChooser fileChooser;// = new JFileChooser();
	private JFrame newFrame;
	private JLabel label;

	JTextArea textArea;

	/***
	 * toString()
	 * @return the String name of the node
	 */
	public FileWindow() 
	{
		this.DoCreate();
	}
	public void Show()
	{
		newFrame.setVisible(true);				
	}
	
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
	 * toString()
	 * @return the String name of the node
	 */
	public static void main(String argsv[]) 
	{
		FileWindow f = new FileWindow();
		f.Show();
	}
	
	private Node CreateNewNode()
	{
		return new DemoFileNode();
	}
	
	public Node runOnDirectory(String directory)
	{
        File file = new File(directory);
        if(file.exists())
        {
        	label.setText("Selected File " +  file.getAbsolutePath());
	    	Node tree = this.CreateNewNode();
	    	tree.buildFileTree(file);  
        	this.PrintFileOutput(tree);
	    	return tree;
        }
        else
        {
	        label.setText("Directory does not exist");
	        return null;
        }
	}
	
	
	
	private void PrintFileOutput(Node n) {
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
	 * toString()
	 * @return the String name of the node
	 */
	public void actionPerformed(ActionEvent e) {
	    //Handle open button action.
	    if (e.getSource() == this.openButton) {
	        int returnVal = fileChooser.showOpenDialog(newFrame.getContentPane());//fc.showOpenDialog(FileWindow.this);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            label.setText("Selected File" +  file.getAbsolutePath());
	        	Node fileTree = this.CreateNewNode();
	        	fileTree.buildFileTree(file);  
	        	this.PrintFileOutput(fileTree);
	        } 
	        else {
	            label.setText("No Path Selected");
	        }
	   }	
	}
}


