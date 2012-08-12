package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;
import com.akjava.wiki.client.modules.SimpleCommand;

public class BootstrapIconConverter extends AbstractConverter{
	
	public boolean canConvert(Node node){
	    return (node instanceof SimpleCommand) && ((SimpleCommand)node).getName().equals("icon");
		}
	
	public String toHeader(Node node){
		String icon="";
		 String attributes[]=((SimpleCommand)node).getAttributes();
		    if(attributes.length>0){
		       icon=attributes[0];
		    }
		    
		
		String result="<p>";
	    
		if(icon.equals("info")){
			result+="<div class='alert alert-info'><p><i class='icon-info-sign'></i>èÓïÒ </p></div>";
		}else if(icon.equals("warn")){
			result+="<div class='alert alert-error'><p><i class='icon-remove-sign'></i>íçà”</p></div>";
		}else if(icon.equals("suprise")){
			result+="<div class='alert alert-success'><p><i class='icon-pencil'></i>ÉÅÉÇ</p></div>";
		}
		else if(icon.equals("url")){
			result+="<p><code><i class='icon-sitemap'></i>URL</code></p>";
		}else if(icon.equals("mouse-single")){
			result+="<p><code><i class='icon-chevron-down'></i>Click</code></p>";
		}else if(icon.equals("mouse-double")){
			result+="<p><code><i class='icon-chevron-down'></i><i class='icon-chevron-down'></i>Double Click</code></p>";
		}else if(icon.equals("yes")){
			result+="<p><code><i class='icon-check'></i>YES</code></p>";
		}else if(icon.equals("ok")){
			result+="<p><code><i class='icon-ok'></i>OK</code></p>";
		}else if(icon.equals("start")){
			result+="<p><code><i class='icon-plane'></i>Start</code></p>";
		}else if(icon.equals("download")){
			result+="<p><code><i class='icon-download-alt'></i>Download</code></p>";
		}else if(icon.equals("unzip")){
			result+="<p><code><i class='icon-signout'></i>Extract</code></p>";
		}else if(icon.equals("menu")){
			result+="<p><code><i class='icon-credit-card'></i>Menu</code></p>";
		}else if(icon.equals("button")){
			result+="<p><code><i class='icon-sign-blank'></i>Button</code></p>";
		}else if(icon.equals("program_remove")){
			result+="<p><img src='http://www.akjava.com/img/program_remove.png'></img></p>";
		}else if(icon.equals("web-download")){
			result+="<p><code><i class='icon-download-alt'></i>Download</code></p>";
		}else if(icon.equals("sourceforge-download")){
			result+="<p><code><i class='icon-download-alt'></i>Download from SourceForge</code></p>";
		}else if(icon.equals("sourceforge-manual")){
			result+="<p><code><i class='icon-sign-blank'></i>SourceForge</code></p>";
		}else if(icon.equals("vector-manual")){
			result+="<p><code><i class='icon-sign-blank'></i>Vector</code></p>";
		}else if(icon.equals("next")){
			result+="<p><code><i class='icon-sign-blank'></i>Next</code></p>";
		}else if(icon.equals("madonomori-download")){
			result+="<p><code><i class='icon-download-alt'></i>Download from Madonomori</code></p>";
		}else if(icon.equals("vector-download")){
			result+="<p><code><i class='icon-download-alt'></i>Download from Vector</code></p>";
		}else if(icon.equals("shortcut")){
			result+="<p><code><i class='icon-share-alt'></i>Shortcut</code></p>";
		}else if(icon.equals("msdos")){
			result+="<p><code><i class='icon-list-alt'></i>MS-DOS</code></p>";
		}else if(icon.equals("mouse-right_menu")){
			result+="<p><code><i class='icon-indent-left'></i>Mouse-right-menu</code></p>";
		}else if(icon.equals("cdrom")){
			result+="<p><code><i class='icon-play-circle'></i>CD-ROM</code></p>";
		}else if(icon.equals("no")){
			result+="<p><code><i class='icon-ban-circle'></i>NO</code></p>";
		}else if(icon.equals("text")){
			result+="<p><code><i class='icon-table'></i>TEXT</code></p>";
		}else if(icon.equals("select")){
			result+="<p><code><i class='icon-check-empty'></i>SELECT</code></p>";
		}else if(icon.equals("choosefile")){
			result+="<p><code><i class='icon-signin'></i>Pick File</code></p>";
		}else if(icon.equals("close")){
			result+="<p><code><i class='icon-remove-circle'></i>Close</code></p>";
		}else if(icon.equals("mouse-drag_drop")){
			result+="<p><code><i class='icon-share-alt'></i>Drag and Drop</code></p>";
		}else{
			throw new RuntimeException("unknown icon:"+icon);
		}
		
		
		
	    
	    return result;
		}
	
	
	public String toFooter(Node node){
	    return "</p>"+(isPretty()?LINE_SEPARATOR:"");
	}

}
