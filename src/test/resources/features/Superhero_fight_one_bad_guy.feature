Feature: Superhero fight one bad guy


  Scenario Outline: fight a bad guy and the bad guy wins
    Given a fight between a supehero of strength <hero_strength> and a BadGuy of strength <badguy_strength>
    When the bad guy wins against the super hero
    Then the superhero strength decrease to <hero_newstrength>
    And the bad guy strength grow up to <badguy_newstrength>

    Examples:
      | hero_strength | badguy_strength | hero_newstrength | badguy_newstrength |
      | 50 | 60 | 25 | 85 |
      | 250 | 500 | 125 | 625 |

  Scenario Outline: fight a bad guys and the super hero wins
    Given a fight between a supehero of strength <hero_strength> and a Bad Guy of strength <badguy_strength>
    When the super hero wins against the bad guy
    Then the SuperHero strength grows up to <hero_newstrength>
    And the bad guy strength decrease to <badguy_newstrength>

    Examples:
      | hero_strength | badguy_strength | hero_newstrength | badguy_newstrength |
      | 200 | 50 | 225 | 25 |
      | 250 | 100 | 250 | 50 |
