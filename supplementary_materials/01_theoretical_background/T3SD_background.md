# Theoretical Background: Tricotyledon Theory of System Design (T3SD)

*Source: Appendix A.2.1 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*

## Overview

The main source for this section is Wymore's book titled "Model-Based Systems Engineering" [23], which contains the mathematically rigorous prescription of T3SD. Other sources include [51, 75, 84-89]. Further summary context of T3SD is published in [44].

## The Three Cotyledons

T3SD earned its name from the cotyledons that form three spaces of "system designs":

1. **Functional Space** - shown as Problem Space of Functions
2. **Buildable Space** - shown as Technology
3. **Implementable Space** - shown as Implementation & Testing (and verification)

Note: A system design in the context of T3SD is a model that exists initially prior to the existence of a final product.

## Problem Space of Functions

The problem space of functions is characterized by desired input/output transformations. This space defines a boundary of functional system designs that can be specified as acceptable versus those that are not acceptable. A functional system design is considered to be a minimum system model of the system design [75] and is represented as a Moore-based state machine [74].

## Buildable System Designs

The space of buildable system designs provides a boundary of acceptable (e.g., available) technology such as components and interfaces. Each component model is represented as a Moore-based state machine [74]. The resultant of coupling of the components is a single Moore state machine. The resultant buildable system design is generally expected to be more elaborate (have more detailed structure) than the functional system design.

## Implementable System Designs

The space of implementable system designs is formed from a mathematical characterization of equivalence between the more abstract functional system design and the more elaborate buildable system design. The mathematical characterization of equivalence is referred to as a morphism; specifically, homomorphism is the general morphism used in T3SD.

The morphism is a means to enforce adherence to a design that adheres to the problem space of functions. The implementable system design is what is tested (i.e., verified), which is conducted based on a subset of input/output transformations defined as part of the problem space of functions.

---

## Mathematical Definitions

### Input/Output Requirement (IOR)

The problem space of functions is formally referred to as the Input/Output Requirement (IOR) within T3SD:

```
IOR = (OLR, IR, ITR, OR, OTR, ER)                    (9)
```

Where:
- **OLR** = Operational Life Requirement
- **IR** = Set of Inputs
- **ITR** = Input Trajectories
- **OR** = Set of Outputs
- **OTR** = Output Trajectories
- **ER** = Eligibility Function (maps eligible sets of output trajectories to be produced from sets of input trajectories)

### Functional System Design (FSD)

The functional system design is bounded by the IOR:

```
FSD = (Z, DS_Z, TS_Z)                                (10)
```

Where:
- **Z** = Minimum model of the system
- **DS_Z** = Initial state
- **TS_Z** = Discrete timescale of the system

### Minimum System Model (Z)

The minimum system model is a discrete system model based on the Moore state machine:

```
Z = (S_Z, I_Z, O_Z, N_Z, R_Z)                        (11)
```

Where:
- **Z** = Name (identifier) of the system
- **S_Z** = Set of states
- **I_Z** = Set of inputs
- **O_Z** = Set of outputs
- **N_Z** = Next state function
- **R_Z** = Readout function (specifies outputs for each state)

### Buildable System Design (BSD)

```
BSD = (Z@, SCR)                                       (12)
```

Where:
- **SCR** = System Coupling Recipe (defines connectivity of components, subsystems, and systems)
- **Z@** = Resultant system from the coupling (@ symbol indicates resultant from coupling)

### System Coupling Recipe (SCR)

```
SCR = (V_SCR, C_SCR)                                  (13)
```

Where:
- **V_SCR** = Vector of systems to be coupled
- **C_SCR** = System connectivity between outputs and inputs

The SCR is described as "the mathematical theory of system coupling: how systems can be put together by input/output relationships to create hierarchical models of more complex systems" [23].

### Implementable System Design (ISD)

```
ISD = (FSD, BSD, IA)                                  (14)
```

Where:
- **FSD** = Functional System Design
- **BSD** = Buildable System Design
- **IA** = Implementation Artifacts (captures homomorphism between FSD and BSD)

### Implementation Artifacts (IA)

```
IA = (Z_S, H_S, H_I, H_O)                            (15)
```

Where:
- **Z_S** = Components, subcomponents, and modes of the real system
- **H_S** = Homomorphic mapping between states of FSD and BSD
- **H_I** = Homomorphic mapping between inputs of FSD and BSD
- **H_O** = Homomorphic mapping between outputs of FSD and BSD

---

## Homomorphism in T3SD

Homomorphism in T3SD is formally defined as follows [23]:

One system (e.g., FSD) is a **homomorphic image** of another system (e.g., BSD) with respect to:
- A set of inputs I₂ ⊆ IZ₂
- A set of outputs O₂ ⊆ OZ₂
- A set of states Q₂ ⊆ SZ₂

**If and only if:**

1. There exists a surjection `hi: I₂ → I₁`, where I₁ ⊆ IZ₁
2. There exists a surjection `ho: O₂ → O₁`, where O₁ ⊆ OZ₁
3. There exists a surjection `hq: Q₂ → Q₁`, where Q₁ ⊆ SZ₁
4. `hq(NZ₂(x,i)) = NZ₁(hq(x), hi(i))`, ∀x ∈ Q₂, i ∈ I₂ (transition function preservation)
5. `ho(RZ₂(x)) = RZ₁(hs(x))`, ∀x ∈ Q₂ (output function preservation)

---

## References

- [23] Wymore, A.W. "Model-Based Systems Engineering"
- [44] Wach, P.F. "A systematic literature review on the mathematical underpinning of model-based systems engineering"
- [51, 75, 84-89] Additional T3SD sources
