/*
 * Created on 2004/11/23
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 */
public abstract class AbstractDocumentConverter implements DocumentConverter{

	protected Map<Class,String> optionMap=new HashMap<Class, String>();
    @Override
	public void addNodeConverterOption(Class target,
			String option) {
		optionMap.put(target, option);
	}
    
    protected Map<String,Object> parameters=new HashMap<String, Object>();
    public Object getParameter(String key){
    	return parameters.get(key);
    }
    
	public NodeConverter[] getNodeConverters() {
        return nodeConverters;
    }
    public void setNodeConverters(NodeConverter[] nodeConverters) {
        this.nodeConverters = nodeConverters;
    }
    private NodeConverter[] nodeConverters;
    
    
    public abstract String getHeader(Document document);
    public abstract String getFooter(Document document);
    protected abstract void startAction(Document document);
    protected abstract void initializeConverters();
    protected List<NodeConverter> list;
    
    private boolean debug;
    public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
    public String convert(Document document){
    	
    	
        if(list==null){
        	initializeConverters();
        }
        
        if(list==null){
        	throw new RuntimeException("list must be initialized");
        }
        
        if(debug){
        	System.out.println("[converter]");
        	for(NodeConverter coverter:list){
        		System.out.println(coverter);
        	}
        }
        
        
        startAction(document);
        String result="";
        result+=getHeader(document);
        for(int i=0;i<document.countNode();i++){
        	
            result+=convert(document.getNodeAt(i),true);
        }
        
        result=finallyAction(result);
        
        result+=getFooter(document);
        return result;
    }

    protected abstract String finallyAction(String text);
    public String convert(Node node,boolean parseChildren){
    /*
     * 
       if(node.getAttributes().length>0)
    System.out.println("last:"+node.getAttributes()[0]);
       */ 
    String result="";
    if(nodeConverters!=null){
        for(int i=0;i<nodeConverters.length;i++){
            if(nodeConverters[i].canConvert(node)){

            	nodeConverters[i].setDocumentConverter(this);
            	
            	
            	if(optionMap.get(nodeConverters[i].getClass())!=null){
              	  String option=optionMap.remove(nodeConverters[i].getClass());
              	nodeConverters[i].setNextOption(option);
                }
            	
            	
                result+=nodeConverters[i].toHeader(node);
                break;
            }
        }
    }
    
    if(node instanceof Element && parseChildren){
        Element element=(Element)node;
        
         for(int i=0;i<element.countNode();i++){
        	NodeConverter converter=findParentConverter(element);
        	 if(converter==null){
        		 throw new RuntimeException("cant't find converter for "+element.getClass()+"\r\n"+nodeConvertes());
        	 }
        	
        	 
          
        	 
          result+=converter.convertChildren(element.getNodeAt(i),convert(element.getNodeAt(i),true));  
          }
       }
    
    if(nodeConverters!=null){
        for(int i=0;i<nodeConverters.length;i++){
            if(nodeConverters[i].canConvert(node)){
                result+=nodeConverters[i].toFooter(node);
                break;
            }
        }
    }
    
    return result;
    }
    
    public NodeConverter findParentConverter(Node node){
        NodeConverter converter=null;
       
        for(int i=0;i<nodeConverters.length;i++){
            if(nodeConverters[i].canConvert(node)){
                return nodeConverters[i];
               
            }
        }
        return converter;
    }
    private String nodeConvertes(){
    	String ret="";
    	 for(int i=0;i<nodeConverters.length;i++){
            ret+=nodeConverters[i].getClass().getName();
            ret+="\r\n";
         }
    	return ret;
    }
    
}
