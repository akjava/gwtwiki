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
public class DivCommandParser implements LineParser{

    public static DivCommandParser instance=new DivCommandParser();
    public static DivCommandParser getInstance(){
        return instance;
    }
    public DivCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#div");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
       
        DivCommand code=new DivCommand();
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
        String result="#div";
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
