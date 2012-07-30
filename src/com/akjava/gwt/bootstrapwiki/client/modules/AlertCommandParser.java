/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.CodeCommand;

/**
 * 
 *
 */
public class AlertCommandParser implements LineParser{

    public static AlertCommandParser instance=new AlertCommandParser();
    public static AlertCommandParser getInstance(){
        return instance;
    }
    public AlertCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#alert");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
       
        AlertCommand code=new AlertCommand();
        code.setParent(element);
        element.addNode(code);
        
        String attributes[]=this.parseAttributes(line);
        for(int i=0;i<attributes.length;i++){
            code.addAttribute(attributes[i]);
        }
        
        return code;
    }
    
    
    public static String toText(Node node){
        if(node instanceof CodeCommand){
            CodeCommand codeCommand=(CodeCommand)node;
        String result="#alert";
        if(codeCommand.getAttributes().length>0){
        	result+="("+codeCommand.getAttributes()[0]+")";
        }
        return result;
        }else{
            return null;
        }
    }
    
    public String[] parseAttributes(String line){
        int index=line.indexOf("(");
        if(index==-1){
            return new String[0];
        }else{
            int last=line.lastIndexOf(")");
            if(last==-1){
                last=line.length();
                System.out.println("forget )");
            }
            //Math.max(last,);//for forget );
            String ats=line.substring(index+1,last);
            return ats.split(",");
        }
    }
}
