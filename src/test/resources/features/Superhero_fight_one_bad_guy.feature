Feature: Superhero fight one bad guy


  Scenario Outline: fight a bad guy and the bad guy wins
    Given a fight between a superhero and a Bad Guy of strength <badguy_strength>
    When the bad guy wins against the super hero
    Then the superhero strength decrease to <hero_newstrength>
    And the bad guy strength grow up to <badguy_newstrength>

    Examples:
      | badguy_strength | hero_newstrength | badguy_newstrength |
      | 260 | 20 | 280 |
      | 500 | 20 | 520 |



    Examples:
      |  badguy_strength | hero_newstrength | badguy_newstrength |
      | 30 | 55 | 15 |
      | 20 | 50 | 10 |
