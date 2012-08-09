/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.LineSeparator;

/**
 * 
 *
 */
public class LineSeparatorConverter extends AbstractConverter{
private Class targetClass=LineSeparator.class;

public boolean canConvert(Node node){
    return node.getClass().equals(targetClass);
	}

public String toHeader(Node node){
    String result="";
    result+="<br>"+(isPretty()?LINE_SEPARATOR:"");
    return result;
	}

public String toFooter(Node node){
    return "";
}

}
