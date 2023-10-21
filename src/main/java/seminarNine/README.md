# Simple restApi server

## Просмотр документации swagger

Для проверки взаимодействия с сервисом, и отправки запросов, не забудьте собрать и запустить сервис)

### Первый вариант:
- Перейти на сайт https://editor.swagger.io/
- Загрузить файл openapi.json, через меню "File" -> "Import file"

### Второй вариант запустить локальный веб сервер с движком swagger:

    `docker run -p 80:8080 -e SWAGGER_JSON=/openapi.json -v ./openapi.json:/openapi.json swaggerapi/swagger-ui`

Затем открыть страницу в браузере http://localhost