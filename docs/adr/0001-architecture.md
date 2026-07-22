# ADR-0001: SRB marketentry `:implemented`

Flagship `nonresident-pib-missing` (Art. 26 Zakon o poreskom postupku i
poreskoj administraciji — PIB assignment to a non-resident bidder's
permanent business unit, Poreska uprava). No second secondary
"corporate-number" check: unlike Poland (EU member, where EU-
establishment and NIP-verification are two independent facts), Serbia
(EU-candidate, non-EU-member) has only the one PIB mechanism — adding a
second check would fabricate a distinction the source statute does not
draw. See `src/marketentry/governor.cljc` docstring for the full
reasoning and citation trail.
