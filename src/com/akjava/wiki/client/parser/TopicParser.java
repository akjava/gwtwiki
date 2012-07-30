/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.parser;


import com.akjava.wiki.client.core.Document;
import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.Topic;

/**
 * 
 *
 */
public class TopicParser implements LineParser{

    public static TopicParser instance=new TopicParser();
    public static TopicParser getInstance(){
        return instance;
    }
    public TopicParser(){}
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#canParse(java.lang.String)
     */
    public boolean canParse(String line) {
        return line.startsWith("*");
    }

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.LineParser#parse(org.jpn.xucker.wiki.Element, java.lang.String)
     */
    public Element parse(Element element, String line) {
        int level=parseLevel(line);
        String title=line.substring(level);
        Topic topic=new Topic();
        topic.addAttribute(""+level);
        topic.addAttribute(title);
        
        if(!(element instanceof Document) && !(element instanceof Topic)){
            //over
            element=element.getParent();
        }
        
        if(element instanceof Document){
            topic.setParent(element);
            element.addNode(topic);
            return topic;
        }    
        else if(element instanceof Topic){
        Topic parentTopic=(Topic)element;
        int parentLevel=parentTopic.getLevel();
        while(parentLevel>=level){
            Element el=parentTopic.getParent();
            if(el instanceof Document){
                topic.setParent(el);
                el.addNode(topic);
                return topic;
            }else if (el instanceof Topic){
                parentTopic=(Topic)el;
                parentLevel=parentTopic.getLevel();
            }else{
                return element;
            }
        }
        topic.setParent(parentTopic);
        parentTopic.addNode(topic);
        return topic;
        }
        
        return element;
    }

    /**
     * @param line
     * @return
     */
    private int parseLevel(String line) {
        int result=0;
        for(int i=0;i<line.length();i++){
            if(line.charAt(i)=='*'){
                result++;
            }else{
                break;
            }
        }
        return result;
    }
    
    public static String toText(Node node){
        if(node instanceof Topic){
            Topic topic=(Topic)node;
        String result="";
        for(int i=0;i<topic.getLevel();i++){
            result+="*";
        }
        result+=topic.getTitle();
        return result;
        }else{
            return null;
        }
    }

}
