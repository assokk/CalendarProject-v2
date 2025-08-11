package org.example.calendarproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String author;

    public Schedule(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public void updateTitleAndAuthor(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
