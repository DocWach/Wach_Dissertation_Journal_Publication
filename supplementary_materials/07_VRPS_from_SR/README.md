# VRPS Definition from SR - Appendix A.8

This section documents the morphism proofs between Verification Requirement Problem Spaces (VRPS) and System Requirements (SR).

## Overview

VRPS are defined through morphic relationships to SR, establishing that verification activities are bounded by system requirements. Each VRPS represents a specific verification scope.

## VRPS Definitions

| VRPS | Morphism to SR | Verification Scope |
|------|---------------|-------------------|
| VRPS1 | Counter-intuitive | Pizza VM (VM11) |
| VRPS2 | PSF-S1 + PSF-S2 | On/off light functions |
| VRPS3 | PSF-S3 | Water-resistance |
| VRPS4 | Modified PSF-S1 | Blue-light variant |
| VRPS5 | Binary I/O | 1's and 0's exchange |

## Morphism Proofs

### A.8.1 VRPS1 to SR Morphism
- Counter-intuitive problem space
- Designed for VM11 (pizza) adherence
- Unexpected morphic equivalence to SR found

### A.8.2 VRPS2 to SR Morphism
- Combined on/off functionality
- All SD-based VM expected to adhere
- VM18 (submarine) also adheres

### A.8.3 VRPS3 to SR Morphism
- Water-resistance function subset
- Parameterization bounds added
- Eliminates non-SD-based VM

### A.8.4 VRPS4 to SR Morphism
- Blue-light variant (vs yellow in SR)
- Only VM8, VM9 adhere
- Tests orthogonality of SR

### A.8.5 VRPS5 to SR Morphism
- Binary 1's and 0's exchange
- Only VM7 adheres
- Digital abstraction verification

## Key Findings

1. **VRPS-SR Morphism Exists**: Common underlying mathematical structure enables morphic relationships
2. **Parameterization Matters**: VRPS3 parameterization bounds eliminate VM outside SD range
3. **Orthogonality Tested**: VRPS4 and VRPS5 explore SR subset independence

*Source: Appendix A.8 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
