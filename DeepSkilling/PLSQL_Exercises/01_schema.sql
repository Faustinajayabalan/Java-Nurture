CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER(10,2),
    IsVIP VARCHAR2(5) DEFAULT 'FALSE',
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(10,2),
    LastModified DATE,
    CONSTRAINT FK_Customer
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER(10,2),
    TransactionType VARCHAR2(20),
    CONSTRAINT FK_Account
    FOREIGN KEY (AccountID)
    REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER(10,2),
    InterestRate NUMBER(5,2),
    StartDate DATE,
    EndDate DATE,
    CONSTRAINT FK_LoanCustomer
    FOREIGN KEY (CustomerID)
    REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER(10,2),
    Department VARCHAR2(50),
    HireDate DATE
);

CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    ActionDate DATE,
    ActionType VARCHAR2(50)
);

CREATE TABLE ErrorLog (
    ErrorID NUMBER PRIMARY KEY,
    ErrorMessage VARCHAR2(4000),
    ErrorDate DATE
);