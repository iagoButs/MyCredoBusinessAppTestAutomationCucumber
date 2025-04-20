Feature: neagative Cases for Login Page

  Scenario Outline: Login without password and username
    Given user Clicks changeLanguage Buttons
    And user Choose aplication language: <language>
    When user Clicks Login Button
    Then usernameField errorMessage should be: <userNameerrorMessage>
    Then PasswordField errorMessage should be: <passwordFieldErrorMessage>

    Examples:
      | language  | userNameerrorMessage                | passwordFieldErrorMessage  |
      |"KA"       | "აუცილებელი ველი არ არის შევსებული"|"აუცილებელი ველი არ არის შევსებული"|
      |"EN"       | "Mandatory field is empty"          |"Mandatory field is empty"         |
      |"RU"       | "Необходимое поле не заполнено"     |"Необходимое поле не заполнено"    |

  Scenario Outline: attempt authorisation only LoginField
    Given user Clicks changeLanguage Buttons
    And user Choose aplication language: <language>
    And user fills userInput <username>
    When user Clicks into Password Field
    And user Clicks into login Field
    Then PasswordField errorMessage should be: <passwordFieldErrorMessage>
    Examples:
      | language  | username      | passwordFieldErrorMessage  |
      |"KA"       | "testUser"    |"აუცილებელი ველი არ არის შევსებული"|
      |"EN"       | "testUser"    |"Mandatory field is empty"         |
      |"RU"       | "testUser"    |"Необходимое поле не заполнено"    |


  Scenario Outline: attempt authorisation only PasswordField
    Given user Clicks changeLanguage Buttons
    And user Choose aplication language: <language>
    And user fills passwordInputInput <password>
    When user Clicks into login Field
    And user Clicks into Password Field
    Then usernameField errorMessage should be: <userNameerrorMessage>
    Examples:
      | language  | password                | userNameerrorMessage  |
      |"KA"       | "testPassword"          |"აუცილებელი ველი არ არის შევსებული"|
      |"EN"       | "testPassword"          |"Mandatory field is empty" |
      |"RU"       | "testPassword"          |"Необходимое поле не заполнено"|


  Scenario Outline: use Wrong symbols in userName field
    Given user Clicks changeLanguage Buttons
    And user Choose aplication language: <language>
    And user fills userInput <username>
    Then usernameField errorMessage should be: <userNameerrorMessage>
    Examples:
      | language  | username      | userNameerrorMessage  |
      |"KA"       | "#%&"         |"მომხმარებლის სახელში გამოყენებულია არასწორი სიმბოლოები"|
      |"EN"       | "#%&"         |"Wrong symbols"         |
      |"RU"       | "#%&"         |"В имени пользователя использованы недопустимые символы"|


  Scenario Outline: authorisation with wrong username and password
    Given user Clicks changeLanguage Buttons
    And user Choose aplication language: <language>
    And user fills userInput <username>
    And user fills passwordInputInput <password>
    When user Clicks Login Button
    Then flashMessage Text should be equals: <checkText>
    Examples:
      | language  |username    | password                | checkText  |
      |"KA"       |"testUsername"| "testPassword"          |"ავტორიზაციის დროს დაფიქსირდა შეცდომა"|
      |"EN"       |"testUsername"| "testPassword"          |"An error occurred while login" |
      |"RU"       |"testUsername"| "testPassword"          |"Произошла ошибка при входе в систему"|