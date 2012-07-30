/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.*;
import com.akjava.wiki.client.modules.*;

/**
 * 
 *
 */
public class TextStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static String toText(Node node){
        if(node instanceof Text){
            Text text=(Text)node;
        String result="";
        result=text.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }

}
