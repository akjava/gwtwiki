/*
 * Created on 2004/11/24
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.keyword;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Alink;
import com.akjava.wiki.client.modules.LineFolder;
import com.akjava.wiki.client.modules.Popup;
import com.akjava.wiki.client.modules.Text;
import com.akjava.wiki.client.util.StringUtils;
import com.akjava.wiki.client.util.SystemUtils;



/**
 * 
 *
 */
public class KeyWordUtils {

    public static Keyword[] loadCsvKeyWord(String text){
    List list=new Vector();
   
    	text=StringUtils.replace(text,"\r\n", "\n");
    	text=StringUtils.replace(text,"\r", "\n");
 
        String line[]=text.split(SystemUtils.LINE_SEPARATOR);
        for(int i=0;i<line.length;i++){
            String word[]=line[i].split(",");
            if(word.length>1){
                list.add(new Keyword(word[0],word[1]));
            }
        }
   
   
    Keyword[] keywords=(Keyword[])list.toArray(new Keyword[list.size()]);
    
    //Arrays.sort(keywords);
    
    return keywords;
    }
    

    
    public static void insertKeyword(Element element,Keyword[] keywords,String ignoreKeys[],String ignoreURL[]){
        if(element instanceof LineFolder){
            insertKeyword((LineFolder)element,keywords,ignoreKeys,ignoreURL);
        }else{
            for(int i=0;i<element.countNode();i++){
                Node node=element.getNodeAt(i);
                if(node instanceof Element){
                    insertKeyword(((Element)node),keywords,ignoreKeys,ignoreURL);
                }
            }
        }
    }

    public static void insertKeyword(LineFolder line,Keyword[] keywords,String ignoreKeys[],String ignoreURL[]){
        Node[] nodes=new Node[line.countNode()];
        for(int i=0;i<line.countNode();i++){
            nodes[i]=line.getNodeAt(i);
        }
        line.removeAllNode();
           
        for(int i=0;i<nodes.length;i++){
            if(nodes[i] instanceof Text){
                String remainText=((Text)nodes[i]).getText();
                String notMatchText="";
                while(remainText.length()>0){
                    boolean match=false;
                    FOR:for(int j=0;j<keywords.length;j++){
                        if(!isIgnored(keywords[j],ignoreKeys,ignoreURL)  &&remainText.startsWith(keywords[j].getKeyword())){
                            //addNode
                            if(notMatchText.length()>0){
                                line.addNode(new Text(notMatchText));
                            }
                            if(isPopup(keywords[j])){
                                //currently limited support.
                            line.addNode(new Popup(keywords[j].getKeyword(),keywords[j].getUrl().substring(1),null));
                                  
                            //}else if(isAmazon(keywords[j].getUrl())){
                              //  line.addNode(new Alink(toAmazon(keywords[j].getUrl()),keywords[j].getKeyword()));
                                
                            }else{
                            
                            line.addNode(new Alink(keywords[j].getUrl(),keywords[j].getKeyword()));
                            }
                            notMatchText="";
                            remainText=remainText.substring(keywords[j].getKeyword().length());
                            match=true;
                            break FOR;
                        }
                    }
                    
                    if(match==false){
                        notMatchText+=remainText.charAt(0);
                        remainText=remainText.substring(1);
                    }
                }
                //finally add remain.
                if(notMatchText.length()>0){
                    line.addNode(new Text(notMatchText));
                }
            }else{
                line.addNode(nodes[i]);
            }
        }
    }





 


    /**
     * @param ignoreKeys
     * @return
     */
    public static boolean isIgnored(Keyword keyword,String[] ignoreKeys,String[] ignoreURL) {
        if(ignoreURL!=null){
            for (int i = 0; i < ignoreURL.length; i++) {
                if(keyword.getUrl().equals(ignoreURL[i])){
                    //log("ignoreURL:"+keyword.getUrl());
                    return true;
                }
            }
        }
        
        if(ignoreKeys!=null){
            for (int i = 0; i < ignoreKeys.length; i++) {
                if(keyword.getKeyword().equals(ignoreKeys[i])){
                    return true;
                }
            }
        }
       
        
        return false;
    }



    /**
     * @param keyword
     * @return
     */
    public static boolean isPopup(Keyword keyword) {
        if(keyword.getUrl().startsWith("#")){
            return true;
        }
        return false;
    }
}
