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
import com.akjava.wiki.client.parser.AbstractCommandParser;
import com.akjava.wiki.client.util.TagUtil;

/**
 * 
 *
 */
public class ProgressCommandParser extends AbstractCommandParser{

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {

        return line.startsWith("#progress");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.StringParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
    	ProgressCommand code=new ProgressCommand();
        
         
         String attributes[]=parseAttributes(line);
         for(String attr:attributes){
        	 if(isTypeText(attr)){
        		 code.setType(attr);
        	 }else if(isColorText(attr)){
        		 code.setColor(attr);
        	 }else if(isPersentText(attr)){
        		 code.setPersent(attr);
        	 }else if(isWidthText(attr)){
        		 code.setWidth(Integer.parseInt(attr));
        	 }
         }
          
        code.setParent(element);
        element.addNode(code);
        return element;
    }
    
    
    public boolean isWidthText(String text){
    	for(int i=0;i<text.length();i++){
    		if(!Character.isDefined(text.charAt(i))){
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public boolean isTypeText(String text){
    	if(text.equals("striped")){return true;}
    	if(text.equals("animated")){return true;}
    	if(text.equals("default")){return true;}
    	
    	return false;
    }
    
    public boolean isColorText(String text){
    	if(text.equals("info")){return true;}
    	if(text.equals("success")){return true;}
    	if(text.equals("danger")){return true;}
    	if(text.equals("warning")){return true;}
    	
    	return false;
    }
    
    public boolean isPersentText(String text){
    	return text.endsWith("%");
    }
    
    public static ProgressCommandParser instance=new ProgressCommandParser();
    public static ProgressCommandParser getInstance(){
        return instance;
    }
    public ProgressCommandParser(){}
    
    
    public static String toText(Node node){
        if(node instanceof ProgressCommandParser){
       //TODO support other     
       return "#progress";
        }else{
            return null;
        }
    }
}
