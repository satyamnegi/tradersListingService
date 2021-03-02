## SELLICS SEARCH SCORE SOLUTION

### Project Requirements

* JDK 1.8.

* Spring-boot 2.4.3.RELEASE.

* Maven

* Postgresql

* Spring security

* HEROKU cloud


Project is structured and grouped in a standard format.

#### Algorithm:

* Our maain motive here is to list the trade listings and play around them by allowing traders to create, update, get and delete trade listings.

* After lot of research, I came to conclusion that we have to use Spring boot as a backend and postgresql as a database.

* Since it is a backend application, for the easy usablitiy I have implemented Swagger UI with this.

* I have integrated https://www.currencyconverterapi.com/ for getting the item listing API which will give currency converted to GBP.

* each operation is handled seperately and data is controlled over database.

#### How to run the application:

* Application is already hosted at HEROKU cloud so you can directly access the same using below steps.

* Swagger is implemented for a better testing of application instead of command line.

* Please click on https://tradeListingsService.herokuapp.com/swagger-ui.html

* Use the username and password are both same i.e. admin

* After that click on trade-controller and you will be able to see all the API's.

* Just use the request provided to perform operations like create, update, get and delete trade listings.

* You may also clone the application in your local system and change the datasource parameters in property file to use any other database of your choice.

#### Assumptions Take:

* Firstly, I have done the assumptions that what all I can build ready-made so anyone can directly access my application without bearing a setu pain.

* Next, I found that why not just deploy the application over my personal cloud space and make it public, with this thought I did lot of research over cloud-integration.

* Then, I noticed that I have database part too which can complicate the things for which I have tried to use postgres client in cloud itself.

* Finally, I got my application up and running with all the things handy for the user's who just wanted to use this rather than doing setup at first phase.

