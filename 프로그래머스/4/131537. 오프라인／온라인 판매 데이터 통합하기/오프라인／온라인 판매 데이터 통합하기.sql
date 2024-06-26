-- 코드를 입력하세요
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE MONTh(SALES_DATE) = 3
UNION
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
PRODUCT_ID, 
Null AS USER_ID, 
SALES_AMOUNT
FROM OFFLINE_SALE
WHERE MONTh(SALES_DATE) = 3
order by SALES_DATE, PRODUCT_ID, USER_ID