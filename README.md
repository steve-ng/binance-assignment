
### Binance assignment

#### Build & Run
````
./gradlew build
./gradlew run
````

Visit localhost:8080 after and if you see a prompt for basic auth, the application is working as expected!

### Requirement
REST API to support a CMS system. This CMS system includes articles and for each article, there can be multiple translations being created.

Other requirements includes
- A form of authentication to protect against create, update or delete article/ translations.
- For GET request, no authentication should be required

### API(s)

Visit http://localhost:8080/swagger-ui.html on the list of API and the documentation.

In generate 2 main API endpoint

/v1/articles
- around getting a list of articles or deleting an article

/v1/article-translations
- around CRUD for an article translation
- eg. GET http://localhost:8080/v1/article-translations/block-chain-101?lang=CN will return you the CN translation for block-chain-101 title

### Setup
Database: h2 in memory database. In order to access the database


### Authentication
Simple HTTP Auth is added. For authenticated request, send API request with user/user as username and password