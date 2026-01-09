/* Do not remove or modify this comment!  It is required for file identification!
DNL
platform:/resource/DissertationModels/src/Models/dnl/genBC.dnl
1994371008
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
public class genBC extends AtomicModelImpl implements PhaseBased,
    StateVariableBased {
    private static final long serialVersionUID = 1L;

    // Declare state variables
    private PropertyChangeSupport propertyChangeSupport =
        new PropertyChangeSupport(this);
    String phase = "SendX";
    String previousPhase = null;
    Double sigma = 1.0;
    Double previousSigma = Double.NaN;

    // End state variables

    // Input ports
    // End input ports

    // Output ports
    //ID:OUTP:0
    public final Port<Serializable> outIoXB2 =
        addOutputPort("outIoXB2", Serializable.class);

    //ENDID
    //ID:OUTP:1
    public final Port<Serializable> outIoXB3 =
        addOutputPort("outIoXB3", Serializable.class);

    //ENDID
    //ID:OUTP:2
    public final Port<Serializable> outIoXB4 =
        addOutputPort("outIoXB4", Serializable.class);

    //ENDID
    //ID:OUTP:3
    public final Port<Serializable> outIoXB1 =
        addOutputPort("outIoXB1", Serializable.class);

    //ENDID
    //ID:OUTP:4
    public final Port<Serializable> outIoXC1 =
        addOutputPort("outIoXC1", Serializable.class);

    //ENDID
    // End output ports
    protected SimulationOptionsImpl options = new SimulationOptionsImpl();
    protected double currentTime;

    // This variable is just here so we can use @SuppressWarnings("unused")
    private final int unusedIntVariableForWarnings = 0;

    public genBC() {
        this("genBC");
    }

    public genBC(String name) {
        this(name, null);
    }

    public genBC(String name, Simulator simulator) {
        super(name, simulator);
    }

    public void initialize() {
        super.initialize();

        currentTime = 0;

        holdIn("SendX", 1.0);

    }

    @Override
    public void internalTransition() {
        currentTime += sigma;

        if (phaseIs("SendX")) {
            getSimulator().modelMessage("Internal transition from SendX");

            //ID:TRA:SendX
            holdIn("SendY", 1.0);

            //ENDID
            // Internal event code
            //ID:INT:SendX
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("SendY")) {
            getSimulator().modelMessage("Internal transition from SendY");

            //ID:TRA:SendY
            holdIn("SendZ", 1.0);

            //ENDID
            // Internal event code
            //ID:INT:SendY
            //place your own code for internal event here.
            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("SendZ")) {
            getSimulator().modelMessage("Internal transition from SendZ");

            //ID:TRA:SendZ
            holdIn("SendW", 1.0);

            //ENDID
            // Internal event code
            //ID:INT:SendZ
            //place your own code for internal event here.

            //ENDID
            // End internal event code
            return;
        }
        if (phaseIs("SendW")) {
            getSimulator().modelMessage("Internal transition from SendW");

            //ID:TRA:SendW
            passivateIn("passive");

            //ENDID
            // Internal event code
            //ID:INT:SendW
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

        if (phaseIs("SendX")) {
            // Output event code
            //ID:OUT:SendX
            //Add your own code
            output.add(outIoXB2, null);
            output.add(outIoXC1, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("SendY")) {
            // Output event code
            //ID:OUT:SendY
            //Add your own code
            output.add(outIoXB3, null);
            output.add(outIoXC1, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("SendZ")) {
            // Output event code
            //ID:OUT:SendZ
            //Add your own code
            output.add(outIoXB4, null);
            output.add(outIoXC1, null);

            //ENDID
            // End output event code
        }
        if (phaseIs("SendW")) {
            // Output event code
            //ID:OUT:SendW
            //Add your own code
            output.add(outIoXB1, null);
            output.add(outIoXC1, null);

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
        genBC model = new genBC();
        model.options = options;

        if (options.isDisableViewer()) { // Command line output only
            Simulation sim =
                new SimulationImpl("genBC Simulation", model, options);
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
            dirUri = genBC.class.getResource(".").toURI();
            dir = new File(dirUri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(
                "Could not find Models directory. Invalid model URL: " +
                genBC.class.getResource(".").toString());
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
        return new String[] { "SendX", "SendY", "SendZ", "SendW", "passive" };
    }
}
