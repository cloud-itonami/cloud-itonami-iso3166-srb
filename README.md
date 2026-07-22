# cloud-itonami-iso3166-srb

Open ISO 3166 Blueprint for **SRB**: Republic of Serbia (EU-candidate,
non-EU-member).

**`:implemented`** for **SRB**. Flagship `nonresident-pib-missing`
(Art. 26 Zakon o poreskom postupku i poreskoj administraciji).

```
clojure -M:dev:test
```

Independent public-sector market-entry & procurement-compliance service
for an already-incorporated operator entering public contracts in Serbia.

## Official surface (web-verified)

- Procurement: Kancelarija za javne nabavke (Office for Public
  Procurement, ujn.gov.rs) operates the Portal javnih nabavki
  (jnportal.ujn.gov.rs) under the Zakon o javnim nabavkama ("Sl.
  glasnik RS", br. 91/2019 i 92/2023). (Note: an earlier draft of this
  README assumed the name "Uprava za javne nabavke" -- verified this
  tick against ujn.gov.rs directly and corrected to the agency's actual
  official name, Kancelarija za javne nabavke.)
- Business/tax: Agencija za privredne registre (APR, apr.gov.rs) runs
  the unified business register; Poreska uprava (purs.gov.rs) assigns
  the PIB tax identification number, including to non-resident legal
  entities' permanent business units (Art. 26 Zakon o poreskom
  postupku i poreskoj administraciji).
- Foreign investment: Razvojna agencija Srbije (RAS, ras.gov.rs) is
  the investment-promotion agency. Serbia's Zakon o ulaganjima (Law on
  Investments, "Sl. glasnik RS", br. 89/2015 i 95/2018) gives foreign
  investors national treatment (Art. 7) and does not impose an explicit
  FDI screening/notification threshold -- this asymmetry with EU-member
  siblings (e.g. Poland) is deliberate and disclosed, not an omission.

See `src/marketentry/facts.cljc` and `src/statute/facts.cljc` for the
full citation trail and an explicit provenance disclosure (the official
gazette registry, pravno-informacioni-sistem.rs, was unreachable this
session -- statute citations are corroborated via a private legal
publisher instead, clearly marked as such).

## What this is NOT

- **Not the government of Serbia.**

## License

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Serbia:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
