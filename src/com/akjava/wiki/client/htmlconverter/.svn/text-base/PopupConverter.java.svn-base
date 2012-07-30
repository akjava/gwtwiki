/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.EscapeUtil;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Popup;

/**
 * 
 *
 */
public class PopupConverter extends AbstractConverter{

/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    return (node instanceof Popup);
	}
public String toHeader(Node node){
    String result="";
    Popup popup=(Popup)node;
    String attribute[]=popup.getAttributes();
    if(attribute.length>1){
    String text=popup.getText();
    String description=popup.getDescription();
    /*
     * 
     * 
     * 
     */
    String mark="";

    mark="<img src='/img/popup.png' border='0'>";
    
   
    result="<a class='keyword' href=\"javascript:void(0);\" onmouseover=\"return overlib('"+description+"');\" onmouseout=\"return nd();\">"+EscapeUtil.escape(text)+mark+"</a>";
    	
    }
    //currently not support link?
    
    //result=codeCommand.getAttributes()[0];
    return result;
	}
public String toFooter(Node node){
    //currently not support.
    return "";
}
}
