/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;

import com.akjava.gwt.bootstrapwiki.client.modules.SplitCommand;
import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.modules.TagCommand;

/**
 * 
 *
 */
public class SplitCommandParser implements LineParser{

    public static SplitCommandParser instance=new SplitCommandParser();
    public static SplitCommandParser getInstance(){
        return instance;
    }
    public SplitCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#split");
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
        SplitCommand code=new SplitCommand();
        code.setParent(parentElement);
        parentElement.addNode(code);
        
        String attributes[]=line.split(",");
        for(int i=1;i<attributes.length;i++){
        	code.addAttribute(attributes[i]);
        }
        
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
