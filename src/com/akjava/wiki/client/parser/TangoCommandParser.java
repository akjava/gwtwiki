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
import com.akjava.wiki.client.modules.TangoCommand;

/**
 * 
 *
 */
public class TangoCommandParser implements LineParser{

    public static TangoCommandParser instance=new TangoCommandParser();
    public static TangoCommandParser getInstance(){
        return instance;
    }
    public TangoCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#tango");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
        if(element instanceof CodeCommand){
            return element;//skip
        }
        //getRootDoc?
        
        // TODO Auto-generated method stub
        TangoCommand code=new TangoCommand();
        code.setParent(element);
        element.addNode(code);
        return code;
    }
    
    
    public static String toText(Node node){
        if(node instanceof CodeCommand){
            CodeCommand codeCommand=(CodeCommand)node;
        String result="#tango";
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
}
