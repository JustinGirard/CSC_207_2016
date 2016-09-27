package TestInterface;

import java.io.File;
import java.util.ArrayList;

/**
* Node
* 
* <P> General Node interface. Allows for creating of a hierarchy, 
* and the search of the created hierarchy. Typical implementation is a file system.
* 
* @author CSC 207 Instructors
* @version 1.0
*/
public interface Node {

	/***
	 * FileType()
	 * 
	 * <P> Enumeration of file type, directory, file
	 * 
	 */
	public enum FileType {directory,file};

	/***
	 * getName()
	 * @return name of this Node
	 */
	public String getName();
	

	/***
	 * setName(String name)
	 * 
	 * Set the name of the current node
	 * 
	 * @param name of the file/directory
	 * 
	 */
	public void setName(String name);
	
	/***
	 * setParent(Node parent)
	 * 
	 * Set the parent node of this current file/directory
	 * 
	 * @param parent node for this node
	 */
	public void setParent(Node parent);

	/***
	 * setType(FileType typeIn)
	 * 
	 * Set the type of the file/directory in FileType={directory,file} 
	 * 
	 * @param FileType typeIn - the type that is being set to
	 */
	public void setType(FileType typeIn);

	
	/***
	 * findChild(String name)
	 * 
	 * Find a child node with a certain name, and return it. This will require a tree search.
	 * 
	 * @param node to add 
	 * @return 
	 */
	public Node findChild(String name);

	/***
	 * addChild(Node n)
	 * @param node to add 
	 * @return 
	 */
	public void addChild(Node n);	
	
	/***  !!IMPORTANT!!
	 * getChildrenNamesDepthFirst()
	 * Recursively walks the node tree, beginning at a node with name "name" and constructs
	 * a list of all the children visited during a **depth-first** walk.
	 * @return all children names, recursively, with a spacer
	 */
	public ArrayList<String> getChildrenNamesDepthFirst(String spacer);
	

	/*** !!IMPORTANT!!
	 * buildFileTree()
	 * 
	 * Internally, recursively (or iteratively) build a file tree using any technique. 
	 * All Nodes should have correct parent relationships, and names are either the 
	 * full file name (including extension) or the directory name.
	 * 
	 */
	public void buildFileTree(File inFile);	
	
	/***
	 * isReady()
	 * @return true if this node has a name and type set in a satisfactory manner, false otherwise
	 */
	
	public boolean isReady();


}
