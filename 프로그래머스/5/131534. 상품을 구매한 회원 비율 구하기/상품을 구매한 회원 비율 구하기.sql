-- 코드를 입력하세요


WITH S AS(
    SELECT COUNT(USER_ID) AS COUNT
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
)


SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) AS MONTH, COUNT(DISTINCT USER_ID) AS PURCHASED_USERS, 
ROUND(COUNT(DISTINCT USER_ID) / (SELECT COUNT FROM S),1) AS PUCHASED_RATIO
FROM ONLINE_SALE
WHERE USER_ID IN (
    SELECT USER_ID
    FROM USER_INFO
    WHERE JOINED LIKE '2021%'
)
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE)
ORDER BY YEAR(SALES_DATE), MONTH(SALES_DATE)

