/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class SimpleCommandParser extends AbstractCommandParser{
/*
    public static SimpleCommandParser instance=new SimpleCommandParser();
  */
    
    public SimpleCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
       
        return isCommand(line);
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
    	
        
        SimpleCommand command=new SimpleCommand();
        command.setName(this.getCommandName(line));
        element.addNode(command);
        String attributes[]=this.parseAttributes(line);
        for(int i=0;i<attributes.length;i++){
            command.addAttribute(attributes[i]);
        }
        
        return element;
    }
    
    public static String toText(Node node){
        if(node instanceof SimpleCommand){
        SimpleCommand command=(SimpleCommand)node;
        String result="#"+command.getName();
        
        String attr[]=command.getAttributes();
        if(attr.length>0){
            result+="(";
        for (int i = 0; i < attr.length; i++) {
            result+=attr[i];
            if(i!=attr.length-1){
                result+=",";
            }
        }
        result+=")";
        }
        return result;
        }else{
            return null;
        }
    }
}
