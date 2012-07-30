/*
 * Created on 2004/11/24
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.modules.PlainText;
import com.akjava.wiki.client.util.SystemUtils;

/**
 * 
 * for codeCommand.
 */
public class PlainTextLineParser extends SimpleCommandParser{
    public boolean canParse(String line) {
        
         return true;
     }

     /* (non-Javadoc)
      * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
      */
     public Element parse(Element element, String line) {
         
         
        element.addNode(new PlainText(line+SystemUtils.LINE_SEPARATOR));
        
        
         return element;
     }
     
     /*
     public static String toText(Node node){
         return "";
         
     }
     */
}
