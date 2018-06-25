package zk.springboot.vm.admin.bd002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import zk.springboot.server.domain.Member;
import zk.springboot.server.domain.OrderMaster;
import zk.springboot.server.service.MemberService;
import zk.springboot.server.service.OrderMasterService;

/**
 * 日程表管理 ViewModel
 * @author Louis
 * 2018-06-13
 */

@VariableResolver(DelegatingVariableResolver.class)
public class Q002 {
	
	private static final Logger LOG = LoggerFactory.getLogger(Q002.class);
	
	@WireVariable
	private OrderMasterService orderMasterSrvc;
	
	private OrderMaster omSel;
	private ListModelList<OrderMaster> omListModel = new ListModelList<>();
	
	@Init
	public void init() {
		omListModel.addAll(orderMasterSrvc.findAll());
		LOG.info("######## OrderMaster Size: " + orderMasterSrvc.findAll().size());
	}

	@Command
	@NotifyChange("omSel")
	public void showOmInfo(@BindingParam("omSel") OrderMaster om) {
		omSel = om;
		LOG.info("######## in showOmInfo ########");
	}
	
	@Command
	@NotifyChange({"omListModel","omSel"})
	public void updatePay(@BindingParam("omTarget") OrderMaster om) {
		Integer index = omListModel.indexOf(om);
		if(om.getOmStatus().equals(0)) {
			om.setOmStatus(1);
		} else if(om.getOmStatus().equals(1)){
			om.setOmStatus(0);
		}
		orderMasterSrvc.save(om);
		omSel = om;
		omListModel.set(index, om);
	}
	
	public OrderMaster getOmSel() {
		return omSel;
	}

	public void setOmSel(OrderMaster omSel) {
		this.omSel = omSel;
	}

	public ListModelList<OrderMaster> getOmListModel() {
		return omListModel;
	}

	public void setOmListModel(ListModelList<OrderMaster> omListModel) {
		this.omListModel = omListModel;
	}
	
}
