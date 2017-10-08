# Patient Controlled and Contributed Health Record
**openmrs-module-patientportaltoolkit-pcchr**

> ## Work in progress.... 

master: [![Build Status](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr.svg?branch=master)](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr)

develop: [![Build Status](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr.svg?branch=develop)](https://travis-ci.org/E-Health/openmrs-module-patientportaltoolkit-pcchr)


#### If you are looking for a completed openMRS 2.x module, please [try skinhelpdesk!](https://github.com/dermatologist/openmrs-module-skinhelpdesk)

![HL10 Framework](https://raw.github.com/E-Health/openmrs-module-patientportaltoolkit-pcchr/master/docs/hl10-github.png)
**Dundurn Castle; Hamilton, ON. Photo Credit: beapen**

## What is openMRS?

openMRS is a highly customizable EMR platform that can be extended and customized by user-contributed modules. More details here: [http://openmrs.org](http://openmrs.org)

## What is openmrs-module-patientportaltoolkit-pcchr?

This is a fork of https://github.com/maurya/openmrs-module-patientportaltoolkit 

It allows patients to login to the system and enter self-monitored healthcare data. Patients can give access to their circle of care. Clinicians can login and view their patient data just like any other EMR. 

PCCHR has a uniform data model for all health data that would allow devices such as mobile phones and sensors to feed data as well. The reference implementation has a PhoneGap application that can be used to send data. A Windows 10 App with Cortana integration for voice recognition is also planned. 

PCCHR is an open-source project and needs your help to reach our goal. Experience in OpenMRS platform, ReactJS, d3js, hGraph.js, PhoneGap or Windows Universal App programming would be useful. Even if you are not a programmer, you can help us with testing and documentation. 

[Please watch this video to see the current state of this project.](https://youtu.be/WCthqDKqea4)

## What is the motivation and what is HL10?

HL10 stands for Hamilton, a city in Ontario, Canada. HL10 is a conceptual framework for mHealth Behaviour Intervention Technology. [Read More..](http://nuchange.ca/2015/10/hl10-what-is-it.html)

This module is (would be) an example backend implementation. The mobile application (Ionic) is in the hl10App folder

This module would extend the concept of Patient-Controlled Health Record (PCHR) to **Patient-Controlled and Contributed Health Record (PCCHR)** with the simple and unique HL10 data model for Behaviour Intervention Technology. 

Expect more on [my blog ](http://nuchange.ca) and the [Prodents wiki](http://wiki.prodents.com)

## If you just want to try this module out:
- [install maven](https://maven.apache.org/install.html)
- 'Download Zip' (Right Top) and extract to a folder.
- mvn clean install  (This creates am .omod file in target folder.
- Install a stand alone version of openMRS from here.
- Install the omod module file to the openMRS instance.
- Create a new User for access to PHR.

## If you want to develop:
- install maven, git and openMRS SDK and setup a 2.x server as explained [here: https://wiki.openmrs.org/display/docs/OpenMRS+SDK](https://wiki.openmrs.org/display/docs/OpenMRS+SDK)
- git clone https://github.com/E-Health/openmrs-module-patientportaltoolkit-pcchr
	- cd module-name
	- mvn openmrs-sdk:watch  (If you are doing development)
	- mvn clean install
	- mvn openmrs-sdk:install
	- mvn openmrs-sdk:run
	- Import project to IDE as a maven project

	- Login with admin/Admin123 at http://localhost:8080/openmrs
	- Click on 'PHR Icon on homepage'

## To use/develop Ionic:
- [Install ionic](http://ionicframework.com/docs/guide/installation.html)
- cd to hl10App folder
- ionic serve

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
