package cnam.nsy209.selServices.association.client.internationalization;

import com.google.gwt.core.client.GWT;

public class I18n {

	/* get constants String values */
	private static AssociationConstants i18nConstants = GWT.create(AssociationConstants.class);

	public static AssociationConstants getI18nConstants() {
		return i18nConstants;
	}	
	

	/* get messages value */
	private static AssociationMessages i18nMessages = GWT.create(AssociationMessages.class);

	public static AssociationMessages getI18nMessages() {
		return i18nMessages;
	}	
	
}
