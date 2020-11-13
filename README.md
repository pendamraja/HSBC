# 
Currency exchange rate.
When we are hit this url http://localhost:8080/latest/ from postman, this service retrive currency rates form external API. this API url is configure in application.properties. the data is stored in In Memory. localhost:8080/Inmemory/2020-11-12 ,when we hit another url with date. the data is displayed as json in postman screen.
Used JPA repository with In memory. 
