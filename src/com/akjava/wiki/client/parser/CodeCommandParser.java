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
public class CodeCommandParser implements LineParser{

    public static CodeCommandParser instance=new CodeCommandParser();
    public static CodeCommandParser getInstance(){
        return instance;
    }
    public CodeCommandParser(){}

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("#code");
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
        CodeCommand code=new CodeCommand();
        code.setParent(element);
        element.addNode(code);
        String attributes[]=this.getAttributes(line);
        for(int i=0;i<attributes.length;i++){
            code.addAttribute(attributes[i]);
        }
        return code;
    }
    
    
    public static String toText(Node node){
        if(node instanceof CodeCommand){
            CodeCommand codeCommand=(CodeCommand)node;
        String result="#code";
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
    //TODO move AbstractCommandParser?
    public String[] getAttributes(String line){
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
