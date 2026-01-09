package Models.java;

import com.ms4systems.devs.core.model.impl.AtomicModelImpl;
import com.ms4systems.devs.core.message.Port;
import java.io.Serializable;
import com.ms4systems.devs.extensions.PhaseBased;
import com.ms4systems.devs.extensions.ProvidesTooltip;
import com.ms4systems.devs.extensions.StateVariableBased;

public class ZAC2sys extends AtomicModelImpl implements PhaseBased, StateVariableBased, ProvidesTooltip { 
	private static final long serialVersionUID = 1L;

	public final Port<? extends Serializable> inIoXC1= addInputPort("inIoXC1",Serializable.class);
	public final Port<? extends Serializable> inIoXA2= addInputPort("inIoXA2",Serializable.class);
	public final Port<? extends Serializable> inIoXA1= addInputPort("inIoXA1",Serializable.class);
	public final Port<? extends Serializable> outIoXA3= addOutputPort("outIoXA3",Serializable.class);
	public final Port<? extends Serializable> outIoXA4= addOutputPort("outIoXA4",Serializable.class);
	public final Port<? extends Serializable> outIoXC1= addOutputPort("outIoXC1",Serializable.class);
	public ZAC2sys(){
		this("ZAC2sys");
	}
	public ZAC2sys(String nm) {
		super(nm);
	}
	public String getTooltip() {
		return null;
	}
	public String[] getStateVariableNames() {
		return  new String[]{};
	}
	public Object[] getStateVariableValues() {
		return null;
	}
	public Class<?>[] getStateVariableTypes() {
		return new Class<?>[0];
	}
	public void setStateVariableValue(int index, Object value) {}
	public String[] getPhaseNames() {
		return  new String[]{};
	}
	public String getPhase() {
		return null;
	}
	public boolean phaseIs(String phase) {
		return false;
	}
}