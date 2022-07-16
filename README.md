# Movies API

![Publish Docker Image](https://github.com/eneskacan/movies-api/actions/workflows/publish-docker-image.yml/badge.svg)

Movies API is a simple web service for receiving movie details and saving that information locally. To run the app, it is required to generate a [CollectAPI](https://collectapi.com/api/imdb/imdb-api) access token.

## Docker

The easiest way to run this application is via Docker. To install Docker, see [here](https://docs.docker.com/). Once you have Docker installed and [working](https://docs.docker.com/get-started/#test-docker-installation), you can easily pull and start the Docker image.

```bash
  docker run -e collect.api.token="apikey <your-token-here>" -p 8080:8080 eneskacan/movies-api
```

## Installation

Clone the project

```bash
  git clone https://github.com/eneskacan/movies-api.git
```

Update access token in the [application.properties](src/main/resources/application.properties) file

```bash
  collect.api.token=apikey <your-token-here>
```

Go to the project directory

```bash
  cd movies-api
```

Install and start

```bash
  mvn spring-boot:run
```

## API Reference

#### Search movies

```http
GET /api/movies?name=${movie_name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `movie_name` | `string` | **Required**. Movie name |

#### Get movie

```http
GET /api/movies/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of the movie |

#### Save movie

```http
POST /api/movies/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of the movie |

## Acknowledgements

- [Spring Initializr](https://start.spring.io/)
- [White House Web API Standards](https://github.com/WhiteHouse/api-standards)
- [Exception Handling for REST API](https://medium.com/@sampathsl/exception-handling-for-rest-api-with-spring-boot-c5d5ba928f5b)
- [Patika.dev](https://www.patika.dev/tr)
