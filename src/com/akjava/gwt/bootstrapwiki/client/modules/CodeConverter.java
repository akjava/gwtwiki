/*
 * Created on 2004/11/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.EscapeUtil;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;

/**
 * 
 *
 */
public class CodeConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof Code);
	}
public String toHeader(Node node){

    Code alink=(Code)node;
    String attribute[]=alink.getAttributes();
    
    if(attribute.length>0){
    String content=attribute[0];
    //TODO support icon
    return "<code>"+EscapeUtil.escape(content)+"</code>";
	}
    return "";
}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
