-- 코드를 입력하세요
# SELECT *
# FROM FIRST_HALF F
# JOIN JULY J
# ON F.FLAVOR = J.FLAVOR
# GROUP BY F.FLAVOR
# ORDER BY SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
# LIMIT 3


# SELECT FLAVOR, SUM(TOTAL_ORDER)
# FROM FIRST_HALF F
# GROUP BY FLAVOR


# SELECT J.FLAVOR
# FROM JULY J
# JOIN (
#     SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL
#     FROM FIRST_HALF
#     GROUP BY FLAVOR
# ) F
# ON J.FLAVOR = F.FLAVOR
# ORDER BY F.TOTAL + J.TOTAL_ORDER DESC
# LIMIT 3


SELECT F.FLAVOR
FROM FIRST_HALF F
    INNER JOIN (SELECT FLAVOR, sum(TOTAL_ORDER) AS JULY_TOTAL_ORDER
                FROM JULY
                GROUP BY FLAVOR) J
        ON F.FLAVOR = J.FLAVOR
ORDER BY TOTAL_ORDER + JULY_TOTAL_ORDER DESC
LIMIT 3;

