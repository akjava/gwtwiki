package com.akjava.gwt.wiki.client;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.bootstrapwiki.client.BootstrapHtmlDocumentConverter;
import com.akjava.gwt.lib.client.GWTHTMLUtils;
import com.akjava.gwt.lib.client.IStorageControler;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.lib.client.StorageControler;
import com.akjava.gwt.lib.client.StorageException;
import com.akjava.gwt.lib.client.ValueUtils;
import com.akjava.gwt.wiki.client.ui.AlertInput;
import com.akjava.gwt.wiki.client.ui.AnchorInput;
import com.akjava.gwt.wiki.client.ui.BtnInput;
import com.akjava.gwt.wiki.client.ui.LabelInput;
import com.akjava.gwt.wiki.client.ui.ProgressInput;
import com.akjava.gwt.wiki.client.ui.TemplatePanel;
import com.akjava.wiki.client.core.RootDocument;
import com.akjava.wiki.client.core.StringLineDocumentBuilder;
import com.akjava.wiki.client.core.WikiException;
import com.akjava.wiki.client.keyword.Keyword;
import com.akjava.wiki.client.util.TagUtil;
import com.github.gwtbootstrap.client.ui.Brand;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.ButtonGroup;
import com.github.gwtbootstrap.client.ui.ButtonToolbar;
import com.github.gwtbootstrap.client.ui.NavLink;
import com.github.gwtbootstrap.client.ui.Navbar;
import com.github.gwtbootstrap.client.ui.TabPane;
import com.github.gwtbootstrap.client.ui.TabPanel;
import com.github.gwtbootstrap.client.ui.constants.ButtonType;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWT_Wiki2012 implements EntryPoint {

	  /**
	     * This is the entry point method.
	     */
	    public void onModuleLoad() {
	     	/*
	    	defaultValueInputId=ValueUtils.getFormValueById(PEOPERTY_DEFAULT_ID, "");
	    	outputTextHiddenId=ValueUtils.getFormValueById(PEOPERTY_OUTPUT_TEXT, "");
	    	outputHtmlHiddenId=ValueUtils.getFormValueById(PEOPERTY_OUTPUT_HTML, "");
	    	
	    	LogUtils.log("inited:"+defaultValueInputId+","+outputTextHiddenId+","+outputHtmlHiddenId);
	    	*/
	    
	    	//create only if <div id="gwtwikicontainer"/> not exist for resetting session_id
	    	WikiWidget widget=WikiWidget.createWikiWidgetByHtml();
		    GWTHTMLUtils.getPanelIfExist("gwtwikicontainer").add(widget);
		    
	    }
	   
	   

	    
	    
	    
}
