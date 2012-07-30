/*
 * Created on 2004/10/24
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.modules.Alink;
import com.akjava.wiki.client.util.TagUtil;

/**
 * 
 *
 */
public class CodeStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("<code>") || line.startsWith("<code/>") || line.startsWith("<code ") ;
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
        String all=TagUtil.getTag(line);
        if(all==null){
            throw new RuntimeException("code tag parse faild."+line);
        }
       
        
        	//need?
        	 int start=all.indexOf(">");
             int end=all.indexOf("</code>",start);
             String content=null;
             if(end!=-1){
             content=all.substring(start+1,end);
             }
                 //TagUtil.getContain(all);
        
        
       
       
        Code alink=new Code();
        if(content!=null){
        alink.addAttribute(content);
        }
       
        
        element.addNode(alink);
        
        return line.substring(all.length());
    }
    
    public static CodeStringParser instance=new CodeStringParser();
    public static CodeStringParser getInstance(){
        return instance;
    }
    public CodeStringParser(){}
    
    
    public static String toText(Node node){
        if(node instanceof Alink){
            
        String result=null;
        Alink alink=(Alink)node;
        String attribute[]=alink.getAttributes();
        if(attribute.length>1){
        String link=attribute[0];
        String text=attribute[1];
        if(link.equals(text)){
            result="<i class='"+attribute[0]+"'/>";
        	}
        else{
            result="<i class='"+attribute[0]+"'>"+attribute[1]+"</i>";
        	}
        }
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
}
