/* Do not remove or modify this comment!  It is required for file identification!
DNL
platform:/resource/DissertationModels/src/Models/dnl/ZBD.dnl
-463649343
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
public class ZBD extends AtomicModelImpl implements PhaseBased,
    StateVariableBased {
    private static final long serialVersionUID = 1L;

    // Declare state variables
    private PropertyChangeSupport propertyChangeSupport =
        new PropertyChangeSupport(this);
    String phase = "SBD1";
    String previousPhase = null;
    Double sigma = Double.POSITIVE_INFINITY;
    Double previousSigma = Double.NaN;

    // End state variables

    // Input ports
    //ID:INP:0
    public final Port<Serializable> inIoXB3 =
        addInputPort("inIoXB3", Serializable.class);

    //ENDID
    //ID:INP:1
    public final Port<Serializable> inIoXB1 =
        addInputPort("inIoXB1", Serializable.class);

    //ENDID
    //ID:INP:2
    public final Port<Serializable> inIoXB2 =
        addInputPort("inIoXB2", Serializable.class);

    //ENDID
    //ID:INP:3
    public final Port<Serializable> inIoXB4 =
        addInputPort("inIoXB4", Serializable.class);

    //ENDID
    // End input ports

    // Output ports
    //ID:OUTP:0
    public final Port<Serializable> outIoXB9 =
        addOutputPort("outIoXB9", Serializable.class);

    //ENDID
    //ID:OUTP:1
    public final Port<Serializable> outIoXB10 =
        addOutputPort("outIoXB10", Serializable.class);

    //ENDID
    //ID:OUTP:2
    public final Port<Serializable> outIoXB8 =
        addOutputPort("outIoXB8", Serializable.class);

    //ENDID
    // End output ports
    protected SimulationOptionsImpl options = new SimulationOptionsImpl();
    protected double currentTime;

    // This variable is just here so we can use @SuppressWarnings("unused")
    private final int unusedIntVariableForWarnings = 0;

    public ZBD() {
        this("ZBD");
    }

    public ZBD(String name) {
        this(name, null);
    }

    public ZBD(String name, Simulator simulator) {
        super(name, simulator);
    }

    public void initialize() {
        super.initialize();

        currentTime = 0;

        passivateIn("SBD1");

    }

    @Override
    public void internalTransition() {
        currentTime += sigma;

        if (phaseIs("trans12")) {
            getSimulator().modelMessage("Internal transition from trans12");

            //ID:TRA:trans12
            passivateIn("SBD2");

            //ENDID
            // Internal event code
            //ID:INT:trans12
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("trans23")) {
            getSimulator().modelMessage("Internal transition from trans23");

            //ID:TRA:trans23
            passivateIn("SBD3");

            //ENDID
            // Internal event code
            //ID:INT:trans23
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("trans21")) {
            getSimulator().modelMessage("Internal transition from trans21");

            //ID:TRA:trans21
            passivateIn("SBD1");

            //ENDID
            // Internal event code
            //ID:INT:trans21
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("trans32")) {
            getSimulator().modelMessage("Internal transition from trans32");

            //ID:TRA:trans32
            passivateIn("SBD2");

            //ENDID
            // Internal event code
            //ID:INT:trans32
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
        if (phaseIs("SBD1")) {
            if (input.hasMessages(inIoXB3)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB3.getMessages(input);

                passivateIn("SBD1");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD1:inIoXB3
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB1)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB1.getMessages(input);

                passivateIn("SBD1");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD1:inIoXB1
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB2)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB2.getMessages(input);

                holdIn("trans12", 0.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SBD1:inIoXB2
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB4)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB4.getMessages(input);

                passivateIn("SBD1");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD1:inIoXB4
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
        }

        if (phaseIs("SBD2")) {
            if (input.hasMessages(inIoXB3)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB3.getMessages(input);

                holdIn("trans23", 0.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SBD2:inIoXB3
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB1)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB1.getMessages(input);

                holdIn("trans21", 0.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SBD2:inIoXB1
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB4)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB4.getMessages(input);

                passivateIn("SBD2");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD2:inIoXB4
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB2)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB2.getMessages(input);

                passivateIn("SBD2");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD2:inIoXB2
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
        }

        if (phaseIs("SBD3")) {
            if (input.hasMessages(inIoXB4)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB4.getMessages(input);

                holdIn("trans32", 0.0);

                // Fire state and port specific external transition functions
                //ID:EXT:SBD3:inIoXB4
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB1)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB1.getMessages(input);

                passivateIn("SBD3");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD3:inIoXB1
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB2)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB2.getMessages(input);

                passivateIn("SBD3");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD3:inIoXB2
                //Add your own code
                Serializable variable = messageList.get(0).getData();

                //ENDID
                // End external event code
                return;
            }
            if (input.hasMessages(inIoXB3)) {
                ArrayList<Message<Serializable>> messageList =
                    inIoXB3.getMessages(input);

                passivateIn("SBD3");

                // Fire state and port specific external transition functions
                //ID:EXT:SBD3:inIoXB3
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
            output.add(outIoXB9, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("trans23")) {
            // Output event code
            //ID:OUT:trans23
            //Add your own code
            output.add(outIoXB10, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("trans21")) {
            // Output event code
            //ID:OUT:trans21
            //Add your own code
            output.add(outIoXB8, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("trans32")) {
            // Output event code
            //ID:OUT:trans32
            //Add your own code
            output.add(outIoXB9, null);

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
        ZBD model = new ZBD();
        model.options = options;

        if (options.isDisableViewer()) { // Command line output only
            Simulation sim =
                new SimulationImpl("ZBD Simulation", model, options);
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
            dirUri = ZBD.class.getResource(".").toURI();
            dir = new File(dirUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(
                "Could not find Models directory. Invalid model URL: " +
                ZBD.class.getResource(".").toString());
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
        return new String[] {
            "SBD1", "trans12", "SBD2", "trans23", "trans21", "SBD3", "trans32"
        };
    }
}
