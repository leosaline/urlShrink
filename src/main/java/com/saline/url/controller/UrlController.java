package com.saline.url.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.url.service.UrlService;

@RestController
public class UrlController {
	@Autowired
	private UrlService service;

	@PostMapping("/url")
	String newUrlToShrink(@RequestBody String url) {
		return service.newUrlToShrink(url);
	}

	@GetMapping("/url/{id}")
	String recoverShrinkToFullUrl(@PathVariable String id) {
		return service.recoverShrinkToFullUrl(id);
	}

	@GetMapping("/forward")
	public void redirectToUrl(@RequestBody String id, HttpServletResponse resp) throws Exception {
		String url = service.recoverShrinkToFullUrl(id);
		resp.addHeader("Location", url);
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	}

}
