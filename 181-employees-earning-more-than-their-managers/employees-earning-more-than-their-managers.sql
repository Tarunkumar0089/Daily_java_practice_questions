# Write your MySQL query statement below
select e1.name As Employee 
from Employee As e1
join Employee As e2
on e1.managerId=e2.id
where e1.salary>e2.salary;