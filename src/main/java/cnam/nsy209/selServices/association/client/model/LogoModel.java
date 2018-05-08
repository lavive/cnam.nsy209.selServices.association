package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class LogoModel extends Observable {
	
	/* Singleton */
	private static LogoModel instance;
	public static LogoModel get() {
		if(instance == null)
			instance = new LogoModel();
		
		return instance;
	}
	
	/* Constructor */
	private LogoModel() {}

	/* Attribute */
	private String associationName;
	
	/* set association name value */
	public void onChange(String name) {
		associationName = name;

		notifyObservers();
	}
	
	/* getter */

	public String getAssociationName() {
		return associationName;
	}
	
}
