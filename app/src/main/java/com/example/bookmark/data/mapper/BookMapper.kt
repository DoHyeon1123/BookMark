package com.example.bookmark.data.mapper

import com.example.bookmark.data.book.Document
import com.example.bookmark.data.db.BookEntity
import com.example.bookmark.data.db.CommentEntity
import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment

class BookMapper {
    fun mapDocumentToBook(list : List<Document>) : List<Book>{
        val newList : MutableList<Book> = arrayListOf()
        list.map {
            newList.add(
                Book(
                title = it.title,
                image = it.thumbnail,
                author = it.authors.toString(),
                content = it.contents,
                url = it.url,
                id = it.isbn
            )
            )
        }
        return newList
    }

    fun mapEntityToBook(list : List<BookEntity>) : List<Book>{
        val newList : MutableList<Book> = arrayListOf()
        list.map {
            newList.add(
                Book(
                title = it.title,
                image = it.image,
                author = it.authors,
                content = it.contents,
                url = it.url,
                id = it.id
            )
            )
        }
        return newList
    }

    fun mapEntityToComment(list : List<CommentEntity>) : List<Comment>{
        val newList : MutableList<Comment> = arrayListOf()
        list.map {
            newList.add(
                Comment(
                    comment = it.comment,
                    dateTime = it.dateTime,
                    bookId = it.bookId,
                    id = it.id
                )
            )
        }
        return newList
    }

    fun mapEntityToBook(entity : BookEntity) : Book {
        return Book(
            title = entity.title,
            image = entity.image,
            author = entity.authors,
            content = entity.contents,
            url = entity.url,
            id = entity.id
        )
    }
}