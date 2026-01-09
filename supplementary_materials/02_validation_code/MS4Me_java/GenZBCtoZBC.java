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

public class GenZBCtoZBC extends CoupledModelImpl implements StateVariableBased{ 
	private static final long serialVersionUID = 1L;
	protected SimulationOptionsImpl options = new SimulationOptionsImpl();
	
		public final Port<? extends Serializable> outIoXB5= addOutputPort("outIoXB5",Serializable.class);
		public final Port<? extends Serializable> outIoXB6= addOutputPort("outIoXB6",Serializable.class);
		public final Port<? extends Serializable> outIoXB7= addOutputPort("outIoXB7",Serializable.class);
		public final Port<? extends Serializable> outIoXC1= addOutputPort("outIoXC1",Serializable.class);
	public GenZBCtoZBC(){
		this("GenZBCtoZBC");
	}
	public GenZBCtoZBC(String nm) {
		super(nm);
		make();
	}
	public void make(){

		genBC genBC = new genBC();
		addChildModel(genBC);
		ZBC2 ZBC2 = new ZBC2();
		addChildModel(ZBC2);
		addCoupling(genBC.outIoXB3,ZBC2.inIoXB3);
		addCoupling(genBC.outIoXB4,ZBC2.inIoXB4);
		addCoupling(ZBC2.outIoXB5,this.outIoXB5);
		addCoupling(ZBC2.outIoXB6,this.outIoXB6);
		addCoupling(ZBC2.outIoXB7,this.outIoXB7);
		addCoupling(genBC.outIoXC1,ZBC2.inIoXC1);
		addCoupling(ZBC2.outIoXC1,this.outIoXC1);
		addCoupling(genBC.outIoXB1,ZBC2.inIoXB1);
		addCoupling(genBC.outIoXB2,ZBC2.inIoXB2);

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

		GenZBCtoZBC model = new GenZBCtoZBC();
		model.options = options;
		if(options.isDisableViewer()){ // Command Line output only
			Simulation sim = new com.ms4systems.devs.core.simulation.impl.SimulationImpl("GenZBCtoZBC Simulation",model,options);
			sim.startSimulation(0);
			sim.simulateIterations(Long.MAX_VALUE);
		}else { //Use SimViewer
			SimViewer viewer = new SimViewer();
			viewer.open(model,options);
		}
	}
}