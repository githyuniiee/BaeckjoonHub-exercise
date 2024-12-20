-- 코드를 작성해주세요





SELECT A.ID, IFNULL(B.COUNT,0) AS CHILD_COUNT
FROM ECOLI_DATA A
LEFT OUTER JOIN (SELECT PARENT_ID, COUNT(PARENT_ID) AS COUNT
FROM ECOLI_DATA
GROUP BY PARENT_ID
HAVING PARENT_ID IS NOT NULL) B
ON A.ID = B.PARENT_ID
ORDER BY ID