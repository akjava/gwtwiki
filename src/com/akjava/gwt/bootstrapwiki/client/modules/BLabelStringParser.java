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
public class BLabelStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {

        return line.startsWith("<label ") || line.startsWith("<label/") || line.startsWith("<label>");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
        String all=TagUtil.getTag(line);
        if(all==null){
            throw new RuntimeException("blabel tag parse faild."+line);
        }
        //System.out.println("all:"+all+","+line);
        String another=TagUtil.getAnother(all);
        String type=null;
        if(another==null){
        	type="info";
        }else{
        String[] names=another.split(" ");
        if(names[0].isEmpty()){
            throw new RuntimeException("Label need type:"+line);
        }
        type=names[0];
        }
        int start=all.indexOf(">");
        int end=all.indexOf("</label>",start);
        String content=null;
        if(end!=-1){
        content=all.substring(start+1,end);
        }
        
        BLabel alink=new BLabel();
        alink.addAttribute(type);
        if(content!=null)
            alink.addAttribute(content);
        else
            alink.addAttribute(type.substring(0,1).toUpperCase()+type.substring(1));
            
        element.addNode(alink);
        
        return line.substring(all.length());
    }
    
    public static BLabelStringParser instance=new BLabelStringParser();
    public static BLabelStringParser getInstance(){
        return instance;
    }
    public BLabelStringParser(){}
    
    
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
