package Models.java;
import com.ms4systems.devs.core.model.impl.CoupledModelImpl;
import com.ms4systems.devs.core.message.Port;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;
import java.io.Serializable;
import com.ms4systems.devs.extensions.StateVariableBased;
import com.ms4systems.devs.core.model.AtomicModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class ZBC2 extends CoupledModelImpl implements StateVariableBased{ 
	private static final long serialVersionUID = 1L;
	protected SimulationOptionsImpl options = new SimulationOptionsImpl();
	
		public final Port<? extends Serializable> outIoXB5= addOutputPort("outIoXB5",Serializable.class);
		public final Port<? extends Serializable> inIoXB1= addInputPort("inIoXB1",Serializable.class);
		public final Port<? extends Serializable> inIoXB2= addInputPort("inIoXB2",Serializable.class);
		public final Port<? extends Serializable> outIoXB6= addOutputPort("outIoXB6",Serializable.class);
		public final Port<? extends Serializable> outIoXB7= addOutputPort("outIoXB7",Serializable.class);
		public final Port<? extends Serializable> inIoXB3= addInputPort("inIoXB3",Serializable.class);
		public final Port<? extends Serializable> inIoXB4= addInputPort("inIoXB4",Serializable.class);
		public final Port<? extends Serializable> inIoXC1= addInputPort("inIoXC1",Serializable.class);
		public final Port<? extends Serializable> outIoXC1= addOutputPort("outIoXC1",Serializable.class);
	public ZBC2(){
		this("ZBC2");
	}
	public ZBC2(String nm) {
		super(nm);
		make();
	}
	public void make(){

		ZC ZC = new ZC();
		addChildModel(ZC);
		ZBE ZBE = new ZBE();
		addChildModel(ZBE);
		ZBD ZBD = new ZBD();
		addChildModel(ZBD);
		addCoupling(ZBD.outIoXB10,ZBE.inIoXB10);
		addCoupling(ZBE.outIoXB5,this.outIoXB5);
		addCoupling(ZBD.outIoXB8,ZBE.inIoXB8);
		addCoupling(ZBD.outIoXB9,ZBE.inIoXB9);
		addCoupling(this.inIoXB1,ZBD.inIoXB1);
		addCoupling(this.inIoXB2,ZBD.inIoXB2);
		addCoupling(ZBE.outIoXB6,this.outIoXB6);
		addCoupling(ZBE.outIoXB7,this.outIoXB7);
		addCoupling(this.inIoXB3,ZBD.inIoXB3);
		addCoupling(this.inIoXB4,ZBD.inIoXB4);
		addCoupling(this.inIoXC1,ZC.inIoXC1);
		addCoupling(ZC.outIoXC1,this.outIoXC1);

	}
    @Override
    public String[] getStateVariableNames() {
        ArrayList<String> lst = new ArrayList<String>();
        for (AtomicModel child : getChildren())
            if (child instanceof StateVariableBased)
                for (String childVar : ((StateVariableBased) child)
                        .getStateVariableNames())
                    lst.add(child.getName() + "." + childVar);
        return lst.toArray(new String[0]);
    }

    @Override
    public Object[] getStateVariableValues() {
        ArrayList<Object> lst = new ArrayList<Object>();
        for (AtomicModel child : getChildren())
            if (child instanceof StateVariableBased)
                for (Object childVar : ((StateVariableBased) child)
                        .getStateVariableValues())
                    lst.add(childVar);
        return lst.toArray();
    }

    @Override
    public Class<?>[] getStateVariableTypes() {
        ArrayList<Class<?>> lst = new ArrayList<Class<?>>();
        for (AtomicModel child : getChildren())
            if (child instanceof StateVariableBased)
                for (Class<?> childVar : ((StateVariableBased) child)
                        .getStateVariableTypes())
                    lst.add(childVar);
        return lst.toArray(new Class<?>[0]);
    }

    @Override
    public void setStateVariableValue(int index, Object value) {
        int i = 0;
        for (AtomicModel child : getChildren())
            if (child instanceof StateVariableBased)
                for (int childIndex = 0; childIndex < ((StateVariableBased) child)
                        .getStateVariableNames().length; childIndex++) {
                    if (i == index) {
                        ((StateVariableBased) child).setStateVariableValue(
                                childIndex, value);
                        return;
                    }
                    i++;
                }
    }
    
	public static void main(String[] args){
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);
		// Uncomment the following line to disable SimViewer for this model
		// options.setDisableViewer(true);
		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);

		ZBC2 model = new ZBC2();
		model.options = options;
		if(options.isDisableViewer()){ // Command Line output only
			Simulation sim = new com.ms4systems.devs.core.simulation.impl.SimulationImpl("ZBC2 Simulation",model,options);
			sim.startSimulation(0);
			sim.simulateIterations(Long.MAX_VALUE);
		}else { //Use SimViewer
			SimViewer viewer = new SimViewer();
			viewer.open(model,options);
		}
	}
}