select * from employees;

select * from jobs;

--1.
SELECT JOB_ID, MAX(SALARY), MIN(SALARY)
  FROM EMPLOYEES
 WHERE JOB_ID LIKE ('SA%')
 GROUP BY JOB_ID;

--2.
SELECT JOB_ID, MAX(SALARY) MAX_SAL
  FROM EMPLOYEES
 GROUP BY JOB_ID
 ORDER BY MAX_SAL DESC;
 
--3.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.SALARY
  FROM EMPLOYEES E
 INNER JOIN JOBS J
   ON E.SALARY BETWEEN J.MIN_SALARY AND J.MAX_SALARY
  WHERE J.JOB_ID = 'IT_PROG';
 
--4.
SELECT E.FIRST_NAME "이름", E.LAST_NAME "성", SALARY "연봉"
  FROM EMPLOYEES E
 INNER JOIN JOBS J
    ON E.JOB_ID = J.JOB_ID
 WHERE J.JOB_TITLE = 'Sales Representative'
   AND E.SALARY BETWEEN 9000 AND 10000
 ORDER BY E.FIRST_NAME;
 
--5.
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, J.JOB_TITLE, D.DEPARTMENT_NAME
  FROM EMPLOYEES E
  INNER JOIN JOBS J
     ON E.JOB_ID = J.JOB_ID
  INNER JOIN DEPARTMENTS D
    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS L
    ON D.LOCATION_ID = L.LOCATION_ID
 WHERE CITY = 'Seattle';
 
 --6.
 SELECT J.JOB_TITLE, SUM(E.SALARY) AS SAL_SUM
  FROM EMPLOYEES E
 INNER JOIN JOBS J
  ON E.JOB_ID = J.JOB_ID
 GROUP BY J.JOB_TITLE
HAVING SUM(E.SALARY) > 30000
 ORDER BY SAL_SUM DESC;
 
--7.
SELECT E.LAST_NAME, E.SALARY
  FROM EMPLOYEES E
 INNER JOIN EMPLOYEES E2
    ON E.MANAGER_ID = E2.EMPLOYEE_ID
 WHERE E.SALARY > E2.SALARY;
 
--8.
SELECT E1.EMPLOYEE_ID,E1.FIRST_NAME, D.DEPARTMENT_NAME, E2.FIRST_NAME
  FROM EMPLOYEES E1
 INNER JOIN EMPLOYEES E2
    ON E1.MANAGER_ID = E2.EMPLOYEE_ID
 INNER JOIN DEPARTMENTS D
    ON E1.DEPARTMENT_ID = D.DEPARTMENT_ID
 ORDER BY E1.EMPLOYEE_ID;
    
--9.
SELECT E1.EMPLOYEE_ID, E1.FIRST_NAME, NVL(E2.FIRST_NAME, '관리자 없음') AS "관리자 이름"
  FROM EMPLOYEES E1
 LEFT OUTER JOIN EMPLOYEES E2
    ON E1.MANAGER_ID = E2.EMPLOYEE_ID
WHERE E1.FIRST_NAME LIKE '%v%'
ORDER BY E1.EMPLOYEE_ID;

--10.
SELECT E1.EMPLOYEE_ID, E1.LAST_NAME, E1.HIRE_DATE, E2.HIRE_DATE
  FROM EMPLOYEES E1
 INNER JOIN EMPLOYEES E2
    ON E1.MANAGER_ID = E2.EMPLOYEE_ID
   AND E1.HIRE_DATE < E2.HIRE_DATE
 ORDER BY E1.HIRE_DATE;
 
--11.

 
 
 