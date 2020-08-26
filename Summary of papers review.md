#Summary of papers review 
This document summarizes my findings following the review of selected studies that discuss on microservices composition or microservices patterns. The aim of this review is to i) have a solid understanding of the field related to my research namely microservice composition ii) come up with research questions that are relevant to the my research.

## Papers selection process

The papers in scope were retrieved by running the following query on ScienceDirect database: 

*"microservice composition" OR "microservice pattern"*

The queries returned 14 results. I then reviewed the abstracts of each the the 14 papers and excluded the ones that did not contain the target keywords in abstract as well as the ones that focus on composition nor patterns of microservices. From this exercise I identify 3 relevant papers and 3 more that were cited in those papers.

##Findings
P. Valderas et al. (2020) discuss a microservice composition approach which is based on the choreography of Business Process Model and Notation (BPMN) fragments. The BPMN is an Object Management Group (OMG) standard which allows for a graphical representation (modeling) of business processes. The researchers discuss a new approach to composing microservices based on an event-based choreography of BPMN fragments. This is a three-steps process:

1. Creation of the BPMN model which describes the big picture of the composition process
2. Split the model into BPMN fragments which are subsequently distributed among microservices
3. Execution of the BPMN fragments through an event-based choreography.

This approach aims to providing developers with a solution that allows having a centralized model which describes the big picture of a microservice composition while having at the same time the possibility to execute the composition defined in this model by way of event-based choreography

This approach has the advantage that it combines an orchestration-based solution which is usually considered BPMN as remark P. Valderas et al. (2020) and the choreography solution which helps achive the decoupling and independence promise of microservice architecture. 

P. Valderas et al. (2020) approach supports microservice choreographies that use pub/sub mechanisms to establish collaboration. A microservice is triggered by an event to accomplish its task and once complete, an event is produced, which triggers other microservices waiting for this event to execute their tasks. 

![alt text](ms-event-based-com.png)
		Fig.1 Event-based communication among microservices in BPMN 2.

They illustrate their approach using an an example of an ecommerce scenario that describes an order processing in an online store. This process is supported by four microservices: Customers, Payment, Inventory, and Shipment. The sequence of steps that these microservices must perform when a customer places an order in the online shop is as follows:

1. Customers microservice checks the customer data and registers the request. If the customer data is not valid then the customer is informed and the process of the order is cancelled. On the contrary, if customer data is valid the control flow is transferred to the Inventory microservice.
2. The Inventory microservice checks the availability of the ordered items. If there is not enough stock to satisfy the order, the process of the order is cancelled and the customer is informed. On the contrary, the items are booked and the control flow of the process is transferred to the Payment microservice.
3. The Payment microservice provides the customer with different alternatives to proceed with the payment of the order as well as to change payment details. Next, the microservice processes the payment.

Depending on the result of the payment two different sequences of steps are performed.

If the payment fails:

- The Inventory microservices releases the booked items and the process of the order is cancelled.

If the payment is successful, the following three steps are performed:

- The Inventory microservices update the stock of the purchased items and the control flow is transferred to the Shipping microservice.

- The Shipping microservice creates a shipment order and assign it to a driver and the control flow is transferred to the Customer microservice.

- The Customer microservice updates the customer record and informs the customer about the finalization of the process.

![alt text](ms-comp-order-proc.png)
		Fig.2 Microservice composition for the place order process example

Once the BPMN fragments of a microservice composition have been obtained, each of them must be deployed into the microservice that is responsible for executing it. An event-based choreography of BPMN fragments can be achieved as it is illustrated in Fig. 3. below, each microservice is in charge of executing its corresponding process fragment and informing the others about it.  Once the client places an order in the online store, the client application triggers the event “Process Purchase Order”. The Customers microservice, which is listening to this event (defined through the start event of its pool), reacts executing part of its associated BPMN fragment and pauses its execution to trigger the event “Customer Checked” (see the message intermediate through event). Then, the Inventory microservice, which is listening to this event, executes its BPMN fragment and generates the event that makes the next microservice in the composition to execute the next process fragment. And so on. When the Shipment microservice generates the event “Shipment Managed”, the Customer microservice resumes its tasks and finishes the composition by triggering the event “Order Processed”.

![alt text](choreography-bpmn-fragments.png)
		Fig.3 Event-based Microservice Choreography of BPMN fragments

## References
1. Pedro Valderas, Victoria Torres, Vicente Pelechano,
A microservice composition approach based on the choreography of BPMN fragments, Information and Software Technology, Volume 127, 2020


