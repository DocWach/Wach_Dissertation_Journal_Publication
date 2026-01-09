# Validation Code (Appendix A.3)

This directory contains the DEVS-based MS4 Me validation code used to verify the system model specifications and morphisms presented in the dissertation.

## Directory Structure

```
02_validation_code/
├── MS4Me_java/          # Java source code for MS4 Me
│   ├── ZA.java          # System model ZA implementation
│   ├── ZB.java          # System model ZB implementation
│   ├── ZC.java          # System model ZC implementation
│   ├── ZAD.java         # System model ZAD implementation
│   ├── ZAE.java         # System model ZAE implementation
│   ├── ZBD.java         # System model ZBD implementation
│   ├── ZBE.java         # System model ZBE implementation
│   ├── ZA2.java         # Coupled system model ZA2
│   ├── ZB2.java         # Coupled system model ZB2
│   ├── ZAC*.java        # ZAC variant implementations
│   ├── ZBC*.java        # ZBC variant implementations
│   ├── gen*.java        # Generator classes for testing
│   ├── Hom*.java        # Homomorphism validation classes
│   └── Gen*.java        # Additional generator classes
│
└── DEVS_dnl/            # DEVS Notation Language specifications
    ├── ZA.dnl           # ZA specification in DNL
    ├── ZB.dnl           # ZB specification in DNL
    └── ...              # Additional DNL files
```

## System Models

The following system models are implemented:

### Component Models (Level 1)
| Model | Description |
|-------|-------------|
| ZA | Basic two-state system model |
| ZB | Extended three-state system model |
| ZC | Alternative system model |
| ZAD | Component A variant D |
| ZAE | Component A variant E |
| ZBD | Component B variant D |
| ZBE | Component B variant E |

### Coupled Models (Level 2)
| Model | Description |
|-------|-------------|
| ZA2 | Coupled system from ZA components |
| ZB2 | Coupled system from ZB components |
| ZAC1 | Coupled system variant AC1 |
| ZAC2 | Coupled system variant AC2 |
| ZBC1 | Coupled system variant BC1 |
| ZBC2 | Coupled system variant BC2 |

## Homomorphism Validation

The `Hom*.java` files contain validation code for proving morphic equivalence between system model pairs:

- `HomZAZB1.java` - Validates homomorphism between ZA and ZB
- `HomZADZBD.java` - Validates homomorphism between ZAD and ZBD
- `HomZAEZBE.java` - Validates homomorphism between ZAE and ZBE
- `HomZACZA.java` - Validates ZAC to ZA morphism
- `HomZACZBC.java` - Validates ZAC to ZBC morphism
- `HomZBCZB.java` - Validates ZBC to ZB morphism

## Running the Code

### Requirements
- Java JDK 8 or higher
- MS4 Me (Modeling for Systems - Modeling Environment)
- DEVS-Suite or compatible DEVS simulation framework

### Execution
1. Import the project into MS4 Me or Eclipse with DEVS plugins
2. Run individual model simulations via the generator classes
3. Execute homomorphism validation via the `Hom*.java` main methods

### Example: Validate ZA-ZB Homomorphism
```bash
java Models.java.HomZAZB1
```

Output shows state transition preservation through morphic mapping.

## References

- **MS4 Me**: Modeling for Systems - Modeling Environment
- **DEVS**: Discrete Event System Specification formalism
- **DNL**: DEVS Notation Language for model specification

*Source: Appendix A.3 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
