Feature: Superhero fight one bad guy


  Scenario Outline: fight a bad guy and the bad guy wins
    Given a fight between a superhero and a Bad Guy of strength <badguy_strength>
    When the bad guy wins against the super hero
    Then the superhero strength decrease to <hero_newstrength>
    And the bad guy strength grow up to <badguy_newstrength>

    Examples:
      | badguy_strength | hero_newstrength | badguy_newstrength |
      | 260 | 125 | 385 |
      | 500 | 62 | 562 |



    Examples:
      |  badguy_strength | hero_newstrength | badguy_newstrength |
      | 30 | 77 | 15 |
      | 20 | 87 | 10 |
