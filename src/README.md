#  Schedule &  Comment REST API

Spring Boot 기반의 일정 & 댓글 관리 API입니다.  
일정을 등록하고, 각 일정에 댓글과 대댓글을 작성/수정/삭제할 수 있으며, **일정과 댓글은 소프트 딜리트** 방식으로 안전하게 관리됩니다.

---

##  주요 기능

###  Schedule - 일정

| 기능 | 메서드 | 엔드포인트 |
|------|--------|------------|
|  전체 일정 조회 | `GET` | `/schedules` |
|  단일 일정 조회 | `GET` | `/schedules/{id}` |
|  일정 생성 | `POST` | `/schedules` |
|  일정 수정 | `PUT` | `/schedules/{id}` |
|  일정 삭제 (소프트 딜리트) | `DELETE` | `/schedules/{id}` |

---

###  Comment - 댓글 / 대댓글

| 기능               | 메서드 | 엔드포인트 |
|------------------|--------|------------|
| 댓글 전체 조회 (일정 기준) | `GET` | `/schedules/{scheduleId}/comments` |
| 댓글 단건 조회 | `GET` | `/comments/{commentId}` |
| 댓글 작성            | `POST` | `/schedules/{scheduleId}/comments` |
| 대댓글 작성 (1개만 가능)  | `POST` | `/schedules/{scheduleId}/comments/{parentCommentId}/replies` |
| 댓글 수정            | `PUT` | `/comments/{commentId}` |
| 댓글 삭제 (소프트 딜리트)  | `DELETE` | `/comments/{commentId}` |

---

##  요청 예시
![캡처.PNG](../image/%EC%BA%A1%EC%B2%98.PNG)
![캡처2.PNG](../image/%EC%BA%A1%EC%B2%982.PNG)
![캡처3.PNG](../image/%EC%BA%A1%EC%B2%983.PNG)
![캡처4.PNG](../image/%EC%BA%A1%EC%B2%984.PNG)
![캡처5.PNG](../image/%EC%BA%A1%EC%B2%985.PNG)
![캡처6.PNG](../image/%EC%BA%A1%EC%B2%986.PNG)
![캡처7.PNG](../image/%EC%BA%A1%EC%B2%987.PNG)
![캡처8.PNG](../image/%EC%BA%A1%EC%B2%988.PNG)
![캡처9.PNG](../image/%EC%BA%A1%EC%B2%989.PNG)
![캡처10.PNG](../image/%EC%BA%A1%EC%B2%9810.PNG)
![캡처11.PNG](../image/%EC%BA%A1%EC%B2%9811.PNG)
---

##  주요 특징

-  **댓글/대댓글 1단계 구조**: 댓글은 하나의 대댓글만 가질 수 있습니다.
-  **소프트 딜리트 적용**: 삭제된 일정 및 삭제된 댓글은 DB에 남아 있으며, 조회 시 제외됩니다.
-  **DTO 구조**: 요청/응답은 DTO 기반으로 명확하게 분리되어 유지보수 용이.
-  **대댓글의 대댓글은 금지**: 비즈니스 로직으로 제한됩니다.

---

##  기술 스택

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL / H2
- Lombok
- Gradle
