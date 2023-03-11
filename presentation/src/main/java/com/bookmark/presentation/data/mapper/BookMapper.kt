package com.bookmark.presentation.data.mapper

import com.example.bookmark.domain.model.Book
import com.example.bookmark.domain.model.Comment

class BookMapper {
    fun mapDocumentToBook(list : List<com.bookmark.presentation.data.book.Document>) : List<Book>{
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

    fun mapEntityToBook(list : List<com.bookmark.presentation.data.db.BookEntity>) : List<Book>{
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

    fun mapEntityToComment(list : List<com.bookmark.presentation.data.db.CommentEntity>) : List<Comment>{
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

    fun mapEntityToBook(entity : com.bookmark.presentation.data.db.BookEntity) : Book {
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