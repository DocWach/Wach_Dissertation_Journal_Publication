// For homomorphism proof between ZG and ZBC

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZBCZG {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SB1","SG1");
		h.put("SB2","SG1");
		h.put("SB3","SG1");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZG ZG = new ZG();
		ZBC ZBC = new ZBC();
		ZG.options = options;
		ZBC.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZG Simulation", ZG, options);
			Simulation simB = new SimulationImpl("ZBC Simulation", ZBC, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZG.inIoXG1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZG.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB2, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZBC.getPhase();
				String hZBCZG = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		
				input = new MessageBagImpl();
				input.add(ZG.inIoXG1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZG.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB3, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZG.inIoXG1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZG.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB4, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZG.inIoXG1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZG.getPhase();
				aState = ZG.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZG.getPhase();
				input = new MessageBagImpl();
				input.add(ZG.inIoXG1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZG.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}