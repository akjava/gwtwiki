/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.modules.AmazonCommand;
import com.akjava.wiki.client.modules.RefCommand;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class RefCommandParser extends SimpleCommandParser{
    public boolean canParse(String line) {
        
         return line.startsWith("#ref");
     }

     /* (non-Javadoc)
      * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
      */
     public Element parse(Element element, String line) {
         
         
         RefCommand command=new RefCommand();
         command.setName(this.getCommandName(line));
         element.addNode(command);
         String attributes[]=this.getAttributes(line);
         for(int i=0;i<attributes.length;i++){
             command.addAttribute(attributes[i]);
         }
         
         return element;
     }
}
