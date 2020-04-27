package com.enfec.enfecservicelatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.enfec.enfecservicelatest.model.Photos;
import com.enfec.enfecservicelatest.model.PhotosUrls;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/api")
public class EnfecController {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://jsonplaceholder.typicode.com/photos";

	@GetMapping("/urls")
	@ApiOperation(value = "View a list of available products", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	public String getUrls(Model model) {
		List<PhotosUrls> photosUrls = new ArrayList<PhotosUrls>();
		Photos photos[] = restTemplate.getForObject(url, Photos[].class);
		for (int i = 0; i < photos.length; i++) {
			PhotosUrls photosUrl = new PhotosUrls();
			photosUrl.setUrl(photos[i].getUrl());
			photosUrl.setThumbnailUrl(photos[i].getThumbnailUrl());
			photosUrls.add(photosUrl);
		}
		// model.addAllAttributes(photosUrls);
		model.addAttribute("photosUrls", photosUrls);
		return "urls";
	}

}
