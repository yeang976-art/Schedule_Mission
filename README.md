[일정관리.postman_collection.json](https://github.com/user-attachments/files/29530252/postman_collection.json)# Schedule_Mission

[Uploading 일정관ᄅ{
  "info": {
    "_postman_id": "38d56d4a-7091-490f-bd1f-b0d5ce42fc1d",
    "name": "일정관리",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
    "_exporter_id": "55306576",
    "_collection_link": "https://go.postman.co/collection/55306576-38d56d4a-7091-490f-bd1f-b0d5ce42fc1d?source=collection_link"
  },
  "item": [
    {
      "name": "일정 만들기",
      "request": {
        "method": "POST",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"title\": \"Spring 일정\",\n  \"content\": \"POST 요청으로 일정 기능을 테스트한다.\",\n  \"author\": \"예은\",\n  \"password\": \"12634\"\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "http://localhost:8080/schedule",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "schedule"
          ]
        }
      },
      "response": []
    },
    {
      "name": "일정 보기",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/schedule",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "schedule"
          ]
        }
      },
      "response": []
    },
    {
      "name": "일정 수정",
      "request": {
        "method": "PUT",
        "header": [],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"title\": \"수정된 일정 제목6\",\n  \"author\": \"지수\",\n  \"password\": \"1234\"\n}",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        },
        "url": {
          "raw": "http://localhost:8080/schedule/1",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "schedule",
            "1"
          ]
        }
      },
      "response": []
    },
    {
      "name": "일정 삭제",
      "request": {
        "method": "DELETE",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/schedule/3",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "schedule",
            "3"
          ]
        }
      },
      "response": []
    },
    {
      "name": "특정 일정만 보기",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:8080/schedule/4",
          "protocol": "http",
          "host": [
            "localhost"
          ],
          "port": "8080",
          "path": [
            "schedule",
            "4"
          ]
        }
      },
      "response": []
    }
  ]



  
}ᅵ.postman_collection.json…]()


<img width="398" height="245" alt="스크린샷 2026-07-01 오전 10 39 02" src="https://github.com/user-attachments/assets/14fd27fb-d9ab-4fc6-9d6d-6b2b909fcf98" />

