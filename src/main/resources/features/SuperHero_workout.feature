Feature: SuperHero workout


  Scenario Outline: Normal workout
    Given a Superhero with a strength of <hero_strength>
    When the SuperHero is working out
    Then the SuperHero' strength grow up to <hero_strength_workout>

    Examples:
      | hero_strength | hero_strength_workout |
      | 150 | 165 |
      | 100 | 115 |
      | 10 | 25 |

  Scenario Outline: Maximum workout
    Given a SuperHero with a strength of <strength>
    When SuperHero works out
    Then the SuperHero' strength become <strength_workout>

    Examples:
      | strength | strength_workout |
      | 250 | 250 |
      | 240 | 250 |
