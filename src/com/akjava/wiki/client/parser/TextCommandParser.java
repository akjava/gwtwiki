/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;



import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.CodeCommand;

/**
 * 
 *
 */
public class TextCommandParser implements LineParser{

    public static TextCommandParser instance=new TextCommandParser();
    public static TextCommandParser getInstance(){
        return instance;
    }
    public TextCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#text");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
        //if code return only.
        if(element instanceof CodeCommand){
            return element.getParent();
        }
        
        return element;
    }
    

}
