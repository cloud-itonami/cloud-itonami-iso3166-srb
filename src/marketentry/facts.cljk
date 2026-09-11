(ns marketentry.facts
  "Serbia (Republic of Serbia, EU-candidate, non-EU-member) market-entry
  catalog. Every field is WebFetch-verified this tick against the
  official government sites named in `:provenance` -- an entry NOT in
  `catalog` has no spec-basis, full stop; extend `catalog`, never
  invent an authority/URL.

  Verified this tick:
  - https://www.ujn.gov.rs/ -- the procurement authority's own OFFICIAL
    Serbian name is 'Канцеларија за јавне набавке' (Kancelarija za
    javne nabavke, lit. 'Office for Public Procurement') -- NOT 'Uprava
    za javne nabavke' as initially assumed before verification. It
    operates the Portal javnih nabavki.
  - https://jnportal.ujn.gov.rs/ -- 'Портал јавних набавки је развијен
    за потребе примене новог Закона о јавним набавкама' (the portal was
    built to implement the new Law on Public Procurement); the site
    cites specific articles (e.g. Art. 109 contract-award-notice
    deadlines, Art. 181 reporting for law-exempt procurements) and
    exposes separate registration wizards for privredno drustvo /
    preduzetnik / fizicko lice bidders.
  - https://www.apr.gov.rs/ -- Агенција за привредне регистре (Agency
    for Business Registers, APR) -- the unified company/business
    registry (DOO, entrepreneurs, and many other registers).
  - https://www.purs.gov.rs/ -- Пореска управа (Poreska uprava / Tax
    Administration), Ministry of Finance -- runs the PIB register.
  - https://ras.gov.rs/ -- Razvojna agencija Srbije (RAS / Development
    Agency of Serbia) -- investment-promotion agency; states Serbia
    'has attracted more than 52 billion euros in direct foreign
    investment since 2007'; does NOT state a specific 'Law on
    Investments' by name on its own pages (that citation below comes
    from a private secondary source -- see `statute.facts` docstring
    for the full provenance disclosure of every statute citation,
    since the official gazette registry pravno-informacioni-sistem.rs
    was unreachable -- connection refused, not a bot-detection
    challenge -- from this environment every time it was tried).

  Exact law-number citations for `:legal-basis` /
  `:nonresident-pib-legal-basis` below are corroborated via
  paragraf.rs (a private commercial Serbian legal-code publisher,
  NOT the official gazette) because the primary official registry was
  unreachable this session -- see `statute.facts` docstring for the
  full disclosure. The AGENCY NAMES, PORTAL URLS and ARTICLE-NUMBER
  REFERENCES above are all independently confirmed from the agencies'
  own official sites.")

(def catalog
  {"SRB" {:name "Serbia"
          :owner-authority "Kancelarija za javne nabavke (Office for Public Procurement) / Portal javnih nabavki"
          :legal-basis "Zakon o javnim nabavkama (\"Sl. glasnik RS\", br. 91/2019 i 92/2023)"
          :national-spec "Portal javnih nabavki (jnportal.ujn.gov.rs) economic-operator registration"
          :provenance "https://jnportal.ujn.gov.rs/"
          :required-evidence ["APR business-registration extract (izvod iz registra APR)"
                               "PIB assignment record (Poreska uprava)"
                               "Portal javnih nabavki economic-operator registration record"
                               "Authorized-signatory record"]
          ;; Flagship check basis -- see marketentry.governor
          ;; `nonresident-pib-missing-violations`. Grounded in Art. 26
          ;; of the Zakon o poreskom postupku i poreskoj administraciji,
          ;; which names 'stalnim poslovnim jedinicama nerezidentnog
          ;; pravnog lica' (permanent business units of a non-resident
          ;; legal entity) as PIB assignees alongside natural persons,
          ;; entrepreneurs and domestic legal entities.
          :nonresident-pib-owner-authority "Poreska uprava (Ministarstvo finansija)"
          :nonresident-pib-legal-basis "PIB -- Zakon o poreskom postupku i poreskoj administraciji, čl. 26 (\"Sl. glasnik RS\", br. 80/2002, sa izmenama)"
          :nonresident-pib-provenance "https://www.purs.gov.rs/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR"
          :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "DEU" {:name "Germany" :owner-authority "e-Vergabe" :legal-basis "GWB/VgV"
          :national-spec "e-Vergabe" :provenance "https://www.evergabe-online.de/"
          :required-evidence ["Handelsregister extract" "e-Vergabe registration record" "USt-IdNr record" "Authorized-representative record"]}
   "NLD" {:name "Netherlands" :owner-authority "TenderNed" :legal-basis "Aanbestedingswet"
          :national-spec "TenderNed" :provenance "https://www.tenderned.nl/"
          :required-evidence ["KvK extract" "TenderNed registration" "BTW record" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))

(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))

(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))

(defn nonresident-pib-spec-basis
  "Spec-basis for the flagship `nonresident-pib-missing` governor check
  -- PIB assignment to a non-resident bidder's permanent business unit,
  Art. 26 Zakon o poreskom postupku i poreskoj administraciji."
  [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:nonresident-pib-owner-authority sb)
      (select-keys sb [:nonresident-pib-owner-authority :nonresident-pib-legal-basis :nonresident-pib-provenance]))))
