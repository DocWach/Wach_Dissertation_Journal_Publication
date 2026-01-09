# Problem Spaces of Functions (PSF) Definitions - Appendix A.4

This section contains the mathematical definitions of the seven Problem Spaces of Functions (PSF 1-7) used in the dissertation to define System Requirements (SR) and Verification Requirement Problem Spaces (VRPS).

## Overview

Problem Spaces of Functions provide the Level 0 specification for bounding acceptable system designs. Each PSF defines:
- **XY**: Input/output transformation functions
- **N**: Trajectory (next-state) behavior
- **R**: Readout functions
- **IoX**: Items of Exchange instantiation
- **IF**: Interface instantiation

## PSF Definitions Summary

| PSF | Primary Function | Used For |
|-----|-----------------|----------|
| PSF-S1 | On/light function | SR subset for on-command |
| PSF-S2 | Off/no-light function | SR subset for off-command |
| PSF-S3 | Water-resistance | SR subset for water-resistance |
| PSF-S4 | On/off combined | Combined light functionality |
| PSF-S5 | System trajectory | State progression |
| PSF-S6 | Output readout | Output specification |
| PSF-S7 | Complete SR | Superset of all functions |

## Mathematical Structure

Each PSF follows the formal structure:

```
PSF = (XY, N, R, IoX, IF)
```

Where:
- **XY** = {transformation functions}
- **N** = {trajectory functions}
- **R** = {readout functions}
- **IoX** = {input items, output items}
- **IF** = {interfaces with parameterization}

## Mapping to SR and VRPS

### System Requirements (SR)
The superset SR is defined as PSF-S7, which encompasses all functional requirements.

### Verification Requirement Problem Spaces
| VRPS | Based On | Morphism to SR |
|------|----------|----------------|
| VRPS1 | Counter-intuitive space | Specialized morphism |
| VRPS2 | PSF-S1 + PSF-S2 | On/off functions |
| VRPS3 | PSF-S3 | Water-resistance |
| VRPS4 | Modified PSF-S1 | Blue-light variant |
| VRPS5 | Binary I/O | 1's and 0's exchange |

## Detailed Specifications

For complete mathematical specifications including:
- Block diagrams
- Sequence diagrams
- Tabular IoX and IF instantiations
- Proof of PSF relationships

See the dissertation Appendix A.4 (pages 127-134) and the corresponding figures (Figures 24-37).

## Tables Reference

| Table | Content |
|-------|---------|
| Table 125 | PSF-S1 specification |
| Table 126 | PSF-S2 specification |
| Table 127 | PSF-S3 specification |
| Table 128 | PSF-S4 specification |
| Table 129 | PSF-S5 specification |
| Table 130 | PSF-S6 specification |
| Table 131 | PSF-S7 specification |

*Source: Appendix A.4 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
