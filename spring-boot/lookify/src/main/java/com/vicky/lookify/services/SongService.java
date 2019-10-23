package com.vicky.lookify.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


import com.vicky.lookify.models.Song;
import com.vicky.lookify.repositories.SongRepository;



@Service
public class SongService {
	private SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	
	public Song addSong(Song song) {
		return songRepository.save(song);
	}
	
	
	public List<Song> getAllSongs() {
		return (List<Song>) songRepository.findAll();
	}
	
	// retrieves song
    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    // delete song
    public void deleteSong(Long id) {
    	songRepository.deleteById(id);
    } 
	
	// search song
	public List<Song> getSearchSongs(String artist){
		System.out.println("I am in song service and printing an artist " + artist);
		return songRepository.findByArtist(artist);
	}
	
	// get top song
	public List<Song> getTopSongs(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
}
