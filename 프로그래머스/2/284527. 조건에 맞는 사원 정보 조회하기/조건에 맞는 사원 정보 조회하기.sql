-- 코드를 작성해주세요
SELECT SUM(B.SCORE)AS SCORE,A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
FROM HR_EMPLOYEES A
INNER JOIN HR_GRADE B
ON A.EMP_NO = B.EMP_NO
WHERE B.YEAR LIKE "2022"
GROUP BY B.EMP_NO
ORDER BY SCORE DESC
LIMIT 1;


