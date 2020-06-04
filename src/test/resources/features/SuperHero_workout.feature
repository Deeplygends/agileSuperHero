Feature: SuperHero workout


  Scenario Outline: Normal workout
    Given a Superhero with a strength of "<hero_strength>"
    When the SuperHero is working out
    Then the SuperHero' strength grow up to "<hero_strength_workout>"

    Examples:
      | hero_strength | hero_strength_workout |
      | 40 | 55 |

  Scenario Outline: Maximum workout
    Given a SuperHero with a strenght of "<strength>"
    When SuperHero works out
    Then the SuperHero' strength is cap to "<strength_workout>"

    Examples:
      | strength | strength_workout |
      | 40 | 250 |
