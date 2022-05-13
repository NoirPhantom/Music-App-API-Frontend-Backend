package com.project.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.music.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

}