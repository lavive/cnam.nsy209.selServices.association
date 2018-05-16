# cnam.nsy209.selServices.association
CNAM NSY209 project 2018 - frontend side for SEL associations

## Installation
### Pre-requisites
* Before install [cnam.nsy209.selServices.restService](https://github.com/lavive/cnam.nsy209.selServices.restService)
* Web Server installed like [Tomcat](http://tomcat.apache.org/)
* [Java 8 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) installed
* [Eclipse Oxygen](http://www.eclipse.org/downloads/eclipse-packages/) for JavaEE developper or more installed
* Maven pluggin installed
* GWT pluggin installed:
    * 'Help' -> 'Market place'
    * select 'GWT'
    * follow instructions
* Clone this project
### Process
* import this project in Eclipse
* Go to 'RetrofitBuilder' file in package *cnam.nsy209.selServices.association.server.webService*
* Change **BASE_URL** into machine address where **cnam.nsy209.selServices.restServie** will be installed 
* Go to 'run Configurations' -> right click on 'Maven Build' -> 'new'
* At the 'Main' tab fill 'Goals' as **verify**
* Click on 'run'
* A '.war' file has been generated
* You can find it in the Eclipse Workspace folder, go to project folder -> 'target'
* Start the web server and install the 'war' on it
* open your favorite browser and type the web app addess

