|기능|Http Method|Url|요청 방식|요청 내용|응답 내용|응답 코드|
|게시글 작성|POST|/newsfeeds|요청 Body|{"title":"제목", "contents":"내용", "username":"유저이름"}|{"title":"제목", "contents":"내용", "username":"유저이름"}|201 CREATED|
|게시글 전체 조회|GET|/newsfeeds|요청 Param|-|{"title":"제목", "contents":"내용", "username":"유저이름"}|200 OK|
|게시글 단건 조회|GET|/newsfeeds{id}|요청 Param|{"id":"Long", "title":"제목", "contents":"내용", "username":"유저이름"}|200 OK|
|게시글 수정|PUT|/newsfeeds{id}|요청 Body|{"id":"Long", "title":"수정된 제목", "contents":"수정된 내용", "username":"유저이름"}|{"id":"Long", "title":"수정된 제목", "contents":"수정된 내용", "username":"유저이름"}|200 OK|
|게시글 삭제|DELETE|/newsfeeds{id}|요청 Param|-|-|200 OK|
