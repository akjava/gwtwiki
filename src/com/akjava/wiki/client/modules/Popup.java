/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * maybe
 *this is used only in keyword converter.
 */
public class Popup extends ElementImp{
public Popup(){
    setName("popup");
}
public Popup(String text,String description,String url){
    this();
    addAttribute(text);
    addAttribute(description);
    if(url!=null){
        addAttribute(url);
    }
    
}
public String getText(){
    return getAttributes()[0];
}
public String getDescription(){
    return getAttributes()[1];
}
public String getUrl(){
    if(getAttributes().length>1){
        return getAttributes()[2];
    }else{
        return null;
    }
}
}
