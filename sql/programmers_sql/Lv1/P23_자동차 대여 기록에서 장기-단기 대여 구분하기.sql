# https://school.programmers.co.kr/learn/courses/30/lessons/151138

# CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 대여 시작일이 2022년 9월에 속하는 대여 기록에 대해서
# 대여 기간이 30일 이상이면 '장기 대여' 그렇지 않으면 '단기 대여' 로 표시하는 컬럼(컬럼명: RENT_TYPE)을 추가하여
# 대여기록을 출력하는 SQL문을 작성해주세요.
# 결과는 대여 기록 ID를 기준으로 내림차순 정렬해주세요.
# START_DATE와 END_DATE의 경우 예시(ex. 2022-09-16)의 데이트 포맷과 동일해야 정답처리 됩니다.
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, "%Y-%m-%d") AS START_DATE, DATE_FORMAT(END_DATE, "%Y-%m-%d") AS END_DATE
     , IF(TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1>=30, '장기 대여', '단기 대여') AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE YEAR(START_DATE)=2022 AND MONTH(START_DATE)=9
ORDER BY HISTORY_ID DESC


## 추가 공부
[ TIMESTAMPDIFF(DAY, START_DATE, END_DATE) ] = [ DATEDIFF(END_DATE, START_DATE) ] : 시작일/종료일이 반대니 주의 !

# SUBSTRING, SUBSTR('문자열 STR', '시작지점 START INDEX', '길이 LENGTH') : MySQL은 숫자를 1부터 셈
# - 문자열(STR)을 시작지점부터 길이만큼 추출 / [길이 미입력시 끝까지 추출]
[ YEAR(START_DATE)=2022 AND MONTH(START_DATE)=9 ] = [ SUBSTR(START_DATE, 1, 7) = '2022-09' ]
  = [ LEFT(START_DATE, 7) = '2022-09' ] = [ DATE_FORMAT(START_DATE, '%Y-%m') = '2022-09' ]

DATE_FORMAT(START_DATE, "%Y-%m-%d") = LEFT(START_DATE, 10)

IF(TIMESTAMPDIFF(DAY, START_DATE, END_DATE)+1>=30, '장기 대여', '단기 대여') AS RENT_TYPE
    = CASE WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN '장기 대여'
        ELSE '단기 대여' END AS RENT_TYPE
