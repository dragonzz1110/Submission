# NASA APOD Explorer – Backend (Quarkus)

This is the backend service for **NASA APOD Explorer**, built with **Quarkus + Java 17**.

It exposes a REST API that your Node/React frontend can consume.

## Requirements

- Java 17+
- Maven 3.9+
- NASA API Key from https://api.nasa.gov/

## Setup

```bash
export NASA_API_KEY=YOUR_REAL_KEY   # Linux / macOS
# or on Windows:
# setx NASA_API_KEY "YOUR_REAL_KEY"
```

## Run in dev mode

```bash
mvn quarkus:dev
```

Service will run at: `http://localhost:8080`

## REST Endpoints

- `GET /api/apod/today`  
  Returns today's Astronomy Picture of the Day.

- `GET /api/apod/date/{yyyy-MM-dd}`  
  Returns APOD for the specified date.

## OpenAPI / Swagger UI

- OpenAPI spec: `http://localhost:8080/openapi`
- Swagger UI: `http://localhost:8080/swagger`

## Caching

- Caching is implemented using **Quarkus Cache (Caffeine)**.
- Cache name: `apod-cache`
- Configured in `application.properties`:
  - Expire after write: `1H`
  - Maximum size: `100`

## Build JAR

```bash
mvn package
```

JAR will be under `target/`.

## Docker

Build image:

```bash
docker build -t apod-backend .
```

Run:

```bash
docker run -p 8080:8080   -e NASA_API_KEY=YOUR_REAL_KEY   apod-backend
```

Then hit:

- `http://localhost:8080/api/apod/today`
- `http://localhost:8080/api/apod/date/2024-01-01`
