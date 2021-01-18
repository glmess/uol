## Queries validation
I followed the steps below to validate my search queries and criteria (inclusion & exclusion) validation.

I started by reviewing existing literature to have an understanding of the state of the art in the area of microservice composition. The papers reviewed including a number of systematic literature reviews which I read in full to understand their scope and any potential gap that could constitute the basis of my study. This approach is what Wholin et al (2012) recommend as part of the planning phase of a systematic literature review. For each RQ I identified one reference paper that discusses the subject matter which, I used to devise the inclusion and exclusion criteria. I then performed a snowballing by looking at papers that cited the reference paper (forward snowball) as well as the papers that were cited on it (backward snowball). In the next section, I introduce the benchmark paper and related ones from the snowballing process for each research question, as well as the inclusion and exclusion criteria. I ended up with a short list of benchmark papers which I used to test my search queries which I consider valid if the benchmark papers are retrieved when the query is run against the selected databases.

***RQ1: What are the existing approaches to microservices composition ?***

For RQ1, the reference paper that I selected is "Improving entity linking with ontology alignment for Semantic microservices composition" by Salvadori et al (2017). From applying snowballing I ended up with a list of 9 papers out of which 2 papers that cite the reference paper (forward snowballing), and 7 other papers from the references (backward snowballing).

1. Improving Entity Linking with Ontology Alignment for Semantic Microservices Composition
2.  An ontology alignment framework for data-driven microservices
3. A Systematic Literature Review on Composition of Microservices through the Use of Semantic Annotations
4. Microservices: A Language-Based Approach
5. Beethoven: An Event-Driven Lightweight Platform for Microservice Orchestration
6. Building orchestrated microservice systems using declarative business processes
7. Microflows: Automated Planning and Enactment of Dynamic Workflows Comprising Semantically-Annotated Microservices
8. Microflows: Enabling agile business process modeling to orchestrate semantically-annotated microservices
9. Microservice-oriented Approach to Automation of Distributed Scientific Computations
10. Automated tools for the development of microservice compositions for hybrid scientific computations

After reading the above papers I noted a number of themes that form the basis of the inclusion and exclusion criteria for RQ1 outlined below:

**Inclusion criteria:**

1. Papers that discuss microservice composition
2. Papers that describe microservice composition method
3. Papers that discuss microservice orchestration, choreography or both
4. Papers published from 2016 or later
5. Peer-reviewed papers
6. Papers that are in English language only

After removing duplicates I was left with 1009 papers.

**Exclusion criteria:**

1. Discuss web service composition
2. Describe web service composition method
3. Non peer-reviewed
4. Language other than english

On running the query string for RQ1 *
*

I found total of 1062 papers. The breakdown by database is shown below.

- Scopus: 286 papers  
- ACM Digital Library: 296 papers  
- Science Direct: 480 papers  

By searching within the results of the queries, I was able to found everytime the 10 benchmark papers.

***RQ2 - What are the patterns, reference 
architectures and best practices for building microservices based systems?***

This research question is already tackled partially by the work of Taibi et al (2018) whom conducted a system mapping study on architectural pattterns of microservices. They focus specifically on client to microservices communication, data storage patterns as well as deployment strategies patterns. The gap that my research aim to fill here is look into pattern of microservices orchestration as well as inter-microservice communication, data exchange between microservice and some security aspects of microservice architectural patterns.

While a gap has been identified in Taibi et al (2018) study, the are similarities with RQ2 hence I have used Taibi's work as reference paper for validating my query.

The paper has been cited 81 times so through forward snowballing, I reviewed the all the 81 papers and manually checked against the inclusion and exclusion criteria outlined below:

**Inclusion criteria**

1. Papers that discuss microservice architecture
2. Papers discuss how microservices communicate and exchange data
3. Papers published from 2017 or later
4. Peer-reviewed papers
5. Papers that are in English language only

**Exclusion criteria**

1. Papers that do not discuss microservices
2. Papers that discuss microservices but do not cover the architecture 
3. Describe web service composition method
4. Non peer-reviewed papers
5. Papers in a language other than english
6. Papers published before 2017

The following query is used to search for the relevant papers:

*("microservice" OR "micro-service" OR " micro service") AND ("architecture" OR "pattern" OR "artifact" OR "building block" OR "component")*

I found 2533 papers in total. The number of papers per selected database is shown below.

Scopus: 1235   
ACM Digital Library: 628  
Science Direct: 670 

After removing duplicates it was reduced to 2296 papers.

Updated query:
*("microservice" OR "micro-service"  OR  "micro service" ) AND ( "composition"  OR  "choreography"  OR  "orchestration"  OR  "composability") AND ("framework" OR "architecture")*

*("microservice" OR "event-driven"  OR  "micro service") AND ( "composition"  OR  "choreography"  OR  "orchestration"  OR  "composability") AND ("framework" OR "architecture")*