package stream_api.course;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapAndFlatMap {
    public static void main(String[] args) {

        // map

        List<Double> numbers = List.of(6.28, 5.42, 84.0, 26.0);
        List<Double> dividedByTwo = numbers.stream()
                .map(n -> n / 2)
                .collect(Collectors.toList());

        List<Job> jobs = List.of(
                new Job("Super developer Java 11", "...", 350_000),
                new Job("Senjor developer Java", "...", 180_000));
        List<String> titles = jobs.stream()
                .map(Job::getTitle)
                .collect(Collectors.toList());

        // primitive-specialized types of the map operation

        List<Planet> planets = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .mapToObj(Planet::new)
                .collect(Collectors.toList());

        // flatMap

        List<Book> books = List.of(
                new Book("Java EE 7 Essentials", 2013, List.of("Arun Gupta")),
                new Book("Algorithms", 2011, List.of("Robert Sedgewick", "Kevin Wayne")),
                new Book("Clean code", 2014, List.of("Robert Martin"))
        );
        List<String> auhors = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .collect(Collectors.toList());
    }

    static class Job {
        private final String title;
        private final String decgription;
        private final double salary;

        public Job(String title, String decgription, double salary) {
            this.title = title;
            this.decgription = decgription;
            this.salary = salary;
        }

        public String getTitle() {
            return title;
        }

        public String getDecgription() {
            return decgription;
        }

        public double getSalary() {
            return salary;
        }
    }

    static class Planet {
        private final int orderFromSun;

        public Planet(int orderFromSun) {
            this.orderFromSun = orderFromSun;
        }

        public int getOrderFromSun() {
            return orderFromSun;
        }
    }

    static class Book {
        private final String title;
        private final int year;
        private final List<String> authors;

        public Book(String title, int year, List<String> authors) {
            this.title = title;
            this.year = year;
            this.authors = authors;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        public List<String> getAuthors() {
            return authors;
        }
    }
}
