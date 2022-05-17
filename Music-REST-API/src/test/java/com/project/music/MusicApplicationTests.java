package com.project.music;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.project.music.model.Track;
import com.project.music.repository.TrackRepository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MusicApplicationTests {

	@Autowired
	TrackRepository tRepository;

	@Test
	@Order(1)
	public void testCreate() {
		Track t = new Track();
		t.setId(1L);
		t.setName("Believer");
		t.setGenre("Rock");
		t.setArtist("Imagine Dragons");
		t.setDurationInSeconds(205);
		tRepository.save(t);
		assertNotNull(tRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testReadAll() {
		List<Track> list = tRepository.findAll();
		assertTrue(list.size() > 0);
	}

	@Test
	@Order(3)
	public void testReadById() {
		Track track = tRepository.findById(1L).get();
		assertEquals(205, track.getDurationInSeconds());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Track t = tRepository.findById(1L).get();
		t.setDurationInSeconds(215);
		tRepository.save(t);
		assertNotEquals(205, tRepository.findById(1L).get().getDurationInSeconds());
	}

	@Test
	@Order(5)
	public void testDelete() {
		tRepository.deleteById(1L);
		assertFalse(tRepository.existsById(1L));
	}

}
