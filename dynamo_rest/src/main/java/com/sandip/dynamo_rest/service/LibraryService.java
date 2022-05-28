package com.sandip.dynamo_rest.service;

import com.sandip.dynamo_rest.entities.*;
import com.sandip.dynamo_rest.entities.requests.AuthorCreationRequest;
import com.sandip.dynamo_rest.entities.requests.BookCreationRequest;
import com.sandip.dynamo_rest.entities.requests.BookLendRequest;
import com.sandip.dynamo_rest.entities.requests.MemberCreationRequest;
import com.sandip.dynamo_rest.exceptions.EntityNotFoundException;
import com.sandip.dynamo_rest.repository.AuthorRepository;
import com.sandip.dynamo_rest.repository.BookRepository;
import com.sandip.dynamo_rest.repository.LendRepository;
import com.sandip.dynamo_rest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {
//    Automatically Autowired

    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;
    private final LendRepository lendRepository;
    private final BookRepository bookRepository;

    public Book readBookById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book with given Id not found"));
    }

    public Iterable<Book> readBooks() {
        return bookRepository.findAll();
    }

    public Book readBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new EntityNotFoundException("No book with Given Isbn Found"));
    }

    public Book createBook(BookCreationRequest book) {
        Author author = authorRepository.findById(book.getAuthorId()).orElseThrow(() -> new EntityNotFoundException("Author Specified Not Found"));

        Book bookToCreate = new Book();
        BeanUtils.copyProperties(book, bookToCreate);
        bookToCreate.setAuthorId(author.getId());
        return bookRepository.save(bookToCreate);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Member createMember(MemberCreationRequest request) {
        Member member = new Member();
        BeanUtils.copyProperties(request, member);
        member.setStatus(MemberStatus.ACTIVE);
        return memberRepository.save(member);
    }

    public Member updateMember(String id, MemberCreationRequest request) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }
        Member member = optionalMember.get();
        member.setLastname(request.getLastName());
        member.setFirstname(request.getFirstName());
        return memberRepository.save(member);
    }

    public Author createAuthor(AuthorCreationRequest request) {
        Author author = new Author();
        BeanUtils.copyProperties(request, author);
        return authorRepository.save(author);
    }

    public List<String> lendABook(BookLendRequest request) {
        Optional<Member> memberForId = memberRepository.findById(request.getMemberId());
        if (memberForId.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }
        Member member = memberForId.get();
        if (member.getStatus() != MemberStatus.ACTIVE) {
            throw new RuntimeException("User is not active to proceed a lending.");
        }
        List<String> booksApprovedToBurrow = new ArrayList<>();
        request.getBookIds().forEach(bookId -> {
            Optional<Book> bookForId = bookRepository.findById(bookId);
            if (bookForId.isEmpty()) {
                throw new EntityNotFoundException("Cant find any book under given ID");
            }
            Optional<Lend> burrowedBook = lendRepository.findByBookIdAndStatus(bookForId.get().getId(), LendStatus.BORROWED);
            if (burrowedBook.isEmpty()) {
                booksApprovedToBurrow.add(bookForId.get().getName());
                Lend lend = new Lend();
                lend.setMemberId(memberForId.get().getId());
                lend.setBookId(bookForId.get().getId());
                lend.setStatus(LendStatus.BORROWED);
                lend.setStartOn(Instant.now().toString());
                lend.setDueOn(Instant.now().plus(30, ChronoUnit.DAYS).toString());
                lendRepository.save(lend);
            }
        });
        return booksApprovedToBurrow;
    }
}

