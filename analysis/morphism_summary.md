# Morphism Results Summary

This document provides a consolidated summary of all morphism results from the dissertation research.

## Overview

The dissertation explores verification model (VM) definition through morphic equivalence relationships. Key finding: **VM should be defined through a combination of relationships (VRPS + VMMC + SD), not any single relationship alone.**

---

## 1. SM Morphism Results (Chapter 4.2)

### Component Morphisms
| Source | Target | Result |
|--------|--------|--------|
| ZAD | ZBD | L1 Homomorphism proven |
| ZAE | ZBE | L1 Homomorphism proven |

### Coupled System Morphisms Summary
| Source | Targets with Proven Morphism |
|--------|------------------------------|
| ZAC1 | ZA, ZB, ZC, ZA2, ZB2, ZAC2, ZBC1, ZBC2 (8 total) |
| ZAC2 | ZA, ZB, ZC, ZA2, ZB2, ZBC1, ZBC2 (7 total) |
| ZBC1 | ZA, ZB, ZC, ZA2, ZB2, ZBC2 (6 total) |
| ZBC2 | ZA, ZB, ZC, ZA2, ZB2 (5 total) |

**Total: 28 morphism proofs**

---

## 2. VM Definition from SR (Chapter 4.4)

| VM | SR Superset | On/Light (S1) | Off/No-Light (S2) | Water-Resist (S3) |
|----|:-----------:|:-------------:|:-----------------:|:-----------------:|
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

---

## 3. VM Definition from VRPS (Chapter 4.5)

| VM | VRPS1 | VRPS2 | VRPS3 | VRPS4 | VRPS5 |
|----|:-----:|:-----:|:-----:|:-----:|:-----:|
| VM1 | - | Yes | Yes | - | - |
| VM2 | - | Yes | Yes | - | - |
| VM3 | - | Yes | Yes | - | - |
| VM4 | - | Yes | Yes | - | - |
| VM5 | - | - | - | - | - |
| VM6 | - | Yes | - | - | - |
| VM7 | - | - | - | - | Yes |
| VM8 | - | - | - | Yes | - |
| VM9 | - | - | - | Yes | - |
| VM10 | - | - | - | - | - |
| VM11 | Yes | - | - | - | - |
| VM12 | - | - | - | - | - |
| VM13 | - | - | - | - | - |
| VM14 | - | - | - | - | - |
| VM15 | - | - | - | - | - |
| VM16 | - | - | - | - | - |
| VM17 | - | - | - | - | - |
| VM18 | - | Yes | - | - | - |

---

## 4. VM Definition from SD (Chapter 4.6-4.7)

**Key Finding: Every VM has morphic equivalence to every SD.**

| VM | SD1 | SD2 | SD3 | SD4 |
|----|:---:|:---:|:---:|:---:|
| VM1-VM18 | Yes | Yes | Yes | Yes |

This "infinite equivalence" necessitates VMMC to bound acceptable VM.

---

## 5. VM Adherence to VMMC (Chapter 4.8)

| VM | VMMC1 | VMMC2 | VMMC3 | VMMC4 | VMMC5 | VMMC6 |
|----|:-----:|:-----:|:-----:|:-----:|:-----:|:-----:|
| VM1 | Yes | Yes | Yes | Yes | Yes | Yes |
| VM2 | Yes | Yes | Yes | Yes | Yes | Yes |
| VM3 | Yes | Yes | Yes | Yes | Yes | Yes |
| VM4 | Yes | Yes | Yes | Yes | Yes | Yes |
| VM5 | - | - | - | - | - | - |
| VM6 | - | - | Yes | - | - | Yes |
| VM7 | - | - | - | - | - | - |
| VM8 | - | - | - | - | - | - |
| VM9 | - | - | - | - | - | - |
| VM10 | - | - | - | - | - | - |
| VM11 | - | - | - | - | - | - |
| VM12 | - | - | - | - | - | Yes |
| VM13 | - | - | - | - | - | - |
| VM14 | - | - | - | - | - | - |
| VM15 | - | - | - | - | - | - |
| VM16 | Yes | - | Yes | Yes | Yes | Yes |
| VM17 | - | - | - | - | - | - |
| VM18 | Yes | Yes | Yes | Yes | Yes | Yes |

---

## 6. VM from Combined VRPS + VMMC + SD (Chapter 4.9)

The combination tables (Tables 88-117) show that combining all three constraints yields bounded VM selection. Key patterns:

### VRPS2 Combinations (Selected Results)

| VMMC | SD1 | SD2 | SD3 | SD4 | Unique VMs |
|------|-----|-----|-----|-----|------------|
| VMMC1 | VM1,3,16-18 | VM2,4 | VM1,3,16-18 | VM2,4 | Bounded |
| VMMC6 | VM1-4,6,12,16,18 | VM1-4,6,12,16,18 | VM1-4,6,12,16,18 | VM1-4,6,12,16,18 | Broader |

---

## 7. WySE Metamodel Summary

The Wymorian Systems Engineering (WySE) metamodel establishes:

1. **VM indirectly defined from SR** through SD and VRPS
2. **VRPS serves dual role**: morphic relationship to SR AND bounding VMMC
3. **SD-VM morphism necessary but not sufficient**
4. **Combined knowledge required**: VRPS + VMMC + SD

```
        SR (System Requirements)
       /  \
      /    \
   VRPS    SD (System Designs)
     \    /
      \  /
     VMMC
       |
       v
      VM (Verification Models)
```

---

## Key Dissertation Findings

1. **Infinite Equivalence Problem**: Every VM is morphically equivalent to every SD
2. **Bounding Required**: VMMC constrains infinite equivalence
3. **Combination Necessary**: Single relationships insufficient for VM definition
4. **Science-Based Framework**: WySE provides rigorous foundation for VM selection

---

*Summary compiled from: "Study of Equivalence in Systems Engineering within the Frame of Verification" (Wach, 2022)*
