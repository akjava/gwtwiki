/*
 * Created on 2004/10/23
 * Author aki@www.xucker.jpn.org
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.modules;

import com.akjava.wiki.client.core.ElementImp;

/**
 * 
 *
 */
public class Img extends ElementImp{
public Img(){
    setName("img");
}
public Img(String src){
    this();
    addAttribute(src);
}
private String getSrc(){
    return getAttributes()[0];
}
}
