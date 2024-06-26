WITH Percentage AS (       
    SELECT
    ID,
    NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS SIZE_GROUP
    FROM ECOLI_DATA
),
COL AS (
    SELECT ID,
    CASE WHEN SIZE_GROUP = 1 THEN 'CRITICAL'
    WHEN SIZE_GROUP = 2 THEN 'HIGH'
    WHEN SIZE_GROUP = 3 THEN 'MEDIUM'
    ELSE 'LOW'
    END AS COLONY_NAME
    FROM Percentage
)

SELECT * FROM
COL
ORDER BY ID;