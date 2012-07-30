/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;


/**
 * 
 *
 */
public interface NodeConverter {
public String toHeader(Node node);
public String toFooter(Node node);
public String convertChildren(Node node,String value);
public boolean canConvert(Node node);
public void setNextOption(String option);
public void setDocumentConverter(DocumentConverter docConverter);
}
