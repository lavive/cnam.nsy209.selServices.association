package cnam.nsy209.selServices.association.client.controler;

import java.util.List;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.user.client.Timer;

import cnam.nsy209.selServices.association.client.asyncCallback.SupplyDemandAsyncCallback;
import cnam.nsy209.selServices.association.client.internationalization.I18n;
import cnam.nsy209.selServices.association.client.model.DemandsDisplayModel;
import cnam.nsy209.selServices.association.client.view.helper.DialogBoxConfirm;
import cnam.nsy209.selServices.association.client.view.helper.IActionToTransmit;
import cnam.nsy209.selServices.association.shared.localDto.SupplyDemandLocalDto;

public class DemandsDisplayControler {
	
	/* Attributes */
	private DemandsDisplayModel model;
	
	/* Constructors */
	public DemandsDisplayControler(List<SupplyDemandLocalDto> demands) {
		this.model = DemandsDisplayModel.get(demands);
	}
	
	/* get the action for delete button */
	public ActionCell<SupplyDemandLocalDto> getDeleteAction(){
		return new ActionCell<SupplyDemandLocalDto>(I18n.getI18nConstants().delete(), new ActionCell.Delegate<SupplyDemandLocalDto>() {
			 @Override
			 public void execute(SupplyDemandLocalDto supplyDemand) {
				 DialogBoxConfirm<SupplyDemandLocalDto> dialogBox = new DialogBoxConfirm<SupplyDemandLocalDto>(supplyDemand,
						 I18n.getI18nMessages().sure(),clickHandlerToTransmit());
				 dialogBox.center();
				 dialogBox.show();
			 }
		 });

	}
	
	/* getter */

	public DemandsDisplayModel getModel() {
		return model;
	}
	
	/* helper method */
	private void delete(SupplyDemandLocalDto supplyDemand) {
		Timer t = new Timer() {
			@Override
			public void run() {
				SupplyDemandAsyncCallback callback = new SupplyDemandAsyncCallback();
				callback.setDemandsDisplayControler(DemandsDisplayControler.this);
				callback.deleteSupplyDemand(supplyDemand);
			}
		};
		t.schedule(0);
	}
	private IActionToTransmit<SupplyDemandLocalDto> clickHandlerToTransmit() {
		return new IActionToTransmit<SupplyDemandLocalDto>() {
			@Override
			public void action(SupplyDemandLocalDto supplyDemand) {
				delete(supplyDemand);				
			}
      };
	}	
}
