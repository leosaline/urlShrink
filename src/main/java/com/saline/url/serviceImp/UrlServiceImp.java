package com.saline.url.serviceImp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saline.url.entity.Url;
import com.saline.url.repository.UrlRepository;
import com.saline.url.service.UrlService;

@Service
public class UrlServiceImp implements UrlService{
	@Autowired
	private UrlRepository urlRepository;

	@Override
	public String recoverShrinkToFullUrl(String idUrl) {
		String id = "";
		
		try {
			URI uri = new URI(idUrl);
			id = uri.getPath().replaceAll("/", "");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		Optional<Url> url = urlRepository.findById(id);
		return url.get().getOriginalUrl();
	}

	@Override
	public String newUrlToShrink(String urlOriginal) {
		Url url = new Url();
		url.setId(Integer.toString(urlOriginal.hashCode()).replaceAll("-", ""));
		url.setOriginalUrl(urlOriginal);
		
		String urlPath = "";
		try {
			URI uri = new URI(urlOriginal);
			urlPath = uri.getPath();
			urlPath = urlOriginal.replace(uri.getPath(), "");
			url.setShrinkUrl(urlPath+ "/" + url.getId());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		urlRepository.save(url);	
		return url.getShrinkUrl();
	}

}
