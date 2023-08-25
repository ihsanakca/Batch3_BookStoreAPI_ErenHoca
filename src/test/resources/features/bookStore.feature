@all
Feature: BookStore Circle


  Scenario: Scenario-1
    Given Get all books
    Then Validate that the books are listed


  Scenario: Scenario-2
    Given Add new user
    Then Validate that the user is created


  Scenario: Scenario-3
    Given Generate Token
    Then Validate that the token is generated


  Scenario: Scenario-4
    Given Authorize User
    Then Validate that the user is authorized


  Scenario: Scenario-5
    Given Add new book to the user
    Then Validate that the book is added to the user


  Scenario: Scenario-6
    Given Get user information
    Then Validate that the information is correct


  Scenario: Scenario-7
    Given Update first book with the second one
    Then Validate that the book is updated

  @wip
  Scenario: Scenario-8
    Given Delete Book
    Then Validate that the book is deleted