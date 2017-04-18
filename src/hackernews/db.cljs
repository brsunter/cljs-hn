(ns hackernews.db
  (:require [clojure.spec :as s]))

;; spec of app-db
(s/def ::greeting string?)

(s/def ::id pos-int?)
(s/def ::title string?)
(s/def ::points (s/nilable int?))
(s/def ::user string?)
(s/def ::time pos-int?)
(s/def ::time-ago string?)
(s/def ::comments-count string?)
(s/def ::type string?)
(s/def ::url (s/nilable string?))
(s/def ::domain string?)

(s/def ::read? boolean?)
(s/def ::story (s/keys :req-un [::id ::title ::points] :opt-un [::read?]))
(s/def ::stories (s/coll-of ::story))
(s/def ::front-page-stories ::stories)
(s/def ::current-page-num int?)
(s/def ::front-page (s/keys :req-un [::front-page-stories] :opt-un [::current-page-num]))
(s/def ::app-db (s/keys :req-un [::greeting ::front-page]))

;; initial state of app-db
(def app-db {:greeting "Hello Clojure in iOS and Android!"
             :front-page {:front-page-stories []
                          :current-page-num 1}})
