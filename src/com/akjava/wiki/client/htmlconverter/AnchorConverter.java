/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class AnchorConverter extends AbstractConverter{





public boolean canConvert(Node node){
	System.out.println(node);
    return (node instanceof SimpleCommand) && ((SimpleCommand)node).getName().equals("anchor");
	}
public String toHeader(Node node){
    String result="";
   
    String attributes[]=((SimpleCommand)node).getAttributes();
    
    if(attributes.length>0){
     String name=attributes[0];
      
       result+="<a name='"+name+"'></a>";
    }
    
    return result;
	}
public String toFooter(Node node){
    return "";
}
}
