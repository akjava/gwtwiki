/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.TagCommand;

/**
 * 
 *
 */
public class TagCommandParser implements LineParser{

    public static TagCommandParser instance=new TagCommandParser();
    public static TagCommandParser getInstance(){
        return instance;
    }
    public TagCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#tag");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
        if(element instanceof TagCommand){
            return element;//skip
        }
        //getRootDoc?
        
        // TODO Auto-generated method stub
        TagCommand code=new TagCommand();
        code.setParent(element);
        element.addNode(code);
        return code;
    }
    
    
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
}
