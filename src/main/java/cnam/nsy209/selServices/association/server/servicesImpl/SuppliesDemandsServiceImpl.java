package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.SuppliesDemandsService;
import cnam.nsy209.selServices.association.server.callable.DeleteSuppliesDemandsCallable;
import cnam.nsy209.selServices.association.server.callable.GetSuppliesDemandsCallable;
import cnam.nsy209.selServices.association.server.callable.GetSupplyDemandCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.SuppliesDemandsDto;
import cnam.nsy209.selServices.association.server.dto.SupplyDemandDto;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the SupplyDemand Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class SuppliesDemandsServiceImpl extends RemoteServiceServlet implements SuppliesDemandsService {

	@Override
	public List<SupplyDemandLocalDto> getSuppliesDemands(String type) {
		SuppliesDemandsDto suppliesDemands = null;
		try {
			suppliesDemands = 
					new WebServiceCallable<SuppliesDemandsDto>(new GetSuppliesDemandsCallable(type)).call();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<SupplyDemandLocalDto> suppliesDemandsLocal = new ArrayList<SupplyDemandLocalDto>();
		for(SupplyDemandDto supp:suppliesDemands.getSuppliesDemands()) {
			suppliesDemandsLocal.add(RemoteToLocal.toLocalSupplyDemand(supp));
		}
		return suppliesDemandsLocal;
				
	}

	@Override
	public List<SupplyDemandLocalDto> delete(SupplyDemandLocalDto supplyDemand) throws DoNotExistException {
		if(supplyDemand == null) throw new DoNotExistException();
		boolean exist = false;
		for(SupplyDemandLocalDto sd:getSuppliesDemands(supplyDemand.getType())) {
			if(sd.getId().longValue() ==supplyDemand.getId().longValue()) exist = true;
		}
		if(!exist) throw new DoNotExistException();		

		SuppliesDemandsDto suppliesDemands = null;
		try {
			SupplyDemandDto supplyDemandRemote = LocalToRemote.toRemoteSupplyDemand(supplyDemand);
			suppliesDemands = 
					new WebServiceCallable<SuppliesDemandsDto>(new DeleteSuppliesDemandsCallable(supplyDemandRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<SupplyDemandLocalDto> suppliesDemandsLocal = new ArrayList<SupplyDemandLocalDto>();
		for(SupplyDemandDto supp:suppliesDemands.getSuppliesDemands()) {
			suppliesDemandsLocal.add(RemoteToLocal.toLocalSupplyDemand(supp));
		}
		return suppliesDemandsLocal;
	}

	@Override
	public SupplyDemandLocalDto getSupplyDemand(long id) {	

		SupplyDemandDto supplyDemandDto = null;
		try {
			supplyDemandDto = 
					new WebServiceCallable<SupplyDemandDto>(new GetSupplyDemandCallable(id)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return RemoteToLocal.toLocalSupplyDemand(supplyDemandDto);
	}

}
