// For homomorphism proof between ZC and ZBC

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZBCZC {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SB1","SC1");
		h.put("SB2","SC1");
		h.put("SB3","SC1");

		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZC ZC = new ZC();
		ZBC ZBC = new ZBC();
		ZC.options = options;
		ZBC.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZC Simulation", ZC, options);
			Simulation simB = new SimulationImpl("ZBC Simulation", ZBC, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simB.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZC.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB2, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				String bState = ZBC.getPhase();
				String hZBCZC = h.get(bState).toString();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				double Time = simB.getCurrentSimulationTime();
				
		
				input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZC.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB3, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));

				Time = simB.getCurrentSimulationTime();
				
				input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZC.getPhase();
				input = new MessageBagImpl();
				input.add(ZBC.inIoXB4, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZC.getPhase();
				aState = ZC.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
				
				
				
				aState = ZC.getPhase();
				input = new MessageBagImpl();
				input.add(ZC.inIoXC1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZC.getPhase();
				input.add(ZBC.inIoXB1, null);
				simB.injectInput(i, input);
				simB.simulateIterations(1);
				bState = ZBC.getPhase();
				System.out.println("Equal "+h.get(bState).equals(aState));
			}
	}

}