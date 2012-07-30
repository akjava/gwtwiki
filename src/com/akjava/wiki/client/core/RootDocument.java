/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import com.akjava.wiki.client.modules.Topic;

/**
 * 
 *
 */
public class RootDocument extends ElementImp implements Document{
    public RootDocument(){
        setName("root");
    }
    
    public String getDocumentPath(){
        String attributes[]=getAttributes();
        String result="";
        if(attributes.length>0){
            result=attributes[0];
        }
        return result;
    }
    

    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.Document#getDocumentTitle()
     */
    public String getDocumentTitle() {
        String title="";
        for(int i=0;i<countNode();i++){
            
            if(getNodeAt(i) instanceof Topic){
                title=((Topic)getNodeAt(i)).getTitle();
                break;
            }
        }
        
        return title;
    }
    
    
}
