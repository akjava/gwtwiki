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
public class BtnStringParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {

        return line.startsWith("<btn ") || line.startsWith("<btn/") || line.startsWith("<btn>");
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
        String href=(String) TagUtil.getAttribute(all).get("href");
        String another=TagUtil.getAnother(all);
        
        if(href==null){
        	//bugly called later
        	int m=another.indexOf("href");
        	if(m!=-1){
        		String newtag="<a "+another.substring(m)+"/>";
        		href=(String) TagUtil.getAttribute(newtag).get("href");
        	}
        }
        
        String type="default";
        String size=null;
        
        if(href==null){
            throw new RuntimeException("btn need href "+line);
        }
        
        String content=TagUtil.getContain(all);
        if(content==null){
        	throw new RuntimeException("btn need content "+content);
        }
        
        String av[]=another.split("\\s+");
        for(String v:av){
        	if(v.toLowerCase().equals("small")){
        		size="small";
        	}else if(v.toLowerCase().equals("large")){
        		size="large";
        	}else if(v.toLowerCase().equals("mini")){
        		size="mini";
        	}else if(v.toLowerCase().equals("default")){
        		type="default";
        	}else if(v.toLowerCase().equals("primary")){
        		type="primary";
        	}else if(v.toLowerCase().equals("info")){
        		type="info";
        	}else if(v.toLowerCase().equals("success")){
        		type="success";
        	}else if(v.toLowerCase().equals("warning")){
        		type="warning";
        	}else if(v.toLowerCase().equals("danger")){
        		type="danger";
        	}else if(v.toLowerCase().equals("inverse")){
        		type="inverse";
        	}
        
        }
        
        Btn btn=new Btn();
        btn.addAttribute(type);
        btn.addAttribute(content);
        btn.addAttribute(href);
        if(size!=null){
        	 btn.addAttribute(size);
        }
        
        element.addNode(btn);
        
        return line.substring(all.length());
    }
    
    public static BtnStringParser instance=new BtnStringParser();
    public static BtnStringParser getInstance(){
        return instance;
    }
    public BtnStringParser(){}
    
    
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
