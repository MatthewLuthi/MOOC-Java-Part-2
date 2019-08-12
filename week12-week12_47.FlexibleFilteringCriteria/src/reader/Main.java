package reader;

import reader.criteria.AtLeastOne;
import reader.criteria.ContainsWord;
import reader.criteria.Criterion;

public class Main {

    public static void main(String[] args) {
        //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
        String address = "http://gutenberg.readingroo.ms/2/5/5/2554/2554-8.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion =new AtLeastOne(
                    new ContainsWord("beer"),
                    new ContainsWord("milk"),
                    new ContainsWord("oil")
                );

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
