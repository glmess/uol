## Queries validation
I followed the steps below to validate my search queries and criteria (inclusion & exclusion) validation.

I started by reviewing existing literature to have an understanding of the state of the art in the area of microservice composition. The papers reviewed including a number of systematic literature reviews which I read in full to understand their scope and any potential gap that could constitute the basis of my study. This approach is what Wholin et al (2012) recommend as part of the planning phase of a systematic literature review. For each RQ I identified one reference paper that discusses the subject matter which, I used to devise the inclusion and exclusion criteria. I then performed a snowballing by looking at papers that cited the reference paper (forward snowball) as well as the papers that were cited on it (backward snowball). In the next section, I introduce the benchmark paper and related ones from the snowballing process for each research question, as well as the inclusion and exclusion criteria. I ended up with a short list of benchmark papers which I used to test my search queries which I consider valid if the benchmark papers are retrieved when the query is run against the selected databases.

***RQ1: What are the existing approaches to microservices composition ?***

For RQ1, the reference paper that I selected is "A microservice composition approach based on the choreography of BPMN fragments by Valderas et al (2020). From applying snowballing I ended up with a list of 5 papers. I could only look examine papers cited in the reference paper in other words backward snowballing, since the paper was published in 2020 it has not been cited yet hence we could not conduct any forward snowballing.

1. Improving Entity Linking with Ontology Alignment for Semantic Microservices Composition
2. A Systematic Literature Review on Composition of Microservices through the Use of Semantic Annotations: Solutions and Techniques 
3. Hybrid composition of microservices with eucaliptool
4. Medley: An event-driven lightweight platform for service composition
5. Building orchestrated microservice systems using declarative business processes
6. Beethoven: An event-driven lightweight platform for microservice orchestration

After reading the above papers I noted a number of themes that form the basis of the inclusion and exclusion criteria for RQ1 outlined below:

**Inclusion criteria:**

1. Discuss microservice composition
2. Describe microservice composition method
3. Discuss microservice orchestration, choreography or both
4. Paper written from 2017 or later
5. Peer-reviewed
6. English language only

**Exclusion criteria:**

1. Discuss web service composition
2. Describe web service composition method
3. Non peer-reviewed
4. Language other than english

On running the query string for RQ1 ("microservice\*" OR "micro-service\*"  OR  "micro service\*" ) AND ( "composition"  OR  "choreography"  OR  "orchestration"  OR  "composability"  OR  "nest\*")
