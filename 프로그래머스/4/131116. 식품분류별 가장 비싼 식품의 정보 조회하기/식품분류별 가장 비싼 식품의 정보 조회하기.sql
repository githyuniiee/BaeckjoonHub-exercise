-- 코드를 입력하세요
# SELECT MAX(PRICE) AS MAX_PRICE
# FROM FOOD_PRODUCT
# WhERE CATEGORY IN('과자', '국', '김치', '식용유')
# GROUP BY CATEGORY

SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (SELECT CATEGORY, MAX(PRICE) AS MAX_PRICE
FROM FOOD_PRODUCT
GROUP BY CATEGORY
HAVING CATEGORY IN ('과자', '국', '김치', '식용유')
)
ORDER BY MAX_PRICE DESC;