/*
 * Created on 2004/10/24
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.core.WikiException;
import com.akjava.wiki.client.modules.Alink;
import com.akjava.wiki.client.util.TagUtil;

/**
 * 
 *
 */
public class ALinkStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("<a ");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) throws WikiException{
        String all=TagUtil.getTag(line);
        if(all==null){
            throw new WikiException("A link tag parse faild."+line);
        }
        //System.out.println("all:"+all+","+line);
        String href=(String)TagUtil.getAttribute(all).get("href");
        if(href==null){
            throw new WikiException("Alink need href:"+line);
        }
        int start=all.indexOf(">");
        int end=all.indexOf("</a>",start);
        String content=null;
        if(end!=-1){
        content=all.substring(start+1,end);
        }
            //TagUtil.getContain(all);
        Alink alink=new Alink();
        alink.addAttribute(href);
        if(content!=null)
            alink.addAttribute(content);
        else
            alink.addAttribute(href);
            
        element.addNode(alink);
        
        return line.substring(all.length());
    }
    
    public static ALinkStringParser instance=new ALinkStringParser();
    public static ALinkStringParser getInstance(){
        return instance;
    }
    public ALinkStringParser(){}
    
    
    public static String toText(Node node){
        if(node instanceof Alink){
            
        String result=null;
        Alink alink=(Alink)node;
        String attribute[]=alink.getAttributes();
        if(attribute.length>1){
        String link=attribute[0];
        String text=attribute[1];
        if(link.equals(text)){
            result="<a href='"+attribute[0]+"'/>";
            //TODO direct alink?
        	}
        else{
            result="<a href='"+attribute[0]+"'>"+attribute[1]+"</a>";
        	}
        }
        //result=codeCommand.getAttributes()[0];
        return result;
        }else{
            return null;
        }
    }
}
