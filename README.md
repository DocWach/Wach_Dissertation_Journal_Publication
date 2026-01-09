# A Systems Theoretic Metamodel for Defining Verification Models through Morphic Equivalence

**Supplementary Materials Repository**

This repository contains supplementary materials for the journal article submission to *Systems Engineering* (Wiley), derived from the doctoral dissertation:

> **Study of Equivalence in Systems Engineering within the Frame of Verification**
> Paul F. Wach, Ph.D.
> Virginia Tech, Industrial and Systems Engineering
> December 2022

---

## Abstract

Verification models are fundamental to systems engineering practice, yet their definition remains largely qualitative, relying on heuristic assumptions about representativeness rather than scientific principles. This paper presents a systems theoretic metamodel for defining verification models through morphic equivalence relationships, grounded in the theoretical foundations of A. Wayne Wymore's computational systems theory, Tricotyledon Theory of System Design (T3SD), and Discrete Event System Specification (DEVS).

We demonstrate that verification models should be defined through a combination of systems theoretic relationships between verification artifacts: system requirements, system designs, verification requirements, and verification models. The research establishes that verification models are indirectly defined from system requirements through system designs and verification requirements. While verification models are expected to be morphically equivalent to corresponding system designs, infinite equivalence may exist and must be bounded through two mechanisms: (1) verification requirement problem spaces that characterize verification activity based on morphic equivalence to system requirements, and (2) verification model morphic conditions specifying desired equivalence between system designs and verification models.

The resulting Wymorian Systems Engineering (WySE) metamodel provides a science-based framework for verification model definition, advancing the discipline of systems engineering toward the analytical rigor characteristic of mature engineering fields. Validation against ISO 15288 and NASA verification practices confirms the unique contribution and practical applicability of this theoretical foundation.

**Keywords:** Verification, Systems Theory, DEVS, T3SD, Morphism, Equivalence, MBSE, Metamodel

---

## Repository Structure

```
├── paper/
│   ├── abstract.md                   # Article abstract
│   └── figures/                      # High-resolution figures for publication
│
├── supplementary_materials/
│   ├── 00_glossary/                  # Glossary of acronyms and terms
│   ├── 01_theoretical_background/    # T3SD and DEVS foundations
│   ├── 02_validation_code/           # MS4 Me validation code
│   ├── 03_PSF_definitions/           # Problem Spaces of Functions (PSF 1-7)
│   ├── 04_SM_definitions/            # System Models (ZA through ZBC2)
│   ├── 05_SM_from_PSF/               # SM defined from PSF adherence proofs
│   ├── 06_SM_from_SM_morphisms/      # 28 morphism proofs between SMs
│   ├── 07_VRPS_from_SR/              # VRPS defined from SR (VRPS1-5)
│   ├── 08_SD_adherence_SR/           # SD adherence to SR proofs
│   ├── 09_VM_from_SR_subsets/        # VM defined from SR subsets (VM1-18)
│   ├── 10_VM_from_VRPS/              # VM defined from VRPS
│   └── 11_VM_from_SD/                # VM defined from SD
│
├── data/
│   └── tabular_specifications/       # Machine-readable CSV/JSON tables
│
└── analysis/
    └── morphism_summary.md           # Summary of all morphism results
```

---

## Supplementary Material Contents

### Theoretical Background (Appendix A.2)
- T3SD (Tricotyledon Theory of System Design) background
- DEVS (Discrete Event System Specification) hierarchy

### Mathematical Definitions
- **PSF 1-7**: Problem Spaces of Functions specifications
- **SM ZA-ZBC2**: 13 System Model specifications including coupled systems
- **28 Morphism Proofs**: Complete SM-to-SM morphism demonstrations

### Verification Model Results
- **VM1-VM18**: Verification model definitions
- **VRPS1-VRPS5**: Verification Requirement Problem Spaces
- **VMMC1-VMMC6**: Verification Model Morphic Conditions
- **Tables 88-117**: Complete VRPS+VMMC+SD combination results

### Validation Code
- MS4 Me implementation of system models
- Homomorphism validation routines
- Experimental frame specifications

---

## Related Publications

- Wach, P.F. (2024). *A systematic literature review on the mathematical underpinning of model-based systems engineering*. Systems Engineering, 27(2). DOI: [10.1002/sys.21781](https://doi.org/10.1002/sys.21781)

---

## Citation

If you use these materials, please cite:

```bibtex
@phdthesis{wach2022verification,
  author = {Wach, Paul F.},
  title = {Study of Equivalence in Systems Engineering within the Frame of Verification},
  school = {Virginia Tech},
  year = {2022},
  address = {Blacksburg, VA},
  department = {Industrial and Systems Engineering}
}
```

---

## License

This work is licensed under [CC BY 4.0](https://creativecommons.org/licenses/by/4.0/).

---

## Contact

**Paul F. Wach, Ph.D.**
University of Arizona
[pfwach@arizona.edu](mailto:pfwach@arizona.edu)
