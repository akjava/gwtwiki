/*
 * Created on 2004/11/20
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;


import java.util.HashMap;
import java.util.Map;

import com.akjava.wiki.client.modules.Alink;
import com.akjava.wiki.client.modules.Bold;
import com.akjava.wiki.client.modules.CodeCommand;
import com.akjava.wiki.client.modules.LineFolder;
import com.akjava.wiki.client.modules.LineSeparator;
import com.akjava.wiki.client.modules.SimpleCommand;
import com.akjava.wiki.client.modules.TagCommand;
import com.akjava.wiki.client.modules.Text;
import com.akjava.wiki.client.modules.Topic;
import com.akjava.wiki.client.parser.TextStringParser;
import com.akjava.wiki.client.parser.TopicParser;
import com.akjava.wiki.client.util.StringUtils;
import com.akjava.wiki.client.util.SystemUtils;

/**
 * 
 *
 */
public class DescriptionConverter implements DocumentConverter{

	protected Map<Class<NodeConverter>,String> optionMap=new HashMap<Class<NodeConverter>, String>();
    @Override
	public void addNodeConverterOption(Class target,
			String option) {
		optionMap.put(target, option);
	}
    public String convert(Document document){
        String result="";
        for(int i=0;i<document.countNode();i++){
            result+=convert(document.getNodeAt(i),true);
        }
        
        //chomp
        if(result.endsWith(SystemUtils.LINE_SEPARATOR)){
            result=result.substring(0,result.length()-SystemUtils.LINE_SEPARATOR.length());
        }
        
        return result;
    }
    
    public String convert(Node node,boolean bool){
      //  System.out.println(node.getClass().getName());
        String result="";
        
        if(node instanceof Text){
            result+=TextStringParser.toText(node);
        }
        else if(node instanceof LineSeparator){
          
            result+=SystemUtils.LINE_SEPARATOR;
        }else if(node instanceof Alink){
            
            //result+=ALinkStringParser.toText(node);
            result+=node.getAttributes()[1];
            
        }else if(node instanceof Bold){
            //result+=BoldStringParser.toText(node);
            result+=node.getAttributes()[0];
            
        }else if(node instanceof LineFolder){
            //
        }
        else{
            
        
        if(node instanceof Topic){
            
            String topic=TopicParser.toText(node);;
            topic=topic.substring(1);
            topic=StringUtils.replace(topic,"*","-");
            
            result+=topic;
            
        }else if(node instanceof SimpleCommand){
            //result+=SimpleCommandParser.toText(node);
        } else if(node instanceof CodeCommand){
           // result+=CodeCommandParser.toText(node);
            return result;
        	}else if(node instanceof TagCommand){
             //   result+=TagCommandParser.toText(node);
        	}
        //addLine
        result+=SystemUtils.LINE_SEPARATOR;
        }
        
        
        if(node instanceof Element && bool){
          Element element=(Element)node;
          if(element instanceof Topic){
          Topic tp=(Topic)element;
          if(tp.getLevel()>1){
          for(int i=0;i<element.countNode();i++){
              if(element.getNodeAt(i) instanceof Topic){
             result+=convert(element.getNodeAt(i),true);
              }
              }
          }else{
              for(int i=0;i<element.countNode();i++){
                  result+=convert(element.getNodeAt(i),true);
                  }
          }
          }else{
              
              for(int i=0;i<element.countNode();i++){
                  result+=convert(element.getNodeAt(i),true);
                  }
          }
           
        }
        
        
        if(node instanceof LineFolder){
            //throw new RuntimeException("lins");
            result+=SystemUtils.LINE_SEPARATOR;
        }
        
        return result;
    }
    
    

}
