package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
/** 
 * 
 * Interface which calls SupplyDemand service
 * 
 * @author lavive
 *
 */
public interface SuppliesDemandsServiceAsync {
	public void getSuppliesDemands(String type,AsyncCallback<List<SupplyDemandLocalDto>> callback);
	public void delete(SupplyDemandLocalDto supplyDemand,AsyncCallback<List<SupplyDemandLocalDto>> callback);
	public void getSupplyDemand(long id,AsyncCallback<SupplyDemandLocalDto> callback);
}
