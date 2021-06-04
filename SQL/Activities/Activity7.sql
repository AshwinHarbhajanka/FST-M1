select * from orders;
select sum(purchase_amount) total from orders;
select avg(purchase_amount) Average_Amount from orders;
select min(purchase_amount) minAmount from orders;
select max(purchase_amount) maxAmount from orders;
select count(distinct salesman_id) salesman from orders;