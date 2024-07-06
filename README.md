## API Automation Testing on PestStore API
This project involves performing automation testing on PestStore APi using a Rest Assured Hydrid Framework

## Features 
- HTML Reports
- Data Driven Testing
- Logging
- Parallel Testing using TestNG

## Test Scenarios
1). User Module: 
  - Post User
  - Get User by Username
  - Update user
  - Delete User by Username
  * Data Driven Test:  
      - Post users using data from an xlsx file
      - Delete All Users

2). Pet Module:
  - Create pet
  - Get pet
  - Update pet data
  - Delete pet
  * Testing with external Json:
      - Create pet using data from an external json file
      - Delete pet created

   3). Store Module:
    - Create order
    - Get oder
    - Delete order
    * Data Driven Test:
        - Create orders using data from an xlsx file
        - Delete orders created

## Languages and  tools used
- Java
- REST Assured
- All other dependencies can be seen in the pom.xml file

## Test Execution
Run the testng.xml file
