package seedu.duke.commands;

import seedu.duke.DukeException;

import seedu.duke.task.Book;
import seedu.duke.task.BookList;
import seedu.duke.task.ItemList;
import seedu.duke.task.ListType;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// @@author MuhammadHoze

public class BorrowCommand extends Command {

    public static final String COMMAND_WORD = "borrow";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a book to the book list.\n"
            + "     Parameters: BOOK_NAME date/DATE\n"
            + "     Example: " + COMMAND_WORD + " example_book  date/10-10-2020";
    private String description = "";
    public static final HashSet<String> ALLOWED_ARGUMENTS = new HashSet<>(Collections.singletonList("date"));
    private final HashMap<String, String> argumentsMap;

    public BorrowCommand(String description, HashMap<String, String> argumentsMap) {
        this.description = description;
        this.argumentsMap = argumentsMap;
    }

    @Override
    public void execute(Map<ListType, ItemList> listMap) throws DukeException {

        BookList books = (BookList) listMap.get(ListType.BOOK_LIST);
        Book newBook = new Book(description);

        if (argumentsMap.containsKey("date")) {
            newBook.setDateFromString(argumentsMap.get("date"));
        }
        books.addBook(newBook);
    }
}