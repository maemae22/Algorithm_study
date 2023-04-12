# https://school.programmers.co.kr/learn/courses/30/lessons/131120

# MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요.
# 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.
# DATE_OF_BIRTH의 데이트 포맷이 예시(ex. 1992-02-12)와 동일해야 정답처리 됩니다.
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") AS DATE_OF_BIRTH FROM MEMBER_PROFILE
    WHERE MONTH(DATE_OF_BIRTH)=3 AND GENDER='W' AND TLNO IS NOT NULL ORDER BY MEMBER_ID
