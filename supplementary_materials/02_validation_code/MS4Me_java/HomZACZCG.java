// For homomorphism proof between ZAC and ZCG

package Models.java;


import java.util.Hashtable;

import com.ms4systems.devs.analytics.Function;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

public class HomZACZCG {
	


	public static void main(String[] args) {
		Hashtable h = new Hashtable();
		h.put("SA1","SG1");
		h.put("SA2","SG1");


		
		SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

		// Uncomment the following line to disable SimViewer for this model
		//
		options.setDisableViewer(true);

		// Uncomment the following line to disable plotting for this model
		// options.setDisablePlotting(true);

		// Uncomment the following line to disable logging for this model
		// options.setDisableLogging(true);
		ZAC ZAC = new ZAC();
		ZCG ZCG = new ZCG();
		ZAC.options = options;
		ZCG.options = options;
		if (options.isDisableViewer()) { // Command line output only
			Simulation simA = new SimulationImpl("ZAC Simulation", ZAC, options);
			Simulation simG = new SimulationImpl("ZCG Simulation", ZCG, options);			
			simA.startSimulation(0); // starts in initial state and time equals zero
			simG.startSimulation(0); // starts in initial state and time equals zero
			
			int i = 0; // starts in initial state and time equals zero
				MessageBag input = new MessageBagImpl();
				input.add(ZAC.inIoXA2, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				String aState = ZAC.getPhase();
				input = new MessageBagImpl();
				input.add(ZCG.inIoXG1, null);
				simG.injectInput(i, input);
				simG.simulateIterations(1);
				String gState = ZCG.getPhase();
				String hZAZCG = h.get(aState).toString();
				System.out.println("Equal "+h.get(aState).equals(gState));
				
				input = new MessageBagImpl();
				input.add(ZAC.inIoXA1, null);
				simA.injectInput(i, input);
				simA.simulateIterations(1);
				aState = ZAC.getPhase();
				input.add(ZCG.inIoXG1, null);
				simG.injectInput(i, input);
				simG.simulateIterations(1);
				gState = ZCG.getPhase();
				System.out.println("Equal "+h.get(aState).equals(gState));
				
//				double Time = simG.getCurrentSimulationTime();
//				
//		
//
//				input = new MessageBagImpl();
//				input.add(ZCG.inIoXC3, null);
//				simG.injectInput(i, input);
//				simG.simulateIterations(1);
//				gState = ZCG.getPhase();
//				System.out.println("Equal "+h.get(gState).equals(aState));

//				Time = simG.getCurrentSimulationTime();
//				
//				input = new MessageBagImpl();
//				input.add(ZCG.inIoXC4, null);
//				simG.injectInput(i, input);
//				simG.simulateIterations(1);
//				gState = ZCG.getPhase();
//				System.out.println("Equal "+h.get(gState).equals(aState));
//				
//				input = new MessageBagImpl();
//				input.add(ZAC.inIoXA1, null);
//				simA.injectInput(i, input);
//				simA.simulateIterations(1);
//				aState = ZAC.getPhase();
//				input.add(ZCG.inIoXG1, null);
//				simG.injectInput(i, input);
//				simG.simulateIterations(1);
//				gState = ZCG.getPhase();
//				System.out.println("Equal "+h.get(gState).equals(aState));
//				
//				
//				
//				aState = ZAC.getPhase();
//				input = new MessageBagImpl();
//				input.add(ZAC.inIoXA2, null);
//				simA.injectInput(i, input);
//				simA.simulateIterations(1);
//				aState = ZAC.getPhase();
//				input.add(ZCG.inIoXG1, null);
//				simG.injectInput(i, input);
//				simG.simulateIterations(1);
//				gState = ZCG.getPhase();
//				System.out.println("Equal "+h.get(gState).equals(aState));
			}
	}

}
