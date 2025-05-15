-- 코드를 작성해주세요
with RAN as (
    select ID, percent_rank() over (order by size_of_colony desc) AS PER
    from ECOLI_DATA

)



# select
# from ECOLI_DATA
# where 

select ID, 
case when per <= 0.25 then 'CRITICAL'
when per <= 0.5 then 'HIGH'
when per <= 0.75 then 'MEDIUM'
when per <= 1 then 'LOW'
end as COLONY_NAME
from RAN
order by ID