# System Model (SM) Definitions - Appendix A.5

This section contains the mathematical definitions of the 13 System Models (ZA through ZBC2) used in the dissertation.

## Overview

System Models provide Level 1 and Level 2 specifications for System Designs (SD) and Verification Models (VM). Each SM is defined as a Moore-based state machine with:
- **S**: Set of states
- **X**: Set of inputs (IoX)
- **Y**: Set of outputs (IoX)
- **δ**: State transition function
- **λ**: Output (readout) function
- **ta**: Time advance function

## System Model Catalog

### Component Models (Level 1)

| Model | States | Inputs | Outputs | Description |
|-------|--------|--------|---------|-------------|
| ZA | SA1, SA2 | IoXA1, IoXA2 | IoXA3, IoXA4 | Basic two-state model |
| ZB | SB1, SB2, SB3 | IoXB1-4 | IoXB5-7 | Three-state model |
| ZC | SC1, SC2 | IoXC1, IoXC2 | IoXC3, IoXC4 | Alternative two-state |
| ZAD | SAD1, SAD2 | IoXAD1, IoXAD2 | IoXAD3, IoXAD4 | Component A variant D |
| ZAE | SAE1, SAE2 | IoXAE1, IoXAE2 | IoXAE3, IoXAE4 | Component A variant E |
| ZBD | SBD1, SBD2, SBD3 | IoXBD1-4 | IoXBD5-7 | Component B variant D |
| ZBE | SBE1, SBE2, SBE3 | IoXBE1-4 | IoXBE5-7 | Component B variant E |

### Coupled Models (Level 2)

| Model | Components | Resultant | Description |
|-------|------------|-----------|-------------|
| ZA2 | ZAD, ZAE | ZA@ | Coupled from A variants |
| ZB2 | ZBD, ZBE | ZB@ | Coupled from B variants |
| ZAC1 | - | - | AC variant 1 (L1) |
| ZAC2 | Components | ZAC@ | AC variant 2 (L2) |
| ZBC1 | - | - | BC variant 1 (L1) |
| ZBC2 | Components | ZBC@ | BC variant 2 (L2) |

## State Transition Diagrams

### ZA State Machine
```
     IoXA1
SA1 ←───────── SA1
 │              ↑
 │ IoXA2       │ IoXA1
 ↓              │
SA2 ────────→ SA2
    IoXA2
```

### ZB State Machine
```
     IoXB1,3,4
SB1 ←─────────── SB1
 │                ↑
 │ IoXB2         │ IoXB1
 ↓                │
SB2 ────────────→ SB2
    IoXB2
 │                ↑
 │ IoXB3         │ IoXB4
 ↓                │
SB3 ←─────────── SB3
     IoXB3,4
```

## Mapping to System Designs (SD)

| SD | Based On | Description |
|----|----------|-------------|
| SD1 | ZA | Flashlight design 1 |
| SD2 | ZB | Flashlight design 2 |
| SD3 | ZAC | Coupled flashlight 3 |
| SD4 | ZBC | Coupled flashlight 4 |

## Mapping to Verification Models (VM)

| VM Range | Based On | Description |
|----------|----------|-------------|
| VM1-VM4 | SD-based | Direct SD parameterizations |
| VM5-VM10 | Component | Alternative component VM |
| VM11-VM15 | Abstract | Counter-intuitive VM |
| VM16-VM18 | Coupled | Complex system VM |

## Tables Reference

| Table | Content |
|-------|---------|
| Table 132 | ZA specification |
| Table 133 | ZB specification |
| Table 134 | ZC specification |
| Table 135 | ZAD specification |
| Table 136 | ZAE specification |
| Table 137 | ZBD specification |
| Table 138 | ZBE specification |
| Table 139 | ZA2 specification |
| Table 140 | ZB2 specification |
| Table 141 | ZAC1 specification |
| Table 142 | ZAC2 specification |
| Table 143 | ZBC1 specification |
| Table 144 | ZBC2 specification |

## Figures Reference

| Figure | Content |
|--------|---------|
| Figure 38 | ZA visual description |
| Figure 39 | ZB visual description |
| Figure 40 | ZC visual description |
| Figure 41-44 | ZAD, ZAE, ZBD, ZBE |
| Figure 45-48 | ZA2, ZB2 (L2 and L1) |
| Figure 49-54 | ZAC and ZBC variants |

*Source: Appendix A.5 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
