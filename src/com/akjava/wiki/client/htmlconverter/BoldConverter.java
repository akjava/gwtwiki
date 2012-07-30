/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.EscapeUtil;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Bold;

/**
 * 
 *
 */
public class BoldConverter extends AbstractConverter{

/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    return (node instanceof Bold) ;
	}
public String toHeader(Node node){
    String result="";
    Bold bold=(Bold)node;
    String attribute[]=bold.getAttributes();
    if(attribute.length>0){
    String link=attribute[0];
   
    
        result="<b>"+EscapeUtil.escape(attribute[0]);
    	
    }
    //result=codeCommand.getAttributes()[0];
    return result;
	}
public String toFooter(Node node){
    //currently not support.
    return "</b>";
}
}
