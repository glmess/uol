## Research context

Microservices are an architecture style for building applications that has grown in popularity as many organizations are moving away from the tradional approach of building, deploying and maintaining applications as a single entity also known as monolithic applications. This perhaps explains why the amount of research on microservices has also increased in the past four to five years. With the amount of knowledge such research has and is continuing to generate, it opens up opportunities for researchers to conduct systematic litterature surveys with the aim to finding answers to questions that stemmed from current knowledge gap on microservices paradigm. One such gap that exists is the lack of a taxonomy for designing and building microservices-based applications in order to fufill a set of given end-users requirements. 

This research aims to producing such taxonomy. To do so will require answering a number research questions outlined in the next section.


## Research questions

This study will attempt to answer the following research questions.

**RQ1**: What are the existing processes, tools, techniques and frameworks that are used to design microservices?

**RQ2**: What are the approaches for building microservice-based applications and what are their advantages and disadvantages?

**RQ3**: What are the best practices and patterns for building microservices-based applications.

**RQ4**: What are the existing approaches to microservices composition and what are their advantages and limitations? 

The table below outlines the RQs and the motivation for seeking answer to each in respect to the study.

| Research Question                                                                                                     | Motivation                                                                                                                                                                                                                                                              |
|-----------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| What are the existing processes, tools, techniques and frameworks that are used to design microservices?              | The aim is understand how microservices are built and what is required to build them.                                                                                                                                                                                   |
| What are the approaches for building microservice-based applications and what are their advantages and disadvantages? | The aim is to understand how applications are built using microservices, as well as the complexities involved in their design process including their pros and cons                                                                                                     |
| What are the best practices and patterns for building microservices-based applications?                               | The aim is to understand what are the properties that microservices-based applications shared in common and how they differ from one another. Also what are the recommended best practices to follow when building applications using microservices as building blocks. |
| What are the existing approaches to microservices composition and what are their advantages and limitations?          | The aim is to investigate current methods for composing microservices into applications and what are the advantages and limitations of thes methods.                                                                                                                    |

The research questions are defined in such a way that there is clear relationship between them a logical flow with the answer to each research question setting us well for answering the next one and a step forward towards the end product of the overall research. 

## Significance of the research

The goal of this study is to add to the body of research knowledge on microservices. One specific area where this research could make a difference is by producing a taxonomy that will serve as guidance to practitioners as they look for fast, simple and cost-effective way of adopting microservices. Likewise, the end product of this research should help researchers in the field of software engineering who may want use microservices as part of their research experiments. 

Another reason why this research is important is the opportunity for it to contribute towards my PhD research which aims to propose a novel approach to building applications by way of automated composition of microservices. The output of the literature survey will serve as building block for constructing the new approach to microservice composition. 

## Research approach

I will conduct a qualitative research by looking into existing literature on microservices and try to uncover facts that will help answer the set research questions. I will follow the guidelines of systematic literature survey for retrieving and selecting papers of interest from the most popular databases such as Scopus,Google scholar, Science Direct and SpringerLink. 

The retrieval process will be done by clearly defined queries oulined in the next section, while the selection process will be done on the basis of defined inclusion and exclusion criteria, details of which can be found in the corresponding section below. 

The goal of this exercise will be to end up with a refined list of papers that are most relevant to my research upon applying the inclusion and exclusion criteria. I will then take that list read the papers and do some coding of the key concepts, theories or patterns, that will help answer my research questions. I will then report the results and discuss my findings. 

## Keywords and search strings

I intend to use the following search keywords to form my search queries:

**Keywords & Synonymous**

| Keywords                  | Synonymous Terms                                                      |
|---------------------------|-----------------------------------------------------------------------|
| Microservice              | container, loosely coupled app, self-contained app, containerized app |
| Microservice composition  | application composition, microservice automation                      |
| Microservice architecture | microservice structure                                                |
| Microservice choreography | microservice assembly                                                 |
| Microservice pattern      | microservices properties                                              |

**Query strings**

- ("microservice AND composition") OR 
- ("microservice AND pattern") OR 
- ("microservice AND architecture") OR 
- ("microservice AND orchestration") OR 
- ("microservice AND choreography") OR 
- ("microservice AND automation") OR 
- ("microservice AND discovery") OR 
- ("microservice AND deployment")

The below query was generated from Scopus Database:

*TITLE-ABS-KEY ( "microservice composition"  OR  "microservice pattern"  OR  "microservice architecture"  OR  "microservice orchestration"  OR  "microservice choreography"  OR  "microservice automation"  OR  "microservice discovery"  OR  "microservice deployment" )  AND  LANGUAGE ( english )  AND  SUBJAREA ( comp )  AND  ( LIMIT-TO ( PUBYEAR ,  2020 )  OR  LIMIT-TO ( PUBYEAR ,  2019 )  OR  LIMIT-TO ( PUBYEAR ,  2018 )  OR  LIMIT-TO ( PUBYEAR ,  2017 ) )  AND  ( LIMIT-TO ( SUBJAREA ,  "COMP" ) )  AND  ( LIMIT-TO ( LANGUAGE ,  "English" ) )  AND  ( LIMIT-TO ( SRCTYPE ,  "j" ) )*  


The below query was generated from Scopus Database:
	
*(TI=( "microservice composition" OR "microservice pattern" OR "microservice architecture" OR "microservice orchestration" OR "microservice choreography" OR "microservice automation" OR "microservice discovery" OR "microservice deployment" )  OR  AB=(  "microservice  composition"  OR  "microservice  pattern"  OR  "microservice  architecture"  OR  "microservice  orchestration"  OR  "microservice  choreography"  OR  "microservice  automation"  OR  "microservice  discovery"  OR  "microservice  deployment"  ))   
AND 
LANGUAGE:
  (English)  AND  DOCUMENT 
TYPES:
  (Article) 
Indexes=SCI-EXPANDED, SSCI, A&HCI, CPCI-S, CPCI-SSH, ESCI Timespan=2017-2020*

## Inclusion & exclusion criteria

**Inclusion criteria**

- Date of publication: 2017 or later
- Subject area: Computer Science & Engineering
- Source type: Conference Proceeding & Journal
- Category: Peer-reviewed
- Language: English
- Paper with the search keywords in the title or the abstract
- Studies that discuss microservices patterns
- Studies that discuss use cases or applications that use microservices architectures
- Studies discuss the tools, processes and techniques for designing and building microservices

**Exclusion criteria**

- Any paper published before 2017
- Not peer-reviewed
- Non english language
- Paper that does not contain keywords in the title nor in the abstract
- Studies that cover web services composition
- Studies related to cloud computing or containers but do not feature microservices architecture, patterns, design or deployment
- Anything that does not satisfy the above inclusion criteria implies exclusion
