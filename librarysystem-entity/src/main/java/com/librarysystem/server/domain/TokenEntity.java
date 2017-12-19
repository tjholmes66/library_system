package com.librarysystem.server.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * CREATE TABLE `token` (
 * `token_id` int(11) NOT NULL AUTO_INCREMENT,
 * `user_id` int(11) NOT NULL,
 * `token` varchar(45) NOT NULL,
 * `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * PRIMARY KEY (`token_id`),
 * UNIQUE KEY `token_id_UNIQUE` (`token_id`),
 * UNIQUE KEY `token_UNIQUE` (`token`),
 * KEY `fk_token_user_idx_idx` (`user_id`),
 * CONSTRAINT `fk_token_user_idx` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO
 * ACTION
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * SELECT * FROM opportunity_db.token;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "token")
public class TokenEntity implements Serializable
{
    // `token_id` int(11) NOT NULL AUTO_INCREMENT,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private long tokenId;

    // `user_id` int(11) NOT NULL,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // `token` varchar(45) NOT NULL,
    @Column(name = "token")
    private String token;

    // `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    @Column(name = "created")
    private LocalDateTime created;

    public long getTokenId()
    {
        return tokenId;
    }

    public void setTokenId(long tokenId)
    {
        this.tokenId = tokenId;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public LocalDateTime getCreated()
    {
        return created;
    }

    public void setCreated(LocalDateTime created)
    {
        this.created = created;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + (int) (tokenId ^ (tokenId >>> 32));
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        TokenEntity other = (TokenEntity) obj;
        if (created == null)
        {
            if (other.created != null)
                return false;
        }
        else if (!created.equals(other.created))
            return false;
        if (token == null)
        {
            if (other.token != null)
                return false;
        }
        else if (!token.equals(other.token))
            return false;
        if (tokenId != other.tokenId)
            return false;
        if (user == null)
        {
            if (other.user != null)
                return false;
        }
        else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "TokenEntity [tokenId=" + tokenId + ", user=" + user + ", token=" + token + ", created=" + created + "]";
    }

}
