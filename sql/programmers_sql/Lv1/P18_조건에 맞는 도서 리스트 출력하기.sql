# https://school.programmers.co.kr/learn/courses/30/lessons/144853

# BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트를 찾아서
# 도서 ID(BOOK_ID), 출판일 (PUBLISHED_DATE)을 출력하는 SQL문을 작성해주세요.
# 결과는 출판일을 기준으로 오름차순 정렬해주세요.
# PUBLISHED_DATE의 데이트 포맷이 예시(ex. 2021-03-15)와 동일해야 정답처리 됩니다.
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE FROM BOOK
    WHERE YEAR(PUBLISHED_DATE)=2021 AND CATEGORY='인문' ORDER BY PUBLISHED_DATE
