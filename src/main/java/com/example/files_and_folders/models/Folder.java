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

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    @JsonIgnoreProperties({"files"})
    private Person person;

    @ManyToMany
    @JsonIgnoreProperties({"folders"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "people_folders",
            joinColumns = {
                    @JoinColumn(name = "folder_id", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "people_id", nullable = false)
            }
    )
    private List<File> files;

    public Folder(String title) {
        this.title = title;
        this.files = new ArrayList<File>();
    }

    public Folder() {
    }

    public String getTitle() {
        return title;
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