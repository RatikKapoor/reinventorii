<img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/> <img alt="Spring" src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/> <img alt="MySQL" src="https://img.shields.io/badge/mysql-%2300f.svg?&style=for-the-badge&logo=mysql&logoColor=white"/> <img alt="NodeJS" src="https://img.shields.io/badge/node.js%20-%2343853D.svg?&style=for-the-badge&logo=node.js&logoColor=white"/> <img alt="TypeScript" src="https://img.shields.io/badge/typescript%20-%23007ACC.svg?&style=for-the-badge&logo=typescript&logoColor=white"/> <img alt="React" src="https://img.shields.io/badge/react%20-%2320232a.svg?&style=for-the-badge&logo=react&logoColor=%2361DAFB"/> <img alt="CSS3" src="https://img.shields.io/badge/css3%20-%231572B6.svg?&style=for-the-badge&logo=css3&logoColor=white"/> <img alt="Docker" src="https://img.shields.io/badge/docker%20-%230db7ed.svg?&style=for-the-badge&logo=docker&logoColor=white"/> <img alt="GitHub" src="https://img.shields.io/badge/github%20-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/>

# Reinventorii

This project creates a platform for employees at the University of Calgary to manage their furniture. By using this advanced Supply Chain Management software, the university will be able to prevent reusable materials from entering the landfill and thus preventing waste.

### Built With

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Ionic React](https://ionicframework.com)
- [Docker](https://www.docker.com)

## Getting Started

### Using Docker (recommended)

#### Prerequisites

Ensure that you have Docker and `docker-compose` installed on your development computer: [Docker website](https://www.docker.com). Windows computers will need to use WSL2 (Windows Subsystem for Linux) as a backend following [this guide](https://docs.docker.com/docker-for-windows/wsl/).

The platform requires a SQLServer with valid data to connect to. For temporary testing purposes we have the default server information set to our remote testing server. In order to connect the platform to your own server change the URL, Username, and Password in the `.env` file.

**MySQL Default Paramaters**
| .env paramater | default |
|----------------|---------------------------------|
| DB_URL | server.ratik.me:25565/INVENTORY |
| DB_USER | root |
| DB_PASS | eNsF409 |

#### Installation

```bash
# Clone this repo
git clone https://github.com/March-27-Hackathon/supply-chain-management-RatikKapoor.git
cd supply-chain-management-RatikKapoor

# Build a production React app and start the Java backend
./run

# *** Note: if `./run` does not work you can start the production environment using the following command ***
docker-compose up --build
```

_**NOTE:** Since this process is compiling **both** React and Java code in production mode, it may take 2-3 minutes to fully compile (depending on your computer specs). Once building is finished, browse to [http://localhost:5000](http://localhost:5000) to view the application._

To quit the development environment, simply press Ctrl+C and the Docker containers will shut down.

### Manual method (not recommended)

#### Prerequisites

The platform requires a SQLServer with valid data to connect to. For temporary testing purposes we have the default server information set to our remote testing server. In order to connect the platform to your own server change the URL, Username, and Password in the `.env` file.

**MySQL Default Paramaters**
| .env paramater | default |
|----------------|---------------------------------|
| DB_URL | server.ratik.me:25565/INVENTORY |
| DB_USER | root |
| DB_PASS | eNsF409 |

Ensure that you have the standard Node.js development tools available to use and the Yarn Package Manager installed globally as well as Java JDK 11.

- [Java 11 SDK](https://www.oracle.com/ca-en/java/technologies/javase-jdk11-downloads.html)
- [Node.js](https://nodejs.org/en/)
- [Yarn](https://yarnpkg.com)
- [Ionic CLI](https://ionicframework.com/docs/cli)
- [Node Serve](https://www.npmjs.com/package/serve)

#### Installation

To run this repository locally:

```bash
# Clone this repo
git clone https://github.com/March-27-Hackathon/supply-chain-management-RatikKapoor.git
cd supply-chain-management-RatikKapoor

# Start Maven project
./mvnw spring-boot:run

# Start the Node server (in another terminal)
cd frontend
yarn install
yarn build
serve -s build
```

## Development

The same prerequisites as the "Getting Started" section are required.

### Using Docker (recommended)

#### Development

```bash
# Clone this repo
git clone https://github.com/March-27-Hackathon/supply-chain-management-RatikKapoor.git
cd supply-chain-management-RatikKapoor

# Build a production React app and start the Java backend
./dev

# *** Note: if `./dev` does not work you can start the development environment using the following command ***
docker-compose -f docker-compose.dev.yml up --build
```

_**NOTE:** Since this process is compiling **both** React and Java code in development mode, it may take 2-3 minutes to fully compile (depending on your computer specs). Once building is finished, browse to [http://localhost:3000](http://localhost:3000) to view the application._

### Manual method (not recommended)

#### Installation

To develop on this repository locally:

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

## Contributing

Pull requests are welcome. Please use semantic commit messages and branch naming conventions using [this guide](https://www.conventionalcommits.org/en/v1.0.0/). Private branches should be named using the `semantic/name/purpose` convention. For example: `docs/ratik/update-readme` signifies that Ratik is responsible for this documentation change and the purpose of the branch is to update the README. For major changes, please open an issue first to discuss what you would like to change. Please base all pull requests off of the main branch as they will be rebase merged. Before opening a pull request: check that there are no testing issues by running `./mvnw clean test`. The linear history requirement is enforced on main.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
