# Business Model: Independent Public-Sector Market-Entry & Procurement Compliance Service — Republic of Serbia

## Classification

- Repository: `cloud-itonami-iso3166-srb`
- ISO 3166: `SRB` (Republic of Serbia)
- Activity: public-procurement market-entry and ongoing regulatory-
  compliance navigation for an already-incorporated operator
- Social impact: [:sme-market-access :public-spend-transparency :cross-border-friction-reduction]

## Customer

- an already-incorporated `cloud-itonami-cofog-{code}` /
  `cloud-itonami-isco-{code}` / `cloud-itonami-unspsc-{segment}` /
  `cloud-itonami-{ISIC}` operator wanting to bid on a Serbian public
  contract
- a foreign SME or civic-tech vendor entering the public sector in
  Serbia for the first time
- a `cloud-itonami-M6910` client that has just completed incorporation
  and now needs public-sector market access

## Offer

- registration walkthrough for the Portal javnih nabavki
  (jnportal.ujn.gov.rs), operated by the Kancelarija za javne nabavke
  (Office for Public Procurement), under the Zakon o javnim nabavkama
  ("Sl. glasnik RS", br. 91/2019 i 92/2023)
- business/tax registration checklist: an APR (Agencija za privredne
  registre) business-register entry plus a PIB (poreski
  identifikacioni broj, tax identification number) assigned by the
  Poreska uprava -- including, per Art. 26 Zakon o poreskom postupku i
  poreskoj administraciji, to a non-resident legal entity's permanent
  business unit (stalna poslovna jedinica)
- local-content / preferential-procurement navigation: Serbia is an
  EU-candidate country, NOT an EU member -- no EU-wide open-tendering
  threshold regime applies the way it does for Poland; procurement runs
  entirely under Serbia's own national Zakon o javnim nabavkama via the
  Portal javnih nabavki
- ongoing regulatory-change monitoring subscription
- compliance-audit export package for the client's own records

## Revenue

- per-engagement market-entry fee (one-time registration + checklist
  completion)
- recurring regulatory-change monitoring subscription
- compliance-audit export package

## Trust Controls

- any actual Portal javnih nabavki registration or filing submission
  requires Market-Entry Compliance Governor clearance and always
  escalates to human sign-off (`:filing/submit` is never automated at
  any phase)
- a false or fabricated regulatory-requirement claim is a HARD hold
  that cannot be overridden by human approval alone — it must be
  corrected against a cited official source first
- this service does **not** provide legal or tax advice; characterization
  and filing on the client's behalf beyond checklist/draft assistance
  routes to Serbian-licensed counsel or a registered agent
- every requirement cites the official portal or regulation, never
  invented; where the primary official gazette source
  (pravno-informacioni-sistem.rs) was unreachable this session, the
  gap is disclosed explicitly in `src/statute/facts.cljc` rather than
  papered over

## Honest disclosure: no FDI screening mechanism found

Unlike some EU-member siblings in this fleet, Serbia's Zakon o
ulaganjima ("Sl. glasnik RS", br. 89/2015 i 95/2018) gives foreign
investors national treatment (Art. 7) and does not establish an
explicit foreign-investment screening or notification threshold. RAS
(Razvojna agencija Srbije) promotes investment rather than gating it.
This is stated here as a positive finding about Serbia's actual regime,
not a gap in this catalog's coverage — there is nothing to independently
verify because the source law does not impose a threshold.

## Boundary with adjacent actors (read before forking)

- **`com-etzhayyim-ooyake`** (etzhayyim/root): read-only civic-wayfinding
  mirror of government structure, non-commercial, barred from acting as
  or for the government (G3 impersonation ban). This blueprint is
  commercial and never claims to be an official channel.
- **`matsurigoto`** (etzhayyim/root): sovereign e-government statecraft —
  literally the government, for etzhayyim's own covenant or an adopting
  nation-state. This blueprint is an independent operator the government
  contracts with or that bids into its procurement — never the
  government.
- **`com-etzhayyim-toritsugi`** (etzhayyim/root): guides a consenting
  INDIVIDUAL citizen through their OWN procedure, non-profit,
  donation-only. This blueprint's client is a business operator, not an
  individual citizen, and it is commercial.
- **`legal-entity.etzhayyim.com`**: read-only aggregated company-registry
  data, no execution. This blueprint executes (gated) registrations.
- **`cloud-itonami-M6910`**: helps a client BECOME a legal entity
  (incorporation, ISIC 6910) — a prior, different regulatory phase
  (company law, Zakon o privrednim društvima). This blueprint assumes
  incorporation is already done and handles public-procurement market
  entry (a different regulatory domain).
- **`cloud-itonami-cofog-{code}`**: a jurisdiction-agnostic operator
  template for ONE public function. This blueprint is the orthogonal
  jurisdiction-specific axis — the two compose (fork a COFOG-function
  blueprint AND this one to operate in Serbia).
