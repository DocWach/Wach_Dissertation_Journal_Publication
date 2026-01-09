// For homomorphism proof between ZAE and ZBE

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZAEZBE {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SB1","SAE1");
		h.put("SB2","SAE2");
		h.put("SB3","SAE2");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZAE ZAE = new ZAE();
		ZBE ZBE = new ZBE();
		ZAE.options = options;
		ZBE.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZAE Simulation", ZAE, options);
			Simulation simB = new SimulationImpl("ZBE Simulation", ZBE, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZAE.inIoXA6, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZAE.getPhase();
				input = new MessageBagImpl();
				input.add(ZBE.inIoXB9, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZBE.getPhase();
				String hZBE = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		

				input = new MessageBagImpl();
				input.add(ZBE.inIoXB10, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBE.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZBE.inIoXB9, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBE.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZAE.inIoXA5, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAE.getPhase();
				input.add(ZBE.inIoXB8, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBE.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZAE.getPhase();
				input = new MessageBagImpl();
				input.add(ZAE.inIoXA6, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAE.getPhase();
				input.add(ZBE.inIoXB8, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBE.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}
