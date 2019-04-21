Feature: Add, view and delete branches
Description: The purpose of this test is to test add, view and delete branches
 
Scenario Outline: User add, view and delete branches to gurukula application
Given user navigates to the gurukula application
When he log-in to the application
Then he add the branch to the application "<row_index>"
And he can edit the branch details "<row_index>"
And he can delete the branch
Examples:
  |row_index|
  |0|
  |1|
  |2|
  |3|