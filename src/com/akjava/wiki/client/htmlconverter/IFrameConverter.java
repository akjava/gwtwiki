/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.IFrame;

/**
 * 
 *
 */
public class IFrameConverter extends AbstractConverter{

/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    return node instanceof IFrame;
	}
public String toHeader(Node node){
    String result="";
    IFrame command=(IFrame)node;
    
    
       
    if(command.getName().equals("iframe")){
        result+="<iframe border=\"0\" src=\""+command.getSrc()+"\" width=\""+command.getWidth()+"\" height=\""+command.getHeight()+"\"></iframe>";
        
        
    }
    return result;
	}
public String toFooter(Node node){
    return "";
}
}
