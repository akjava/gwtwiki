package com.akjava.wiki.client.htmlconverter;

import com.akjava.gwt.bootstrapwiki.client.modules.SplitCommand;
import com.akjava.wiki.client.core.DocumentConverter;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.NodeConverter;
import com.akjava.wiki.client.modules.SimpleCommand;

public class SplitCommandConverter implements NodeConverter{
	int persent;
	int attributeIndex;
	String[] attributes;
	@Override
	public boolean canConvert(Node node) {
		
		/*
		if(node instanceof SimpleCommand){
			SimpleCommand command=(SimpleCommand)node;
			if(command.getName().equals("block") && command.getParent() instanceof SplitCommand){
				return true;
			}
		}
		*/
		
		 return (node instanceof SplitCommand);
	}

	@Override
	public String convertChildren(Node node, String value) {
		//something wrong,empty or over
		if(node instanceof SimpleCommand){//must be block-command
			SimpleCommand command=(SimpleCommand)node;
			if(!command.getName().equals("block")){
				return value;
			}
			
			attributeIndex++;
			if(attributes==null || attributes.length==0||attributeIndex>=attributes.length){
				return "";
			}
			
			String html="";
			html+="</div></td>";
			html+="<td valign='top' width='"+persent+"%'>";
			html+="<div class='"+attributes[attributeIndex]+"'>";
			return html;
		}else{
			return value;
		}
		
	}

	@Override
	public String toHeader(Node node) {
		SplitCommand splitCommand=(SplitCommand)node;
		
		String header="<table width='100%' border=0><tr>";
		
		if(splitCommand.getAttributes().length>0){
			attributes=splitCommand.getAttributes();
			attributeIndex=0;
			persent=100/attributes.length;
			header+="<td valign='top' width='"+persent+"%'>";
			header+="<div class='"+attributes[attributeIndex]+"'>";
		}else{
			header+="<td><div>";
		}
		
		return header;
	}
	
	@Override
	public String toFooter(Node node) {
		// TODO Auto-generated method stub
		return "</div></td></tr></table>";
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
