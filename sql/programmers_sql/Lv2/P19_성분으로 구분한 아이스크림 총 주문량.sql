# https://school.programmers.co.kr/learn/courses/30/lessons/133026

# 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성해주세요.
# 이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주세요.
SELECT I.INGREDIENT_TYPE, SUM(F.TOTAL_ORDER) AS TOTAL_ORDER
    FROM ICECREAM_INFO I JOIN FIRST_HALF F ON I.FLAVOR=F.FLAVOR GROUP BY I.INGREDIENT_TYPE ORDER BY TOTAL_ORDER
