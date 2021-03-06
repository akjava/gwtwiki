/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Alink;

/**
 * 
 *
 */
public class AlinkConverter extends AbstractConverter{
private String amazonId="";
/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    return (node instanceof Alink);
	}
public String toHeader(Node node){
    String result="";
    Alink alink=(Alink)node;
    String attribute[]=alink.getAttributes();
    if(attribute.length>1){
    String link=attribute[0];
    String text=attribute[1];
    /*
     * 
     * 
     * 
     */
    String mark="";
    /*
    if(attribute[0].indexOf(".wikipedia.org/")!=-1){
        mark="<img src='/img/wikipedia.png' border='0'>";
        
    }else if(attribute[0].startsWith("asin:")){
//      amazon version
        mark="<img src='/img/amazon_icon.png' border='0'>";
    }
    else if(attribute[0].startsWith("http://pt.afl.rakuten.co.jp")){
        mark="";
    }
    else if(attribute[0].startsWith("http://")){
        mark="<img src='/img/outside.png' border='0'>";
    }*/
    
    if(link.equals(text)){
    	if((link.startsWith("http://") || link.startsWith("https://")) && (link.toLowerCase().endsWith(".jpg") || link.toLowerCase().endsWith(".png"))){
    		result="<img src='"+link+"' border='0'>";	
    	}else{
        result="<a href='"+attribute[0]+"'>"+attribute[0]+mark+"</a>";;
    	}
    	}
    else{
        if(attribute[0].startsWith("asin:")){
            String amazon="http://www.amazon.co.jp/exec/obidos/ASIN/"+attribute[0].substring(5)+"/"+amazonId;
            
            result="<a href='"+amazon+"'>"+attribute[1]+mark+"</a>";
        }else{
            result="<a href='"+attribute[0]+"'>"+attribute[1]+mark+"</a>";
        }
        
    	}
    }
    //result=codeCommand.getAttributes()[0];
    return result;
	}

public String toFooter(Node node){
    //currently not support.
    return "";
}
public String getAmazonId() {
	return amazonId;
}
public void setAmazonId(String amazonId) {
	this.amazonId = amazonId;
}

}
