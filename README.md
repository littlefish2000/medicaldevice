# medicaldevice
#To run the application
   1. clone the github repo with git clone https://github.com/littlefish2000/medicaldevice.git
   2. cd medicaldevice
   3. download ojdbc.jar from oracle web site http://www.oracle.com/technetwork/apps-tech/jdbc-112010-090769.html or http://download.oracle.com/otn/utilities_drivers/jdbc/11204/ojdbc6.jar
   4. use maven install oracle jdbc driver with the following command:       mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar 
   5. mvn clean package tomcat7:run will run the application with tomcat7 
   6. At internet explore open http://localhost:8080/MedicalDevice/
   
#Configuration
