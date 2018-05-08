package cnam.nsy209.selServices.association.client.model;

import java.util.ArrayList;
import java.util.List;

import cnam.nsy209.selServices.association.client.view.helper.Observable;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

@SuppressWarnings("serial")
public class DemandsDisplayModel extends Observable {
	
	/* Singleton */
	private static DemandsDisplayModel instance;
	public static DemandsDisplayModel get(List<SupplyDemandLocalDto> demands) {
		if(instance == null)
			instance = new DemandsDisplayModel(demands);
		
		return instance;
	}
	
	/* Constructor */
	private DemandsDisplayModel(List<SupplyDemandLocalDto> demands) {
		this.demands = demands;
	}
	
	/* Attributes */
	private List<SupplyDemandLocalDto> demands = new ArrayList<SupplyDemandLocalDto>();
	
	public void onSet(List<SupplyDemandLocalDto> demands) {
		this.demands = demands;

		notifyObservers();
	}
	
	/* getter */

	public List<SupplyDemandLocalDto> getDemands() {
		return demands;
	}

}