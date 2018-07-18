Feature: Lookup a definition
  In order to talk better
  As an English student
  I want to look up word definitions

  Scenario: Looking up the definition of 'Youtube'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'Youtube','ngg96@hotmail.com','veracruz2016'
    Then they should see the definition 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'
