
package com.akjava.wiki.client.core;
/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */

/**
 * 
 *
 */
public interface DocumentConverter {
public String convert(Document document);
public String convert(Node element,boolean parseChildren);

public void addNodeConverterOption(Class target,String option);
public Object getParameter(String key);
}
