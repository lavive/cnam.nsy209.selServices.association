package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

@SuppressWarnings("serial")
public class SuppliesDisplayModel extends Observable {
	
	/* Singleton */
	private static SuppliesDisplayModel instance;
	public static SuppliesDisplayModel get(List<SupplyDemandLocalDto> supplies) {
		if(instance == null)
			instance = new SuppliesDisplayModel(supplies);
		
		return instance;
	}
	
	/* Constructor */
	private SuppliesDisplayModel(List<SupplyDemandLocalDto> supplies) {
		this.supplies = supplies;
	}
	
	/* Attributes */
	private List<SupplyDemandLocalDto> supplies = new ArrayList<SupplyDemandLocalDto>();
	
	public void onSet(List<SupplyDemandLocalDto> supplies) {
		this.supplies = supplies;

		notifyObservers();
	}
	
	/* getter */

	public List<SupplyDemandLocalDto> getSupplies() {
		return supplies;
	}

}