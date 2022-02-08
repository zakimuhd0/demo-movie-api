## About The Project
Movie api using MySQL as database

## Built With
* [Spring Boot](https://spring.io/)
* [MySQL](https://www.mysql.com/)

## API Documentation
### Tv
1. /tv
    <details>
      <summary>output</summary>

      ```
      {
        "data": [
          {
            "id": 1,
            "title": "Title 1",
            "poster_path": "https://dummyimage.com/600x900/000/fff.jpg&text=1",
            "tv_genre_ids": [
              {
                "id": 2,
                "name": "Genre 2"
              }
            ],
            "tv_country_ids": [
              {
                "id": 1,
                "name": "Country 1"
              }
            ]
          },
          ...
          ..
          .
        ],
        "total_pages": 5,
        "total_items": 49,
        "current_page": 1
      }
      ```
    </details>
    
2. /tv/{id}
    <details>
      <summary>output</summary>

      ```
      {
        "id": 1,
        "title": "Title 1",
        "overview": "Overview 1",
        "first_air_date": "11/11/2011",
        "last_air_date": "12/12/2012",
        "poster_path": "https://dummyimage.com/600x900/000/fff.jpg&text=1",
        "backdrop_path": "https://dummyimage.com/1920x1080/000/fff.jpg&text=1",
        "tv_genre_ids": [
          {
            "id": 2,
            "name": "Genre 2"
          }
        ],
        "tv_country_ids": [
          {
            "id": 1,
            "name": "Country 1"
          }
        ],
        "season": []
      }
      ```
    </details>

### Movie
1. /movie
    <details>
      <summary>output</summary>

      ```
      {
        "data": [
          {
            "id": 1,
            "title": "Title 1",
            "poster_path": "https://dummyimage.com/600x900/000/fff.jpg&text=1",
            "movie_genre_ids": [
              {
                "id": 2,
                "name": "Genre 2"
              }
            ],
            "movie_country_ids": [
              {
                "id": 2,
                "name": "Country 2"
              }
            ]
          },
          ...
          ..
          .
        ],
        "total_pages": 5,
        "total_items": 49,
        "current_page": 1
      }
      ```
    </details>
    
2. /movie/{id}
    <details>
      <summary>output</summary>

      ```
      {
        "id": 1,
        "title": "Title 1",
        "overview": "Overview 1",
        "release_date": "11/11/2011",
        "poster_path": "https://dummyimage.com/600x900/000/fff.jpg&text=1",
        "backdrop_path": "https://dummyimage.com/1920x1080/000/fff.jpg&text=1",
        "movie_genre_ids": [
          {
            "id": 2,
            "name": "Genre 2"
          }
        ],
        "movie_country_ids": [
          {
            "id": 2,
            "name": "Country 2"
          }
        ]
      }
      ```
    </details>
    
## Contact
Muhammad Zaki - [https://www.facebook.com/znphc/](https://www.facebook.com/znphc/)
