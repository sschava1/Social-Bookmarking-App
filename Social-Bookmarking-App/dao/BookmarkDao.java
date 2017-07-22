package com.shirish.thrillio.dao;

import com.shirish.thrillio.DataStore;
import com.shirish.thrillio.entities.Bookmark;
import com.shirish.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
