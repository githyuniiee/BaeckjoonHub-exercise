SELECT B.USER_ID, B.NICKNAME, CONCAT(B.CITY, " ", B.STREET_ADDRESS1, " ", B.STREET_ADDRESS2 ) AS '전체주소', CONCAT(LEFT(B.TLNO, 3), "-", SUBSTR(B.TLNO,4,4), "-", SUBSTR(B.TLNO,8,4)) AS '전화번호'
FROM USED_GOODS_BOARD A
INNER JOIN USED_GOODS_USER B
ON A.WRITER_ID = B.USER_ID
GROUP BY B.USER_ID
HAVING COUNT(B.USER_ID) >= 3
ORDER BY USER_ID DESC;
