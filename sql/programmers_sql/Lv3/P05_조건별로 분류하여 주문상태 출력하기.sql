# https://school.programmers.co.kr/learn/courses/30/lessons/131113

# FOOD_ORDER 테이블에서 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회하는 SQL문을 작성해주세요.
# 출고여부는 5월 1일까지 출고완료로 이후 날짜는 출고 대기로 미정이면 출고미정으로 출력해주시고,
# 결과는 주문 ID를 기준으로 오름차순 정렬해주세요.
# OUT_DATE 컬럼은 2022-04-27와 같은 형식으로 출력해주세요.
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, "%Y-%m-%d") AS OUT_DATE,
       CASE
           WHEN OUT_DATE IS NULL THEN '출고미정'
           WHEN DATE_FORMAT(OUT_DATE, "%m%d") <= '0501' THEN '출고완료'
           ELSE '출고대기'
       END AS '출고여부'
FROM FOOD_ORDER ORDER BY ORDER_ID
