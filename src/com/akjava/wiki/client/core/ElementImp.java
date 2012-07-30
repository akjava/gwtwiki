/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import java.util.List;
import java.util.Vector;

import com.akjava.wiki.client.util.SystemUtils;

/**
 * 
 *
 */
public class ElementImp extends NodeImp implements Element{
private List nodeList=new Vector();

private LineParser[] lineParsers;
private StringParser[] stringParsers;

private Element parent;

public Element getParent() {
    return parent;
}
public void setParent(Element parent) {
    this.parent = parent;
}
/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#getLineParses()
 */
public LineParser[] getLineParses() {
    // TODO Auto-generated method stub
    return DefaultParsers.getLineParsers();
}

/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#getStringParsers()
 */
public StringParser[] getStringParsers() {
    // TODO Auto-generated method stub
    return DefaultParsers.getStringParsers();
}

/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#addNode(org.jpn.xucker.wiki.Node)
 */
public void addNode(Node node) {
   nodeList.add(node);
}

/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#removeNode(org.jpn.xucker.wiki.Node)
 */
public void removeNode(Node node) {
   nodeList.remove(node);
}
public void removeAllNode(){
    nodeList.removeAll(nodeList);
}

/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#getNodeAt(int)
 */
public Node getNodeAt(int index) {
    return (Node)nodeList.get(index);
}
public int countNode(){
    return nodeList.size();
}

public String toString(){
   return toString("");
}

public String toString(String head){
    String result=super.toString()+SystemUtils.LINE_SEPARATOR;
    for(int i=0;i<countNode();i++){
        if(getNodeAt(i) instanceof Element){
        result+=head+"\t"+((Element)getNodeAt(i)).toString(head+"\t")+SystemUtils.LINE_SEPARATOR;
               
        }else{
        result+=head+"\t"+getNodeAt(i).toString()+SystemUtils.LINE_SEPARATOR;
        }
    }
    return result;
}
/* (non-Javadoc)
 * @see org.jpn.xucker.wiki.Element#breakUp(org.jpn.xucker.wiki.Element, java.lang.String)
 */
public Element breakUp(Element element, String line) {
    // TODO Auto-generated method stub
    return element;
}

}
