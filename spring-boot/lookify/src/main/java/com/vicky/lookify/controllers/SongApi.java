package com.vicky.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.vicky.lookify.models.Song;
import com.vicky.lookify.services.SongService;


@RestController
public class SongApi {
	
	private final SongService songService;
	
	public SongApi(SongService songService) {
		this.songService = songService;
	}
	
	// show all
	@RequestMapping("/api/songs")
	public List<Song> index(){
		return songService.getAllSongs();
	}
	
	// add one
	@RequestMapping(value = "api/songs" , method=RequestMethod.POST)
	public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
		Song song = new Song(title, artist, rating);
		return songService.addSong(song);
	}
	
	// show one
	@RequestMapping("/api/songs/{id}/")
	
	public Song show(@PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		return song;
		
	}
	
	// update
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Song update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {    
    	Song song = songService.findSong(id);
    	song.setTitle(title);
    	song.setArtist(artist);
    	song.setRating(rating);
    	return song;
    }
    
    // delete
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
	
}
