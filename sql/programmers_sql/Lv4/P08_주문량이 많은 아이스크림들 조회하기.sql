# https://school.programmers.co.kr/learn/courses/30/lessons/133027

# 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.
SELECT F.FLAVOR FROM FIRST_HALF F
    JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) SUM FROM JULY GROUP BY FLAVOR) J ON F.FLAVOR=J.FLAVOR
    ORDER BY F.TOTAL_ORDER+J.SUM DESC
    LIMIT 3
