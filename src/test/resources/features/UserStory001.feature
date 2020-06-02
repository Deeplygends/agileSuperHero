
Feature: US_001 Presenter un animal
  As a : Player
  I want : Promener les animaux d’un maître donné
  So that : Augmenter leur complicité et leur bien être et avoir plus de possibilites d’interactions avec le jeu

  Scenario Outline: Un nac possède un nom et un nombre d'heure de sommeil
    Given un Nac possédant un <nom> et  un <nbrHeureSommeil>
    When l’utilisateur lui demande de se présenter
    Then le système renvoie la <presentation> du Nac

    Examples:
      | nom       | nbrHeureSommeil | presentation                                 |
      | "Hamtaro" | 12              | "Je m'appelle Hamtaro et je dors 12 heures." |


