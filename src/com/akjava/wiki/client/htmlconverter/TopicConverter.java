/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;

import java.io.UnsupportedEncodingException;



import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Topic;

/**
 * 
 *
 */
public class TopicConverter extends AbstractConverter{
private Class targetClass=Topic.class;
private boolean lineSeparate=true;
public boolean canConvert(Node node){
    return node.getClass().equals(targetClass);
	}

public String toHeader(Node node){
    String result="";
   //TODO re support anchor
    //result+="<a name='"+toEncode(((Topic)node).getTitle())+"'></a>";
    
    result+="<h";
    result+=((Topic)node).getLevel();
    result+=">";
    result+=((Topic)node).getTitle();
    result+="</h"+((Topic)node).getLevel()+">";
    if(lineSeparate){
    	result+="\n";
    }
    return result;
	}

public String toFooter(Node node){
   return "";
}
/*
public String toEncode(String string){
    try {
        return URLEncoder.encode(string,"Shift_JIS");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
}*/
}
