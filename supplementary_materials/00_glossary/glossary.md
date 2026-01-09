# Glossary of Acronyms

This glossary provides definitions for acronyms and terms used throughout the dissertation and supplementary materials. The terms are organized into three categories: general terms, DEVS-specific terms, and T3SD-specific terms.

---

## Table 122: General Terms

| Acronym | Full Term and/or Description |
|---------|------------------------------|
| B | System Model at Level 2 (captures SCR and Z@) |
| DEVS | Discrete Event System Specification |
| F | IoX to IF mapping function |
| IF | Interface (through which IoX are transferred) |
| IoX | Input/output item of exchange |
| L0 | Level 0 (is a PSF) |
| L1 | Level 1 (SM specified as Z or Z@) |
| L2 | Level 2 (SM specified as B, SCR) |
| MBSE | Model-Based Systems Engineering |
| MS4 Me | Modeling for Systems Modeling Environment (DEVS-based software) |
| P | Set of Interfaces (IF) |
| PSF | Problem Space of Functions (mathematical basis for SR and VRPS, Level 0) |
| S | Set of states |
| SCR | Set of System Coupling Recipes (coupling of components at L2) |
| SD | System Design (is an instantiated SM) |
| SE | Systems Engineering |
| SM | System Model (underlying mathematical structure for SD and VM) |
| SR | System Requirements (is an instantiated PSF) |
| T3SD | Tricotyledon Theory of System Design (Wymore's theory of MBSE) |
| VF | Vector of systems (components) to be coupled in SCR |
| VM | Verification Model (is an instantiated SM) |
| VMMC | Verification Model Morphic Conditions (desired pedigree between SD-VM) |
| VR | Verification Requirement (combination of VRPS and VMMC) |
| VRPS | Verification Requirement Problem Space (is an instantiated PSF) |
| VZ | Vector of IoX and IF mapping between components to be coupled in SCR |
| X | Set of input IoX |
| XY | Set of functions that transform input IoX to output IoX |
| Y | Set of output IoX |
| Z | System Model at Level 1 |
| Z@ | Resultant SM from SCR at Level 1 |

---

## Table 123: DEVS-Specific Terms

| Acronym | Full Term and/or Description |
|---------|------------------------------|
| EF | Experimental Frame |
| IO Observation | Input/Output Observation Frame |
| IORO | Input/Output Relation Observation |
| IOFO | Input/Output Function Observation |
| IO System | Input/Output System |
| Network of Systems | Coupled IO System Components |

---

## Table 124: T3SD-Specific Terms

| Acronym | Full Term and/or Description |
|---------|------------------------------|
| BSD | Buildable System Design |
| FSD | Functional System Design |
| ISD | Implementable System Design |

---

## Additional Context

### Hierarchy of System Specification

The DEVS hierarchy of system specification defines levels of abstraction:

- **Level 0 (L0)**: Problem Space of Functions (PSF) - defines functional requirements without state specification
- **Level 1 (L1)**: State-based System Model (Z) - includes states, transitions, and output functions
- **Level 2 (L2)**: Coupled System Model (B) - includes System Coupling Recipe (SCR) for component coupling

### Morphism Types

System morphisms characterize equivalence relationships between system specifications:

- **Homomorphism**: Structure-preserving mapping between systems
- **Isomorphism**: Bijective homomorphism (one-to-one correspondence)
- **System Coupling Recipe (SCR)**: Specification of how component systems are coupled

### Verification Artifacts

The WySE metamodel defines relationships between:

- **SR** → System Requirements
- **SD** → System Designs
- **VRPS** → Verification Requirement Problem Spaces
- **VMMC** → Verification Model Morphic Conditions
- **VM** → Verification Models

---

*Source: Appendix A.1 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
