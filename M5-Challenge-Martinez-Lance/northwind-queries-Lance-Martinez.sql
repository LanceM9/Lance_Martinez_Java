use northwind;

-- list all categories of products
select category from products;

-- list all products made by Dell
select * from products 
where product_name like '%dell%';

-- list all orders shipped to Pennsylvania
select * from orders 
where ship_state = 'pennsylvania';

-- list the first name and last name of all employees with 
-- last names that start with 'w'
select first_name, last_name from employees
where last_name like 'w%';

-- list all customers who's zip codes start with 55
select * from customers
where postal_code like '55%';

-- list all customers who's zip code end with 0
select * from customers
where postal_code like '%0';

-- list the first name, last name and email for all
-- customers with an '.org' email address
select first_name, last_name, email from customers
where email like '%.org';

-- list first name, last name and phone number
-- for all customers from the 202 area code
select first_name, last_name, phone from customers
where phone like '___202%';

-- list first name, last name, and phone number
-- for all customers from the area code 202, 
-- ordered by last name, first name
select first_name, last_name, phone from customers
where phone like '___202%'
order by last_name, first_name;