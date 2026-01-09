# Theoretical Background: Discrete Event System Specification (DEVS)

*Source: Appendix A.2.2 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*

## Overview

The description of DEVS is largely based on [73], with supporting summary provided in [44]. Other sources leveraged or recommended for further reading on DEVS include [6, 59, 60, 81, 90-94].

## DEVS Hierarchy of System Specification

The hierarchy is typically defined as:

| Level | Specification | Description |
|-------|--------------|-------------|
| Level 0 | I/O Frame | Least amount of system structure specified |
| Level 1 | I/O Relation Observation (IORO) | Relation between inputs and outputs |
| Level 2 | I/O Function Observation (IOFO) | Functional mapping with initial state |
| Level 3 | I/O System | Global state transition behavior |
| Level 4 | Network of Systems | Most internal structure specified |

### Key Properties

- The I/O Frame, IORO, and IOFO are independent of internal structure
- IOFO captures the notion of an initial state (only initial in context of a single function)
- The I/O System creates a single system function closed under concatenation
- Network of Systems are composed of independent component systems coupled together

### Morphism Relationships

- For every one I/O Frame there are many (possibly infinite) system structures down to Network of Systems
- For every Network of Systems there is only one I/O Frame it maps to
- At each level of system specification there exists a system morphism (mathematical characterization of equivalence between pairs)

---

## Mathematical Definitions

### Level 0: I/O Observation Frame

```
IO = (T, X, Y)                                       (16)
```

Where:
- **T** = Time base
- **X** = Input values set
- **Y** = Output values set

**I/O Frame Morphism:** We relate two systems IO = (T, X, Y) and IO' = (T', X', Y') by:
- g : (X', T') → (X, T) - function to define a segment over X given a segment over X'
- k : (Y, T) →onto (Y', T') - function to define output segment over Y' given output over Y

### Level 1: I/O Relation Observation (IORO)

```
IORO = (T, X, Ω, Y, R)                               (17)
```

Where:
- **T** = Time base
- **X** = Input values set
- **Ω** = Set of allowable input segments
- **Y** = Output values set
- **R** = I/O relation

**Constraints:**
- Ω ⊆ (X,T)
- R ⊆ Ω × (X,T) where (ω,ρ) ∈ R ⇒ dom(ω) = dom(ρ)

**IORO Morphism (S' more abstract, S more elaborate):**

Mapping from S' to S:
1. g : Ω' → Ω
2. k : (Y, T) →onto (Y', T')
3. For every pair (ω', ρ') ∈ R', there exists (ω, ρ) ∈ R such that ω = g(ω') and k(ρ) = ρ'

Mapping from S to S':
1. g : Ω →onto Ω'
2. k : (Y, T) →onto (Y', T')
3. For every pair (ω, ρ) ∈ R, there exists (ω', ρ') ∈ R' such that ω' = g(ω) and ρ' = k(ρ)

### Level 2: I/O Function Observation (IOFO)

```
IOFO = (T, X, Ω, Y, F)                               (18)
```

Where:
- **T** = Time base
- **X** = Input values set
- **Ω** = Set of allowable input segments
- **Y** = Output values set
- **F** = Set of I/O functions

**Constraints:**
- Ω ⊆ (X,T)
- f ∈ F → f ⊆ Ω × (X,T) is a function
- If ρ = f(ω), then dom(ω) = dom(ρ)

**IOFO Morphism:** A pair (g, k) where:
1. g : Ω' → Ω
2. k : (Y, T) →onto (Y', T')
3. For each f' ∈ F' there is an f ∈ F such that f' = k ∘ f ∘ g

### Level 3: I/O System

```
S = (T, X, Ω, Y, Q, Δ, Λ)                            (19)
```

Where:
- **T** = Time base
- **X** = Input values set
- **Ω** = Set of allowable input segments
- **Y** = Output values set
- **Q** = Set of states
- **Δ** : Q × Ω → Q = Global state transition function
- **Λ** : Ω × X → Y (or Λ : Q → Y) = Output function

**Constraints (Closure Properties):**
- Ω is closed under concatenation
- Ω is closed under left segmentation
- Composition (semigroup) property: For contiguous input segments ω, ω' ∈ Ω:
  - Δ(q, ω) = Δ((Δ(q, ω), ω') with q ∈ Q

**I/O System Morphism:** A triple (g, h, k) where:
1. g : Ω' → Ω
2. h : Q̄ →onto Q', where Q̄ ⊆ Q
3. k : Y →onto Y'
4. h(Δ(q, g(ω'))) = Δ'(h(q), ω') - **transition function preservation**
5. k(Λ(q)) = Λ'(h(q)) - **output function preservation**

### Level 4: Network of Systems (Coupled System)

```
N = (T, X_N, Y_N, D, {M_d | d ∈ D}, {I_d | d ∈ D ∪ {N}}, {Z_d | d ∈ D ∪ {N}})    (20)
```

Where:
- **X_N** = Set of external inputs of the network
- **Y_N** = Set of external outputs of the network
- **D** = Set of component references with d ∈ D
- **M_d** = An I/O System (component)
- **I_d** ⊆ D ∪ {N} = Set of influencers of d
- **Z_d** : ×_{i∈I_d} YX_i → XY_d = Interface map for d

**Interface Definitions:**
```
YX_i = { X_i  if i = N
       { Y_i  if i ≠ N

XY_d = { Y_d  if d = N
       { X_d  if d ≠ N
```

**Network Morphism:** A structure ⟨coord, {k_d'}, {g_d'}, {h_d'}⟩ where:
- coord : D →onto D' (mapping from components D of N onto D' of N')
- {h_d'} = Mapping of states
- {k_d'} = Mapping of outputs
- {g_d'} = Mapping of inputs

These must satisfy coupling preservations, state transition preservation, and input/output preservation conditions.

---

## References

- [73] Zeigler, B.P., Praehofer, H., & Kim, T.G. "Theory of Modeling and Simulation"
- [44] Wach, P.F. "A systematic literature review on the mathematical underpinning of model-based systems engineering"
- [6, 59, 60, 81, 90-94] Additional DEVS sources
