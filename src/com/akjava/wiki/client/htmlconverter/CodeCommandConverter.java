/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.NodeConverter;
import com.akjava.wiki.client.modules.CodeCommand;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class CodeCommandConverter extends AbstractConverter{

/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    return (node instanceof CodeCommand);
	}


public String toHeader(Node node){
    String result="";
    result+="<pre";
    String attributes[]=((CodeCommand)node).getAttributes();
    if(attributes.length>0){
    	result+=" class='prettyprint "+ attributes[0]+"'";
    }else{
    	//result+=" check";
    }
    result+=">";
    
    
    return result;
	}
public String toFooter(Node node){

    return "</pre>";
}
}
