/*
 * Created on 2004/10/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class Alink extends ElementImp{
public Alink(){
    setName("a");
}
public Alink(String url,String text){
    this();
    addAttribute(url);
    addAttribute(text);
}
private String getHref(){
    return getAttributes()[0];
}
private String getContent(){
    return getAttributes()[1];
}
}
