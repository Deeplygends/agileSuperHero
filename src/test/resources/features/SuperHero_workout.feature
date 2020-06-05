Feature: SuperHero workout


  Scenario Outline: Normal workout
    Given an instance of a Superhero
    When the SuperHero is working out one time
    Then the SuperHero' strength grow up to "<hero_strength_workout>"

    Examples:
      | hero_strength_workout |
      | 55 |

  Scenario Outline: Maximum workout
    Given a new instance of SuperHero
    When SuperHero works out 100 times
    Then the SuperHero' strength is cap to "<strength_workout>"

    Examples:
      | strength_workout |
      | 250 |
