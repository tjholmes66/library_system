package com.librarysystem.server.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "enabled")
    private boolean enabled;

    // `category_code` varchar(10) NOT NULL,
    @Column(name = "category_code")
    private String categoryCode;

    // `category_name` varchar(45) NOT NULL,
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "entered_by")
    private long enteredBy;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

    @Column(name = "edited_by")
    private long editedBy;

    @Column(name = "edited_date")
    private LocalDateTime editedDate;

    public long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(long categoryId)
    {
        this.categoryId = categoryId;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode)
    {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryCode == null) ? 0 : categoryCode.hashCode());
        result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
        result = prime * result + (int) (editedBy ^ (editedBy >>> 32));
        result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
        result = prime * result + (enabled ? 1231 : 1237);
        result = prime * result + (int) (enteredBy ^ (enteredBy >>> 32));
        result = prime * result + ((enteredDate == null) ? 0 : enteredDate.hashCode());
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
        CategoryEntity other = (CategoryEntity) obj;
        if (categoryCode == null)
        {
            if (other.categoryCode != null)
                return false;
        }
        else if (!categoryCode.equals(other.categoryCode))
            return false;
        if (categoryId != other.categoryId)
            return false;
        if (categoryName == null)
        {
            if (other.categoryName != null)
                return false;
        }
        else if (!categoryName.equals(other.categoryName))
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
        return true;
    }

    @Override
    public String toString()
    {
        return "CategoryEntity [categoryId=" + categoryId + ", enabled=" + enabled + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", enteredBy=" + enteredBy + ", enteredDate="
            + enteredDate + ", editedBy=" + editedBy + ", editedDate=" + editedDate + "]";
    }

}
