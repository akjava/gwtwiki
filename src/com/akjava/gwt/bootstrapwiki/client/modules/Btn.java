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
public class Btn extends ElementImp{
public Btn(){
    setName("btn");
}
public Btn(String type,String text){
    this();
    addAttribute(type);
    addAttribute(text);
}
public String getType(){
    return getAttributes()[0];
}
public String getContent(){
    return getAttributes()[1];
}
public String getHref(){
    return getAttributes()[2];
}
public String getSize(){
	return getAttributeAt(3);
}

}
