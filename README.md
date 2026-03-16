# LinkedIn Clone - Backend

## How to run the application locally

1. **Start the database**  
   See the next section, *How to start the database*, for full details.

2. **Start the Spring Boot application**

   In the same directory:

   ```bash
   mvn spring-boot:run
   ```

3. **Verify the application is healthy**

   With the app running, call the Actuator health endpoint:

   ```text
   GET http://localhost:8080/api/actuator/health
   ```

   You should see a JSON response like:

   ```json
   { "status": "UP", "groups": ["liveness", "readiness"] }
   ```

## How to start the database

1. From this directory (where `docker-compose.yml` is), start PostgreSQL in the background:

   ```bash
   docker compose up -d
   ```

2. Check that the container is running:

   ```bash
   docker compose ps
   ```

3. **(Optional)** Open an interactive shell and run commands on the database:

   ```bash
   docker compose exec postgres psql -U root -d linkedin_clone
   ```

   You will get a prompt like `linkedin_clone=#`. Useful commands:

   - `\dt` - list tables
   - `\d table_name` - describe a table
   - `SELECT 1;` - run a query
   - `\q` - quit

   To use the container name directly instead:

   ```bash
   docker exec -it <container_name> psql -U root -d linkedin_clone
   ```

   (Get `<container_name>` from `docker compose ps`.)
# LinkedIn Clone — Backend

## How to run the application locally

1. **Start the database**  
   See the next section, *How to start the database*, for full details.

2. **Start the Spring Boot application**

   In the same directory:

   ```bash
   mvn spring-boot:run

Verify the application is healthy

With the app running, call the Actuator health endpoint:

GET http://localhost:8080/api/actuator/health
You should see a JSON response like:


{ "status": "UP", "groups": ["liveness", "readiness"] }
