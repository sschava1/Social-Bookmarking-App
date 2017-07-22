package com.shirish.thrillio;

import com.shirish.thrillio.constants.KidFriendlyStatus;
import com.shirish.thrillio.constants.UserType;
import com.shirish.thrillio.controllers.BookmarkController;
import com.shirish.thrillio.entities.Bookmark;
import com.shirish.thrillio.entities.User;
import com.shirish.thrillio.partners.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmark != null) {
					if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
						boolean isbookmarked = getBookmarkDecision(bookmark);
						if (isbookmarked) {
							bookmarkCount++;
							BookmarkController.getInstance().saveUserBookmark(user, bookmark);
							System.out.println("New item bookmarked" + bookmark);
						}
					}

					if (user.getUserType().equals(UserType.EDITOR)
							|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
						if (bookmark.isKidsFriendlyEligible()
								&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
							String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
							// Mark as Kid friendly
							if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
								BookmarkController.setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
							}
						}
						// Sharing
						if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
								&& bookmark instanceof Shareable) {
							boolean isShared = getShareDecision();
							if (isShared) {
								BookmarkController.getInstance().share(user, bookmark);
							}
						}
					}
				}
			}
		}

	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;

	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {

		return (Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: ((Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN));

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;

	}
}
