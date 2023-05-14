# Spring 에서 LocalDateTime
## 요약
둘 다 써두면 돌아 간다.
```
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
```

## 요청
### @ModelAttribute, @RequestParam
```
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
```
### @RequestBody
```
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
```

## 응답
```
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
```

## 기타
pattern 이 yyyy-MM-dd'T'HH:mm:ss 일 경우 

@RequestBody, @ModelAttribute, @RequestParam 에서 

LocalDateTime 바인딩을 위한 어노테이션이 없어도 바인딩 성공

@ModelAttribute, @RequestParam 의 경우 다른 패턴이 지정 되어도

yyyy-MM-dd'T'HH:mm:ss 형식은 바인딩 가능함.
