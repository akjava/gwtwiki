/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import java.util.List;
import java.util.Vector;

/**
 * 
 *
 */
public class NodeImp implements Node{
private String name;
private List attributes=new Vector();
public String[] getAttributes(){
    return (String[])attributes.toArray(new String[attributes.size()]);
}

public String getAttributeAt(int index){
    return (String)attributes.get(index);
}

public void setAttributeAt(String value,int index){
    attributes.set(index,value);
}

public void addAttribute(String value){
    attributes.add(value);
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public String toString(){
    String result=""+name+"=";
    String[] attributes=getAttributes();
    for(int i=0;i<attributes.length;i++){
        result+=attributes[i];
        if(i!=attributes.length-1){
            result+=",";
        }
    	}
    return result;
	}
}
