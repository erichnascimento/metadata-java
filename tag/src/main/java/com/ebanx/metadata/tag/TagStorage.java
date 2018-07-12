package com.ebanx.metadata.tag;

public interface TagStorage {
	public boolean tagExists(String id, String tagValue);
	public void addTag(String id, String tagValue);
}
