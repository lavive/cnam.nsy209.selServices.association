package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
/** 
 * 
 * Interface which calls SupplyDemand service
 * 
 * @author lavive
 *
 */
@RemoteServiceRelativePath("SuppliesDemandsService")
public interface SuppliesDemandsService extends RemoteService {
	public List<SupplyDemandLocalDto> getSuppliesDemands(String type);
	public List<SupplyDemandLocalDto> delete(SupplyDemandLocalDto supplyDemand) throws DoNotExistException;
	public SupplyDemandLocalDto getSupplyDemand(long id);
}
