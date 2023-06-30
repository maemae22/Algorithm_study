# https://school.programmers.co.kr/learn/courses/30/lessons/131532

# USER_INFO 테이블과 ONLINE_SALE 테이블에서 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요.
# 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.
SELECT YEAR(S.SALES_DATE) YEAR, MONTH(S.SALES_DATE) MONTH, U.GENDER, COUNT(DISTINCT S.USER_ID) USERS FROM ONLINE_SALE S
    JOIN USER_INFO U ON S.USER_ID=U.USER_ID
    WHERE U.GENDER IS NOT NULL
    GROUP BY YEAR(S.SALES_DATE), MONTH(S.SALES_DATE), U.GENDER
    ORDER BY YEAR ASC, MONTH ASC, GENDER ASC
