# Fetch Rewards Coding Exercise - Backend Software Engineering
## Description
A java web service that accepts a string as input and return a response indicating whether a word is a pyramid word. A word is a pyramid word if you can arrange the letters in increasing frequency, starting with 1 and continuing without gaps and without duplicates.

### Example
1. banana is a pyramid word because you have 1 'b', 2 'n's, and 3 'a's.
1. bandana is not a pyramid word because you have 1 'b' and 1 'd'.

## Instruction
### Requirements
1. JDK 1.8 or later
1. Gradle 4+ or Maven 3.2+
1. A favorite text editor or IDE

### Steps
1. Clone the repository and import the folder into your editor.
2. Clean and build the project.
3. Start the services by running FetchRewardsApplication.
4. Open the browser or any web API testing tools and use either of the below URLs as the endpoint:
  ```http://localhost:8080/api/v1/pyramid```
   ```http://127.0.0.1:8080/api/v1/pyramid```
5. The result will be displayed.

## Design

### Input Definition

Pyramid consists only letters i.e lowercase and uppercase alphabets. Any other character would be considered as an invalid input. It means the word can't contain any number or special characters.

The base URL of the service is ``` /api/v1/pyramid ``` and it supports both GET and POST request.

### Response Object (Output)

The response JSON objects consists of three values pair. 
1. word: Indicates the input string.
2. result: Boolean value. It is true when the string is a pyramid word, otherwise false.
3. error: Displays error message (if any). Otherwise it is an empty string.
   - Empty Input (only spaces)
   - No Input (input is missing)
   - Invalid Input (violating the input constraints)
```
{
    "word": "banana",
    "result": true,
    "error": ""
}
```
```
{
    "word": "bana1na",
    "result": false,
    "error": "INVALID INPUT"
}
```

### HTTP Methods
#### GET Request (Path Variable)
Spring @PathVariable tutorial shows how to read a URL template variable with @PathVariable annotation. <sup>[1]</sup> [Link](http://zetcode.com/spring/pathvariable/)

- Syntax: ``` http://localhost:8080/api/v1/pyramid/{word} ```
   - Example: ``` http://localhost:8080/api/v1/pyramid/{banana} ```
   - Example: ``` http://localhost:8080/api/v1/pyramid/{bandana} ```

![Path Variable](https://github.com/roongtarohit/fetch_rewards/blob/master/imgs/pathVariableRequest.png)

#### GET Request 

- Syntax: ``` http://localhost:8080/api/v1/pyramid?word={word} ```
   - Example: ``` http://localhost:8080/api/v1/pyramid?word={banana} ```
   - Example: ``` http://localhost:8080/api/v1/pyramid?word={bandana} ```
 
![Get Request](https://github.com/roongtarohit/fetch_rewards/blob/master/imgs/getRequest.png)

#### POST Request

1. POST URL: ``` http://localhost:8080/api/v1/pyramid ```
2. Content-Type: PlainText
3. Request Body: Input word string

![Post Request](https://github.com/roongtarohit/fetch_rewards/blob/master/imgs/postRequest.png)

## REFERENCES
1. http://zetcode.com/spring/pathvariable/
