/*
 * Created on 2004/11/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;

/**
 * 
 *
 */
public class BLabelConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof BLabel);
	}
public String toHeader(Node node){
    String result="";
    BLabel alink=(BLabel)node;
    String attribute[]=alink.getAttributes();
    if(attribute.length>1){
    String link=attribute[0];
    String text=attribute[1];
    /*
     * 
     * 
     * 
     */
   //<span class="label label-info">NDK Box2D</span>
    result="<span class='label label-"+link+"'>"+text+"</span>";;
    
    }
    //result=codeCommand.getAttributes()[0];
    return result;
	}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
