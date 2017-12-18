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

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class UserEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "enabled")
    private boolean enabled;

    // `username` varchar(45) NOT NULL,
    @Column(name = "username")
    private String username;

    // `password` varchar(45) NOT NULL,
    @JsonIgnore
    @Column(name = "salted_password")
    private String password;

    // `prefix` varchar(45) DEFAULT NULL,
    @Column(name = "prefix")
    private String prefix;

    // `first_name` varchar(45) DEFAULT NULL,
    @Column(name = "first_name")
    private String firstName;

    // `middle_initial` varchar(45) DEFAULT NULL,
    @Column(name = "middle_initial")
    private String middleInitial;

    // `last_name` varchar(45) DEFAULT NULL,
    @Column(name = "last_name")
    private String lastName;

    // `suffix` varchar(45) DEFAULT NULL,
    @Column(name = "suffix")
    private String suffix;

    // `role_id` int(11) NOT NULL,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "reset_key")
    private String resetKey;

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleInitial()
    {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial)
    {
        this.middleInitial = middleInitial;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public RoleEntity getRole()
    {
        return role;
    }

    public void setRole(RoleEntity role)
    {
        this.role = role;
    }

    public long getEnteredBy()
    {
        return enteredBy;
    }

    public void setEnteredBy(long enteredBy)
    {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredDate()
    {
        return enteredDate;
    }

    public void setEnteredDate(LocalDateTime enteredDate)
    {
        this.enteredDate = enteredDate;
    }

    public long getEditedBy()
    {
        return editedBy;
    }

    public void setEditedBy(long editedBy)
    {
        this.editedBy = editedBy;
    }

    public LocalDateTime getEditedDate()
    {
        return editedDate;
    }

    public void setEditedDate(LocalDateTime editedDate)
    {
        this.editedDate = editedDate;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getWorkPhone()
    {
        return workPhone;
    }

    public void setWorkPhone(String workPhone)
    {
        this.workPhone = workPhone;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }

    public String getResetKey()
    {
        return resetKey;
    }

    public void setResetKey(String resetKey)
    {
        this.resetKey = resetKey;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cellPhone == null) ? 0 : cellPhone.hashCode());
        result = prime * result + (int) (editedBy ^ (editedBy >>> 32));
        result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
        result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + (int) (enteredBy ^ (enteredBy >>> 32));
        result = prime * result + ((enteredDate == null) ? 0 : enteredDate.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        result = prime * result + ((resetKey == null) ? 0 : resetKey.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());
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
        UserEntity other = (UserEntity) obj;
        if (cellPhone == null)
        {
            if (other.cellPhone != null)
                return false;
        }
        else if (!cellPhone.equals(other.cellPhone))
            return false;
        if (editedBy != other.editedBy)
            return false;
        if (editedDate == null)
        {
            if (other.editedDate != null)
                return false;
        }
        else if (!editedDate.equals(other.editedDate))
            return false;
        if (emailAddress == null)
        {
            if (other.emailAddress != null)
                return false;
        }
        else if (!emailAddress.equals(other.emailAddress))
            return false;
        if (enabled != other.enabled)
            return false;
        if (enteredBy != other.enteredBy)
            return false;
        if (enteredDate == null)
        {
            if (other.enteredDate != null)
                return false;
        }
        else if (!enteredDate.equals(other.enteredDate))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (middleInitial == null)
        {
            if (other.middleInitial != null)
                return false;
        }
        else if (!middleInitial.equals(other.middleInitial))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (prefix == null)
        {
            if (other.prefix != null)
                return false;
        }
        else if (!prefix.equals(other.prefix))
            return false;
        if (resetKey == null)
        {
            if (other.resetKey != null)
                return false;
        }
        else if (!resetKey.equals(other.resetKey))
            return false;
        if (role == null)
        {
            if (other.role != null)
                return false;
        }
        else if (!role.equals(other.role))
            return false;
        if (suffix == null)
        {
            if (other.suffix != null)
                return false;
        }
        else if (!suffix.equals(other.suffix))
            return false;
        if (userId != other.userId)
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        if (workPhone == null)
        {
            if (other.workPhone != null)
                return false;
        }
        else if (!workPhone.equals(other.workPhone))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "UserEntity [userId=" + userId + ", enabled=" + enabled + ", username=" + username + ", password=" + password + ", prefix=" + prefix + ", firstName=" + firstName + ", middleInitial="
            + middleInitial + ", lastName=" + lastName + ", suffix=" + suffix + ", role=" + role + ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate + ", editedBy=" + editedBy
            + ", editedDate=" + editedDate + ", emailAddress=" + emailAddress + ", workPhone=" + workPhone + ", cellPhone=" + cellPhone + ", resetKey=" + resetKey + "]";
    }

}
