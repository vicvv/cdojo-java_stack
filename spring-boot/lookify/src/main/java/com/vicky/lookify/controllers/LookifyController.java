package com.vicky.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicky.lookify.models.Song;
import com.vicky.lookify.services.SongService;

@Controller
@RequestMapping("/")
public class LookifyController {
	
	private final SongService songService;
	
	public LookifyController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index() {
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.getAllSongs();		
		model.addAttribute("songs", songs);		
		return "/songs/dashboard.jsp";
	}
	
	@PostMapping("/dashboard/search")
	public String search(@RequestParam("artist") String artist) {
		System.out.println("I am in search for  "+ artist);
		return "redirect:/dashboard/search/"+artist;
	}
	
	@RequestMapping("/dashboard/search/{artist}")
	public String showSearch(Model model, @PathVariable("artist") String artist) {
		System.out.println("I am here "+ artist);
		List<Song> songs = songService.getSearchSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		System.out.println(songs);
		return "/songs/search.jsp";
	}
	
	
	@RequestMapping("/songs/new")
	public String showCreateForm(Model model, @ModelAttribute("song") Song song) {
		System.out.println("I am in new song ");
		return "songs/new.jsp";
	}
	
	
	@PostMapping("/songs/new")
	public String createLang(@Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/songs/new";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	// show
	@RequestMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		
		System.out.println("I am in view one song");
		Song song = (Song) songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@RequestMapping("/songs/{id}/edit")
	public String editSong(Model model,@PathVariable("id") Long id) {
		System.out.println("I am in edit one song");
		return "/songs/edit.jsp";
	}
	
	
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping("/songs/delete/{artist}/{id}")
	public String deleteSongFromSearch(@PathVariable("artist") String artist, @PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/search/"+artist;
	}
	
	
	@RequestMapping("/songs/top")
	public String showTopSongs(Model model) {
		System.out.println("I am in top songs");
		List<Song> songs = songService.getTopSongs();
		model.addAttribute("songs", songs);
		return "songs/topsongs.jsp";
	}
	

}
