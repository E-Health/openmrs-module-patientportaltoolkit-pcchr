## Steps Followed

- Changing navigation in home.gsp

## Profiler data model

### hl10Profiler

- id (PK)
- uuid
- patientId
- patientUuid
- profilerId
- profilerUuid
- startTime
- endTime
- dataType (C/N/B/D)
- dataName
- dataCode
- dataNs (SNOMED / ICD10)
- dataUnit
- dataUnitNs
- charData
- numData
- boolData
- dateTimeData
- segmentName
- segmentCode
- segmentNs (SNOMED / ICD10)
- index 0 (If 0 no further, -1 last packet, All others in sequence)
- prevUuid
- status (PROCESSED, PENDING, etc)

## Resources
https://github.com/openmrs/openmrs-module-reporting/blob/master/api/src/main/resources/liquibase.xml (Good compilation of liquibase commands)