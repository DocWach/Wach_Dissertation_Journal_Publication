// For homomorphism proof between ZA and ZB

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZAZB1 {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SB1","SA1");
		h.put("SB2","SA2");
		h.put("SB3","SA2");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZA ZA = new ZA();
		ZB ZB = new ZB();
		ZA.options = options;
		ZB.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZA Simulation", ZA, options);
			Simulation simB = new SimulationImpl("ZB Simulation", ZB, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZA.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZA.getPhase();
				input = new MessageBagImpl();
				input.add(ZB.inIoXB2, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZB.getPhase();
				String hZB = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		

				input = new MessageBagImpl();
				input.add(ZB.inIoXB3, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZB.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZB.inIoXB4, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZB.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZA.inIoXA1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZA.getPhase();
				input.add(ZB.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZB.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZA.getPhase();
				input = new MessageBagImpl();
				input.add(ZA.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZA.getPhase();
				input.add(ZB.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZB.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}
