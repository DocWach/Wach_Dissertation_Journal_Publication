# VM Definition from SR Subsets - Appendix A.10

This section documents the definition of Verification Models (VM1-VM18) from System Requirement (SR) subsets.

## Overview

VM can be defined based on their adherence to SR subsets. This establishes which VM satisfy which functional requirements without considering system design relationships.

## VM Catalog

| VM | Description | Based On |
|----|-------------|----------|
| VM1 | SD1 parameterization | ZA |
| VM2 | SD2 parameterization | ZB |
| VM3 | SD3 parameterization | ZAC |
| VM4 | SD4 parameterization | ZBC |
| VM5 | Alternative component | ZA variant |
| VM6 | Coupled light components | ZAC variant |
| VM7 | Binary I/O system | Digital abstraction |
| VM8 | Blue light variant 1 | Color modification |
| VM9 | Blue light variant 2 | Color modification |
| VM10 | Alternative implementation | Component variant |
| VM11 | Pizza | Counter-intuitive |
| VM12 | Firefly | Biological analog |
| VM13 | Hand radio | Communication device |
| VM14 | Alternative design | Variant |
| VM15 | Dry bag | Waterproof container |
| VM16 | Fireflies in dry bag | Coupled biological |
| VM17 | Waterproof radio | Coupled communication |
| VM18 | Submarine | Complex system |

## SR Subset Adherence Matrix

| VM | SR Superset | On/Light | Off/No-Light | Water-Resist |
|----|-------------|----------|--------------|--------------|
| VM1 | Yes | Yes | Yes | - |
| VM2 | Yes | Yes | Yes | - |
| VM3 | Yes | Yes | Yes | - |
| VM4 | Yes | Yes | Yes | - |
| VM5 | - | - | - | - |
| VM6 | - | Yes | Yes | - |
| VM7 | - | - | - | - |
| VM8 | - | - | - | - |
| VM9 | - | - | - | - |
| VM10 | - | - | - | - |
| VM11 | - | - | - | - |
| VM12 | - | - | - | - |
| VM13 | - | - | - | - |
| VM14 | - | - | - | - |
| VM15 | - | - | - | Yes |
| VM16 | - | - | - | Yes |
| VM17 | - | - | - | Yes |
| VM18 | Yes | Yes | Yes | Yes |

## Key Findings

1. **SD-based VM (1-4)**: Adhere to SR superset as expected
2. **VM18 (Submarine)**: Unexpectedly adheres to SR superset
3. **Water-resistance VM**: VM15-17 adhere only to that subset
4. **Counter-intuitive VM**: VM11 (pizza) does not adhere to expected subsets

*Source: Appendix A.10 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
