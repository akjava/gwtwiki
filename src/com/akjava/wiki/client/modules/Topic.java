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
public class Topic extends ElementImp{
    public Topic(){
        setName("topic");
    }
public int getLevel(){
    return Integer.parseInt(getAttributes()[0]);
}
public String getTitle(){
    return getAttributes()[1];
}
/**
 * @param i
 */
public void setLevel(int i) {
    // TODO Auto-generated method stub
    if(getAttributes().length>0){
        setAttributeAt(""+i,0);
    }
}
/**
 * @param string
 */
public void setTitle(String title) {
    // TODO Auto-generated method stub
    if(getAttributes().length>1){
        setAttributeAt(title,1);
    }
}

}
