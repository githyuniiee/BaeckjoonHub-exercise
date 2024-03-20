-- 코드를 입력하세요
SELECT A.ANIMAL_ID,	A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A
INNER JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE != B.SEX_UPON_OUTCOME
ORDER BY ANIMAL_ID;