/*
 * Created on 2004/10/24
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.modules.Img;
import com.akjava.wiki.client.util.TagUtil;

/**
 * 
 *
 */
public class ImgStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("<img ");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
        String all=TagUtil.getTag(line);
        if(all==null){
            throw new RuntimeException("img tag parse faild."+line);
        }
       // System.out.println("all:"+all+","+line);
        String src=(String)TagUtil.getAttribute(all).get("src");
        if(src==null){
            throw new RuntimeException("img need src:"+line);
        }
        
        Img alink=new Img();
        alink.addAttribute(src);
       
            
        element.addNode(alink);
        
        return line.substring(all.length());
    }
    
    public static ImgStringParser instance=new ImgStringParser();
    public static ImgStringParser getInstance(){
        return instance;
    }
    public ImgStringParser(){}
    
    
    /**
     * I'm afraid this method reaall need?
     * @param node
     * @return
     */
    public static String toText(Node node){
        if(node instanceof Img){
        	String result="";
            Img alink=(Img)node;
            String attribute[]=alink.getAttributes();
            if(attribute.length>0){
            	String src=attribute[0];
            	result+="<img src='"+src+"'";
            	//width
            	//height
            	result+=" />";
            }
            return result;
        }else{
            return null;
        }
    }
}
