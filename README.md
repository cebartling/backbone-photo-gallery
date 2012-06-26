#backbone-photo-gallery

Example application of using Grails and Backbone.js together.


## Installation
This example is dependent on having Grails 2.0.4 installed on your system.  Get the distribution from http://www.grails.org, unzip the archive, and add the following to your shell environment:

    export GRAILS_HOME=/path/to/grails-2.0.4
    export PATH=$PATH:$GRAILS_HOME/bin



## Running the example
Execute the following command from your shell environment:

    grails clean && grails package && grails run-app
    
This command will clean and package the Grails app.  The final command will run the Grails app in-place using the Grails Tomcat plugin.  Once the server is up and running, you should be able to bring up the web application at http://localhost:8080/.   


