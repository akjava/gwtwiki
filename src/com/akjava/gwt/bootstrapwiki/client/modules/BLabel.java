/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class BLabel extends ElementImp{
public BLabel(){
    setName("label");
}
public BLabel(String type,String text){
    this();
    addAttribute(type);
    addAttribute(text);
}
private String getType(){
    return getAttributes()[0];
}
private String getContent(){
    return getAttributes()[1];
}
}
