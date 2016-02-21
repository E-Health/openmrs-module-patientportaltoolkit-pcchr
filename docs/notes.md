## Steps Followed

- Changing navigation in home.gsp

## To do
- Create liquibase.xml
- Create Pcchr.hbm.xml
- Create Pcchr.java POJO

## Resources
https://github.com/openmrs/openmrs-module-reporting/blob/master/api/src/main/resources/liquibase.xml (Good compilation of liquibase commands)

## Code Snippets
public enum Gender {
    C, N, B, D
}

## Webservices Rest to be added to require modules in config.xml
```
		<require_module>
			org.openmrs.module.webservices.rest
		</require_module>
```