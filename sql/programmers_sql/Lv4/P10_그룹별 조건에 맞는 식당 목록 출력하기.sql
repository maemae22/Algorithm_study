# https://school.programmers.co.kr/learn/courses/30/lessons/131124

# MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
# 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.
# REVIEW_DATE의 데이트 포맷이 예시(ex. 2022-02-12)와 동일해야 정답처리 됩니다.
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE FROM REST_REVIEW R
    JOIN MEMBER_PROFILE M ON R.MEMBER_ID=M.MEMBER_ID
    WHERE R.MEMBER_ID=(SELECT MEMBER_ID FROM REST_REVIEW GROUP BY MEMBER_ID ORDER BY COUNT(REVIEW_ID) DESC LIMIT 1)
    ORDER BY REVIEW_DATE ASC, R.REVIEW_TEXT ASC
