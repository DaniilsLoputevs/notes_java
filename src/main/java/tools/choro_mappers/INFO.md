https://www.tablesgenerator.com/markdown_tables#

| Class          | Units of measurement       | Belong to TZ  | ToString - TZ | Is store TZ info? |
|----------------|----------------------------|---------------|---------------|-------------------|
| LocaleDateTime | LocalDate + LocalTime      | System        | System        | NO                |
| LocaleDate     | year, month, day           | System        | System        | NO                |
| LocaleTime     | hour, minute, second, nano | System        | System        | NO                |
| Instant        | second + nano              | UTC/GMT/ZULUS | UTC           | NO                |
| Calendar       | mills                      | UTC/GMT/ZULUS | ---           | NO                |
| Date           | mills                      | UTC/GMT/ZULUS | System        | NO                |