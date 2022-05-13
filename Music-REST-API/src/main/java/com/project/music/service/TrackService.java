package com.project.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.music.model.Track;
import com.project.music.repository.TrackRepository;

@Service
public class TrackService {

    @Autowired // Dependency injection in Spring beans
    TrackRepository trackRepository;

    // CREATE
    public Track createTrack(Track track) {
        return trackRepository.save(track);
    }

    // READ
    public List<Track> getTrack() {
        return trackRepository.findAll();
    }

    // READ BY ID
    public Optional<Track> getTrack(Long id) {
        return trackRepository.findById(id);
    }

    // UPDATE BY REPLACE
    public Track updateTrack(Long trackId, Track trackDetails) {
        Track track = trackRepository.findById(trackId).get();
        track.setName(trackDetails.getName());
        track.setGenre(trackDetails.getGenre());
        track.setArtist(trackDetails.getArtist());
        track.setDurationInSeconds(trackDetails.getDurationInSeconds());
        return trackRepository.save(track);
    }

    // UPDATE BY MODIFY
    public Track updateTrackTitle(Long trackId, String songName) {
        Track track = trackRepository.findById(trackId).get();
        track.setName(songName);
        return trackRepository.save(track);
    }

    // DELETE
    public void deleteTrack(Long trackId) {
        trackRepository.deleteById(trackId);
    }
}