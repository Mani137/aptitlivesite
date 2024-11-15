package com.example.AptItSolutions.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AptItSolutions.Entity.ScrollNews;
import com.example.AptItSolutions.Repo.ScrollNewsRepository;
import com.example.AptItSolutions.service.ScrollNewsService;

@RestController
@RequestMapping("/scrollnews")
public class ScrollNewsController {
	
	@Autowired
	private  ScrollNewsRepository scrollNewsRepository;
	
	
	@Autowired
	private  ScrollNewsService scrollNewsService;



	@PostMapping("/create")
	public ScrollNews createScrollNews(@RequestParam("scrollNews") String scrollNews) {
		ScrollNews ScrollNewss = new ScrollNews();
		ScrollNewss.setScrollNews(scrollNews);

		
		return scrollNewsService.savescrollNews(ScrollNewss);

		// Redirect to the URL that displays the list of scroll news
	}
	
	
	 @GetMapping("/getallscrollnews")
	    public List<ScrollNews> getAllScrollNews() {
	        return scrollNewsService.getAllScrollNews();
	    }
	 

	 
	   @GetMapping("/getbyId/{id}")
	    public ScrollNews getScrollNewsById(@PathVariable Long id) {
	        return scrollNewsService.getScrollNewsById(id);
	    }
	 
	   
	   @DeleteMapping("/deleteby/{id}")
	    public void deleteScrollNews(@PathVariable Long id) {
	        scrollNewsService.deleteScrollNews(id);
	    }
	   
		
	   @PutMapping("/updating/{id}") public ScrollNews
		  updateScrollNews(@PathVariable Long id, @RequestParam("scrollNews") String
			  scrollNews) {
			 
			 ScrollNews updatedScrollNews = scrollNewsService.getScrollNewsById(id);
		  updatedScrollNews.setScrollNews(scrollNews);
		  return scrollNewsService.updateScrollNews(id, updatedScrollNews); 
		  }
}
	   

