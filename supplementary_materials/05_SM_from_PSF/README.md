# SM Definition from PSF - Appendix A.6

This section documents the proofs that System Models (SM) adhere to Problem Spaces of Functions (PSF), establishing that system designs can be defined from system requirements.

## Overview

Each SM must be proven to adhere to the relevant PSF subsets before it can be used as the basis for a System Design (SD). Adherence is proven through:
1. IoX (Items of Exchange) mapping
2. IF (Interface) mapping
3. Transformation function preservation

## Adherence Proofs Summary

| SM | Adheres to PSF | Result |
|----|----------------|--------|
| ZA | PSF-S1, S2, S4-S7 | Proven |
| ZB | PSF-S1, S2, S4-S7 | Proven |
| ZC | PSF-S3, S7 | Proven |
| ZA2 | PSF-S1, S2, S4-S7 | Proven |
| ZB2 | PSF-S1, S2, S4-S7 | Proven |
| ZAC1 | All PSF | Proven |
| ZAC2 | All PSF | Proven |
| ZBC1 | All PSF | Proven |
| ZBC2 | All PSF | Proven |

## Proof Structure

Each proof demonstrates:

### 1. IoX Adherence
```
For each IoX in PSF, there exists corresponding IoX in SM such that:
- Input IoX maps to SM inputs
- Output IoX maps to SM outputs
- Parameterization is consistent
```

### 2. IF Adherence
```
For each IF in PSF, there exists corresponding IF in SM such that:
- Interface parameterization bounds are satisfied
- IoX-IF mapping (F function) is preserved
```

### 3. Transformation Adherence
```
XY functions in PSF are realized by:
- State transition function (δ)
- Output function (λ)
```

## Detailed Proofs

### A.6.1 ZA Definition from PSF
- Tables 145-149: IoX and IF adherence proofs
- Demonstrates ZA satisfies on/off light functionality

### A.6.2 ZB Definition from PSF
- Tables 150-154: IoX and IF adherence proofs
- Extended three-state model adherence

### A.6.3-A.6.9 Remaining SM Proofs
- ZC, ZA2, ZB2, ZAC1, ZAC2, ZBC1, ZBC2
- Complete adherence documentation

## Tables Reference (A.6)

| Table Range | Content |
|-------------|---------|
| 145-149 | ZA adherence proofs |
| 150-154 | ZB adherence proofs |
| 155-159 | ZC adherence proofs |
| 160-164 | ZA2 adherence proofs |
| 165-169 | ZB2 adherence proofs |
| 170-174 | ZAC1 adherence proofs |
| 175-179 | ZAC2 adherence proofs |

## Key Findings

1. **All SD-based SM adhere to SR superset** - Validates design validity
2. **Component SM adhere to functional subsets** - Supports modular design
3. **Coupled SM inherit component adherence** - Composition preserves adherence

*Source: Appendix A.6 of "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
