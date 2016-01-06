## Steps Followed

- Changing navigation in home.gsp

## Profiler data model

### hl10ProfilerMetaData

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
- status (PROCESSED, PENDING, etc)

### hl10ProfilerData

- id (PK)
- uuid
- metaDataid (FK)
- charData
- numData
- boolData
- dateTimeData
- dataSegmentName
- dataSegmentCode
- dataSegmentNs (SNOMED / ICD10)

## Resources
https://github.com/openmrs/openmrs-module-reporting/blob/master/api/src/main/resources/liquibase.xml (Good compilation of liquibase commands)