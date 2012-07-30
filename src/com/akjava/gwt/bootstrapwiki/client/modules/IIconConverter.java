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
public class IIconConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof IIcon);
	}
public String toHeader(Node node){
   
    IIcon alink=(IIcon)node;
    String attribute[]=alink.getAttributes();
    
    if(attribute.length>0){
    String clazz=attribute[0];  
    return "<i class='"+clazz+"'></i>";
	}
    return "";
}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
