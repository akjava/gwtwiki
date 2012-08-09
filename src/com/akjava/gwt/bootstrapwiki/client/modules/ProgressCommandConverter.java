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
public class ProgressCommandConverter extends AbstractConverter{

public boolean canConvert(Node node){
    return (node instanceof ProgressCommand);
	}
public String toHeader(Node node){
    String result="";
    
    ProgressCommand progress=(ProgressCommand)node;
    
    
    String persent="100%";
    if(progress.getPersent()!=null){
    	persent=progress.getPersent();
    }
    
    String type=""; //i prefer
    if(progress.getType()!=null){
    	if(progress.getType().equals("default")){
    		type="";
    	}else {
    		type="progress-"+progress.getType();
    	}
    }
    String color=""; //i prefer
    if(progress.getColor()!=null){
    	color="progress-"+progress.getColor();
    }
    String width;
    if(progress.getWidth()==0){
    	width="";
    }else{
    	width=progress.getWidth()+"px";
    }
    result="<div class='progress"+
    		(type.isEmpty()?"":" "+type)+
    		(color.isEmpty()?"":" "+color)+"'"+
    		(width.isEmpty()?"":" style='width:"+width+";'")+
    		">"+(isPretty()?LINE_SEPARATOR:"");
    result+="<div class='bar' style='width:"+persent+";'></div>"+(isPretty()?LINE_SEPARATOR:"");
    	
    result+="</div>"+(isPretty()?LINE_SEPARATOR:"");
    return result;
	}

public String toFooter(Node node){
    //currently not support.
    return "";
}

}
