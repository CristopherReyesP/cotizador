# cotizador

Spring Boot REST API that calculates shipping quotes from a package's weight, dimensions, region and customer type, using rates stored in SQL Server.

## Overview

This repository is the backend of a small three-part shipping quote system:

| Repository | Role |
|------------|------|
| [cotizador](https://github.com/CristopherReyesP/cotizador) (this repo) | Java / Spring Boot REST API |
| [BDCotizador](https://github.com/CristopherReyesP/BDCotizador) | SQL Server schema (`script.sql`), ER diagram and reference data |
| [CotizadorFront](https://github.com/CristopherReyesP/CotizadorFront) | Angular 17 UI with the quote form and result view |

The API reads countries, regions, rates per region and discounts per customer type from the database, and returns the three parts of a quote: base amount, dimension surcharge and discount.

## Architecture

```
src/main/java/com/cotizador/
├── CotizadorApplication.java   Spring Boot entry point
├── web/controller/             REST controllers: PaisController, TipoClienteController, TarifaController
├── Service/TarifaService.java  Quote calculation
└── persistence/
    ├── *Repository.java        Repository classes used by controllers and the service
    ├── crud/                   Spring Data CrudRepository interfaces
    └── entity/                 JPA entities (Pais, Region, Tarifa, Cliente, Descuento) and request/response classes (Paquete, TarifaResponse)
src/main/resources/
├── application.properties      Active profile, context path, Swagger UI path
├── application-dev.properties  Port 8090 and the SQL Server connection
└── application-pdn.properties  Port 80
```

**Quote request flow**

1. `POST /cotizador/api/tarifa/calcularTarifa` receives a `Paquete` JSON body.
2. `TarifaController` passes it to `TarifaService`.
3. The service loads the region's rate (`TarifaCrudRepository.findByRegion_RegionID`) and the customer type's discount (`DescuentoCrudRepository.findByCliente_TipoClienteID`).
4. It computes the quote and returns a `TarifaResponse`:

| Field | Formula in `TarifaService` |
|-------|----------------------------|
| `monto` | weight × region rate (`Tarifa.Precio`) |
| `adicionales` | 1.66 × height × length × width |
| `descuento` | discount percentage (`Descuento.Porcentaje`) × 0.5 × weight |

The API returns the three values separately; it does not compute a total.

### Endpoints

Base path: `/cotizador/api`

| Method | Path | Description |
|--------|------|-------------|
| GET | `/pais/obtener` | All countries, each with its region |
| GET | `/cliente/obtener` | All customer types |
| POST | `/tarifa/calcularTarifa` | Calculates a quote for a package |
| GET | `/tarifa/paquete` | Returns a hard-coded sample `Paquete` payload |

Example request body (the same values `/tarifa/paquete` returns):

```json
{ "peso": 10, "ancho": 3, "alto": 2.5, "largo": 2, "tipocliente": 2, "region": 1 }
```

## Tech Stack

- Java 17
- Spring Boot 3.1.5 (Spring Web, Spring Data JPA)
- Microsoft SQL Server through the `mssql-jdbc` driver (Hibernate `SQLServer2012Dialect`)
- springdoc-openapi 2.1.0 (Swagger UI)
- Gradle 8.4 (wrapper)
- JUnit 5 through `spring-boot-starter-test`

## Key Technical Decisions

- **Layered packages.** Controllers call the service or repository classes, which wrap Spring Data `CrudRepository` interfaces. The quote logic lives only in `TarifaService`.
- **Derived queries instead of SQL.** Lookups across relations use Spring Data method names (`findByRegion_RegionID`, `findByCliente_TipoClienteID`); the project has no hand-written queries.
- **Column names kept as-is.** `PhysicalNamingStrategyStandardImpl` maps entity fields directly to the PascalCase column names of the BDCotizador schema (for example `Precio`, `TipoClienteID`).
- **Region ID in the request.** A quote request carries a region ID, not a country. `/pais/obtener` returns every country with its region, so a client can resolve one from the other.
- **Spring profiles.** `dev` is active by default (port 8090, local SQL Server). `pdn` only overrides the port to 80.

## Running Locally

Requirements: JDK 17 and a SQL Server instance on `localhost:1433`.

1. Create a database named `Cotizador` and run `script.sql` from [BDCotizador](https://github.com/CristopherReyesP/BDCotizador). Load its reference data too: the quote endpoint needs a rate for the requested region and a discount for the customer type.
2. Set the SQL Server username and password in `src/main/resources/application-dev.properties`. The application reads no environment variables of its own.
3. Start the API:

```bash
chmod +x gradlew    # the wrapper is committed without the executable bit
./gradlew bootRun
```

The API listens on `http://localhost:8090/cotizador/api`, and Swagger UI is at `http://localhost:8090/cotizador/api/swagger-ui.html`.

Build a jar with `./gradlew build` (output in `build/libs/`).

## Testing

The only test is the default Spring Boot `contextLoads` test in `CotizadorApplicationTests`. There are no tests for the quote calculation.

```bash
./gradlew test
```

## Project Status

Learning project built in November 2023. The Angular frontend in CotizadorFront is a static prototype that does not call this API yet, and the API has no CORS configuration for it.
