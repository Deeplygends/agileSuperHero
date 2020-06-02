Feature: US_002 Promener un groupe d’animaux par un maitre
  As a : Player
  I want : Promener les animaux d’un maitre donné
  So that : Augmenter leur complicite et leur bien etre et avoir plus de possibilites d’interactions avec le jeu

  Scenario Outline: Un maître avec deux animaux
    Given Un maitre avec un <nom> et un <age> et les <nom1> <nom2> <nbrSommeil1> <nbrSommeil2> des animaux qu’il possede
    When l’utilisateur demande de promener le groupe
    Then le systeme renvoie un <message> confirmant bien la promenade et les animaux qui y participent
    Examples:
      | nom     | age | nom1      | nom2      | nbrSommeil1 | nbrSommeil2 | message                                                                                              |
      | "Laura" | 10  | "Hamtaro" | "Hamtara" | 12          |  4          | "Pour cette promenade, Laura vous présente :\n-Je m'appelle Hamtaro et je dors 12 heures.\n-Je m'appelle Hamtara et je dors 4 heures."  |

  Scenario Outline: Un maître sans animaux
    Given Un maître avec un <nom> et un <age> ne possédant pas d’animal
    When l’utilisateur demande de promener le groupe
    Then le système renvoie un <message> d erreur
    Examples:
      | nom     | age | message                             |
      | "Laura" | 10  | "Erreur : pas d'animal à promener"  |
      | "Julie" | 14  | "Erreur : pas d'animal à promener"  |

