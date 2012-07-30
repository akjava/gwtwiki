/*
 * Created on 2009/03/01
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.StringParser;
import com.akjava.wiki.client.modules.Alink;

/**
 * 
 *
 */
public class DirectAlinkParser implements StringParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String base) {
    	 String[] alink_other=splitWhiteOrNonAscii(base);
    	 String line=alink_other[0];
        return (line.startsWith("http://") && line.length()>"http://x.xx".length()) || (line.startsWith("https://") && line.length()>"https://x.xx".length()) ;
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public String parse(Element element, String line) {
       String[] alink_other=splitWhiteOrNonAscii(line);

        Alink alink=new Alink();
         alink.addAttribute(alink_other[0]);
         alink.addAttribute(alink_other[0]);
            
        element.addNode(alink);
        
        return alink_other[1];
    }
    
    public String[] splitWhiteOrNonAscii(String line){

    	String[] ret=new String[2];
    	ret[0]=line;
    	ret[1]="";
    	for(int i=0;i<line.length();i++){
    		if(line.charAt(i)==' ' || line.charAt(i)=='\t' || line.charAt(i)=='\r' || line.charAt(i)=='\n' || (int)line.charAt(i)>256){

    			ret[0]=line.substring(0,i);
    			ret[1]=line.substring(i);
    			break;
    		}
    	}
    	return ret;
    }
    
    public static DirectAlinkParser instance=new DirectAlinkParser();
    public static DirectAlinkParser getInstance(){
        return instance;
    }
    public DirectAlinkParser(){}
    
    
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
