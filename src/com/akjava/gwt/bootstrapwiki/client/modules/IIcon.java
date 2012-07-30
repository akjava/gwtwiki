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
public class IIcon extends ElementImp{
public IIcon(){
    setName("i");
}
public IIcon(String iconName){
    this();
    addAttribute(iconName);
}
private String getTagClass(){
    return getAttributes()[0];
}

}
