(ns statute.facts
  "General-law compliance catalog for Serbia (SRB) -- per ADR-2607141700
  (cloud-itonami-compliance-fact-federation), mirroring the shape of
  cloud-itonami-iso3166-pol/-jpn/-usa/-... `statute.facts`. Serbia was
  previously culture-catalog-only in this repo, with no statute.facts
  -- this entry closes that structural gap for the SRB entity.

  PROVENANCE DISCLOSURE (read before trusting any citation below):

  The official Serbian legal-gazette registry, pravno-informacioni-
  sistem.rs (Pravno-informacioni sistem Republike Srbije -- the
  government's own ELI-style legal-act registry, analogous to Poland's
  eli.gov.pl), was attempted directly (https and http, with and
  without 'www.') and via the Wayback Machine (archive.org/wayback/
  available confirmed a snapshot exists, but this environment's
  WebFetch tool refuses web.archive.org URLs categorically -- an
  environment restriction, not something bypassed). Direct fetches
  all failed with `connect ECONNREFUSED` (the same resolved IP,
  194.32.150.130, refused every attempt) -- this is a genuine
  connectivity failure, NOT a CAPTCHA / bot-detection challenge page
  (no challenge was ever served; the connection was refused outright),
  so no bypass technique was attempted or would have been appropriate
  either way.

  Because the primary official registry was unreachable, the THREE law
  citations below (law title, exact 'Sl. glasnik RS' gazette number(s),
  and Article 1 / a substantive article) were instead corroborated via
  https://www.paragraf.rs/ -- a private commercial Serbian legal-code
  publisher (NOT an official government site) -- which WAS fetched and
  read directly this session. This is a materially weaker provenance
  than Poland's eli.gov.pl citations (an alternate OFFICIAL source);
  it is disclosed here explicitly rather than presented as
  official-government-sourced. The AGENCY NAMES and PORTAL URLS in
  `marketentry.facts` (Kancelarija za javne nabavke, APR, Poreska
  uprava/PIB, RAS) ARE independently confirmed from those agencies'
  own official .gov.rs sites this session; only the exact statute
  citations below rely on the paragraf.rs corroboration.

  Zakon o privrednim društvima (Law on Business Companies, \"Sl.
  glasnik RS\", br. 36/2011, 99/2011, 83/2014 - dr. zakon, 5/2015,
  44/2018, 95/2018, 91/2019, 109/2021 i 19/2025) -- paragraf.rs quotes
  Article 1 verbatim: 'Ovim zakonom uređuje se pravni položaj
  privrednih društava i drugih oblika organizovanja u skladu sa ovim
  zakonom, a naročito njihovo osnivanje, upravljanje, statusne
  promene, promene pravne forme, prestanak i druga pitanja od značaja
  za njihov položaj, kao i pravni položaj preduzetnika.'

  Zakon o zaštiti podataka o ličnosti (Law on Personal Data Protection,
  \"Sl. glasnik RS\", br. 87/2018, enacted 2018) -- paragraf.rs states
  Article 1 regulates the protection of natural persons in connection
  with personal-data processing, the free flow of such data,
  processing principles, data-subject rights, and controller/processor
  obligations.

  Zakon o radu (Labour Law, \"Sl. glasnik RS\", br. 24/2005, 61/2005,
  54/2009, 32/2013, 75/2014, 13/2017 - odluka US, 113/2017, 95/2018 -
  autentično tumačenje i 109/2025 - dr. zakon) -- paragraf.rs quotes
  Article 1 verbatim: 'Prava, obaveze i odgovornosti iz radnog odnosa,
  odnosno po osnovu rada, uređuju se ovim zakonom...' (Rights,
  obligations and responsibilities arising from employment
  relationships, or on the basis of work, are regulated by this law...
  -- own gloss, not an official translation).

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"SRB"
   [{:statute/id "srb.sl-glasnik-2011-36-zakon-o-privrednim-drustvima"
     :statute/title "Zakon o privrednim društvima (Law on Business Companies)"
     :statute/jurisdiction "SRB"
     :statute/kind :law
     :statute/law-number "\"Sl. glasnik RS\", br. 36/2011, 99/2011, 83/2014 - dr. zakon, 5/2015, 44/2018, 95/2018, 91/2019, 109/2021 i 19/2025"
     :statute/url "https://www.paragraf.rs/propisi/zakon_o_privrednim_drustvima.html"
     :statute/url-provenance :private-paragraf-rs-official-registry-unreachable
     :statute/enacted-date "2011-05-25"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "srb.sl-glasnik-2018-87-zakon-o-zastiti-podataka-o-licnosti"
     :statute/title "Zakon o zaštiti podataka o ličnosti (Law on Personal Data Protection)"
     :statute/jurisdiction "SRB"
     :statute/kind :law
     :statute/law-number "\"Sl. glasnik RS\", br. 87/2018"
     :statute/url "https://www.paragraf.rs/propisi/zakon_o_zastiti_podataka_o_licnosti.html"
     :statute/url-provenance :private-paragraf-rs-official-registry-unreachable
     :statute/enacted-date "2018-11-09"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "srb.sl-glasnik-2005-24-zakon-o-radu"
     :statute/title "Zakon o radu (Labour Law)"
     :statute/jurisdiction "SRB"
     :statute/kind :law
     :statute/law-number "\"Sl. glasnik RS\", br. 24/2005, 61/2005, 54/2009, 32/2013, 75/2014, 13/2017 - odluka US, 113/2017, 95/2018 - autentično tumačenje i 109/2025 - dr. zakon"
     :statute/url "https://www.paragraf.rs/propisi/zakon_o_radu.html"
     :statute/url-provenance :private-paragraf-rs-official-registry-unreachable
     :statute/enacted-date "2005-03-24"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-srb statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "SRB")) " Serbia entries seeded, "
                 "corroborated via paragraf.rs (private publisher) because "
                 "pravno-informacioni-sistem.rs (official) refused every "
                 "connection this session -- see catalog docstring for full "
                 "disclosure. Extend `statute.facts/catalog`, never fabricate "
                 "an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
