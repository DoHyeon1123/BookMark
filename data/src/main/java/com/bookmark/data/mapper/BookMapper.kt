package com.bookmark.data.mapper

import com.bookmark.data.db.entity.BookEntity
import com.bookmark.data.db.entity.CommentEntity
import com.bookmark.domain.model.book.Book
import com.bookmark.domain.model.book.Document
import com.bookmark.domain.model.profile.Comment
import java.time.LocalDate

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
                    id = it.isbn,
                    reading_date = LocalDate.now().toString()
                )
            )
        }
        return newList
    }

    fun mapEntityToBook(list : List<BookEntity>) : List<Book>{
        return list.map {
            mapEntityToBook(it)
        }
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
            id = entity.id,
            reading_date = entity.reading_date
        )
    }
}