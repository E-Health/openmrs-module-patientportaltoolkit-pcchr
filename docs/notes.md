## Steps Followed

- Changing navigation in home.gsp

## Profiler data model

### hl10ProfilerMetaData

- id (PK)
- uuid
- patientid
- patientUuid
- profilerid
- profilerUuid
- startTime
- endTime
- dataType (C/R/B/DT)
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

