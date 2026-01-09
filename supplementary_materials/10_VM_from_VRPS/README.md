# VM Definition from VRPS - Appendix A.11

This section documents the definition of Verification Models (VM) based on adherence to Verification Requirement Problem Spaces (VRPS1-VRPS5).

## Overview

VM are defined from VRPS through adherence proofs. Each VRPS bounds a specific verification scope, and VM that adhere are candidates for that verification activity.

## VRPS Adherence Results

### VRPS1 (Counter-Intuitive)
| VM | Adheres | Notes |
|----|---------|-------|
| VM11 | Yes | Pizza - designed for this VRPS |
| Others | No | As expected |

### VRPS2 (On/Off Functions)
| VM | Adheres | Notes |
|----|---------|-------|
| VM1-VM4 | Yes | SD-based VM |
| VM6 | Yes | Coupled light components |
| VM12 | No | Firefly - unexpected |
| VM13 | No | Radio - unexpected |
| VM18 | Yes | Submarine |
| Others | No | - |

### VRPS3 (Water-Resistance with Bounds)
| VM | Adheres | Notes |
|----|---------|-------|
| VM1-VM4 | Yes | Within parameterization range |
| VM15 | No | Dry bag - outside bounds |
| VM16 | No | Fireflies in dry bag - outside bounds |
| VM17 | No | Waterproof radio - outside bounds |
| VM18 | No | Submarine - outside bounds |

### VRPS4 (Blue Light)
| VM | Adheres | Notes |
|----|---------|-------|
| VM8 | Yes | Blue light variant 1 |
| VM9 | Yes | Blue light variant 2 |
| Others | No | Yellow light or different function |

### VRPS5 (Binary I/O)
| VM | Adheres | Notes |
|----|---------|-------|
| VM7 | Yes | Digital abstraction |
| Others | No | Non-binary I/O |

## Key Findings

1. **VRPS Alone Insufficient**: VRPS cannot uniquely define VM without additional constraints
2. **Parameterization Critical**: VRPS3 bounds eliminate VM outside SD parameter range
3. **Orthogonality Demonstrated**: Different VRPS yield different VM sets

## Tables Reference

| Table Range | Content |
|-------------|---------|
| 400-430 | VM adherence to VRPS1 |
| 431-470 | VM adherence to VRPS2 |
| 471-510 | VM adherence to VRPS3 |
| 511-550 | VM adherence to VRPS4 |
| 551-590 | VM adherence to VRPS5 |

*Source: Appendix A.11 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
