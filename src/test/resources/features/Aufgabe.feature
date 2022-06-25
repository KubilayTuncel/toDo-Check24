@aufgabe
Feature: Aufgabe
  Background: Open app
    Given Open app in android mobile phone
  Scenario: test1
    When Klicken Plus Button
    Then Screiben "Test" in Textfeld
    Then Klicken Datum button
    Then Wählen datum aus
    Then Klicken Zeit button
    Then Wählen Zeit aus
    Then Assert "Wed, Jul 13" in Datum Header
    Then Klicken Done Button
    Then Assert Neuer Task "Test" wurde erstellt und ist in der Liste sichtbar
    And schließen App

  Scenario: test2
    When Klicken Plus Button
    Then Screiben "Test" in Textfeld
    Then Klicken Cancel Button
    Then Assert Es wurde kein neuer Task hinzufügt, oben steht noch immer "What do you want do today?"
    And schließen App

  Scenario: test3
    When Klicken Plus Button
    Then Klicken Done Button
    Then Assert Fehlermeldung "Oops, Cannot set an empty text" erscheint
    And schließen App

  Scenario: test4
    When Klicken Plus Button
    Then Screiben "Test" in Textfeld
    Then Klicken Done Button
    Then Klicken Mülltonnen Icon
    Then Assert "Deleted successfully" erscheint
    And schließen App

  Scenario: test5
    When Klicken Sonne-Mond Icon
    Then Klicken Sonne-Mond Icon
    Then Assert Background Farbe der Veränderung
    And schließen App
