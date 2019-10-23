package com.example.demo;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.HashMap; 
import java.util.Map;
import java.util.Arrays;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
		}
		
		return "index.jsp";
		
	}
	
@RequestMapping(path ="", method = RequestMethod.POST)
public String countGold(HttpSession session, @RequestParam(value="place") String place) {
	
	if(session.getAttribute("gold") == null) {
		session.setAttribute("gold", 0);
		session.setAttribute("activities", new ArrayList<String>());
	}
	
	System.out.println((Integer) session.getAttribute("gold"));
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	Integer limit = -100;
	//HashMap<String, Integer> map  = new HashMap<>(); 
	
	HashMap<String, ArrayList<Integer>> hashmap = new HashMap<String, ArrayList<Integer>>();
	ArrayList<Integer> arraylistf = new ArrayList<Integer>();
	ArrayList<Integer> arraylistc = new ArrayList<Integer>();
	ArrayList<Integer> arraylisth = new ArrayList<Integer>();
	ArrayList<Integer> arraylistcs = new ArrayList<Integer>();
	ArrayList<Integer> arraylists = new ArrayList<Integer>();
	
	arraylistf.addAll(Arrays.asList(10, 20));
	arraylistc.addAll(Arrays.asList(5, 10));
	arraylisth.addAll(Arrays.asList(2, 5));
	arraylistcs.addAll(Arrays.asList(-50, 50));
	arraylists.addAll(Arrays.asList(-20, -5));
	
	
	hashmap.put("farm", arraylistf);
	hashmap.put("cave", arraylistc);
	hashmap.put("house", arraylisth);
	hashmap.put("casino", arraylistcs);
	hashmap.put("spa", arraylists);
	
	
	if (hashmap.containsKey(place)) { 
		String earnlost;
		
		Random r = new Random();
		Integer min = hashmap.get(place).get(0);
		Integer max = hashmap.get(place).get(1);
		Integer gold = (Integer) session.getAttribute("gold");
		Integer ammount = r.nextInt((max - min) + 1) + min;
		session.setAttribute("gold", gold + ammount);
		if(ammount < 0) earnlost = "lost";
		else earnlost = "won";
			
		
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		activities.add("You entered a " + place + "and " + earnlost + " " + ammount +" gold. ("+timeStamp+")");	
		
		if ((Integer) session.getAttribute("gold") <  -100) {
			System.out.println("Gold is low... going to prizon now!");
			return "prizon.jsp";
			
		}	
	} 
	
	else if (place.equals("reset")) {session.invalidate();}		
	return "redirect:/";
}
	
	

}
