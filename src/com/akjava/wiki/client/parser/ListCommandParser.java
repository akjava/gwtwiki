/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.modules.ListCommand;
import com.akjava.wiki.client.modules.TagCommand;

/**
 * 
 *
 */
public class ListCommandParser implements LineParser{

    public static ListCommandParser instance=new ListCommandParser();
    public static ListCommandParser getInstance(){
        return instance;
    }
    public ListCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#list");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element parentElement, String line) {
        if(parentElement instanceof TagCommand){
            return parentElement;//skip
        }
        //getRootDoc?
        
        // TODO Auto-generated method stub
        ListCommand code=new ListCommand();
        code.setParent(parentElement);
        parentElement.addNode(code);
        return code;
    }
    
    /*
    public static String toText(Node node){
        if(node instanceof TagCommand){
            TagCommand codeCommand=(TagCommand)node;
        String result="#tag";
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
    */
}
