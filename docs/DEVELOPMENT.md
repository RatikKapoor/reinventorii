## Development

The same prerequisites as the "Getting Started" section are required.

### Using Docker (recommended)

#### Setup

```bash
# Clone this repo
git clone https://github.com/March-27-Hackathon/supply-chain-management-RatikKapoor.git
cd supply-chain-management-RatikKapoor

# Build a production React app and start the Java backend
./dev

# *** Note: if `./dev` does not work you can start the development environment using the following command ***
docker-compose -f docker-compose.dev.yml up --build --force-recreate
```

_**NOTE:** Since this process is compiling **both** React and Java code in development mode, it may take 2-3 minutes to fully compile (depending on your computer specs). Once building is finished, browse to [http://localhost:3000](http://localhost:3000) to view the application._

### Manual method (not recommended)

#### Installation

To develop on this repository locally:

A MySQL server must also be running on your machine or remotely. To set up the database run the `inventory.sql` file located in the `db` folder. Enter the appropriate login credentials into the `.env` folder.

```bash
# Clone this repo
git clone https://github.com/March-27-Hackathon/supply-chain-management-RatikKapoor.git
cd supply-chain-management-RatikKapoor

# Start Maven project
./mvnw spring-boot:run

# Start the Node server (in another terminal)
cd frontend
yarn install
ionic serve
```
