SELECT * FROM demo.employees;
use demo;
SELECT AVG(salary) AS AverageSalary
FROM employees;
SELECT SUM(Salary) AS TotalSalary
FROM Employees;
SELECT MIN(Salary) AS MinimumSalary
FROM Employees;
SELECT MAX(Salary) AS MaximumSalary
FROM Employees;
SELECT COUNT(*) AS TotalEmployees
FROM Employees;
SELECT UCASE(FirstName) AS UpperFirstName
FROM Employees;
SELECT LOWER(Email) AS LowercaseEmail
FROM Employees;
SELECT SUBSTRING(FirstName, 1, 3) AS SubstrFirstName
FROM Employees;
SELECT DATE_FORMAT(BirthDate, '%d-%m-%Y') AS FormattedBirthDate
FROM Employees;
SELECT NOW() AS CurrentDateTime;
SELECT *
FROM Employees
WHERE Email LIKE '%example.com';
SELECT CONCAT(FirstName, ' ', LastName) AS FullName
FROM Employees;