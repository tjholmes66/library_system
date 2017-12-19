package com.librarysystem.server.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class LoginResponseDTO implements Serializable
{

    private String token;
    private List<BookDTO> bookList;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public List<BookDTO> getBookList()
    {
        return bookList;
    }

    public void setBookList(List<BookDTO> bookList)
    {
        this.bookList = bookList;
    }

    @Override
    public String toString()
    {
        return "LoginResponseDTO [token=" + token + ", bookList=" + bookList + "]";
    }

}
