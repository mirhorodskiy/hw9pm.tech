--departments
INSERT INTO Departments
VALUES (1, 'Programming');

INSERT INTO Departments
VALUES (2, 'Design');

INSERT INTO Departments
VALUES (3, 'Analytics');

INSERT INTO Departments
VALUES (4, 'Management');

INSERT INTO Departments
VALUES (5, 'Finance');


-- employees
-- employees without projects
INSERT INTO Employees
VALUES (1, 'hromandrew@gmail.com', 'Andrew', 'Hrom', 1);

INSERT INTO Employees
VALUES (2, 'karpenko@gmail.com', 'Dmytro', 'Karpenko', 2);

INSERT INTO Employees
VALUES (3, 'kazymyrchuk@gmail.com', 'Konstantin', 'Kazymyrchuk', 3);

INSERT INTO Employees
VALUES (4, 'trotsmargo@gmail.com', 'Margarita', 'Trots', 4);

INSERT INTO Employees
VALUES (5, 'khariton@gmail.com', 'Nikolay', 'Khariton', 4);

INSERT INTO Employees
VALUES (6, 'tsarev@gmail.com', 'Alexander', 'Tsarev', 5);

-- employees with projects
INSERT INTO Employees
VALUES (7, 'ivankova@gmail.com', 'Elena', 'Ivankova', 3);

INSERT INTO Employees
VALUES (8, 'harashchenko@gmail.com', 'Filipp', 'Harashchenko', 3);

INSERT INTO Employees
VALUES (9, 'shostka@gmail.com', 'Petro', 'Shostka', 4);

INSERT INTO Employees
VALUES (10, 'shevchenko@gmail.com', 'Natali?a', 'Shevchenko', 4);

INSERT INTO Employees
VALUES (12, 'yaroshenko@gmail.com', 'Ulyana', 'Yaroshenko', 4);

INSERT INTO Employees
VALUES (13, 'filipchuk@gmail.com', 'Boris', 'Filipchuk', 5);

INSERT INTO Employees
VALUES (14, 'sharov@gmail.com', 'Pavel', 'Sharov', 5);

INSERT INTO Employees
VALUES (15, 'zhezheliv@gmail.com', 'Sergey', 'Zhezheliv', 2);

INSERT INTO Employees
VALUES (16, 'koropie@gmail.com', 'Roman', 'Koropie', 2);

INSERT INTO Employees
VALUES (17, 'myskina@gmail.com', 'Olga', 'Myskina', 1);

INSERT INTO Employees
VALUES (18, 'ivashchenko@gmail.com', 'Yury', 'Ivashchenko', 1);

INSERT INTO Employees
VALUES (19, 'shchepkin@gmail.com', 'Andrew', 'Shchepkin', 1);

INSERT INTO Employees
VALUES (20, 'medvyn@gmail.com', 'Yaroslav', 'Medvyn', 1);


INSERT INTO Managers
VALUES (1, 'Adruschenko');

INSERT INTO Managers
VALUES (2, 'Marchenko');

INSERT INTO Managers
VALUES (3, 'Marchuk');

INSERT INTO Managers
VALUES (4, 'Vilatov');

INSERT INTO Managers
VALUES (5, 'Myrhorodskyi');

INSERT INTO Customers
VALUES (1, 'mirhorodskiy@gmail.com', 'Myrhorodskyi', '0633729033');

INSERT INTO Customers
VALUES (2, 'mykhailenko@gmail.com', 'Mykhailenko', '0975614973');

INSERT INTO Customers
VALUES (3, 'onyshchenko@gmail.com' 'Onyshchenko', , '0982456987');

INSERT INTO Customers
VALUES (4, 'rybchynskyi@gmail.com', 'Rybchynskyi', '0675214468');

INSERT INTO Customers
VALUES (5, 'stetsenko@gmail.com', 'Stetsenko', '0973654197');

INSERT INTO Customers
VALUES (6, 'kovalenko@gmail.com', 'Kovalenko', '0982197568');

INSERT INTO Customers
VALUES (7, , 'haievych@gmail.com', 'Haievych' '0975237428');



INSERT INTO Projects
VALUES (1, 'Instagram', 1, 1);

INSERT INTO Projects
VALUES (2, 'Facebook', 2, 2);

INSERT INTO Projects
VALUES (3, 'CoD 4', 3, 3);

INSERT INTO Projects
VALUES (4, 'Warcraft', 4, 4);

INSERT INTO Projects
VALUES (5, 'Telegram', 5, 5);

INSERT INTO Projects
VALUES (6, 'DOTA 3', 6, 5);

INSERT INTO Projects
VALUES (7, 'Smart Beer', 7, 5);

INSERT INTO Projects
VALUES (8, 'Holohram', 1, 5);

INSERT INTO Projects
VALUES (9, 'Robodog', 4, 1);

INSERT INTO Projects
VALUES (10, 'Social network for alcoholics', 1, 2);

INSERT INTO Projects
VALUES (11, 'Smart watch', 1, 3);



INSERT INTO Employees_projects
VALUES (7, 1);
INSERT INTO Employees_projects
VALUES (18, 1);
INSERT INTO Employees_projects
VALUES (19, 1);
INSERT INTO Employees_projects
VALUES (16, 1);
INSERT INTO Employees_projects
VALUES (17, 1);
INSERT INTO Employees_projects
VALUES (13, 1);
-- project 2
INSERT INTO Employees_projects
VALUES (19, 2);
INSERT INTO Employees_projects
VALUES (20, 2);
INSERT INTO Employees_projects
VALUES (15, 2);
INSERT INTO Employees_projects
VALUES (8, 2);
INSERT INTO Employees_projects
VALUES (14, 2);
-- project 3
INSERT INTO Employees_projects
VALUES (7, 3);
INSERT INTO Employees_projects
VALUES (18, 3);
INSERT INTO Employees_projects
VALUES (19, 3);
INSERT INTO Employees_projects
VALUES (16, 3);
INSERT INTO Employees_projects
VALUES (17, 3);
INSERT INTO Employees_projects
VALUES (13, 3);
-- project 4
INSERT INTO Employees_projects
VALUES (7, 4);
INSERT INTO Employees_projects
VALUES (18, 4);
INSERT INTO Employees_projects
VALUES (19, 4);
INSERT INTO Employees_projects
VALUES (16, 4);
INSERT INTO Employees_projects
VALUES (17, 4);
INSERT INTO Employees_projects
VALUES (13, 4);
-- project 5
INSERT INTO Employees_projects
VALUES (19, 5);
INSERT INTO Employees_projects
VALUES (20, 5);
INSERT INTO Employees_projects
VALUES (15, 5);
INSERT INTO Employees_projects
VALUES (8, 5);
INSERT INTO Employees_projects
VALUES (14, 5);
-- project 6
INSERT INTO Employees_projects
VALUES (19, 6);
INSERT INTO Employees_projects
VALUES (20, 6);
INSERT INTO Employees_projects
VALUES (15, 6);
INSERT INTO Employees_projects
VALUES (8, 6);
INSERT INTO Employees_projects
VALUES (14, 6);
-- project 7
INSERT INTO Employees_projects
VALUES (7, 7);
INSERT INTO Employees_projects
VALUES (18, 7);
INSERT INTO Employees_projects
VALUES (19, 7);
INSERT INTO Employees_projects
VALUES (16, 7);
INSERT INTO Employees_projects
VALUES (17, 7);
INSERT INTO Employees_projects
VALUES (13, 7);
-- project 8
INSERT INTO Employees_projects
VALUES (7, 8);
INSERT INTO Employees_projects
VALUES (18, 8);
INSERT INTO Employees_projects
VALUES (19, 8);
INSERT INTO Employees_projects
VALUES (16, 8);
INSERT INTO Employees_projects
VALUES (17, 8);
INSERT INTO Employees_projects
VALUES (13, 8);
-- project 9
INSERT INTO Employees_projects
VALUES (19, 9);
INSERT INTO Employees_projects
VALUES (20, 9);
INSERT INTO Employees_projects
VALUES (15, 9);
INSERT INTO Employees_projects
VALUES (8, 9);
INSERT INTO Employees_projects
VALUES (14, 9);
-- project 10
INSERT INTO Employees_projects
VALUES (19, 10);
INSERT INTO Employees_projects
VALUES (20, 10);
INSERT INTO Employees_projects
VALUES (15, 10);
INSERT INTO Employees_projects
VALUES (8, 10);
INSERT INTO Employees_projects
VALUES (14, 10);
-- project 11
INSERT INTO Employees_projects
VALUES (7, 11);
INSERT INTO Employees_projects
VALUES (18, 11);
INSERT INTO Employees_projects
VALUES (19, 11);
INSERT INTO Employees_projects
VALUES (16, 11);
INSERT INTO Employees_projects
VALUES (17, 11);
INSERT INTO Employees_projects
VALUES (13, 11);



