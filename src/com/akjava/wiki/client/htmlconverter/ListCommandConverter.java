package com.akjava.wiki.client.htmlconverter;

import com.akjava.wiki.client.core.DocumentConverter;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.NodeConverter;
import com.akjava.wiki.client.modules.ListCommand;

public class ListCommandConverter implements NodeConverter{

	@Override
	public boolean canConvert(Node node) {
		 return (node instanceof ListCommand);
	}

	@Override
	public String convertChildren(Node node, String value) {
		//System.out.println(node.getClass().getName()+","+value);
		return "<li>"+value+"</li>";
	}

	@Override
	public String toFooter(Node node) {
		// TODO Auto-generated method stub
		return "</ul>";
	}

	@Override
	public String toHeader(Node node) {
		String header="<ul";
		//TODO support class
		header+=">";
		return header;
	}

	@Override
	public void setNextOption(String option) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentConverter(DocumentConverter docConverter) {
		// TODO Auto-generated method stub
		
	}

}
