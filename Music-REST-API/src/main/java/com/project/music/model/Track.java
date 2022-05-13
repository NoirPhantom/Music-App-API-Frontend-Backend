package com.project.music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @Column(name = "song_name")
    private String name;

    @Column(name = "genre_type")
    private String genre;

    @Column(name = "artist_name")
    private String artist;

    @Column(name = "durationInSeconds")
    private Integer durationInSeconds;

    public Track() {
    }

    public Track(Long id, String songName, String genreType, String artistName, Integer durationInSeconds) {
        this.id = id;
        this.name = songName;
        this.genre = genreType;
        this.artist = artistName;
        this.durationInSeconds = durationInSeconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public String toString() {
        return "Track [artistName=" + artist + ", genreType=" + genre + ", id=" + id + ", durationInSeconds="
                + durationInSeconds
                + ", songName=" + name + "]";
    }

}