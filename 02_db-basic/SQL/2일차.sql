-- order by : ASC(오름차순) DESC(내림차순)
-- order by 표현식 | 컬럼명 [ASC(디폴트) | DESC]
order by no;	-- asc 디폴트 설정
order by salary * 1000;
order by no asc;
order by no desc;

-- 사원의 정보를 출력합니다.
-- 단 사원의 급여가 높은 사원부터 출력합니다.
select * 
	from employees
order by salary desc;

-- 사원의 정보를 부서번호 순으로 출력하시오

select department_id, last_name, salary
	from employees
	order by department_id asc;
	
-- 사원의 정보를 부서번호 순으로 출력하시오
-- 단, 부서번호가 같을 경우 급여순으로 출력
select department_id, last_name, salary
	from employees
	order by department_id asc, salary asc;
	
--사원의 연봉을 출력합니다
-- 연봉 : 급여 * 15
-- 단, 출력시 연봉이 높은 사원부터 출력
select last_name, salary * 15 as salary2 
	from employees
	order by salary2 desc;

-- distinct
select department_id
	from employees;

select distinct department_id
	from employees;

select distinct department_id, last_name
	from employees;
	
---------------------------------------------
GROUP BY
-- 데이터들을 소그룹으로 묶는다
-- 그룹함수 
-- : 그룹핑된 데이터와 같이 주로 사용
-- : 여러개의 데이터를 받아서 하나의 결과를 반환
-- : COUNT, SUM, MAX, MIN, AVG
---------------------------------------------
-- 사원들의 수, 최대급여를 출력하시오
SELECT COUNT(*), MAX(SALARY), MIN(SALARY), SUM(SALARY), AVG(SALARY)
 FROM EMPLOYEES;
 
-- 100 번 부서의 각종 정보 출력
 SELECT COUNT(*), MAX(SALARY), MIN(SALARY), SUM(SALARY), AVG(SALARY)
 FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 100;
 
 -- 각 부서의 정보를 출력(수, 최대, 최소...)
 SELECT DEPARTMENT_ID,
 	COUNT(*), MAX(SALARY), MIN(SALARY), SUM(SALARY), AVG(SALARY)
 FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID;
 
 --FULL TABLE SCAN
 SELECT JOB_ID, MAX(SALARY), MIN(SALARY) 
 FROM TB_GROUP
 GROUP BY JOB_ID;
 
 SELECT DEPT_ID, JOB_ID, MAX(SAL), MIN(SAL)
 	FROM TB_GROUP
 GROUP BY DEPT_ID, JOB_ID;
 
 -- 각 부서별 최대급여를 출력합니다.
 -- 단, 최대급여가 높은 부서부터 출력
 SELECT DEPT_ID, MAX(SAL) AS SAL
 	FROM TB_GROUP
 GROUP BY DEPT_ID
 ORDER BY SAL DESC;
 
 -- 각 부서별 최대급여를 출력합니다.
 -- 최대급여가 10000 이상인 부서를 대상으로 
 -- 단, 최대급여가 높은 부서부터 출력
 -- WHERE절은 그룹핑된 문장이 올 수 없다.
 SELECT DEPARTMENT_ID, MAX(SALARY) AS MAX_SAL
 FROM  EMPLOYEES
 WHERE MAX(SALARY) >= 10000
 GROUP BY DEPARTMENT_ID
 ORDER BY MAX_SAL DESC;
 
 -----------------------------------
 HAVING
  : 그룹에 대한 제약을 처리
 -----------------------------------
 SELECT DEPARTMENT_ID, MAX(SALARY) AS MAX_SAL
 FROM  EMPLOYEES
 GROUP BY DEPARTMENT_ID
 HAVING MAX(SALARY) >= 10000
 ORDER BY MAX_SAL DESC;
  
-- 부서별 평균 급여를 출력합니다.
-- 단, 100번보다 큰 부서는 제외하고
-- 부서의 평균 급여가 5000 이상인 부서만 출력
-- 부서번호 순으로 출력합니다.
SELECT DEPARTMENT_ID, AVG(SALARY)
 FROM  EMPLOYEES
 WHERE DEPARTMENT_ID <= 100 
 GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 5000
 ORDER BY DEPARTMENT_ID;

-- 실행순서
-- FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY

 ------------------------------------
 함수 - 단일행 함수
 문자 함수
 숫자 함수
 날짜 함수
 변환 함수 : TO_CHAR, TO_DATE, TO_NUMBER
 기타 함수 : NVL, DECODE, CASE
 ------------------------------------
  
SELECT LAST_NAME, LOWER(LAST_NAME), UPPER(LAST_NAME),
	   CONCAT(LAST_NAME, '사원'),
	   LAST_NAME || '사원'
  FROM EMPLOYEES;

SELECT LAST_NAME, FIRST_NAME, CONCAT( UPPER(FIRST_NAME), LAST_NAME)
  FROM EMPLOYEES;
  
SELECT LAST_NAME,
	   SUBSTR(LAST_NAME, 1, 2)
  FROM EMPLOYEES;
  
SELECT '2017-05-02'
  FROM EMPLOYEES;
  
-- DUMMY TABLE : DUAL
SELECT '2017-05-02'
  FROM DUAL;
SELECT *
  FROM DUAL;
  
-- 실행 시 결과가 2017, 05, 02 출력
SELECT SUBSTR('2017-05-02', 1, 4),
	   SUBSTR('2017-05-02', 6, 2),
	   SUBSTR('2017-05-02', 9, 2)
  FROM DUAL;

SELECT LAST_NAME, LENGTH(LAST_NAME),
	   LPAD(LAST_NAME, 10, '*'),
	   RPAD(LAST_NAME, 10, '*')
  FROM EMPLOYEES;
  
SELECT 'hi hello sql',
		REPLACE('hi hello sql', 'el', 'ak'),
		TRANSLATE('hi hello sql', 'el', 'ak')
  FROM DUAL;
  
-- 숫자형 함수
SELECT ABS(100), ABS(-100)
  FROM DUAL;
-- CEIL : 입력된 수보다 크거나 같으면서 가장 작은 정수
-- FLOOR : 입력된 수보다 작거나 같으면서 가장 큰 정수
SELECT CEIL(1.1), FLOOR(1.1)
  FROM DUAL;
  
SELECT SIGN(-10), SIGN(0), SIGN(10)
  FROM DUAL;
  
SELECT ROUND(73.727), ROUND(73.727, 2), ROUND(73.727, -2),
	   TRUNC(73.727), TRUNC(73.727, 2), TRUNC(73.727, -2)
  FROM DUAL;

-- 날짜형 함수
SELECT SYSDATE
  FROM DUAL;
  
SELECT SYSDATE,
	   ADD_MONTHS(SYSDATE, 1),
	   ADD_MONTHS(SYSDATE, -1)
  FROM DUAL;
  
  
-- 각 사원의 입사일로부터 1년뒤의 날짜를 출력

SELECT HIRE_DATE, ADD_MONTHS(HIRE_DATE, 12)
  FROM EMPLOYEES;
  
-- MONTHS_BETWEEN(날짜1, 날짜2)
-- 두날짜간의 개월 차를 반환
-- 사원의 근무 개월을 출력
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
  FROM EMPLOYEES;
  
SELECT SYSDATE, LAST_DAY(SYSDATE)
  FROM DUAL;
  
-- 날짜 + 숫자 = 날짜
-- 날짜 - 숫자 = 날짜
-- 날짜 - 날짜 = 숫자
SELECT SYSDATE, SYSDATE + 7, SYSDATE - 7,
	   SYSDATE + 1/24 --1시간 뒤
  FROM DUAL;
  
SELECT SYSDATE - HIRE_DATE	--일수
  FROM EMPLOYEES;
  
-- 변환형 함수
-- to_char(날짜, '패턴') : 날짜를 문자로
-- to_char(숫자, '패턴') : 숫자를 문자로

SELECT SYSDATE,
	   TO_CHAR(SYSDATE, 'yyyy-mm-dd'),
	   TO_CHAR(SYSDATE, 'hh24:mi:ss')
  FROM DUAL;
  
 
-- to_date
-- to_date('문자', '패턴') : 문자를 날짜로
SELECT SYSDATE,
 	   TO_DATE('2017-03-11', 'yyyy-mm-dd')
  FROM DUAL;
  
INSERT INTO TB_BOARD(
	NO, TITLE, WRITER, CONTENT, REG_DATE
) VALUES (
	4, 'test', 'tester', 'exam', TO_DATE('2017-01-01', 'yyyy-mm-dd')
);

-- 숫자를 문자로
SELECT 892768491,
	   TO_CHAR(89112323),
	   TO_CHAR(892768491, '999,999,999'),
	   TO_CHAR(892768491, '99,999,999')
  FROM DUAL;
-- TO_NUMBER : 문자를 숫자로 변환
-- TO_NUMBER('문자', '패턴')
SELECT TO_NUMBER('892,768', '999,999')
  FROM DUAL;
  

-- 사원중에서 5월에 입사한 사원들의 정보만 출력하시오
SELECT *
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'mm') = '05'; 


-- 현재 월과 동일한 월에 입사한 사원의 정보를 출력하시오
SELECT *
  FROM EMPLOYEES
 WHERE TO_CHAR(HIRE_DATE, 'mm') = TO_CHAR(SYSDATE, 'mm');

-- 기타 함수
-- NVL('표현식|컬럼', '값')
-- NULL일 경우에 특정한 값을 설정
SELECT SALARY, COMMISSION_PCT,
	   SALARY + SALARY * NVL(COMMISSION_PCT, 0) SAL
  FROM EMPLOYEES;

-- 그룹 함수는 NULL값을 배제하고 처리한다.
SELECT SUM(COMMISSION_PCT)
  FROM EMPLOYEES;

-- 관리자가 없는 사원은 MANAGER_ID에 '관리자 없음' 출력
SELECT LAST_NAME, EMPLOYEE_ID, 
		--NVL(TO_CHAR(MANAGER_ID), '관리자 없음')
		NVL(MANAGER_ID || '', '관리자 없음')
  FROM EMPLOYEES;
  
-- DECODE : 자바의 SWITCH 문 같은 용도
SELECT JOB_ID,
	   DECODE (JOB_ID, 'IT_PROG', '개발자',
	                   'SA_MAN', '세일즈',
	                   '그냥 직원')
	   AS JOB_TYPE
  FROM EMPLOYEES;
  
-- CASE ~ END
SELECT JOB_ID,
	   CASE JOB_ID WHEN 'IT_PROG' THEN '개발자'
	               WHEN 'SA_MAN' THEN '세일즈'
	               ELSE '그냥 직원'
	   END AS JOB_TYPE
  FROM EMPLOYEES;

SELECT JOB_ID,
	   CASE WHEN JOB_ID = 'IT_PROG' THEN '개발자'
	        WHEN JOB_ID = 'SA_MAN' THEN '세일즈'
	        ELSE '그냥 직원'
	   END AS JOB_TYPE
  FROM EMPLOYEES;
  
-- 사원의 급여에 따라서 다음과 같이 출력한다.
-- 급여가 15000 이상이라면 '고급 인력'
-- 급여가 10000 ~ 14999 사이라면 '중급 인력'
-- 급여가 10000 미만일 경우 '초급 인력'
-- 출력은 급여와 급여 타입(고급,...)을 출력

SELECT SALARY "급여",
	   CASE WHEN SALARY >= 15000 THEN '고급인력'
			WHEN SALARY >= 10000 THEN '중급인력'
			ELSE '초급 인력'
		END AS "급여 타입"
  FROM EMPLOYEES;
  
  -------------------------------------------
  시퀀스(SEQUENCE) 객체
  고유번호 생성기
  -------------------------------------------
 SELECT NVL(MAX(NO), 0) +1 FROM TB_BOARD;
 DELETE FROM TB_BOARD; 
 
  INSERT INTO TB_BOARD(
   	NO, TITLE, WRITER, CONTENT
  ) VALUES (
  	(SELECT NVL(MAX(NO), 0) +1 FROM TB_BOARD),
  	'제목', '글쓴이', '내용'
  )
  
  SELECT * FROM TB_BOARD;
  
-- 시퀀스 생성 : S_테이블명_컬럼명
CREATE SEQUENCE S_BOARD_NO;

-- 번호 추출 : 시퀀스명.nextval
SELECT S_BOARD_NO.NEXTVAL
  FROM DUAL;
  
SELECT S_BOARD_NO.CURRVAL
  FROM DUAL;

  INSERT INTO TB_BOARD(
   	NO, TITLE, WRITER, CONTENT
  ) VALUES (
  	S_BOARD_NO.NEXTVAL,
  	'제목', '글쓴이', '내용'
  )