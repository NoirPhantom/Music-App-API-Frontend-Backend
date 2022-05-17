package com.project.music.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.music.model.Track;
import com.project.music.service.TrackService;

@RestController
@RequestMapping("/music")
public class TrackController {
    @Autowired
    TrackService trackService;

    @CrossOrigin(origins = "*")
    @PostMapping("/track")
    public Track createTrack(@RequestBody Track track) {
        return trackService.createTrack(track);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/tracks")
    public List<Track> readTracks() {
        return trackService.getTrack();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/track/{trackId}")
    public Optional<Track> getTrack(@PathVariable(value = "trackId") Long trackId) {
        return trackService.getTrack(trackId);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/track/{trackId}")
    public Track updateTrack(@PathVariable(value = "trackId") Long id, @RequestBody Track trackDetails) {
        return trackService.updateTrack(id, trackDetails);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/track/{trackId}")
    public Track replaceTrack(@PathVariable(value = "trackId") Long id,
            @PathVariable(value = "newSongName") String songName) {
        return trackService.updateTrackTitle(id, songName);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/track/{trackId}")
    public void deleteTrack(@PathVariable(value = "trackId") Long id) {
        trackService.deleteTrack(id);
    }
}
