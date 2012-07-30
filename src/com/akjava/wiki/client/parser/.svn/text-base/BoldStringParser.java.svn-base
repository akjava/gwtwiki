/*
 * Created on 2004/10/24
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.modules.Alink;
import com.akjava.wiki.client.modules.Bold;

/**
 * 
 *
 */
public class BoldStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("''");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
        int last=line.indexOf("''",2);
        if(last!=-1){
            String text=line.substring(2,last);
            Bold bold=new Bold();
            bold.addAttribute(text);
            element.addNode(bold);
        }
        return line.substring(last+2);
    }
    
    private static BoldStringParser instance=new BoldStringParser();
    public static BoldStringParser getInstance(){
        return instance;
    }
    public BoldStringParser(){}
    
    
    public static String toText(Node node){
        if(node instanceof Bold){
        String result=null;
        Bold alink=(Bold)node;
        String attribute[]=alink.getAttributes();
        if(attribute.length>0){
      
        String text=attribute[0];
        result="''"+text+"''";
        }
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
}
