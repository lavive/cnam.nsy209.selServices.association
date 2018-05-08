package cnam.nsy209.selServices.association.client.controler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

import cnam.nsy209.selServices.association.client.view.page.AssociationEditPage;
import cnam.nsy209.selServices.association.shared.localDto.AssociationLocalDto;

public class AssociationDisplayControler {
	
	/* Attributes */
	private int width;
	private int height;
	private AssociationLocalDto association;
	
	/* Constructors */
	public AssociationDisplayControler(int width, int height, AssociationLocalDto association) {
		this.height = height;
		this.width = width;
		this.association = association;
	}
	
	/* get the handler for update button */
	public ClickHandler getUpdateClickHandler() {
		ClickHandler clickHandler = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {	
				RootPanel.get().clear();
				RootPanel.get().add(new AssociationEditPage(AssociationDisplayControler.this.width,
						AssociationDisplayControler.this.height,association));
			}
		};
		
		return clickHandler;
	}
}