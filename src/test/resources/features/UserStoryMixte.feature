# new feature
# Tags: optional

Feature: User Story Mixte
  As a : Player
  I want : Que mon Nac sache combattre
  So that : Pour se défendre contre les méchants


  Scenario Outline: Le nac gagne contre un badguy
    Given un Nac avec un <nbrHeureDodo> et un BadGuy avec une <force>
    When le Nac gagne
    Then le Nac voit son <evolutionNbrSommeil> augmenter et le badguy son <evolutionForce> diminuer

    Examples:
      | nbrHeureDodo     | force | evolutionNbrSommeil | evolutionForce |
      | 12               | 12    | 1                | 0          |

  Scenario Outline: Le nac perd contre un badguy
    Given un Nac avec un <nbrHeureDodo> et un BadGuy avec une <force>
    When le badguy gagne
    Then le Nac voit son <evolutionNbrSommeil> diminuer et le badguy son <evolutionForce> augmenter

    Examples:
      | nbrHeureDodo     | force         | evolutionNbrSommeil | evolutionForce |
      | 1                | 1000000000    | 0                   | 1              |