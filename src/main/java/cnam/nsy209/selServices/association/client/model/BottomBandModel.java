package cnam.nsy209.selServices.association.client.model;

import cnam.nsy209.selServices.association.client.view.helper.Observable;

@SuppressWarnings("serial")
public class BottomBandModel extends Observable {
	
	/* Singleton */
	private static BottomBandModel instance;
	public static BottomBandModel get() {
		if(instance == null)
			instance = new BottomBandModel();
		
		return instance;
	}
	
	/* Constructor */
	private BottomBandModel() {
	}

	/* Attribute */
	private String associationDatas;
	
	/* set association name value */
	public void onChange(String datas) {
		associationDatas = datas;

		notifyObservers();
	}
	
	/* getter */

	public String getAssociationDatas() {
		return associationDatas;
	}
	
}
