/*
 * Program Name: TagList.java
 * Author: Youssef Rizk
 * Date Modified: 3/28/15
 * 
 * This class creates a basic Doubly-Linked List that holds a string within each node.
 * The list can perform basic functions such as adding a node to the end of the list,
 * removing a node from the front of the list, returning the number of elements in the list,
 * and checking to see if the list is empty.
 * 
 */

package com.example.mmowgli_backend;

import java.util.*;

public class TagList 
{
	
	private int numElements = 0;
	private Node front;
	private Node back;
	
	/*
	 * TagList - creates a linked list with two dummy nodes for the front and back
	 */
	public TagList()
	{
		front = new Node();
		back = new Node();
		front.next = back;
		back.prev = front;
	}
	
	/*
	 * Node - creates an object with a String that holds the data and can point to the next
	 * or previous card in a linked list
	 */
	private class Node
	{
		private Node next;
		private Node prev;
		private String item;
	}
	
	/*
	 * isEmpty - returns true if the linked list contains no Nodes other than the front node 
	 * and returns false if there are nodes in the linked list.
	 */
	public boolean isEmpty()
	{
		if(numElements == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * size - returns the number of elements in the linked list
	 */
	public int size()
	{
		return numElements;
	}
	
	/*
	 * addTag - adds a node to the back of the linked list containing tag data
	 */
	public void addTag(String c)
	{
		//Temporary node holds address of the last node in the list
	    Node lastNode = back.prev;

	    //A new node is created for insertion into the list 
	    Node newNode = new Node();

	    //The new Node's card data is set to the passed in card
	    newNode.item = c;

	    //The new Node's next address is assigned as the back of the list's dummy node
	    newNode.next = back;

	    //The new Node's previous address is set to the address of the initial last node
	    newNode.prev = lastNode;

	    //The dummy node at the back of the list is updated to hold the address of the new Node
	    back.prev = newNode;

	    //The initial last node's next address is updated to hold the address of the new last node
	    lastNode.next = newNode;

	    //Number of elements incremented by 1
	    numElements++;
	}
	
	/*
	 * getTag - removes the first node in the list and returns a String with the values
	 * contained in the first node.
	 */
	public String getTag()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		String frontTag = front.next.item;
		front.next = front.next.next;
		front.next.prev = front;
		numElements--;
		
		return frontTag;
	}
	
}
