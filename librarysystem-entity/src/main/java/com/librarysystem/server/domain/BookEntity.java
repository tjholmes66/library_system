package com.librarysystem.server.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "book")
public class BookEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "book_published")
    private LocalDate bookPublished;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_pages")
    private long bookPages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "checked_out_user")
    private UserEntity checkedOutUser;

    @Column(name = "checked_out_date")
    private LocalDate checkedOutDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getBookDescription()
    {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription)
    {
        this.bookDescription = bookDescription;
    }

    public LocalDate getBookPublished()
    {
        return bookPublished;
    }

    public void setBookPublished(LocalDate bookPublished)
    {
        this.bookPublished = bookPublished;
    }

    public String getBookAuthor()
    {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor)
    {
        this.bookAuthor = bookAuthor;
    }

    public long getBookPages()
    {
        return bookPages;
    }

    public void setBookPages(long bookPages)
    {
        this.bookPages = bookPages;
    }

    public UserEntity getCheckedOutUser()
    {
        return checkedOutUser;
    }

    public void setCheckedOutUser(UserEntity checkedOutUser)
    {
        this.checkedOutUser = checkedOutUser;
    }

    public LocalDate getCheckedOutDate()
    {
        return checkedOutDate;
    }

    public void setCheckedOutDate(LocalDate checkedOutDate)
    {
        this.checkedOutDate = checkedOutDate;
    }

    public CategoryEntity getCategory()
    {
        return category;
    }

    public void setCategory(CategoryEntity category)
    {
        this.category = category;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
        result = prime * result + ((bookDescription == null) ? 0 : bookDescription.hashCode());
        result = prime * result + (int) (bookId ^ (bookId >>> 32));
        result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
        result = prime * result + (int) (bookPages ^ (bookPages >>> 32));
        result = prime * result + ((bookPublished == null) ? 0 : bookPublished.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((checkedOutDate == null) ? 0 : checkedOutDate.hashCode());
        result = prime * result + ((checkedOutUser == null) ? 0 : checkedOutUser.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BookEntity other = (BookEntity) obj;
        if (bookAuthor == null)
        {
            if (other.bookAuthor != null)
                return false;
        }
        else if (!bookAuthor.equals(other.bookAuthor))
            return false;
        if (bookDescription == null)
        {
            if (other.bookDescription != null)
                return false;
        }
        else if (!bookDescription.equals(other.bookDescription))
            return false;
        if (bookId != other.bookId)
            return false;
        if (bookName == null)
        {
            if (other.bookName != null)
                return false;
        }
        else if (!bookName.equals(other.bookName))
            return false;
        if (bookPages != other.bookPages)
            return false;
        if (bookPublished == null)
        {
            if (other.bookPublished != null)
                return false;
        }
        else if (!bookPublished.equals(other.bookPublished))
            return false;
        if (category == null)
        {
            if (other.category != null)
                return false;
        }
        else if (!category.equals(other.category))
            return false;
        if (checkedOutDate == null)
        {
            if (other.checkedOutDate != null)
                return false;
        }
        else if (!checkedOutDate.equals(other.checkedOutDate))
            return false;
        if (checkedOutUser == null)
        {
            if (other.checkedOutUser != null)
                return false;
        }
        else if (!checkedOutUser.equals(other.checkedOutUser))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", bookDescription=" + bookDescription + ", bookPublished=" + bookPublished + ", bookAuthor=" + bookAuthor + ", bookPages="
            + bookPages + ", checkedOutUser=" + checkedOutUser + ", checkedOutDate=" + checkedOutDate + ", category=" + category + "]";
    }

}
