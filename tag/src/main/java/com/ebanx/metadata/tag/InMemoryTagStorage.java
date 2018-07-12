package com.ebanx.metadata.tag;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class InMemoryTagStorage implements TagStorage {
	private final Map<String, List<String>> map;

	public InMemoryTagStorage() {
		this.map = new HashMap<String, List<String>>();
	}

	public void addTag(String id, String tagValue) {
		List<String> tags = this.map.get(id);
		if (tags == null) {
			tags = new ArrayList<String>();
			this.map.put(id, tags);
		}

		tags.add(tagValue);
	}

	public boolean tagExists(String id, String tagValue) {
		List<String> tags = this.getTags(id);

		return tags == null
			? false
			: tags.contains(tagValue);
	}

	public List<String> getTags(String id) {
		return this.map.get(id);
	}
}
