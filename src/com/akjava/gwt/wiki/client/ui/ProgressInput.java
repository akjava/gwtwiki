package com.akjava.gwt.wiki.client.ui;

import com.akjava.gwt.wiki.client.TextInsertTarget;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.base.TextBox;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ProgressInput extends HorizontalPanel{
TextInsertTarget target;
	public ProgressInput(TextInsertTarget ta){
		this.target=ta;
		final ListBox list=new ListBox();
		list.setWidth("100px");
		list.addItem("-progress-");
		list.addItem("0%");
		list.addItem("25%");
		list.addItem("50%");
		list.addItem("75%");
		list.addItem("100%");
		list.addItem("10%");
		list.addItem("20%");
		list.addItem("30%");
		list.addItem("40%");
		list.addItem("50%");
		list.addItem("60%");
		list.addItem("70%");
		list.addItem("80%");
		list.addItem("90%");
		list.addItem("100%");
		list.setSelectedIndex(0);
		add(list);
		/*
		final TextBox text=new TextBox();
		text.setWidth("80px");
		add(text);
		*/
		list.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				int selection=list.getSelectedIndex();
				if(selection>0){
				
					//String input=text.getText();
					
					String label=list.getItemText(selection);
					/*
					if(input.isEmpty()){
						input=label;
					}
					*/
					target.insertText("#progress("+label+")\n");
					list.setSelectedIndex(0);
				}
			}
		});
	}
}
