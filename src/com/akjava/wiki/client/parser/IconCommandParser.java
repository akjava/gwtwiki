/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.modules.AmazonCommand;
import com.akjava.wiki.client.modules.IconCommand;
import com.akjava.wiki.client.modules.RefCommand;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class IconCommandParser extends SimpleCommandParser{
    public boolean canParse(String line) {
        
         return line.startsWith("#icon");
     }

     /* (non-Javadoc)
      * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
      */
     public Element parse(Element element, String line) {
         
         
         IconCommand command=new IconCommand();
         command.setName(this.getCommandName(line));
         element.addNode(command);
         String attributes[]=this.getAttributes(line);
         for(int i=0;i<attributes.length;i++){
             command.addAttribute(attributes[i]);
         }
         
         return element;
     }
}
