-- 코드를 작성해주세요
SELECT ID,EMAIL,FIRST_NAME,LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 IN ('PYTHON') OR SKILL_2 IN ('PYTHON') OR SKILL_3 IN ('PYTHON') 
ORDER BY ID;