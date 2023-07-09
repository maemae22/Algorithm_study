# https://school.programmers.co.kr/learn/courses/30/lessons/157339

# CAR_RENTAL_COMPANY_CAR 테이블과 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블과 CAR_RENTAL_COMPANY_DISCOUNT_PLAN 테이블에서
# 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
# 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성해주세요.
# 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬해주세요.
# FEE의 경우 예시(ex. 690000)처럼 정수부분만 출력되어야 합니다.
SELECT C.CAR_ID, C.CAR_TYPE, TRUNCATE(C.DAILY_FEE*30*(100-D.DIS)/100, 0) FEE FROM CAR_RENTAL_COMPANY_CAR C
    JOIN (SELECT CAR_TYPE, DISCOUNT_RATE DIS FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE='30일 이상') D ON C.CAR_TYPE=D.CAR_TYPE
    WHERE C.CAR_TYPE IN ('세단', 'SUV')
      AND C.CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                             WHERE DATE_FORMAT(START_DATE, "%Y%m%d") BETWEEN '20221101' AND '20221130'
                                OR DATE_FORMAT(END_DATE, "%Y%m%d") BETWEEN '20221101' AND '20221130'
                                OR (DATE_FORMAT(START_DATE, "%Y%m%d")<'20221101' AND DATE_FORMAT(END_DATE, "%Y%m%d")>'20221130'))
      AND (C.DAILY_FEE*30*(100-D.DIS)/100)>=500000
      AND (C.DAILY_FEE*30*(100-D.DIS)/100)<2000000
    ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC
