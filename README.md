
## API 명세

### 1. 유저(User) API

**1.1 회원가입**

| 항목           | 내용                                                                     |
| ------------ |------------------------------------------------------------------------|
| URL          | **POST** `/users/signup`                                               |
| Request Body | `email`(String, 필수) <br/>`username`(String, 필수) <br/>`password`(String, 필수) |
| Response     | `200 OK`                                                               |
| Error        | `409 Conflict`(이메일 중복), `400 Bad Request`(형식 오류)                       |

**1.2 로그인**

| 항목           | 내용                                               |
| ------------ |--------------------------------------------------|
| URL          | **POST** `/users/login`                          |
| Request Body | `email`(String, 필수) <br/> `password`(String, 필수) |
| Response     | `200 OK`                                          |
| Error        | `401 Unauthorized`(이메일/비번 불일치)                   |

**1.3 유저 조회**

| 항목            | 내용                                                             |
|---------------|----------------------------------------------------------------|
| URL           | **GET** `/users`, `/users/{id}`                                 |
| Response      | `200 OK`                                                       |
| Response Body | 유저 정보 배열 (`id`, `username`, `email`, `createdAt`, `modifiedAt` |

**1.4 유저 정보 수정**

| 항목            | 내용                                                             |
|---------------|----------------------------------------------------------------|
| URL           | **PUT** `/users/{id}`                                          |
| Request Body  |  `email`(String, 필수) <br/>`username`(String, 필수) <br/>`password`(String, 필수)                                      |
| Response      | `200 OK`                                                       |
| Response Body | 유저 정보 배열 (`id`, `username`, `email`, `createdAt`, `modifiedAt` |

**1.5 유저 삭제**

| 항목            | 내용                                                                          |
|---------------|-----------------------------------------------------------------------------|
| URL           | **DELETE** `/users/{id}`                                                    |
| Response      | `200 OK`                                                                    |


### 2. 일정(Schedule) API

**1.1 일정 생성**

| 항목            | 내용                                                    |
|---------------|-------------------------------------------------------|
| URL           | **POST** `/schedules`                                 |
| Request Body  | `title`(String) <br/>`contents`(String)               |
| Response      | `200 OK`                                              |
| Response Body | 일정 정보 배열 (`id`, `title`, `contents`, `createdAt`, `modifiedAt` |

**1.2 일정 조회**

| 항목            | 내용                                                             |
|---------------|----------------------------------------------------------------|
| URL           | **GET** `/schedules`, `/schedules/{id}`                         |
| Response      | `200 OK`                                                       |
| Response Body | 일정 정보 배열 (`id`, `title`, `contents`, `createdAt`, `modifiedAt` |

**1.3 일정 수정**

| 항목            | 내용                                                                 |
|---------------|--------------------------------------------------------------------|
| URL           | **PUT** `/schedules/{id}`                                          |
| Request Body  | `title`(String) <br/>`contents`(String) |
| Response      | `200 OK`                                                           |
| Response Body | 일정 정보 배열 (`id`, `title`, `contents`, `createdAt`, `modifiedAt`     |

**1.4 일정 삭제**

| 항목            | 내용                           |
|---------------|------------------------------|
| URL           | **DELETE** `/schedules/{id}` |
| Response      | `200 OK`                     |


