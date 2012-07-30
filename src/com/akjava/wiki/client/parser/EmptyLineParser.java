/*
 * Created on 2004/11/20
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.modules.LineSeparator;
import com.akjava.wiki.client.modules.SimpleCommand;

/**
 * 
 *
 */
public class EmptyLineParser implements LineParser{

    public static EmptyLineParser instance=new EmptyLineParser();
    public static EmptyLineParser getInstance(){
        return instance;
    }
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.equals("");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
        LineSeparator command=new LineSeparator();
        //command.setName("br");
        //command.addAttribute("br");
        element.addNode(command);
        return element;
    }

}
