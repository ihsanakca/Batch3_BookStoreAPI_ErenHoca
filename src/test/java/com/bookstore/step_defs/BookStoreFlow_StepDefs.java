package com.bookstore.step_defs;

import com.bookstore.services.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BookStoreFlow_StepDefs {

    GetAllBooks getAllBooks = new GetAllBooks();
    AddNewUser addNewUser = new AddNewUser();
    GenerateToken generateToken = new GenerateToken();
    AuthorizeUser authorizeUser = new AuthorizeUser();
    AddNewBook addNewBook = new AddNewBook();
    GetUserInfo getUserInfo = new GetUserInfo();
    UpdateBook updateBook = new UpdateBook();
    DeleteBook deleteBook = new DeleteBook();

    @Given("Get all books")
    public void get_all_books() {
        getAllBooks.getAllBooks();
    }

    @Then("Validate that the books are listed")
    public void validate_that_the_books_are_listed() {
        getAllBooks.validateThatAllBooksAreListed();
    }

    @Given("Add new user")
    public void add_new_user() {
        addNewUser.addNewUser();
    }

    @Then("Validate that the user is created")
    public void validate_that_the_user_is_created() {
        addNewUser.validateThatNewUserIsCreated();
    }

    @Given("Generate Token")
    public void generate_Token() {
        generateToken.generateToken();
    }

    @Then("Validate that the token is generated")
    public void validate_that_the_token_is_generated() {
        generateToken.validateThatTokenIsGenerated();
    }

    @Given("Authorize User")
    public void authorize_User() {
        authorizeUser.authorizeUser();
    }

    @Then("Validate that the user is authorized")
    public void validate_that_the_user_is_authorized() {
        authorizeUser.validateThatUserIsAuthorized();
    }

    @Given("Add new book to the user")
    public void add_new_book_to_the_user() {
        addNewBook.addNewBook();
    }

    @Then("Validate that the book is added to the user")
    public void validate_that_the_book_is_added_to_the_user() {
        addNewBook.validateThatTheBookAddedToTheUser();
    }

    @Given("Get user information")
    public void get_user_information() {
        getUserInfo.getUserInformation();
    }

    @Then("Validate that the information is correct")
    public void validate_that_the_information_is_correct() {
        getUserInfo.validateThatTheUserInformation();
    }

    @Given("Update first book with the second one")
    public void update_first_book_with_the_second_one() {
        updateBook.updateBook();
    }

    @Then("Validate that the book is updated")
    public void validate_that_the_book_is_updated() {
        updateBook.validateThatTheBookIsUpdated();
    }

    @Given("Delete Book")
    public void delete_Book() {
        deleteBook.deleteBook();
    }

    @Then("Validate that the book is deleted")
    public void validate_that_the_book_is_deleted() {
        deleteBook.validateThatTheBookIsDeleted();
    }

}
