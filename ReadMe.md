Endpoints: 


ping :
``````
curl -X GET \
http://localhost:8080/orders/api/v1/ping \
-H 'cache-control: no-cache' 
``````

add order
``````````
curl -X POST \
  http://localhost:8080/orders/api/v1/1/addorder \
  -H 'accept: application/json' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{"customerId":1,"productId":2,"quantity":3}'
``````````


get orders 

````````
curl -X GET \
  http://localhost:8080/orders/api/v1/1/getorders \
  -H 'cache-control: no-cache' 
````````



Task
Implement two REST API endpoints in the context of order management for the following tasks:
Add new order for a customer
Retrieve all orders by customer id

Description
To simplify the data structure, you can assume that an order contains only one product. 
The orders and any additional data need to be stored in a database. 
You can mock the database with a simple cache and store the data in memory. 
Also, you will need to put some sample products into the cache, 
which can be added to the orders. Each product has the fields:
id
title
price


Add order endpoint

Body Parameters:
order:
product id
quantity


Retrieve orders endpoint
Path Parameters:
customer id


Result (JSON body):
Array of following objects:
order:
id
product id
product title
price
quantity


Desired techonologies:
Java EE 8 (JAX-RS for Rest API, CDI for dependency injection)
Annotation driven configuration (e. g. @Inject for CDI)
To run the app, you need an application server, e. g. https://www.wildfly.org/
JDK > 1.8
Maven-3.5+
Git repository to store the project
Submission
You can send me a download link of the Git repository as a ZIP file or a link to Gihub, if you rather want to upload the repository to Github.


Good Luck!
