package com.javacode.Entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "items" )
public class ItemEnt {

    @Id
   // @GeneratedValue
 //   private Long itemId;

    @Column(length = 78 ,nullable = false) private String tittle ;
    @Column(columnDefinition = "TEXT")
    private String description ;
    private Date pubDate;
    @Column(length = 48 ) private String enclosureType ;
    @Column(length = 64 ) private String enclosureUrl ;

    public ItemEnt() {
    }

    public ItemEnt(String title, String description, Date pubDate, String enclosureType, String enclosureUrl) {
        this.tittle = title;
        this.description = description;
        this.pubDate = pubDate;
        this.enclosureType = enclosureType;
        this.enclosureUrl = enclosureUrl;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getEnclosureType() {
        return enclosureType;
    }

    public void setEnclosureType(String enclosureType) {
        this.enclosureType = enclosureType;
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl;
    }

    @Override
    public String toString() {
        return "ItemEnt{" +
                "tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", pubDate=" + pubDate +
                ", enclosureType='" + enclosureType + '\'' +
                ", enclosureUrl='" + enclosureUrl + '\'' +
                '}';
    }
}
