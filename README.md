# smoghistory

## db
Table sources
- id
- name
- details

table locations
- id
- lat
- lon
- country_iso
- details

table measurements
- id
- source_id
- location_id
- measurement_type (pm2.5/pm10/aqi/no2/so2)
- datetime_start
- datetime_end
- value_type (avg/point)


## backend
### services

-> GET /locations/

-> GET /sources/

-> GET /measurements/
- location
- daysBack (0 as default -> last 24hrs)
- granularity (1h/24h)

response body:
```json
{
    "location": "MARYSIN_SZARUGI",
    "granularity": "24h",
    "history": [
        {
            "dateTimeFrom": "2021-06-04T00:00:00.000Z",
            "dateTimeTo": "2021-06-05T00:00:00.000Z",
            "measurements": [
                {
                    "type": "pm2.5",
                    "value": 5
                },
                {
                    "type": "pm10",
                    "value": 3
                }
            ]
        }
    ]
}
```

## front
