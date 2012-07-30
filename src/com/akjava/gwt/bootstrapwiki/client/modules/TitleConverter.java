/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class TitleConverter extends AbstractConverter{


	
public boolean canConvert(Node node){
    return (node instanceof SimpleCommand) && ((SimpleCommand)node).getName().equals("title");
	}
public String toHeader(Node node){
    String result="";
    
    result+="<div class=\"page-header\">"+"<h2>";
   
    String attributes[]=((SimpleCommand)node).getAttributes();
    if(attributes.length>0){
       result+=attributes[0];
      
       if(attributes.length>1){
    	   result+="<small> "+attributes[1]+"</small>";
       }
       result+="</h2>";
    }else{
        throw new RuntimeException("title command need attribute[0]:"+node);
    }
    
    return result;
	}
public String toFooter(Node node){
    return "</div>";
}
}
