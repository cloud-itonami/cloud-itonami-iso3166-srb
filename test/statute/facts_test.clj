(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest srb-has-spec-basis
  (let [sb (facts/spec-basis "SRB")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["SRB" "POL" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "POL"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["srb.sl-glasnik-2018-87-zakon-o-zastiti-podataka-o-licnosti"]
         (mapv :statute/id (facts/by-topic "SRB" :privacy))))
  (is (= ["srb.sl-glasnik-2005-24-zakon-o-radu"]
         (mapv :statute/id (facts/by-topic "SRB" :labor))))
  (is (empty? (facts/by-topic "ATL" :privacy))))
