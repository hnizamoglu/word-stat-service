# Word Stat Service
This service provides a REST API which enables clients
to get word statistics.
## Description
API currently supports similarity finding of a given sentence and a word.

I have spent 2 hours on coding 0.5 hours on writing README.
## Usage

* ### Using Docker
This project contains a docker file for quick deployment. Using below command
you can run the service:
```
docker-compose up
```
* ### Executing JAR File
To build the project:
```
./mvnw clean package
```
which will create the jar file under `target` directory.


You can then load the jar file using the command below. This will run the Spring Boot application.
```
java -jar target/word-stat-service-0.0.1-SNAPSHOT.jar
```
## Endpoints
There is currently single endpoint that provides similarity check between
given sentence and word.

* ### POST `/api/word-stats/similarity`
    * ##### Request Example
  ```json
  {
    "notebookEntry": "Word Word Word word",
    "word": "Word"
  }
  ```
    * ##### Response Example
  ```json
  {
    "systemTime": "2022-06-10T17:04:42.981952",
    "data": {
        "frequency": 3,
        "words": [
            "word"
        ]
    }
  }
  ```  

## Testing
Building docker automatically executes the tests.

Maven can also be used to run tests using below command:
```
./mvnw test
```

Code coverage: %100 class and %93 line
## Config
* Service by default runs on port `8080`. This can be configured by setting 
environment variable `WORD_STAT_PORT` to a different value.
## Future Development
- [ ] Add support for punctuation marks while splitting words.
- [ ] Add CORS support for frontend integration
- [ ] Add variable defined threshold support for word similarity
### Authors
Hakan Nizamoglu

