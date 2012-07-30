/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.EscapeUtil;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Text;

/**
 * 
 *
 */
public class TextConverter extends AbstractConverter{
private Class targetClass=Text.class;

public boolean canConvert(Node node){
    return node.getClass().equals(targetClass);
	}

public String toHeader(Node node){
    String result="";
    result+=EscapeUtil.escape(((Text)node).getText());
    return result;
	}

public String toFooter(Node node){
    return "";
}

}
