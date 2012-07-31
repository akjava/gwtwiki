/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;


import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.ecs.A;
import com.akjava.wiki.client.ecs.Comment;
import com.akjava.wiki.client.ecs.IMG;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class CreativeCommonsConverter extends AbstractConverter{



public boolean canConvert(Node node){
    return (node instanceof SimpleCommand) && ((SimpleCommand)node).getName().equals("commons1");
	}
public String toHeader(Node node){
	
    String result="";
    result+=new Comment("クリエイティブ・コモンズ・ライセンス").toString();
   
   
    A a=new A();
    
    a.setRel("license").setHref("http://creativecommons.org/licenses/by/2.1/jp/")
    .addElement(new IMG().setAlt("クリエイティブ・コモンズ・ライセンス").setBorder(0).setSrc("http://creativecommons.org/images/public/somerights2.gif"));
    
    result+=a.toString();
    result+="<br>";
    
    result+="このworkは、"+new A().setRel("license").setHref("http://creativecommons.org/licenses/by/2.1/jp/")
    .addElement("クリエイティブ・コモンズ・ライセンス").toString();
    result+="の下でライセンスされています。";

    
    result+=new Comment("/クリエイティブ・コモンズ・ライセンス").toString();

    return result;
	}
public String toFooter(Node node){
    return "";
}
}
