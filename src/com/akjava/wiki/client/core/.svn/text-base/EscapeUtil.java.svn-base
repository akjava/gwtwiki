/*
 * Created on 2004/11/24
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import com.akjava.wiki.client.util.StringUtils;

/**
 * 
 *
 */
public class EscapeUtil {
public static String escape(String text){
    String result=text;
    result=StringUtils.replace(result,"&","&amp;");
    result=StringUtils.replace(text,"<","&lt;");
    
    result=StringUtils.replace(result,">","&gt;");
   
    result=StringUtils.replace(result,"\"","&quot;");
    return result;
}
}
