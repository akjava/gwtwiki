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
    result+=new Comment("�N���G�C�e�B�u�E�R�����Y�E���C�Z���X").toString();
   
   
    A a=new A();
    
    a.setRel("license").setHref("http://creativecommons.org/licenses/by/2.1/jp/")
    .addElement(new IMG().setAlt("�N���G�C�e�B�u�E�R�����Y�E���C�Z���X").setBorder(0).setSrc("http://creativecommons.org/images/public/somerights2.gif"));
    
    result+=a.toString();
    result+="<br>";
    
    result+="����work�́A"+new A().setRel("license").setHref("http://creativecommons.org/licenses/by/2.1/jp/")
    .addElement("�N���G�C�e�B�u�E�R�����Y�E���C�Z���X").toString();
    result+="�̉��Ń��C�Z���X����Ă��܂��B";

    
    result+=new Comment("/�N���G�C�e�B�u�E�R�����Y�E���C�Z���X").toString();

    return result;
	}
public String toFooter(Node node){
    return "";
}
}
