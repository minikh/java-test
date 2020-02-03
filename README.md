Task 1. Generating test data

Write a program that creates a text file containing the date, time, point of sale number, 
transaction number, and transaction amount.

* The time must be selected randomly in the range for the previous year. That is, if the program is running on 02.06.2018, the operation time can be from 01.01.2017 00: 00 to 01.01.2018 00: 00.
* The number of the point of sale should be randomly selected from a pre-prepared list.
* The list is stored in a text file on a single line of one point of sale.
* Transaction amount-a random value in the range from 10 000,00 to 100 000,00 rubles.

The program passes the name of the file with the list of sales points, the number of operations, 
and the file where to write the generated data as parameters.  

Task 2. Grouping data

Write a program that finds the statistics for the operations.
* Data about operations is located in the file that was generated in the previous task.
* The program must calculate the sum of all transactions for each day and the sum of all transactions at each point of sale.
* The program passes the file name with operations, the file name with statistics on dates, and the file name with statistics on sales points as parameters.
* Date statistics should be sorted in ascending order of dates.
* Statistics for points of sale should be sorted in descending order of the amount.

Example of running the program:
    
    java-jar task2.jar operations.txt sums-by-dates.txt sums-by-offices.txt
