/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.NodeConverter;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class DownloadConverter extends AbstractConverter{

/*
private static AmazonConverter instance=new AmazonConverter();
protected AmazonConverter(){};
public static AmazonConverter getInstance(){
    return instance;
}*/

public boolean canConvert(Node node){
    if(node instanceof SimpleCommand){
        return ((SimpleCommand)node).getName().equals("download");
        
    }
    return false;
	}

public String toHeader(Node node){
    String result="";
    SimpleCommand command=(SimpleCommand)node;
    
    
    http://www.amazon.co.jp/exec/obidos/ASIN/"+asin+"/"+userId
        
    if(command.getName().equals("download")){
        String attributes[]=command.getAttributes();
        result="<div class='download'>";
        result+=attributes[0]+"<br>";
        result+="<a href='"+attributes[1]+"' class='font32'>"+"ダウンロード"+"</a>";
        result+="</div>";
        
    }
    return result;
	}
public String toFooter(Node node){
    return "";
}
}
