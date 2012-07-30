/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

/**
 * 
 *
 */
public interface Element extends Node{
public LineParser[] getLineParses();
public StringParser[] getStringParsers();
public void addNode(Node node);
public void removeNode(Node node);
public void removeAllNode();
public Node getNodeAt(int index);
public int countNode();
public Element getParent();
public void setParent(Element element);
public String toString(String head);
public Element breakUp(Element element,String line);
}
