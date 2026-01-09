/* Do not remove or modify this comment!  It is required for file identification!
DNL
platform:/resource/DissertationModels/src/Models/dnl/ZAE1.dnl
-1610257666
 Do not remove or modify this comment!  It is required for file identification! */
package Models.java;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.io.File;
import java.io.Serializable;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;

import com.ms4systems.devs.core.message.Message;
import com.ms4systems.devs.core.message.MessageBag;
import com.ms4systems.devs.core.message.Port;
import com.ms4systems.devs.core.message.impl.MessageBagImpl;
import com.ms4systems.devs.core.model.impl.AtomicModelImpl;
import com.ms4systems.devs.core.simulation.Simulation;
import com.ms4systems.devs.core.simulation.Simulator;
import com.ms4systems.devs.core.simulation.impl.SimulationImpl;
import com.ms4systems.devs.extensions.PhaseBased;
import com.ms4systems.devs.extensions.StateVariableBased;
import com.ms4systems.devs.helpers.impl.SimulationOptionsImpl;
import com.ms4systems.devs.simviewer.standalone.SimViewer;

@SuppressWarnings("unused")
public class ZAE1 extends AtomicModelImpl implements PhaseBased,
    StateVariableBased {
    private static final long serialVersionUID = 1L;

    // Declare state variables
    private PropertyChangeSupport propertyChangeSupport =
        new PropertyChangeSupport(this);
    String phase = "SAE1";
    String previousPhase = null;
    Double sigma = Double.POSITIVE_INFINITY;
    Double previousSigma = Double.NaN;

    // End state variables

    // Input ports
    //ID:INP:0
    public final Port<Serializable> inIoXA6 =
        addInputPort("inIoXA6", Serializable.class);

    //ENDID
    //ID:INP:1
    public final Port<Serializable> inIoXA5 =
        addInputPort("inIoXA5", Serializable.class);

    //ENDID
    // End input ports

    // Output ports
    //ID:OUTP:0
    public final Port<Serializable> outIoXA4 =
        addOutputPort("outIoXA4", Serializable.class);

    //ENDID
    //ID:OUTP:1
    public final Port<Serializable> outIoXA3 =
        addOutputPort("outIoXA3", Serializable.class);

    //ENDID
    // End output ports
    protected SimulationOptionsImpl options = new SimulationOptionsImpl();
    protected double currentTime;

    // This variable is just here so we can use @SuppressWarnings("unused")
    private final int unusedIntVariableForWarnings = 0;

    public ZAE1() {
        this("ZAE1");
    }

    public ZAE1(String name) {
        this(name, null);
    }

    public ZAE1(String name, Simulator simulator) {
        super(name, simulator);
    }

    public void initialize() {
        super.initialize();

        currentTime = 0;

        passivateIn("SAE1");

    }

    @Override
    public void internalTransition() {
        currentTime += sigma;

        if (phaseIs("trans12")) {
            getSimulator().modelMessage("Internal transition from trans12");

            //ID:TRA:trans12
            passivateIn("SAE2");

            //ENDID
            // Internal event code
            //ID:INT:trans12
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("trans21")) {
            getSimulator().modelMessage("Internal transition from trans21");

            //ID:TRA:trans21
            passivateIn("SAE1");

            //ENDID
            // Internal event code
            //ID:INT:trans21
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }

        //passivate();
    }

    @Override
    public void externalTransition(double timeElapsed, MessageBag input) {
        currentTime += timeElapsed;
        // Subtract time remaining until next internal transition (no effect if sigma == Infinity)
        sigma -= timeElapsed;

        // Store prior data
        previousPhase = phase;
        previousSigma = sigma;

        // Fire state transition functions
        if (phaseIs("SAE1")) {
            if (input.hasMessages(inIoXA6)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXA6.getMessages(input);

                holdIn("trans12", 1.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SAE1:inIoXA6
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXA5)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXA5.getMessages(input);

                passivateIn("SAE1");

                // Fire state and port specific external transition functions
                //ID:EXT:SAE1:inIoXA5
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
        }

        if (phaseIs("SAE2")) {
            if (input.hasMessages(inIoXA5)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXA5.getMessages(input);

                holdIn("trans21", 1.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SAE2:inIoXA5
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXA6)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXA6.getMessages(input);

                passivateIn("SAE2");

                // Fire state and port specific external transition functions
                //ID:EXT:SAE2:inIoXA6
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
        }
    }

    @Override
    public void confluentTransition(MessageBag input) {
        // confluentTransition with internalTransition first (by default)
        internalTransition();
        externalTransition(0, input);
    }

    @Override
    public Double getTimeAdvance() {
        return sigma;
    }

    @Override
    public MessageBag getOutput() {
        MessageBag output = new MessageBagImpl();

        if (phaseIs("trans12")) {
            // Output event code
            //ID:OUT:trans12
            //Add your own code
            output.add(outIoXA4, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("trans21")) {
            // Output event code
            //ID:OUT:trans21
            //Add your own code
            output.add(outIoXA3, null);

            //ENDID
            // End output event code
        }
        return output;
    }

    // Custom function definitions

    // End custom function definitions
    public static void main(String[] args) {
        SimulationOptionsImpl options = new SimulationOptionsImpl(args, true);

        // Uncomment the following line to disable SimViewer for this model
        // options.setDisableViewer(true);

        // Uncomment the following line to disable plotting for this model
        // options.setDisablePlotting(true);

        // Uncomment the following line to disable logging for this model
        // options.setDisableLogging(true);
        ZAE1 model = new ZAE1();
        model.options = options;

        if (options.isDisableViewer()) { // Command line output only
            Simulation sim =
                new SimulationImpl("ZAE1 Simulation", model, options);
            sim.startSimulation(0);
            sim.simulateIterations(Long.MAX_VALUE);
        } else { // Use SimViewer
            SimViewer viewer = new SimViewer();
            viewer.open(model, options);
        }
    }

    public void addPropertyChangeListener(String propertyName,
        PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    // State variables
    public String[] getStateVariableNames() {
        return new String[] {  };
    }

    public Object[] getStateVariableValues() {
        return new Object[] {  };
    }

    public Class<?>[] getStateVariableTypes() {
        return new Class<?>[] {  };
    }

    public void setStateVariableValue(int index, Object value) {
        switch (index) {

            default:
                return;
        }
    }

    // Convenience functions
    protected void passivate() {
        passivateIn("passive");
    }

    protected void passivateIn(String phase) {
        holdIn(phase, Double.POSITIVE_INFINITY);
    }

    protected void holdIn(String phase, Double sigma) {
        this.phase = phase;
        this.sigma = sigma;
        getSimulator()
            .modelMessage("Holding in phase " + phase + " for time " + sigma);
    }

    protected static File getModelsDirectory() {
        URI dirUri;
        File dir;
        try {
            dirUri = ZAE1.class.getResource(".").toURI();
            dir = new File(dirUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(
                "Could not find Models directory. Invalid model URL: " +
                ZAE1.class.getResource(".").toString());
        }
        boolean foundModels = false;
        while (dir != null && dir.getParentFile() != null) {
            if (dir.getName().equalsIgnoreCase("java") &&
                  dir.getParentFile().getName().equalsIgnoreCase("models")) {
                return dir.getParentFile();
            }
            dir = dir.getParentFile();
        }
        throw new RuntimeException(
            "Could not find Models directory from model path: " +
            dirUri.toASCIIString());
    }

    protected static File getDataFile(String fileName) {
        return getDataFile(fileName, "txt");
    }

    protected static File getDataFile(String fileName, String directoryName) {
        File modelDir = getModelsDirectory();
        File dir = new File(modelDir, directoryName);
        if (dir == null) {
            throw new RuntimeException("Could not find '" + directoryName +
                "' directory from model path: " + modelDir.getAbsolutePath());
        }
        File dataFile = new File(dir, fileName);
        if (dataFile == null) {
            throw new RuntimeException("Could not find '" + fileName +
                "' file in directory: " + dir.getAbsolutePath());
        }
        return dataFile;
    }

    protected void msg(String msg) {
        getSimulator().modelMessage(msg);
    }

    // Phase display
    public boolean phaseIs(String phase) {
        return this.phase.equals(phase);
    }

    public String getPhase() {
        return phase;
    }

    public String[] getPhaseNames() {
        return new String[] { "SAE1", "trans12", "SAE2", "trans21" };
    }
}
