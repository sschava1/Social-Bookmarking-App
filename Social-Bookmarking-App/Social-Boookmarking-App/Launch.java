package com.shirish.thrillio;

import com.shirish.thrillio.entities.Bookmark;
import com.shirish.thrillio.entities.User;
import com.shirish.thrillio.managers.BookmarkManager;
import com.shirish.thrillio.managers.UserManager;

public class Launch {

	private static User[] users;
	private static Bookmark[][] bookmarks;

	public static void loadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

//		System.out.println("2. Printing data ...");
//
//		printUserData();
//		printBookmarkData();
	}

//	private static void printUserData() {
//
//		for (User user : users) {
//			System.out.println(user);
//		}
//
//	}
//
//	private static void printBookmarkData() {
//
//		for (Bookmark[] bookmarkList : bookmarks) {
//			for (Bookmark bookmark : bookmarkList) {
//				System.out.println(bookmark);
//			}
//		}
//
//	}

	private static void start() {
		System.out.println("2. Bookmarking ...");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}
}
