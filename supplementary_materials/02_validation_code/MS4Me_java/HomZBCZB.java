// For homomorphism proof between ZB and ZBC

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZBCZB {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SB1","SB1");
		h.put("SB2","SB2");
		h.put("SB3","SB3");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZB ZB = new ZB();
		ZBC ZBC = new ZBC();
		ZB.options = options;
		ZBC.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZB Simulation", ZB, options);
			Simulation simB = new SimulationImpl("ZBC Simulation", ZBC, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZB.inIoXB2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZB.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB2, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZBC.getPhase();
				String hZBCZB = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		
				input = new MessageBagImpl();
				input.add(ZB.inIoXB3, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZB.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB3, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZB.inIoXB4, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZB.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB4, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZB.inIoXB1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZB.getPhase();
				aState = ZB.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZB.getPhase();
				input = new MessageBagImpl();
				input.add(ZB.inIoXB2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZB.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}