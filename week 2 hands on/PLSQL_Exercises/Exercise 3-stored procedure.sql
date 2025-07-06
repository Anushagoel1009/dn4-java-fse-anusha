SET SERVEROUTPUT ON;

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION
  WHEN OTHERS THEN
    NULL; 
END;
/
CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(50),
  emp_salary NUMBER
);
/

BEGIN
  INSERT INTO employees VALUES (1, 'Alice', 50000);
  INSERT INTO employees VALUES (2, 'Bob', 60000);
  COMMIT;
END;
/
CREATE OR REPLACE PROCEDURE get_employee_details (
  p_emp_id IN employees.emp_id%TYPE
)
IS
  v_name employees.emp_name%TYPE;
  v_salary employees.emp_salary%TYPE;
BEGIN
  SELECT emp_name, emp_salary
  INTO v_name, v_salary
  FROM employees
  WHERE emp_id = p_emp_id;

  DBMS_OUTPUT.PUT_LINE('Employee Name: ' || v_name);
  DBMS_OUTPUT.PUT_LINE('Employee Salary: ' || v_salary);
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No employee found with ID ' || p_emp_id);
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/
BEGIN
  get_employee_details(1);
END;
/