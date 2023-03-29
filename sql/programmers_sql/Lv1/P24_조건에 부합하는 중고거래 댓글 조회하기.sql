# https://school.programmers.co.kr/learn/courses/30/lessons/164673

# USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 2022년 10월에 작성된
# 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요.
# 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요.
# CREATED_DATE의 포맷이 예시(ex. 2022-10-02)의 포맷과 일치해야 정답처리 됩니다.
SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, "%Y-%m-%d") AS CREATED_DATE
FROM USED_GOODS_BOARD B JOIN USED_GOODS_REPLY R ON B.BOARD_ID=R.BOARD_ID
WHERE DATE_FORMAT(B.CREATED_DATE, "%Y%m")='202210'
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC
