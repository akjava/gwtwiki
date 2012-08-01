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
public class BtnConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof Btn);
	}
public String toHeader(Node node){
    String result="";
    Btn btn=(Btn)node;
    
    String type=btn.getType();
    String content=btn.getContent();
    String href=btn.getHref();
    String size=btn.getSize();
    
    if(type!=null && content!=null && href!=null){
    	String sizeText="";
    	if(size!=null){
    		sizeText=" btn-"+size;
    	}
    	String btnType="";
    	if(!type.equals("default")){
    		btnType=" btn-"+type;
    	}
    	result+="<a href='"+href+"'>";
    	result+="<button "+"class='btn"+btnType+sizeText+"'>";
    	result+=content;
    	result+="</button>";
    	result+="</a>";
    	
    }
    //result=codeCommand.getAttributes()[0];
    return result;
	}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
