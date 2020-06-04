Feature: Superhero fight one bad guy


  Scenario Outline: fight a bad guy and the bad guy wins
    Given a fight between a supehero of strength <hero_strength> and a BadGuy of strength <badguy_strength>
    When the bad guy wins against the super hero
    Then the superhero strength decrease to <hero_newstrength>
    And the bad guy strength grow up to <badguy_newstrength>

    Examples:
      | hero_strength | badguy_strength | hero_newstrength | badguy_newstrength |
      | 40 | 260 | 125 | 385 |
      | 40 | 500 | 62 | 562 |



    Examples:
      | hero_strength | badguy_strength | hero_newstrength | badguy_newstrength |
      | 40 | 30 | 77 | 15 |
      | 40 | 20 | 87 | 10 |
