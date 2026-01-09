// For homomorphism proof between ZAD and ZBD

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZADZBD {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SBD1","SAD1");
		h.put("SBD2","SAD2");
		h.put("SBD3","SAD2");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZAD ZAD = new ZAD();
		ZBD ZBD = new ZBD();
		ZAD.options = options;
		ZBD.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZAD Simulation", ZAD, options);
			Simulation simB = new SimulationImpl("ZBD Simulation", ZBD, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZAD.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZAD.getPhase();
				input = new MessageBagImpl();
				input.add(ZBD.inIoXB2, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZBD.getPhase();
				String hZBD = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		

				input = new MessageBagImpl();
				input.add(ZBD.inIoXB3, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBD.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZBD.inIoXB4, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBD.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZAD.inIoXA1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAD.getPhase();
				input.add(ZBD.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBD.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZAD.getPhase();
				input = new MessageBagImpl();
				input.add(ZAD.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAD.getPhase();
				input.add(ZBD.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBD.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}
