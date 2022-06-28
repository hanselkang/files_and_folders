package com.example.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folder")
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @JsonIgnoreProperties({"folder"})
    @OneToMany(mappedBy = "folder")
    private List<File> files;

    @ManyToOne
    @JoinColumn(name="person")
    @JsonIgnoreProperties({"files"})
    private Person person;

    public Folder(String title, Person person) {
        this.title = title;
        this.person = person;
        this.files = new ArrayList<File>();
    }

    public Folder() {
    }

    public String getTitle() {
        return title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addFile(File file){
        this.files.add(file);
    }

}