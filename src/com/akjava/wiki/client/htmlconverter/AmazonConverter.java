/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.ecs.IFrame;
import com.akjava.wiki.client.modules.AmazonCommand;


/**
 * 
 *
 */
public class AmazonConverter extends AbstractConverter{
private String userId="";

public boolean canConvert(Node node){
    return node instanceof AmazonCommand;
	}
public String toHeader(Node node){
    String result="";
    AmazonCommand command=(AmazonCommand)node;
    
    if(command.getName().equals("amazon")){
    	 String asins[]=command.getAsins();
    	    if(asins.length>1){
    	    	result+="<table height=240px margin=0 padding=0><tr>";
    	    }
    	    for (int i = 0; i < asins.length; i++) {
    	    	
    	    	if(asins.length>1){
	    	    	result+="<td width='120'>";
	    	    }
    	    	
    	    	String src="http://rcm-jp.amazon.co.jp/e/cm?t="+userId+"&o=9&p=8&l=as1&asins="+asins[i]+"&fc1=000000&IS2=1&lt1=_blank&lc1=0000FF&bc1=000000&bg1=FFFFFF&f=ifr";
    	        
    	        IFrame iframe=new IFrame();
    	        iframe.setSrc(src);
    	        iframe.setStyle("width:120px;height:240px;");
    	        iframe.setScrolling("no");
    	        iframe.setFrameBorder(false);
    	        iframe.setMarginWidth(0);
    	        iframe.setMarginHeight(0);
    	        result+=iframe.toString();
    	        
    	    	
    	    	
    	    	 if(asins.length>1){
    	    	    	result+="</td>";
    	    	    }
    		}
    	    if(asins.length>1){
    	    	result+="</tr></table>";
    	    }
    	 
        
       
        
    }

    return result;
	}
public String toFooter(Node node){
    return "";
}
public  String getUserId() {
	return userId;
}
public  void setUserId(String userId) {
	this.userId = userId;
}
}
