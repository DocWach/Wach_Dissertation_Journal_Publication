// For homomorphism proof between ZAC and ZC

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZACZC {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SA1","SC1");
		h.put("SA2","SC1");


		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZAC ZAC = new ZAC();
		ZC ZC = new ZC();
		ZAC.options = options;
		ZC.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZAC Simulation", ZAC, options);
			Simulation simC = new SimulationImpl("ZC Simulation", ZC, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simC.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZAC.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZAC.getPhase();
				input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simC.injectInput(i, input);
				simC.simulateIterations(1);
				String cState = ZC.getPhase();
				String hZAZC = h.get(aState).toString();
				System.out.println("Equal "+h.get(aState).equals(cState));
				
				input = new MessageBagImpl();
				input.add(ZAC.inIoXA1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAC.getPhase();
				input.add(ZC.inIoXC1, null);
				simC.injectInput(i, input);
				simC.simulateIterations(1);
				cState = ZC.getPhase();
				System.out.println("Equal "+h.get(aState).equals(cState));
				
//				double Time = simC.getCurrentSimulationTime();
//				
//		
//
//				input = new MessageBagImpl();
//				input.add(ZC.inIoXC3, null);
//				simC.injectInput(i, input);
//				simC.simulateIterations(1);
//				cState = ZC.getPhase();
//				System.out.println("Equal "+h.get(cState).equals(aState));

//				Time = simC.getCurrentSimulationTime();
//				
//				input = new MessageBagImpl();
//				input.add(ZC.inIoXC4, null);
//				simC.injectInput(i, input);
//				simC.simulateIterations(1);
//				cState = ZC.getPhase();
//				System.out.println("Equal "+h.get(cState).equals(aState));
//				
//				input = new MessageBagImpl();
//				input.add(ZAC.inIoXA1, null);
//				simA.injectInput(i, input);
//				simA.simulateIterations(1);
//				aState = ZAC.getPhase();
//				input.add(ZC.inIoXC1, null);
//				simC.injectInput(i, input);
//				simC.simulateIterations(1);
//				cState = ZC.getPhase();
//				System.out.println("Equal "+h.get(cState).equals(aState));
//				
//				
//				
//				aState = ZAC.getPhase();
//				input = new MessageBagImpl();
//				input.add(ZAC.inIoXA2, null);
//				simA.injectInput(i, input);
//				simA.simulateIterations(1);
//				aState = ZAC.getPhase();
//				input.add(ZC.inIoXC1, null);
//				simC.injectInput(i, input);
//				simC.simulateIterations(1);
//				cState = ZC.getPhase();
//				System.out.println("Equal "+h.get(cState).equals(aState));
			}
	}

}
