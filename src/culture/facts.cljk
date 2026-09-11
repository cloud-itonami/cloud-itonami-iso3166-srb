(ns culture.facts
  "Country-level regional-culture catalog for Serbia (SRB) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"SRB"
   [{:culture/id "srb.dish.pljeskavica"
     :culture/name "Pljeskavica"
     :culture/country "SRB"
     :culture/kind :dish
     :culture/summary "Serbian grilled dish consisting of a mixture of spiced minced pork, beef and lamb meat; one of the national dishes of Serbia."
     :culture/url "https://en.wikipedia.org/wiki/Pljeskavica"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.dish.cevapi"
     :culture/name "Cevapi"
     :culture/name-local "Ćevapi"
     :culture/country "SRB"
     :culture/kind :dish
     :culture/summary "Grilled dish of minced meat that originated in Serbia in the 19th century and is considered a national dish of Serbia and Bosnia and Herzegovina."
     :culture/url "https://en.wikipedia.org/wiki/%C4%86evapi"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.dish.sarma"
     :culture/name "Sarma"
     :culture/country "SRB"
     :culture/kind :dish
     :culture/summary "Stuffed cabbage rolls; in Serbia, the classic form contains minced meat, which could be pork or beef."
     :culture/url "https://en.wikipedia.org/wiki/Stuffed_leaves"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.product.kajmak"
     :culture/name "Kajmak"
     :culture/country "SRB"
     :culture/kind :product
     :culture/summary "Dairy product considered a national meal by Serbs among other Balkan peoples; in Serbia it is stuffed inside a breaded, fried meat cutlet to make the dish Karadjordjeva snicla."
     :culture/url "https://en.wikipedia.org/wiki/Kajmak"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.beverage.rakia"
     :culture/name "Rakia"
     :culture/name-local "Ракија"
     :culture/country "SRB"
     :culture/kind :beverage
     :culture/summary "Fruit brandy that is the national drink of Serbia and one of the most popular alcoholic drinks in the country."
     :culture/url "https://en.wikipedia.org/wiki/Rakia"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.craft.pirot-carpet"
     :culture/name "Pirot carpet"
     :culture/country "SRB"
     :culture/kind :craft
     :culture/summary "Skill of making woollen kilim rugs on a vertical loom, decorated with geometric, vegetal and figural ornaments; rug-making in Pirot is included on the list of Intangible Cultural Heritage of Serbia."
     :culture/url "https://en.wikipedia.org/wiki/Pirot_carpet"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.festival.guca-trumpet-festival"
     :culture/name "Guca Trumpet Festival"
     :culture/name-local "Gučа Trumpet Festival"
     :culture/country "SRB"
     :culture/kind :festival
     :culture/summary "Annual Balkan brass band festival and competition held in the town of Guca, in the Dragacevo region and Lucani municipality of Serbia."
     :culture/url "https://en.wikipedia.org/wiki/Gu%C4%8Da_Trumpet_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "srb.heritage.stari-ras"
     :culture/name "Stari Ras and Sopocani"
     :culture/country "SRB"
     :culture/kind :heritage
     :culture/summary "The site of Stari Ras, in combination with nearby Sopocani, is a UNESCO World Heritage Site in Serbia, inscribed on the World Heritage List in 1979."
     :culture/url "https://en.wikipedia.org/wiki/Stari_Ras"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-srb culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "SRB"))
                 " SRB entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
