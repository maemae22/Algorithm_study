# https://school.programmers.co.kr/learn/courses/30/lessons/144854

# '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를
# 출력하는 SQL문을 작성해주세요.
# 결과는 출판일을 기준으로 오름차순 정렬해주세요.
# PUBLISHED_DATE의 데이트 포맷이 예시(ex. 2021-02-05)와 동일해야 정답처리 됩니다.
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
    FROM BOOK B JOIN AUTHOR A ON B.AUTHOR_ID=A.AUTHOR_ID WHERE B.CATEGORY='경제' ORDER BY B.PUBLISHED_DATE
