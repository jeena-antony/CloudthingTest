Feature: cloudthing test

  Scenario Outline: Cloudthing Test
    Given cloudthing page is open
    And open careers menu
    And find "<section>" and enter "<name>","<email>","<phone>","<message>" and "<cv>"
    Then close browser

    Examples:
      | section                          | name  | email           | phone      | message                              | cv                              |
      | Senior Performance Test Engineer | jeena | jeena@gmail.com | 6360770456 | this is for cloudthing selenium test | C:\Users\10\Documents\test.docx |

