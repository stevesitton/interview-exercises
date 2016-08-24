package com.tr.exercise.peoplestats;

import com.tr.exercise.peoplestats.domain.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

/**
 * This exercise is to primarily look at your development process, secondly your coding ability.  This is a 30 minute
 * exercise, do not worry if all the questions are not completed.  The Java 8 API is available for reference, but no
 * internet searching is expected during this exercise.
 *
 * People Stats
 * ============
 *
 * We have a list of data about our employees in a separate CSV file (people.csv), we would like to view this data
 * in different ways and answer questions about our employees.
 *
 * CSV Columns: Name, Birth Month, Age, Office
 *
 * Assumption is that all the data is valid and that people's name will always be in the format: <firstname> <surname>
 *
 * You can change any class as you see fit.
 *
 *
 * Complete the following tasks on the data provided:
 *
 *  1) Display number of employees aged 33.  Output should be: The number of employees aged 33 is <number>.
 *
 *  2) Display a list of employees whose surname contains "on".  Output should be: <full name> <age>
 *
 *  3) What month was Camilla Franklin was born?  Output should be: Camilla Franklin was born in the month of <month>.
 *
 *  4) Display a list all employees ordered by surname in ascending order.  Output should be: <full name>
 *
 *  5) What is the average age of the employees?  Output should be: The average age of our employees is <age>.
 *
 */
public class PeopleStats {

    public static void main(String[] args) {

        try {

            // Data already retrieved from the file and populated into a list of objects
            List<Person> people = getData();


        } catch (IOException io) {
            throw new UncheckedIOException(io);
        }
    }

    /**
     * Read CSV file contents
     *
     * @return List of Person objects
     * @throws IOException
     */
    public static List<Person> getData() throws IOException {

        List<Person> people = new ArrayList<>();
        File csvData = new File("people-stats-exercise/src/main/resources/people.csv");
        CSVParser parser = CSVParser.parse(csvData, Charset.defaultCharset(), CSVFormat.RFC4180);
        StreamSupport.stream(parser.spliterator(), false).forEach(p -> people.add(new Person(p.get(0), p.get(1), p.get(2), p.get(3))));

        return people;
    }

}
