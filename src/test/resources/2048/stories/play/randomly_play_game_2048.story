Narrative:
In order to satisfy test task from MacPaw
As a QA Automation person
I want to create robot for playing 2048 game

Scenario: Randomly play 2048 game
Given player in on the home page
And stop playing criteria is 'Game over!'
Then start random play with 'UP, DOWN, LEFT, RIGHT' keys
And show scores