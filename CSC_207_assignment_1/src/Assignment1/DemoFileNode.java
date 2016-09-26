package Assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import TestInterface.Node;
import TestInterface.Node.FileType;
/***
 * 
 * A DemoFileNode demonstrates how one element in a virtual 
 * file hierarchy can be created and used. This virtual node is also 
 * responsible for searching a directory and creating itself, and children nodes.
 * 
 * DemoFileNode : This is the minimum *stub* implementation that allows the 
 * Swing application program to run in a demo capacity.
 * 
 * @author 2016 CSC 207 Instructors
 */
public class DemoFileNode implements Node {

	
	public String getName() {
		return "Demo";
	}
	
	public DemoFileNode() {
	}
	
	public void setName(String name){
	}

	public void setParent(Node parent){
	}
	
	public void setType(FileType typeIn){
	}
	
	public boolean isReady(){
		return true;
	}
	
	public void addChild(Node n) {
	}

	public ArrayList<String> getChildrenNamesDepthFirst(String spacer) {
		/*
		 * Should recursively, in a depth first manner, 
		 * find, then return a list of all files and folders
		 * 
		 * */
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Item");
		list.add(spacer+"Nested_Item");
		list.add(spacer+"Nested_Item_2");
		list.add(spacer+spacer+"Nested_Nested_Item_1");
		list.add(spacer+spacer+"Nested_Nested_Item_1");
		list.add(spacer+"Nested_Item_3");
		list.add("Item1");
		list.add("Item2");
		
		return list;
	}
	

	/***
	 * BuildFileTree()
	 * @return all children, recursively
	 */
	public void buildFileTree(File inFile) {
		/*
		 * Should recursively *Build* a tree structure of a directory
		 * */
	}

	public Node findChild(String name) {
		/*
		 * Should recursively find, then return a child from the tree 
		 * */
		return null;
	}
}
