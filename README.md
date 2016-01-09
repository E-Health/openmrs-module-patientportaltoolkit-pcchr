# openmrs-module-patientportaltoolkit-pcchr

> ## Work in progress.... 

master: [![Build Status](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr.svg?branch=master)](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr)

develop: [![Build Status](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr.svg?branch=develop)](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr)



#### If you are looking for a completed openMRS 2.x module, please [try skinhelpdesk!](https://github.com/dermatologist/openmrs-module-skinhelpdesk)

![HL10 Framework](https://raw.github.com/E-Health/openmrs-module-patientportaltoolkit-pcchr/master/docs/hl10-github.png)
**Dundurn Castle; Hamilton, ON. Photo Credit: beapen**

## What is openMRS?

openMRS is a highly customizable EMR platform that can be extended and customized by user-contributed modules. More details here: [http://openmrs.org](http://openmrs.org)

## What is openmrs-module-patientportaltoolkit-pcchr?

This is a fork of https://github.com/maurya/openmrs-module-patientportaltoolkit that combines openmrs-module-personalhr/phrjournal/messagingphr and lancearmstrong

## What is the motivation and what is HL10?

HL10 stands for Hamilton, a city in Ontario, Canada. HL10 is a conceptual framework for mHealth Behaviour Intervention Technology. [Read More..](http://nuchange.ca/2015/10/hl10-what-is-it.html)
This module is (would be) an example backend implementation.

## What are the wider implications?

This module would extend the concept of Patient-Controlled Health Record (PCHR) to **Patient-Controlled and Contributed Health Record (PCCHR)** with the simple and unique HL10 data model for Behaviour Intervention Technology. 
Expect more on [my blog ](http://nuchange.ca) and the [Prodents wiki](http://wiki.prodents.com)

## How do I test this module / setup a development environment?
- Install git and git clone https://github.com/E-Health/openmrs-module-patientportaltoolkit-pcchr
- Follow [the steps outlined in this wiki: https://wiki.openmrs.org/display/docs/OpenMRS+SDK](https://wiki.openmrs.org/display/docs/OpenMRS+SDK)
	- Install mvn & openMRS SDK (Steps 1 & 2)
	- Install MySQL (Not mentioned in the wiki page)
	- Create OpenMRS Reference Application 2.x server
	- cd module-name
	- mvn openmrs-sdk:watch  (If you are doing development)
	- mvn clean install
	- mvn openmrs-sdk:install
	- mvn openmrs-sdk:run
	- Import project to IDE as a maven project

	- Login with admin/Admin123 at http://localhost:8080/openmrs
	- Click on 'PHR Icon on homepage'


## How do I learn more and Contribute

Learn more about this (and several other) initiatives on [PRO{DENTS} Group.](http://prodents.com)
Feel free to adopt a [GitFlow workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) by joining the [E-Health org on Github](https://github.com/E-Health) OR the usual [forking workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/forking-workflow)
Pull-requests welcome and highly appreciated.
  
## Contributors (Retaining this segment in forks will be appreciated.)

- [B Eapen](http://nuchange.ca) - [Contact Me](http://nuchange.ca/contact)
- [maurya - Original repo](https://github.com/maurya)
- You :)

## Credits

- [mHealthDroid](http://link.springer.com/chapter/10.1007%2F978-3-319-13105-4_14) [Repo](https://github.com/mHealthTechnologies/mHealthDroid)
- [Apple HealthKit](https://developer.apple.com/healthkit/)